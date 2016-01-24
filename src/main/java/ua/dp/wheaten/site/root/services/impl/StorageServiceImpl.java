package ua.dp.wheaten.site.root.services.impl;

import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.Storage;
import ua.dp.wheaten.site.root.repositories.StorageRepository;
import ua.dp.wheaten.site.root.services.StorageService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StorageServiceImpl extends AbstractGenericService<Storage, Integer> implements StorageService {

    @Inject
    private StorageRepository repository;

    @Override
    public StorageRepository getRepository() {
        return repository;
    }
}
