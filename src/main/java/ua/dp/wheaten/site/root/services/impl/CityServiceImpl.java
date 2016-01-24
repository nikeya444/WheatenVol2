package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.City;
import ua.dp.wheaten.site.root.repositories.CityRepository;
import ua.dp.wheaten.site.root.services.CityService;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 24.08.15
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CityServiceImpl
        extends AbstractGenericService<City, Integer>
            implements CityService {

    private CityRepository repository;

    @Override
    protected CrudRepository<City, Integer> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public City findByName(String name) {
        return repository.findByName(name);
    }

    @Inject
    public void setRepository(CityRepository repository) {
        this.repository = repository;
    }
}
