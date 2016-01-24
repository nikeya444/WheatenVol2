package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.Partner;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 06.05.15
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */
public interface PartnerRepository extends CrudRepository<Partner, Integer> {

    Partner findByFirstnameOrLastname(String firstname, String lastname);
}
