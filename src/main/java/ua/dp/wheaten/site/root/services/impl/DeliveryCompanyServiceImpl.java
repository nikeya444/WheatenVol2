package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.DeliveryCompany;
import ua.dp.wheaten.site.root.repositories.DeliveryCompanyRepository;
import ua.dp.wheaten.site.root.services.DeliveryCompanyService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 02.09.15
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DeliveryCompanyServiceImpl
        extends AbstractGenericService<DeliveryCompany, Integer>
            implements DeliveryCompanyService {

    private DeliveryCompanyRepository repository;

    @Override
    protected CrudRepository<DeliveryCompany, Integer> getRepository() {
        return this.repository;
    }

    @Inject
    public void setRepository(DeliveryCompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryCompany findByName(String name) {
        return repository.findByName(name);
    }
}
