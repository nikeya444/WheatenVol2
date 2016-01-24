package ua.dp.wheaten.site.root.repositories.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dp.wheaten.site.root.entities.IncomingDocument;
import ua.dp.wheaten.site.root.repositories.InDocRepository;
import ua.dp.wheaten.site.root.repositories.IncomingDocumentRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;

/**
 * Created by kkm on 16.01.2016.
 */
@Repository
public class IncomingDocumentRepositoryImpl implements InDocRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public IncomingDocument getOne(Integer id) {
        TypedQuery<IncomingDocument> query = entityManager.createQuery(
                "select indoc from IncomingDocument indoc where indoc.id = :id", IncomingDocument.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
