package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.web.formobjects.PartnerForm;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 08.08.15
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public interface PartnerService extends GenericService<Partner, Integer> {
    void save(PartnerForm form);
}
