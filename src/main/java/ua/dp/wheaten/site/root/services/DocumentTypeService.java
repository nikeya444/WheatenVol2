package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.DocumentType;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
public interface DocumentTypeService extends GenericService<DocumentType, Integer> {
    DocumentType findByTypeName(String typeName);
}
