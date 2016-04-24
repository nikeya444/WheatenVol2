package ua.dp.wheaten.site.root.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.Partner;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 06.05.15
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */
public interface PartnerRepository extends CrudRepository<Partner, Integer> {

    @Query(value = "select p.fullname from Partner p")
    List<String> findPartnersFullnames();

    List<Partner> findByFullnameLike(String name);

    @Query(value = "select p.id, p.fullname from Partner p")
    Map<Integer, String> findAllNames();
    Partner findByFullname(String fullname);
    Partner findByFirstnameOrLastname(String firstname, String lastname);
    List<Partner> findAll();
}
