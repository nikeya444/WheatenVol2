package ua.dp.wheaten.site.root.listeners;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.dp.wheaten.site.root.entities.IncomingDetail;
import ua.dp.wheaten.site.root.entities.IncomingDocument;
import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.helpers.AutowireHelper;
import ua.dp.wheaten.site.root.services.OperationService;

import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
@Component
public class IncomingListener {
    /*
    @Inject
    private OperationService operationService;

    @PostPersist
    public void onPostPersist(IncomingDocument document) {
        if (!document.isPosted()) return;
        AutowireHelper.autowire(this, operationService);

        List<Operation> operations = new ArrayList<>(document.getDetails().size());
        for (IncomingDetail detail: document.getDetails()) {
            Operation operation = new Operation();
            operation.setDocumentType(document.getDocumentType());
            operation.setDocumentId(document.getId());
            operation.setUsername(document.getUsername());
            operation.setStorage(document.getStorageTo());
            operation.setProduct(detail.getProduct());
            operation.setQuantity(detail.getQuantity());
            operation.setSum(detail.getSum().negate());
            operations.add(operation);
        }

        operationService.saveList(operations);
    }

    @PostUpdate
    public void onPostUpdate(IncomingDocument document) {
        if (!document.isPosted()) return;
        AutowireHelper.autowire(this, operationService);
        System.out.println("documentType: " + document.getDocumentType().getId());
        System.out.println("documentId: " + document.getId());

        Iterable<Operation> operations = operationService
                .findByDocTypeAndId(document.getDocumentType(), document.getId());
        //operationService.getOne(1);
        System.out.println("Update");

        System.out.println(operations);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        operationService.saveList((List<Operation>)operations);
    }  */
}
