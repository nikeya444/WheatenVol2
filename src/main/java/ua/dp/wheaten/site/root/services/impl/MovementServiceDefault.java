package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.MovementDocument;
import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.repositories.MovementRepository;
import ua.dp.wheaten.site.root.services.MovementService;
import ua.dp.wheaten.site.root.services.OperationService;

import javax.inject.Inject;
import java.util.stream.Collectors;

/**
 * Created by kkm on 03.07.2016.
 */
@Service
public class MovementServiceDefault extends AbstractGenericService<MovementDocument, Integer> implements MovementService {

    @Inject
    private MovementRepository movementRepository;
    @Inject
    private OperationService operationService;

    @Override
    protected CrudRepository<MovementDocument, Integer> getRepository() {
        return this.movementRepository;
    }

    @Override
    public void save(MovementDocument document) {
        document.setDetails(
                document.getDetails().stream().peek(d -> d.setDocument(document)).collect(Collectors.toList())
        );
        this.movementRepository.save(document);
        this.operationService.saveOperationFor(document);
    }
}
