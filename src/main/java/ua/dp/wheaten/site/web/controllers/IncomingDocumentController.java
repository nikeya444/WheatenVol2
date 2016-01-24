package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.services.DocumentService;
import ua.dp.wheaten.site.root.services.IncomingDocumentService;
import ua.dp.wheaten.site.root.services.ProductService;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by kkm on 12.01.2016.
 */
@Controller
@RequestMapping(value = "incoming")
public class IncomingDocumentController {

    @Inject
    private DocumentService documentService;
    @Inject
    private ProductService productService;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String showDocumentForm(Map<String, Object> model) {
        List<Product> products = productService.getAll();
        //model.put()
        return null;
    }

}
