package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentType;

import ua.dp.wheaten.site.root.repositories.DocumentRepository;

import ua.dp.wheaten.site.root.services.DocumentService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
 * Created by kkm on 21.01.2016.
 */

@Service
public class DocumentServiceImpl
                    extends AbstractGenericService<Document, Integer>
                        implements DocumentService {

    @Inject
    private DocumentRepository documentRepository;

    @Override
    protected CrudRepository<Document, Integer> getRepository() {
        return this.documentRepository;
    }

    @Override
    public List<Document> findByType(DocumentType type) {
        return null;
    }

    @Override
    @Transactional
    public void updateStatus(Integer id, boolean status) {
        Document document = getRepository().findOne(id);
        document.setStatus(status);
    }

    @Override
    public List<Document> findIncomingDocuments(boolean status) {
        return this.documentRepository.findAllByStatusAndDocumentTypeIn(
                true,
                asList(Document.Type.PURCHASE, Document.Type.REFUND)
        );
    }

    @Override
    public List<Document> findOutgoingDocuments(boolean status) {
        return this.documentRepository.findAllByStatusAndDocumentTypeIn(
                true,
                asList(Document.Type.SALE, Document.Type.WRITEOFF)
        );
    }

    @Override
    public List<Document> findMovementDocuments(boolean status) {
        return this.documentRepository
                .findAllByStatusAndDocumentTypeIn(
                    true,
                    singletonList(Document.Type.MOVEMENT)
                );
    }

    @Override
    public List<Document> findByDocumentTypeAndStatus(boolean status, Document.Type type) {
        return this.documentRepository
                .findAllByStatusAndDocumentTypeIn(
                        true,
                        singletonList(type)
                );
    }
}
