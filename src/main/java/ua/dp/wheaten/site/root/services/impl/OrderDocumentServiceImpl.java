package ua.dp.wheaten.site.root.services.impl;
 /*
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.OrderDetail;
import ua.dp.wheaten.site.root.entities.OrderDocument;
import ua.dp.wheaten.site.root.repositories.OrderDocumentRepository;
import ua.dp.wheaten.site.root.services.OrderDetailService;
import ua.dp.wheaten.site.root.services.OrderDocumentService;
import ua.dp.wheaten.site.web.formobjects.DocFormWrapper;
import ua.dp.wheaten.site.web.formobjects.DocumentDetailForm;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 14.05.15
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */ /*
@Service
public class OrderDocumentServiceImpl
        extends AbstractGenericService<OrderDocument, Integer>
            implements OrderDocumentService {

    private OrderDocumentRepository repository;

    private OrderDetailService detailService;

    @Override
    protected CrudRepository<OrderDocument, Integer> getRepository() {
        return repository;
    }

    @Inject
    public void setRepository(OrderDocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<OrderDocument> findByType(DocumentType type) {
        return null;
    }

    @Override
    public Iterable<OrderDocument> getCurrent() {
        return null;
    }

    @Override
    public void saveDocument(Object vo) {
        OrderDocument document = this.convert(vo);
        this.save(document);
    }

    OrderDocument convert(Object vo) {
        DocFormWrapper source = (DocFormWrapper) vo;
        OrderDocument document = new OrderDocument();

        document.setDetails(
                convertDetails(
                        source.getDetails(), document )
        );
        document.setDocumentType(source.getDocument().getDocumentType());
        document.setPartner(source.getDocument().getPartner());
        return document;
    }

    private List<OrderDetail> convertDetails(List<DocumentDetailForm> sourceList,
                                                 OrderDocument document) {
        List<OrderDetail> details = new ArrayList<>(sourceList.size());
        BigDecimal sum = new BigDecimal(0);
        sourceList
                .stream()
                .forEach(
                        detailVO -> {
                            OrderDetail od = detailService.convert(detailVO);
                            od.setDocument(document);
                            sum.add(od.getSum());
                            details.add(od);
                        }
                );
    //    document.setSum(sum);
        return details;
    }

    @Inject
    public void setDetailService(OrderDetailService detailService) {
        this.detailService = detailService;
    }
}              */
