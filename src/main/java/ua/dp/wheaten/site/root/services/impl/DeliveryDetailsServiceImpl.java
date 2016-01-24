package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.DeliveryDetails;
import ua.dp.wheaten.site.root.repositories.DeliveryDetailsRepository;
import ua.dp.wheaten.site.root.services.DeliveryDetailsService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 05.09.15
 * Time: 1:26
 * To change this template use File | Settings | File Templates.
 */
public class DeliveryDetailsServiceImpl
        extends AbstractGenericService<DeliveryDetails, Integer>
            implements DeliveryDetailsService {

    private DeliveryDetailsRepository repository;

    @Override
    protected CrudRepository<DeliveryDetails, Integer> getRepository() {
        return this.repository;
    }

    @Inject
    public void setRepository(DeliveryDetailsRepository repository) {
        this.repository = repository;
    }
}
