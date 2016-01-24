package ua.dp.wheaten.site.web.controllers;
   /*
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.dp.wheaten.site.root.entities.OrderDocument;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.ProductType;
import ua.dp.wheaten.site.root.services.OrderDocumentService;
import ua.dp.wheaten.site.root.services.PartnerService;
import ua.dp.wheaten.site.root.services.ProductService;
import ua.dp.wheaten.site.web.formobjects.DocFormWrapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 11.08.15
 * Time: 18:32
 * To change this template use File | Settings | File Templates.
 *
@Controller
@RequestMapping(value = "orders")
public class OrderController {

    @Inject
    private OrderDocumentService orderService;
    @Inject
    private ProductService productService;
    @Inject
    private PartnerService partnerService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String showAllOrders(Map<String, Object> model) {

        //todo: get data

        return "documents/orders/documents";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String showDocumentForm(Map<String, Object> model) {
        List<Product> products = productService.getAll();
        List<Partner> partners = partnerService.getAll();
        model.put("products", products);

        model.put("partners", partners);
        //  form.setDetails(detailsForms);
        return "documents/orders/new";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public @ResponseBody
    String addNewOrder(@RequestBody DocFormWrapper form) {
        orderService.saveDocument(form);
        return "OK";
    }

    @RequestMapping(value = "current", method = RequestMethod.GET)
    public String showCurrentOrders(Map<String, Object> model) {
        Iterable<OrderDocument> orders = orderService.getCurrent();
        model.put("orders", orders);
        return "documents/orders/current";
    }
}           */
