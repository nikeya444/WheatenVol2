package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.repositories.ProductRepository;
import ua.dp.wheaten.site.web.formobjects.ProductForm;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 13.05.15
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("products")
public class ProductController {

    @Inject
    private ProductRepository productRepository;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String showAll(Map<String, Object> model) {
        model.put("products", productRepository.findAll());
        return "products/list";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String showNewProductForm(Map<String, Object> model) {
        model.put("productForm", new Product());
        return "products/new";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public View addNewProduct(Product productForm) {
        //Product product = convert(productForm);
        //productRepository.save(product);
        System.out.println(productForm.getId() + " " + productForm.getName()+ " " + productForm.getDescription());
        return new RedirectView("list", true, false);
    }

    @RequestMapping(value = "edit/{productId}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Integer productId, Map<String, Object> model) {
        Product product = productRepository.findOne(productId);
        ProductForm form = convert(product);
        System.out.println(form);
        model.put("productForm", form);
        return "products/edit";
    }

    @RequestMapping(value = "edit/{productId}", method = RequestMethod.POST)
    public View editProduct(@PathVariable Integer productId, ProductForm form) {
        Product product = productRepository.findOne(productId);
        product.setName(form.getName());
        product.setDescription( form.getDescription() );
        productRepository.save(product);
        return new RedirectView("/products/list", true, false);
    }

    private Product convert(ProductForm form) {
        Product product = new Product();
        product.setName(form.getName());
        product.setDescription( form.getDescription() );
        return product;
    }

    private ProductForm convert(Product product) {
        ProductForm form = new ProductForm();
        form.setName( product.getName() );
        form.setDescription( product.getDescription() );
        return form;
    }


}
