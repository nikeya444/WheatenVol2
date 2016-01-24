package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.entities.Phone;
import ua.dp.wheaten.site.root.repositories.PhoneRepository;
import ua.dp.wheaten.site.root.services.PhoneService;
import ua.dp.wheaten.site.web.formobjects.PhoneForm;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PhoneServiceImpl
        extends AbstractGenericService<Phone, Integer>
            implements PhoneService{

    private PhoneRepository repository;

    @Override
    protected CrudRepository<Phone, Integer> getRepository() {
        return this.repository;
    }

    @Override
    @Transactional
    public void save(Iterable<Phone> phones) {
        this.repository.save(phones);
    }

    @Inject
    public void setRepository(PhoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Phone> convertAndSave(List<PhoneForm> phoneForms, Partner partner) {
        List<Phone> phones = this.convert(phoneForms, partner);
        this.save(phones);
        return phones;
    }

    private List<Phone> convert(List<PhoneForm> phoneForms, Partner partner) {
        List<Phone> phones = new ArrayList<>(phoneForms.size());
        for (PhoneForm form: phoneForms) {
            Phone phone = new Phone();
            phone.setCode( form.getCode() );
            phone.setNumber( form.getNumber() );
            phone.setFullNumber( form.getCode() + form.getNumber() );
            phone.setPartner(partner);
            phones.add(phone);
        }
        return phones;
    }

}
