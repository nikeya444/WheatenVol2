package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.entities.Phone;
import ua.dp.wheaten.site.web.formobjects.PhoneForm;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 18:46
 * To change this template use File | Settings | File Templates.
 */
public interface PhoneService extends GenericService<Phone, Integer> {
    void save(Iterable<Phone> phones);
    List<Phone> convertAndSave(List<PhoneForm> phoneForms, Partner partner);
}
