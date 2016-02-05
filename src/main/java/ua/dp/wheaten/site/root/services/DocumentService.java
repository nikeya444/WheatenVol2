package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentType;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 08.08.15
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public interface DocumentService extends GenericService<Document, Integer> {
    List<Document> findByType(DocumentType type);
    void updateStatus(Integer id, boolean status);
    List<Document> findIncomingDocuments(boolean status);
    List<Document> findOutgoingDocuments(boolean status);
    List<Document> findMovementDocuments(boolean status);
    List<Document> findByDocumentTypeAndStatus(boolean status, Document.Type type);

}
