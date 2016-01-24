package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.DeliveryCompany;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 02.09.15
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public interface DeliveryCompanyRepository extends CrudRepository<DeliveryCompany, Integer> {
    DeliveryCompany findByName(String name);
}
