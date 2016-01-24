package ua.dp.wheaten.site.root.services.impl;

import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.repositories.OperationRepository;
import ua.dp.wheaten.site.root.services.DocumentService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by kkm on 21.01.2016.
 */

public abstract class AbstractDocumentService<T extends Document, ID extends Serializable>
                    extends AbstractGenericService<T, ID>
                        implements DocumentService<T, ID>{

    protected abstract List<Operation> createOperations(T document);

    @Inject
    private OperationRepository operationRepository;

    @Override
    public List<T> findByType(DocumentType type) {
        return null;
    }

    @Override
    @Transactional
    public void updateStatus(ID id, byte status) {

        T document = getRepository().findOne(id);
        document.setStatus(status);

        this.operationRepository.save(
                this.createOperations(document) );
    }
}
