package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.dto.Remnant;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.Product;

import javax.print.Doc;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by kkm on 24.01.2016.
 */
public interface DocumentRepository extends CrudRepository<Document, Integer> {

    @Query(value = "select distinct d " +
            "       from Document d join fetch d.details " +
            "       where d.status = ?1 and d.dateOfDocument between ?2 and ?3")
    List<Document> findAllByStatusAndDateOfDocumentBetween(boolean status, LocalDate from, LocalDate to);

    List<Document> findAllByDateOfDocument(LocalDate date);

    List<Document> findAllByStatusAndDocumentTypeIn(boolean status, List<Document.Type> type);

    @Query(value = "select distinct d " +
            "       from Document d join fetch d.details " +
            "       where d.status = ?1 " )
    List<Document> findAllByStatus(boolean status);

    @Query(value = "select distinct d " +
            "       from Document d join fetch d.details")
    List<Document> findAll();

    @Query(value = "select distinct d from Document d " +
            "       join fetch d.details " +
            "       where d.dateOfDocument between ?1 and ?2")
    List<Document> findAllByDateBetween(LocalDate from, LocalDate to);

    @Query(value = "select d " +
            "       from Document d join fetch d.details dd " +
            "       where d.documentType = ?1 and dd.product = ?2")
    List<Document> findByDocumentTypeAndDetailsProduct(Document.Type type, Product product);

    @Query(value = "select d " +
            "       from Document d join fetch d.details dd " +
            "       where dd.product = ?1 and d.documentType <> 'MOVEMENT'")
    List<Document> findByDetailsProduct(Product product);

    @Query(value = "select sum(dd.quantity) " +
            "       from DocumentDetail dd " +
            "       where dd.product = ?1")
    BigDecimal findTotalQuantityOfProduct(Product product);

    @Query(value = "select new ua.dp.wheaten.site.root.dto.Remnant(dd.product, sum(dd.quantity)) " +
            "       from DocumentDetail dd " +
            "       group by dd.product")
    List<Remnant> getAllProductRemnants();

    @Query(value = "select new ua.dp.wheaten.site.root.dto.Remnant(dd.product, dd.storage, sum(dd.quantity)) " +
            "       from DocumentDetail dd " +
            "       where dd.document.status = true " +
            "       group by dd.storage, dd.product " +
            "       having sum(dd.quantity) > 0")
    List<Remnant> getAllProductRemnantsInStorages();

    @Query(value = "select abs( sum(dd.sum) / sum(dd.quantity) ) " +
            "       from DocumentDetail dd " +
            "       where dd.document.documentType = ?2 and dd.document.status = true and dd.product = ?1")
    BigDecimal calculateAveragePrice(Product product, Document.Type type);
}
