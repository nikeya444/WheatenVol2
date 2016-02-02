package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.ProductType;
import ua.dp.wheaten.site.root.repositories.DocumentRepository;
import ua.dp.wheaten.site.root.repositories.ProductRepository;
import ua.dp.wheaten.site.root.services.DocumentService;

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

    private static final String DOCUMETNS_JSP_PATH = "documents/doc";
    private static final String DOCUMENTS_JSP_ATTRIBUTE = "documents";
    private static final String TITLE = "title";

    @Inject
    private ProductRepository productService;
    @Inject
    private DocumentRepository documentRepository;
    @Inject
    private DocumentService documentService;

    @RequestMapping(value = "incoming", method = RequestMethod.GET)
    public String showAllIncomingDocuments(Map<String, Object> model) {
        List<Document> documents = documentService.findIncomingDocuments(true);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put(TITLE, "Входящие документы");
        return DOCUMETNS_JSP_PATH;
    }

    @RequestMapping(value = "outgoing", method = RequestMethod.GET)
    public String showAllOutgoingDocuments(Map<String, Object> model) {
        List<Document> documents = documentService.findOutgoingDocuments(true);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put(TITLE, "Исходящие документы");
        return DOCUMETNS_JSP_PATH;
    }

    @RequestMapping(value = "movement", method = RequestMethod.GET)
    public String showAllMovementDocuments(Map<String, Object> model) {
        List<Document> documents = documentService.findMovementDocuments(true);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put(TITLE, "Документы перемещения");
        return DOCUMETNS_JSP_PATH;
    }

    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public String showAllOrders(Map<String, Object> model) {
        List<Document> orders = documentRepository.findAllByStatus(false);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, orders);
        return DOCUMETNS_JSP_PATH;
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
