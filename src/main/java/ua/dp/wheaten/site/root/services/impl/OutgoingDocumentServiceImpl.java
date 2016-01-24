package ua.dp.wheaten.site.root.services.impl;

import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.entities.OutgoingDocument;
import ua.dp.wheaten.site.root.repositories.OutgoingDocumentRepository;
import ua.dp.wheaten.site.root.services.OutgoingDetailService;
import ua.dp.wheaten.site.root.services.OutgoingDocumentService;

import javax.inject.Inject;
import javax.swing.text.AbstractDocument;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OutgoingDocumentServiceImpl
        extends AbstractDocumentService<OutgoingDocument, Integer>
            implements OutgoingDocumentService {

    @Inject
    private OutgoingDocumentRepository outgoingDocumentRepository;
    @Inject
    private OutgoingDetailService detailService;

    @Override
    public OutgoingDocumentRepository getRepository() {
        return outgoingDocumentRepository;
    }

    @Override
    protected List<Operation> createOperations(OutgoingDocument document) {
        return Operation.createOperations(document);
    }
}
