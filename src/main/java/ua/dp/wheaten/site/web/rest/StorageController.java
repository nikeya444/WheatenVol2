package ua.dp.wheaten.site.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.dp.wheaten.site.root.entities.Storage;
import ua.dp.wheaten.site.root.repositories.StorageRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kkm on 26.02.2016.
 */
@RestController
@RequestMapping("storages")
public class StorageController {

    @Inject
    private StorageRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Storage> sendAllStorages() {
        return repository.findAll();
    }

}
