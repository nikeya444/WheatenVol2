package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.Operation;
import ua.dp.wheaten.site.root.entities.Rest;

/**
 * Created by kkm on 15.07.2016.
 */
public interface RestService extends GenericService<Rest, Integer> {

    void updatePurchaseRest(Operation operation);
    void updateSaleRest(Operation operation);

}
