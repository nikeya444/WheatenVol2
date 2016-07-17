package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.dp.wheaten.site.root.dto.DetailDTO;
import ua.dp.wheaten.site.root.dto.DocumentDTO;
import ua.dp.wheaten.site.root.entities.*;
import ua.dp.wheaten.site.root.repositories.DocumentRepository;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;
import ua.dp.wheaten.site.root.repositories.ProductRepository;
import ua.dp.wheaten.site.root.repositories.StorageRepository;
import ua.dp.wheaten.site.root.services.DocumentService;
import ua.dp.wheaten.site.root.services.MovementService;
import ua.dp.wheaten.site.root.services.PurchaseService;
import ua.dp.wheaten.site.root.services.SaleService;
import ua.dp.wheaten.site.root.validation.groups.InGroup;
import ua.dp.wheaten.site.root.validation.groups.MovementGroup;
import ua.dp.wheaten.site.root.validation.groups.OutGroup;
import ua.dp.wheaten.site.web.formobjects.DocumentCriteria;
import ua.dp.wheaten.site.web.formobjects.DocumentWrapper;
import ua.dp.wheaten.site.web.formobjects.SearchCriteria;

import javax.inject.Inject;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

    private static final String DOCUMENTS_JSP_PATH = "documents/docs";
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
    private PurchaseService purchaseService;
    @Inject
    private SaleService saleService;
    @Inject
    private MovementService movementService;
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

        model.put("searchCriteria", new SearchCriteria());
        model.put("action", "/documents/find");
        populateModel(model);
        return DOCUMENTS_JSP_PATH;
    }


    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public String showAllOrders(Map<String, Object> model) {
        List<Document> orders = documentRepository.findAllByStatus(false);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, orders);
        model.put(TITLE, "Заказы");
        model.put("searchCriteria", new SearchCriteria());
        model.put("action", "/documents/find");
        populateModel(model);
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public String findDocuments(SearchCriteria criteria, Map<String, Object> model) {
        System.err.println(criteria.getDocumentCriteria().getFrom() + " " + criteria.getDocumentCriteria().getTo() + " " + criteria.getDocumentCriteria().getDocumentTypes());
        List<Document> documents = documentService.findAllByCriteria(criteria);
        model.put(TITLE, TITLE_VALUE);
        model.put(DOCUMENTS_JSP_ATTRIBUTE, documents);
        model.put("searchCriteria", criteria);
        model.put("action", "/documents/find");
        populateModel(model);
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "purchase", method = RequestMethod.GET)
    public String showPurchaseDocuments(Map<String, Object> model) {

        model.put(DOCUMENTS_JSP_ATTRIBUTE, purchaseService.findAll());
        populateModel(model);
        model.put("searchCriteria", new SearchCriteria());
        model.put("action", "/documents/find");
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "purchase/add", method = RequestMethod.GET)
    public String newPurchaseDocument(Map<String, Object> model) {
        PurchaseDocument document = new PurchaseDocument();
        document.addDetail(new PurchaseDetail());
        populateModel(model);
        model.put("document", document);
        return "documents/newDocumentSpring";
    }

    @RequestMapping(value = "purchase/add", method = RequestMethod.POST)
    public String addPurchaseDocument(Map<String, Object> model,
                                      @ModelAttribute("document") PurchaseDocument document,
                                      Errors errors) {
        if (errors.hasErrors()) {
            populateModel(model);
            System.out.println(errors.getAllErrors());
            return "documents/newDocumentSpring";
        }

        purchaseService.save(document);

        return "redirect:/documents/purchase";
    }

    @RequestMapping(value = "sale", method = RequestMethod.GET)
    public String showSaleDocuments(Map<String, Object> model) {

        model.put(DOCUMENTS_JSP_ATTRIBUTE, saleService.findAll());
        populateModel(model);
        model.put("searchCriteria", new SearchCriteria());
        model.put("action", "/documents/find");
        return DOCUMENTS_JSP_PATH;
    }

    @RequestMapping(value = "sale/{id}", method = RequestMethod.GET)
    public String showSaleDocument(@PathVariable Integer id, Map<String, Object> model) {
        SaleDocument document = saleService.getOne(id);
        model.put("document", document);
        populateModel(model);
        return "documents/newDocumentSpring";
    }

    @RequestMapping(value = "sale/{id}", method = RequestMethod.POST)
    public String updateSale(@PathVariable Integer id, Map<String, Object> model,
                             @ModelAttribute("document") SaleDocument document, Errors errors) {

        if (errors.hasErrors()) {
            populateModel(model);
            return "documents/newDocumentSpring";
        }

        saleService.update(id, document);

        return "redirect:/documents/sale";
    }

    @RequestMapping(value = "sale/add", method = RequestMethod.GET)
    public String newSaleDocument(Map<String, Object> model) {
        SaleDocument document = new SaleDocument();
        document.addDetail(new SaleDetail());
        populateModel(model);
        model.put("document", document);
        return "documents/newDocumentSpring";
    }

    @RequestMapping(value = "sale/add", method = RequestMethod.POST)
    public String newSaleDocument(Map<String, Object> model, @ModelAttribute("document") SaleDocument document, Errors errors) {
        if (errors.hasErrors()) {
            populateModel(model);
            System.out.println(errors.getAllErrors());
            return "documents/newDocumentSpring";
        }

        saleService.save(document);

        return "redirect:/documents/sale";
    }

    @RequestMapping(value = "movement", method = RequestMethod.GET)
    public String showMovementDocuments(Map<String, Object> model) {

        model.put(DOCUMENTS_JSP_ATTRIBUTE, movementService.findAll());
        populateModel(model);
        model.put("searchCriteria", new SearchCriteria());
        model.put("action", "/documents/find");
        return "documents/moveDocs";
    }

    @RequestMapping(value = "movement/add", method = RequestMethod.GET)
    public String newMovementDocument(Map<String, Object> model) {
        MovementDocument document = new MovementDocument();
        document.addDetail(new MovementDetail());
        populateModel(model);
        model.put("document", document);
        return "documents/newMovement";
    }

    @RequestMapping(value = "movement/add", method = RequestMethod.POST)
    public String newMovementDocument(Map<String, Object> model, @ModelAttribute("document") MovementDocument document, Errors errors) {
        if (errors.hasErrors()) {
            populateModel(model);
            System.out.println(errors.getAllErrors());
            return "documents/newMovement";
        }

        movementService.save(document);

        return "redirect:/documents/movement";
    }

    private void populateModel(Map<String, Object> model) {
        model.put("partners", partnerRepository.findAll());
        model.put("products", productRepository.findAll());
        model.put("storages", storageRepository.findAll());

    }
}