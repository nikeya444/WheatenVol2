package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.IncomingDetail;
import ua.dp.wheaten.site.root.repositories.IncomingDetailRepository;
import ua.dp.wheaten.site.root.services.IncomingDetailService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
@Service
public class IncomingDetailServiceImpl extends AbstractGenericService<IncomingDetail, Integer> implements IncomingDetailService {

    @Inject
    private IncomingDetailRepository repository;

    @Override
    protected CrudRepository<IncomingDetail, Integer> getRepository() {
        return this.repository;
    }
}
