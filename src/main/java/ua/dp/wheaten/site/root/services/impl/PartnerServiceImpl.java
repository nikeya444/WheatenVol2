package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;
import ua.dp.wheaten.site.root.services.CityService;
import ua.dp.wheaten.site.root.services.PartnerService;
import ua.dp.wheaten.site.root.services.PhoneService;
import ua.dp.wheaten.site.web.formobjects.PartnerForm;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 14.05.15
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PartnerServiceImpl
        extends AbstractGenericService<Partner, Integer>
            implements PartnerService {

    private PartnerRepository repository;
    private CityService cityService;
    private PhoneService phoneService;

    @Override
    protected CrudRepository<Partner, Integer> getRepository() {
        return repository;
    }

    @Inject
    public void setRepository(PartnerRepository repository) {
        this.repository = repository;
    }

    @Inject
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Inject
    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    public void save(PartnerForm form) {
        Partner partner = this.convert(form);
        super.save(partner);
        phoneService.convertAndSave(form.getPhoneForms(), partner);
    }

    private Partner convert(PartnerForm form) {
        Partner partner = new Partner();

        partner.setFirstname(form.getFirstname());
        partner.setLastname(form.getLastname());
        partner.setFathername(form.getFathername());
     //   partner.setPhones( phoneService.convertAndSave( form.getPhoneForms(), partner ));
        return partner;
    }
}
