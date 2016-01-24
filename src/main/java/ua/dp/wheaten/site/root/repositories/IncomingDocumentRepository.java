package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.IncomingDocument;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 13.09.15
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public interface IncomingDocumentRepository extends CrudRepository<IncomingDocument, Integer> {

    @Query(value = "select distinct i from IncomingDocument i join fetch i.details where i.status = ?1")
    List<IncomingDocument> findAllPosted(byte status);
}
