package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.services.CityService;
import ua.dp.wheaten.site.root.services.DeliveryCompanyService;
import ua.dp.wheaten.site.root.services.PartnerService;
import ua.dp.wheaten.site.web.formobjects.PartnerForm;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 14.05.15
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "partners")
public class PartnerController {

    @Inject
    private PartnerService partnerService;
    @Inject
    private CityService cityService;
    @Inject
    private DeliveryCompanyService deliveryCompanyService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String showAllPartners(Map<String, Object> model) {
        model.put("partners", partnerService.getAll());
        return "partners/list";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    @ModelAttribute("partnerForm")
    public PartnerForm showPartnerForm(Map<String, Object> model) {
        model.put("cities", cityService.getAll());
        model.put("deliveryServices", deliveryCompanyService.getAll());
        return new PartnerForm();
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public View addNewPartner(PartnerForm form) {
        System.out.println(form.getPhoneForms());
        System.out.println(form.getDeliveryForms());
        //partnerService.save(form);
        return new RedirectView("/partners/list", true, false);
    }
}
