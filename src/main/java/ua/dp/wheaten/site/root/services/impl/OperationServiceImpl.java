package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.repositories.OperationRepository;
import ua.dp.wheaten.site.root.services.OperationService;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OperationServiceImpl extends AbstractGenericService<Operation, Integer> implements OperationService {

    @Inject
    private OperationRepository repository;

    @Override
    protected CrudRepository<Operation, Integer> getRepository() {
        return this.repository;
    }

    @Override
    public Iterable<Operation> findByDocTypeAndId(DocumentType docType, Integer id) {
        return repository.findByDocumentTypeAndDocumentId(docType, id);
    }

    @Override
    @Transactional
    public void updateList(Iterable<Operation> operations) {
        this.repository.save(operations);
    }
}
