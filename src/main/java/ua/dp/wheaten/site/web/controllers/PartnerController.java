package ua.dp.wheaten.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;
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
    private PartnerRepository partnerService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String showAllPartners(Map<String, Object> model) {
        model.put("partners", partnerService.findAll());
        return "partners/list";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    @ModelAttribute("partnerForm")
    public PartnerForm showPartnerForm(Map<String, Object> model) {


        return new PartnerForm();
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public View addNewPartner(PartnerForm form) {
        System.out.println(form.getPhoneForms());
        System.out.println(form.getDeliveryForms());

        return new RedirectView("/partners/list", true, false);
    }
}
