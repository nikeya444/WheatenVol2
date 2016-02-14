package ua.dp.wheaten.site.root.services.impl;

import com.mysema.query.BooleanBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.*;

import ua.dp.wheaten.site.root.repositories.DetailRepository;
import ua.dp.wheaten.site.root.repositories.DocumentRepository;

import ua.dp.wheaten.site.root.services.DocumentService;
import ua.dp.wheaten.site.web.formobjects.DetailCriteria;
import ua.dp.wheaten.site.web.formobjects.DocumentCriteria;
import ua.dp.wheaten.site.web.formobjects.SearchCriteria;

import javax.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;

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
    @Inject
    private DetailRepository detailRepository;

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
    public List<Document> findByDocumentTypeAndStatus(boolean status, Document.Type type) {
        return this.documentRepository
                .findAllByStatusAndDocumentTypeIn(
                        true,
                        singletonList(type)
                );
    }

    @Override
    public List<Document> findAllByCriteria(SearchCriteria searchCriteria) {
        BooleanBuilder builder = this.createPredicate( searchCriteria );
        return this.documentRepository.findAllByCriteria( builder );
    }

    private BooleanBuilder createPredicate(SearchCriteria searchCriteria) {

        BooleanBuilder builder = new BooleanBuilder();

        this.addDocumentPredicate(
                searchCriteria.getDocumentCriteria(),
                builder
        );

        this.addDetailPredicate(
                searchCriteria.getDetailCriteria(),
                builder
        );

        return builder;
    }


    private void addDocumentPredicate(DocumentCriteria criteria, BooleanBuilder builder) {

        if (criteria == null) return;

        QDocument doc = QDocument.document;

        if ( criteria.getDocumentTypes().size() > 0) {
            builder.and(
                    doc.documentType.in( criteria.getDocumentTypes() )
            );
        }

        if ( criteria.getFrom() != null ) {
            builder.and(doc.dateOfDocument.after(criteria.getFrom()));
        }

        if ( criteria.getTo() != null ) {
            builder.and(
                    doc.dateOfDocument.before( criteria.getTo() )
            );
        }

        List<Integer> partnerList = criteria.getPartnerIdList();
        if ( partnerList != null && partnerList.size() > 0 && partnerList.get(0) > 0) {
            builder.and(
                    doc.partner.id.in(partnerList)
            );
        }

        if ( !criteria.isOrder() ) {
            builder.and( doc.status.eq( true ) );
        }
    }

    private void addDetailPredicate(DetailCriteria criteria, BooleanBuilder builder) {

        if (criteria == null) return;

        QDocumentDetail detail = QDocumentDetail.documentDetail;

        List<Integer> productList = criteria.getProductIdList();
        if ( productList != null && productList.size() > 0 && productList.get(0) > 0) {
            builder.and(
                    detail.product.id.in( productList )
            );

        }

        List<Integer> storageList = criteria.getStorageIdList();
        if ( storageList != null &&  storageList.size() > 0 && storageList.get(0) > 0) {
            builder.and(
                    detail.storage.id.in( storageList )
            );
        }
    }


}
