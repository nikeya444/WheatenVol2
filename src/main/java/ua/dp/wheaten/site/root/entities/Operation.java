package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 0:51
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "OPERATIONS")
public class Operation extends DocumentDetail {

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_TYPE_ID")
    private DocumentType documentType;

    @Column(name = "DOCUMENT_ID")
    private Integer documentId;

    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public static List<Operation> createOperations(IncomingDocument document) {
        List<Operation> operations = new ArrayList<>(document.getDetails().size());
        for (IncomingDetail detail: document.getDetails()) {
            Operation operation = new Operation();
            operation.setProduct(detail.getProduct());
            operation.setQuantity(detail.getQuantity());
            operation.setStorage(detail.getStorageTo());
            operation.setSum(detail.getSum().negate());
            operation.setDocumentId(document.getId());
            operation.setDocumentType(document.getDocumentType());
            operations.add(operation);
        }
        return operations;
    }

    public static List<Operation> createOperations(OutgoingDocument document) {
        List<Operation> operations = new ArrayList<>(document.getDetails().size());
        for (OutgoingDetail detail: document.getDetails()) {
            Operation operation = new Operation();
            operation.setProduct(detail.getProduct());
            operation.setQuantity(Math.negateExact(detail.getQuantity()));
            operation.setStorage(detail.getStorageFrom());
            operation.setSum(detail.getSum());
            operation.setDocumentId(document.getId());
            operation.setDocumentType(document.getDocumentType());
            operations.add(operation);
        }
        return operations;
    }

    public static List<Operation> createOperations(MovementDocument document) {
        List<Operation> operations = new ArrayList<>(document.getDetails().size()*2);
        for (MovementDetail detail: document.getDetails()) {
            Operation operationFrom = new Operation();
            Operation operationTo = new Operation();

            operationFrom.setStorage(detail.getStorageFrom());
            operationTo.setStorage(detail.getStorageTo());

            operationFrom.setProduct(detail.getProduct());
            operationTo.setProduct(detail.getProduct());

            operationFrom.setSum(detail.getSum());
            operationTo.setSum(detail.getSum().negate());

            operationFrom.setQuantity(Math.negateExact(detail.getQuantity()));
            operationTo.setQuantity(detail.getQuantity());

            operationFrom.setDocumentType(document.getDocumentType());
            operationTo.setDocumentType(document.getDocumentType());

            operationFrom.setDocumentId(document.getId());
            operationTo.setDocumentId(document.getId());

            operations.add(operationFrom);
            operations.add(operationTo);
        }

        return operations;
    }
}
