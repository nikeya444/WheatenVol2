package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.repositories.DocumentRepository;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;
import ua.dp.wheaten.site.root.repositories.ProductRepository;
import ua.dp.wheaten.site.root.services.DocumentService;
import ua.dp.wheaten.site.web.formobjects.DocumentWrapper;

import javax.inject.Inject;
import java.util.HashMap;
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

    private static final String DOCUMENTS_JSP_PATH = "documents/doc";
    private static final String DOCUMENTS_JSP_ATTRIBUTE = "documents";
    private static final String TITLE = "title";
    private static Map<Document.Type, String> descriptions;

    @Inject
    private ProductRepository productService;
    @Inject
    private PartnerRepository partnerRepository;
    @Inject
    private DocumentRepository documentRepository;
    @Inject
    private DocumentService documentService;

    @RequestMapping(value = "{documentType}", method = RequestMethod.GET)
    public String showDocuments(@PathVariable String documentType, Map<String, Object> model) {

        Document.Type type = this.getDocumentType(documentType);

        List<Document> documents = documentService
                .findByDocumentTypeAndStatus(true, type);

        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put(TITLE, descriptions.get(type));

        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "incoming", method = RequestMethod.GET)
    public String showAllIncomingDocuments(Map<String, Object> model) {
        List<Document> documents = documentService.findIncomingDocuments(true);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put(TITLE, "Входящие документы");
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "outgoing", method = RequestMethod.GET)
    public String showAllOutgoingDocuments(Map<String, Object> model) {
        List<Document> documents = documentService.findOutgoingDocuments(true);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put(TITLE, "Исходящие документы");
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "movement", method = RequestMethod.GET)
    public String showAllMovementDocuments(Map<String, Object> model) {
        List<Document> documents = documentService.findMovementDocuments(true);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put(TITLE, "Документы перемещения");
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public String showAllOrders(Map<String, Object> model) {
        List<Document> orders = documentRepository.findAllByStatus(false);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, orders);
        model.put(TITLE, "Заказы");
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "new1", method = RequestMethod.GET)
    public String showDocumentForm(Map<String, Object> model) {
        Iterable<Product> products = productService.findAll();
        model.put("products", products);
        model.put("documentTypes", Document.Type.values());
        model.put("partners", partnerRepository.findAll());



        return "documents/incoming/new";
    }

    @RequestMapping(value = "new1", method = RequestMethod.POST)
    public @ResponseBody String addNewDocument(@RequestBody DocumentWrapper wrapper) {
        System.out.println("wrapper - " + wrapper.getDocument() + " details - " + wrapper.getDetails() );
        Document document = wrapper.getDocument();
        document.setDetails(wrapper.getDetails());
        documentRepository.save(document);

        return "redirect: documents/orders";
     //   return new RedirectView("/", true, false);
    //    return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    private Document.Type getDocumentType(String documentType) {
       return Document.Type
               .valueOf(documentType.toUpperCase());
    }

    static {
        descriptions = new HashMap<Document.Type, String>() {{
                put(Document.Type.PURCHASE, "Покупка");
                put(Document.Type.REFUND, "Возврат");
                put(Document.Type.SALE, "Продажа");
                put(Document.Type.WRITEOFF, "Списание");
                put(Document.Type.MOVEMENT, "Перемещение");
            }};
    }
}
