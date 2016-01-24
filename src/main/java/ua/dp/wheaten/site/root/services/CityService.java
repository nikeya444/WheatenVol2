package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.City;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 24.08.15
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public interface CityService extends GenericService<City, Integer> {
    City findByName(String name);
}
