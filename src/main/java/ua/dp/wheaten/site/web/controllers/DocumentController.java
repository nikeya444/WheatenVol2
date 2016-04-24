package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentDetail;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.repositories.DocumentRepository;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;
import ua.dp.wheaten.site.root.repositories.ProductRepository;
import ua.dp.wheaten.site.root.repositories.StorageRepository;
import ua.dp.wheaten.site.root.services.DocumentService;
import ua.dp.wheaten.site.web.formobjects.DocumentCriteria;
import ua.dp.wheaten.site.web.formobjects.DocumentSearchCriteria;
import ua.dp.wheaten.site.web.formobjects.DocumentWrapper;
import ua.dp.wheaten.site.web.formobjects.SearchCriteria;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.*;

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
    private static final String TITLE_VALUE = "Документы";
    private static Map<Document.Type, String> descriptions;

    @Inject
    private ProductRepository productRepository;
    @Inject
    private PartnerRepository partnerRepository;
    @Inject
    private DocumentRepository documentRepository;
    @Inject
    private DocumentService documentService;
    @Inject
    private StorageRepository storageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllDocuments(Map<String, Object> model) {

        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.of(now.getYear(), now.getMonth(), 1);
        SearchCriteria criteria = new SearchCriteria();
        DocumentCriteria documentCriteria = new DocumentCriteria();
     //   documentCriteria.setFrom(from);
     //   documentCriteria.setTo(now);
        criteria.setDocumentCriteria(documentCriteria);
        List<Document> documents = documentService.findAllByCriteria(criteria);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put(TITLE, TITLE_VALUE);
        model.put("documentTypes", descriptions.entrySet());
        model.put("searchCriteria", new SearchCriteria());
        model.put("partners", partnerRepository.findAll());
        model.put("products", productRepository.findAll());
        model.put("storages", storageRepository.findAll());
        model.put("action", "/documents/find");
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String showDocument(@PathVariable Integer id, Map<String, Object> model) {
        Document document = documentRepository.findOne(id);
        DocumentWrapper wrapper = new DocumentWrapper(document);
        model.put("docWrapper", wrapper);

        model.put("documentTypes", descriptions.entrySet());
        model.put("searchCriteria", new SearchCriteria());
        model.put("partners", partnerRepository.findAll());
        model.put("products", productRepository.findAll());
        model.put("storages", storageRepository.findAll());
        model.put("action", "/documents/find");

        return "documents/newDocumentSpring";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public String updateDocument(@PathVariable Integer id, DocumentWrapper wrapper) {
        System.err.println("wrapper - " + wrapper.getDocument() + " details - " + wrapper.getDetails());
        documentService.update(id, wrapper);
        return "redirect:/" + DOCUMENTS_JSP_ATTRIBUTE;
    }

    @RequestMapping(value = "{id}/todocument", method = RequestMethod.POST)
    public String updateStatus(@PathVariable Integer id, SearchCriteria criteria, Map<String, Object> model) {

        Document document = documentRepository.findOne(id);
        document.setStatus(true);
        documentRepository.save(document);

        return "redirect:/documents/orders";
    }

    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public String showAllOrders(Map<String, Object> model) {
        List<Document> orders = documentRepository.findAllByStatus(false);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, orders);
        model.put(TITLE, "Заказы");
        model.put("documentTypes", descriptions.entrySet());
        model.put("searchCriteria", new SearchCriteria());
        model.put("partners", partnerRepository.findAll());
        model.put("products", productRepository.findAll());
        model.put("storages", storageRepository.findAll());
        model.put("action", "/documents/find");
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public String findDocuments(SearchCriteria criteria, Map<String, Object> model) {
        System.out.println(criteria.getDocumentCriteria().getFrom() + " " + criteria.getDocumentCriteria().getTo() + " " + criteria.getDocumentCriteria().getDocumentTypes());
        List<Document> documents = documentService.findAllByCriteria(criteria);
        model.put(TITLE, TITLE_VALUE);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put("documentTypes", descriptions.entrySet());
        model.put("searchCriteria", criteria);
        model.put("partners", partnerRepository.findAll());
        model.put("products", productRepository.findAll());
        model.put("storages", storageRepository.findAll());
        model.put("action", "/documents/find");
        System.out.println(documents);
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "new1", method = RequestMethod.GET)
    public String showDocumentForm(Map<String, Object> model) {
        Iterable<Product> products = productRepository.findAll();
        model.put("products", products);
        model.put("documentTypes", descriptions.entrySet());
        model.put("partners", partnerRepository.findAll());
        model.put("storages", storageRepository.findAll());



        return "documents/incoming/new";
    }

    @RequestMapping(value = "new1", method = RequestMethod.POST)
    public @ResponseBody String addNewDocument(@RequestBody DocumentWrapper wrapper) {
        System.out.println("wrapper - " + wrapper.getDocument() + " details - " + wrapper.getDetails());
        Document document = wrapper.getDocument();
        document.setDetails(wrapper.getDetails());
        documentRepository.save(document);

        return "redirect: documents/orders";
     //   return new RedirectView("/", true, false);
    //    return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String addNewDoc(Map<String, Object> model) {
       // Document document = documentRepository.findOne(3);
        DocumentWrapper wrapper = new DocumentWrapper(new Document(), Collections.singletonList(new DocumentDetail()));
        model.put("docWrapper", wrapper);
        model.put("products", productRepository.findAll());
        model.put("documentTypes", descriptions.entrySet());
        model.put("partners", partnerRepository.findAll());
        model.put("storages", storageRepository.findAll());
        return "documents/newDocumentSpring";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String addNewDoc(DocumentWrapper wrapper) {
        System.out.println("wrapper - " + wrapper.getDocument() + " details - " + wrapper.getDetails());
        Document document = wrapper.getDocument();
        document.setDetails(wrapper.getDetails());
        documentRepository.save(document);

        return "redirect:/documents";
    }

    private Document.Type getDocumentType(String documentType) {
       return Document.Type
               .valueOf(documentType.toUpperCase());
    }

    static {
        descriptions = new LinkedHashMap<Document.Type, String>() {{
                put(Document.Type.PURCHASE, "Покупка");
                put(Document.Type.REFUND, "Возврат");
                put(Document.Type.SALE, "Продажа");
                put(Document.Type.WRITEOFF, "Списание");
                put(Document.Type.MOVEMENT, "Перемещение");
            }};
    }
}
