package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.ProductType;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 05.05.15
 * Time: 23:54
 * To change this template use File | Settings | File Templates.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
}
