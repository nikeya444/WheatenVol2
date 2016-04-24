package ua.dp.wheaten.site.root.repositories.impl;

import com.mysema.query.types.Predicate;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.QDocument;
import ua.dp.wheaten.site.root.entities.QDocumentDetail;
import ua.dp.wheaten.site.root.repositories.DocumentRepositoryCustom;


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
           //     .innerJoin(doc.details, detail).fetch()
                .where(predicate)
                .distinct()
                .orderBy(doc.dateOfDocument.asc(), doc.documentType.asc())
                .list(doc);

    }
}
