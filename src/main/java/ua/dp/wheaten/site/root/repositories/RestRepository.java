package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.Rest;
import ua.dp.wheaten.site.root.entities.Storage;

/**
 * Created by kkm on 15.07.2016.
 */
public interface RestRepository extends CrudRepository<Rest, Integer> {
    Rest findByProductAndStorage(Product product, Storage storage);
}
