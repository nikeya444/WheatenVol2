package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.DocumentType;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Integer> {
    DocumentType findByType(String type);
}
