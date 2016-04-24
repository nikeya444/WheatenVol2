package ua.dp.wheaten.site.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kkm on 26.02.2016.
 */
@RestController
@RequestMapping("partners")
public class PartnerController {

    @Inject
    private PartnerRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Partner> showAllPartners() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"fullname"})
    public List<Partner> fetchLikeFullname(@RequestParam(value = "fullname", required = true) String fullname) {
        List<Partner> partners = repository.findByFullnameLike("%" + fullname + "%");
        System.out.println(partners.size());
        return partners;
    }

}
