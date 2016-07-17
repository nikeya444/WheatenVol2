package ua.dp.wheaten.site.root.services.impl;

import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.*;
import ua.dp.wheaten.site.root.repositories.OperationRepository;
import ua.dp.wheaten.site.root.repositories.RestRepository;
import ua.dp.wheaten.site.root.services.OperationService;
import ua.dp.wheaten.site.root.services.RestService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkm on 03.07.2016.
 */
@Service
@Transactional
public class OperationServiceDefault implements OperationService {

    @Inject
    private OperationRepository operationRepository;
    @Inject
    private RestService restService;


    @Override
    public void saveOperationFor(PurchaseDocument document) {
        List<Operation> operations = new ArrayList<>(document.getDetails().size());
        for (PurchaseDetail detail: document.getDetails()) {
            Operation operation = new Operation(
                    document.getId(), DocumentType.PURCHASE, detail.getProduct(),
                    detail.getQuantity(), detail.getStorage(), detail.getSum().negate()
            );
            restService.updatePurchaseRest(operation);
            operations.add(operation);
        }

        operationRepository.save(operations);

    }

    @Override
    public void saveOperationFor(SaleDocument document) {
        List<Operation> operations = new ArrayList<>(document.getDetails().size());
        for (SaleDetail detail: document.getDetails()) {
            Operation operation = new Operation(
                    document.getId(), DocumentType.SALE, detail.getProduct(),
                    -1*detail.getQuantity(), detail.getStorage(), detail.getSum()
            );
            restService.updateSaleRest(operation);
            operations.add(operation);
        }

        operationRepository.save(operations);

    }

    @Override
    public void saveOperationFor(MovementDocument document) {
        List<Operation> operations = new ArrayList<>(document.getDetails().size()*2);
        for (MovementDetail detail: document.getDetails()) {
            Operation from = new Operation(
                document.getId(), DocumentType.MOVEMENT, detail.getProduct(),
                -1*detail.getQuantity(), detail.getSource(), detail.getSum()
            );
            restService.updateSaleRest(from);
            operations.add(from);
            Operation to = new Operation(
                    document.getId(), DocumentType.MOVEMENT, detail.getProduct(),
                    detail.getQuantity(), detail.getDestination(), detail.getSum().negate()
            );
            restService.updatePurchaseRest(to);
            operations.add(to);
        }

        operationRepository.save(operations);
    }
}
