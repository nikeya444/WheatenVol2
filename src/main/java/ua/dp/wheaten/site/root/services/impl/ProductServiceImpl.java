package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.ProductType;
import ua.dp.wheaten.site.root.repositories.ProductRepository;
import ua.dp.wheaten.site.root.services.ProductService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 06.05.15
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductServiceImpl
        extends AbstractGenericService<Product, Integer>
            implements ProductService {

    private ProductRepository repository;

    @Override
    protected CrudRepository<Product, Integer> getRepository() {
        return repository;
    }

    @Inject
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }
}
