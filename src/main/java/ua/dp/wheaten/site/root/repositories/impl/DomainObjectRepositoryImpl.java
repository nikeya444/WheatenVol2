package ua.dp.wheaten.site.root.repositories.impl;

import org.springframework.stereotype.Repository;
import ua.dp.wheaten.site.root.entities.PersistableObject;
import ua.dp.wheaten.site.root.repositories.DomainObjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 03.08.15
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class DomainObjectRepositoryImpl implements DomainObjectRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public PersistableObject getOne(Integer id, String className) {
        Query query =
                entityManager.createQuery("select o from " + className + " o where o.id = :id");
        query.setParameter("id", id);
        return (PersistableObject) query.getSingleResult();
    }
}
