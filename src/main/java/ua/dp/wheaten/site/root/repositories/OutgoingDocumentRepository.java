package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.OutgoingDocument;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 14.09.15
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */
public interface OutgoingDocumentRepository extends CrudRepository<OutgoingDocument, Integer> {

    @Query(value = "select distinct o from OutgoingDocument o join fetch o.details where o.status = ?1")
    List<OutgoingDocument> findAllPosted(byte status);
}
