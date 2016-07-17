package ua.dp.wheaten.site.root.services.impl;

import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.entities.SaleDocument;
import ua.dp.wheaten.site.root.repositories.SaleRepository;
import ua.dp.wheaten.site.root.services.OperationService;
import ua.dp.wheaten.site.root.services.SaleService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by kkm on 03.07.2016.
 */
@Service
public class SaleServiceDefault extends AbstractGenericService<SaleDocument, Integer> implements SaleService {

    @Inject
    private SaleRepository saleRepository;
    @Inject
    private OperationService operationService;

    @PersistenceContext
    private EntityManager em;

    @Override
    protected CrudRepository<SaleDocument, Integer> getRepository() {
        return this.saleRepository;
    }

    private void lookAtPersistenceContext() {
        SessionImplementor session = em.unwrap(SessionImplementor.class);
        org.hibernate.engine.spi.PersistenceContext context = session.getPersistenceContext();
        Map.Entry<Object, EntityEntry>[] entries = context.reentrantSafeEntityEntries();
        for (Map.Entry<Object, EntityEntry> entry: entries) {
            System.err.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Override
    @Transactional
    public void save(SaleDocument document) {
        document.setDetails(
                document.getDetails().stream().peek(d -> d.setDocument(document)).collect(Collectors.toList())
        );
        this.saleRepository.save(document);
        this.operationService.saveOperationFor(document);
        lookAtPersistenceContext();
    }

    @Override
    @Transactional
    public void update(Integer id, SaleDocument dirty) {
        SaleDocument clean = saleRepository.findOne(id);
        setProperties(clean, dirty);
        clean.getDetails().clear();
        clean.addAll(dirty.getDetails());
    }

    private void setProperties(SaleDocument clean, SaleDocument dirty) {
        if (!clean.getDateOfDocument()
                .equals(dirty.getDateOfDocument())) {
            clean.setDateOfDocument(dirty.getDateOfDocument());
        }
        if (!clean.getPartner().equals(dirty.getPartner())) {
            clean.setPartner(dirty.getPartner());
        }
    }
}
