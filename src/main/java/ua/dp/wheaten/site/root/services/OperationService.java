package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.IncomingDocument;
import ua.dp.wheaten.site.root.entities.Operation;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public interface OperationService extends GenericService<Operation, Integer> {
    Iterable<Operation> findByDocTypeAndId(DocumentType docType, Integer id);
    void updateList(Iterable<Operation> operations);
}
