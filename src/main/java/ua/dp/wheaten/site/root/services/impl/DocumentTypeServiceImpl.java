package ua.dp.wheaten.site.root.services.impl;

import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.repositories.DocumentTypeRepository;
import ua.dp.wheaten.site.root.services.DocumentTypeService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DocumentTypeServiceImpl extends AbstractGenericService<DocumentType, Integer> implements DocumentTypeService {

    @Inject
    private DocumentTypeRepository repository;

    @Override
    public DocumentTypeRepository getRepository() {
        return repository;
    }

    @Override
    public DocumentType findByTypeName(String typeName) {
        return repository.findByType(typeName);
    }
}
