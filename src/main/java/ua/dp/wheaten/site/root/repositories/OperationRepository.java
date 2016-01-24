package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.Operation;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public interface OperationRepository extends CrudRepository<Operation, Integer> {
    List<Operation> findByDocumentTypeAndDocumentId(DocumentType documentType, Integer id);
}
