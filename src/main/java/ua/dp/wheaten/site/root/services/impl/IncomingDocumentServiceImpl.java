package ua.dp.wheaten.site.root.services.impl;

import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.IncomingDocument;
import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.repositories.IncomingDocumentRepository;
import ua.dp.wheaten.site.root.repositories.OperationRepository;
import ua.dp.wheaten.site.root.services.DocumentService;
import ua.dp.wheaten.site.root.services.IncomingDetailService;
import ua.dp.wheaten.site.root.services.IncomingDocumentService;
import ua.dp.wheaten.site.root.services.OperationService;


import javax.inject.Inject;
import javax.naming.OperationNotSupportedException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 13.09.15
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
@Service("indoc")
public class IncomingDocumentServiceImpl
        extends AbstractDocumentService<IncomingDocument, Integer>
            implements IncomingDocumentService {

    @Inject
    private IncomingDocumentRepository documentRepository;
    @Inject
    private IncomingDetailService incomingDetailService;

    public IncomingDocumentRepository getRepository() {
        return documentRepository;
    }

    @Override
    protected List<Operation> createOperations(IncomingDocument document) {
        return Operation.createOperations(document);
    }
}
