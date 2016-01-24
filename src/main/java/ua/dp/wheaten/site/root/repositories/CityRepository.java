package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.City;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 24.08.15
 * Time: 11:54
 * To change this template use File | Settings | File Templates.
 */
public interface CityRepository extends CrudRepository<City, Integer> {
    City findByName(String name);
}
