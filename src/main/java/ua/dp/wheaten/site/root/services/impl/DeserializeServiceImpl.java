package ua.dp.wheaten.site.root.services.impl;

import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.PersistableObject;
import ua.dp.wheaten.site.root.repositories.DomainObjectRepository;
import ua.dp.wheaten.site.root.services.DeserializeService;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 05.08.15
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DeserializeServiceImpl implements DeserializeService {

    private DomainObjectRepository repository;

    @Override
    @Transactional
    public PersistableObject getOne(Integer id, String className) {
        return repository.getOne(id, className);
    }

    @Inject
    public void setRepository(DomainObjectRepository repository) {
        this.repository = repository;
    }
}
