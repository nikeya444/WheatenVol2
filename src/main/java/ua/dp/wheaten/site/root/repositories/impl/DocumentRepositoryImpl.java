package ua.dp.wheaten.site.root.repositories.impl;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.QDocument;
import ua.dp.wheaten.site.root.entities.QDocumentDetail;
import ua.dp.wheaten.site.root.repositories.DocumentRepositoryCustom;

import ua.dp.wheaten.site.web.formobjects.DetailCriteria;
import ua.dp.wheaten.site.web.formobjects.DocumentCriteria;
import ua.dp.wheaten.site.web.formobjects.SearchCriteria;


import java.util.List;

/**
 * Created by kkm on 10.02.2016.
 */
public class DocumentRepositoryImpl extends QueryDslRepositorySupport implements DocumentRepositoryCustom {


    public DocumentRepositoryImpl() {
        super(Document.class);
    }


    @Override
    public List<Document> findAllByCriteria(Predicate predicate) {
        QDocument doc = QDocument.document;
        QDocumentDetail detail = QDocumentDetail.documentDetail;

        return from(doc)
                .innerJoin(doc.details, detail).fetch()
                .where(predicate)
                .distinct().list(doc);

    }
}
