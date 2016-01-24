package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.Document;

import java.util.List;

/**
 * Created by kkm on 24.01.2016.
 */
public interface DocumentRepository extends CrudRepository<Document, Integer> {
    @Query(value = "select distinct d from Document d join fetch d.details where d.status = ?1")
    List<Document> findAllPosted(byte status);
}
