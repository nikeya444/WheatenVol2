package ua.dp.wheaten.site.root.services.impl;

import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.OutgoingDetail;
import ua.dp.wheaten.site.root.repositories.OutgoingDetailRepository;
import ua.dp.wheaten.site.root.services.OutgoingDetailService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OutgoingDetailServiceImpl extends AbstractGenericService<OutgoingDetail, Integer> implements OutgoingDetailService {

    @Inject
    private OutgoingDetailRepository repository;

    @Override
    public OutgoingDetailRepository getRepository() {
        return repository;
    }
}
