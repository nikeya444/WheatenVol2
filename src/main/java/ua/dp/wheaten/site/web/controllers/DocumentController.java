package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.ProductType;
import ua.dp.wheaten.site.root.repositories.ProductRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 07.05.15
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "documents")
public class DocumentController {

    @Inject
    private ProductRepository productService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String showAllDocuments(Map<String, Object> model) {



        return "documents/documents";
    }

    @RequestMapping(value = "new1", method = RequestMethod.GET)
    public String showDocumentForm(Map<String, Object> model) {
        Iterable<Product> products = productService.findAll();
        model.put("products", products);

      //  form.setDetails(detailsForms);
        return "documents/new1";
    }

    @RequestMapping(value = "new1", method = RequestMethod.POST)
    public @ResponseBody String addNewDocument(@RequestBody ua.dp.wheaten.site.web.formobjects.DocFormWrapper form) {
        System.out.println(form.getDocument().getDocumentType());

        return "OK";
     //   return new RedirectView("/", true, false);
    //    return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
