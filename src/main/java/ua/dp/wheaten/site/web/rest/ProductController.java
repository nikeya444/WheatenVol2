package ua.dp.wheaten.site.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.repositories.ProductRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kkm on 26.02.2016.
 */
@RestController
@RequestMapping("products")
public class ProductController {

    @Inject
    private ProductRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> showAllProducts() {
        return repository.findAll();
    }

}
