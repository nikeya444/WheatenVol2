package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.PurchaseDocument;

import java.util.List;

/**
 * Created by kkm on 03.07.2016.
 */
public interface PurchaseRepository extends CrudRepository<PurchaseDocument, Integer> {
    List<PurchaseDocument> findAll();
}
