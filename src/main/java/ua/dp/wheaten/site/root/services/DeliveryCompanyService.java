package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.DeliveryCompany;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 02.09.15
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public interface DeliveryCompanyService extends GenericService<DeliveryCompany, Integer> {
    DeliveryCompany findByName(String name);
}
