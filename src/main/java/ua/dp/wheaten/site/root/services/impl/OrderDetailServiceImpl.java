package ua.dp.wheaten.site.root.services.impl;
/*
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
//import ua.dp.wheaten.site.root.entities.OrderDetail;
import ua.dp.wheaten.site.root.repositories.OrderDetailRepository;
import ua.dp.wheaten.site.root.services.OrderDetailService;
import ua.dp.wheaten.site.web.formobjects.DocumentDetailForm;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 14.05.15
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */    /*
@Service
public class OrderDetailServiceImpl
        extends AbstractGenericService<OrderDetail, Integer>
            implements OrderDetailService {

    private OrderDetailRepository repository;

    @Override
    protected CrudRepository<OrderDetail, Integer> getRepository() {
        return this.repository;
    }

    @Inject
    public void setRepository(OrderDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderDetail convert(Object vo) {
        DocumentDetailForm source = (DocumentDetailForm) vo;
        OrderDetail target = new OrderDetail();
    //    target.setPrice( new BigDecimal(source.getPrice()) );
        target.setProduct( source.getProduct() );
        target.setQuantity( source.getQuantity() );
        double sum = source.getPrice() * source.getQuantity();
        target.setSum(new BigDecimal(sum));
        return target;
    }
}             */
