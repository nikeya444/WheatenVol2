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
public interface DocumentService<T extends Document, ID extends Serializable>
                            extends GenericService<T, ID> {
    List<T> findByType(DocumentType type);
    void updateStatus(ID id, byte status);
}
