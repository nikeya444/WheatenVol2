package ua.dp.wheaten.site.root.services.impl;

import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.entities.Rest;
import ua.dp.wheaten.site.root.repositories.RestRepository;
import ua.dp.wheaten.site.root.services.RestService;

import org.hibernate.*;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.print.Doc;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by kkm on 15.07.2016.
 */
@Service
@Transactional
public class RestServiceDefault extends AbstractGenericService<Rest, Integer> implements RestService {

    @Inject
    private RestRepository repository;

    @Override
    protected CrudRepository<Rest, Integer> getRepository() {
        return this.repository;
    }

    @Override
    public void updatePurchaseRest(Operation op) {
        Rest r = repository.findByProductAndStorage(op.getProduct(), op.getStorage());
        if (r == null) {
            createRest(op);
        } else {
            if (op.getType() == DocumentType.MOVEMENT) {
                calculateSumAndUpdate(r, op);
            } else {
                updateRest(r, op.getQuantity(), op.getSum());
            }
        }
    }

    @Override
    public void updateSaleRest(Operation op) {
        Rest r = repository.findByProductAndStorage(op.getProduct(), op.getStorage());
        calculateSumAndUpdate(r, op);
    }

    private void calculateSumAndUpdate(Rest r, Operation op) {
        BigDecimal sum = r.getSum().divide(new BigDecimal(r.getQuantity()), 2).multiply(new BigDecimal(op.getQuantity()));
        updateRest(r, op.getQuantity(), sum);
    }

    private void updateRest(Rest r, Integer qnt, BigDecimal sum) {
        r.setQuantity(r.getQuantity() + qnt);
        r.setSum(r.getSum().add(sum));
    }

    private void createRest(Operation op) {
        Rest r = new Rest(LocalDate.of(1991, 1, 1), op.getStorage(), op.getProduct(), op.getQuantity(), op.getSum());
        repository.save(r);
    }
}
