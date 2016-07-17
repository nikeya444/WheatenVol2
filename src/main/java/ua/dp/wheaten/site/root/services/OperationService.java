package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.MovementDocument;
import ua.dp.wheaten.site.root.entities.PurchaseDocument;
import ua.dp.wheaten.site.root.entities.SaleDocument;

/**
 * Created by kkm on 03.07.2016.
 */
public interface OperationService {
    void saveOperationFor(PurchaseDocument document);
    void saveOperationFor(SaleDocument document);
    void saveOperationFor(MovementDocument document);
}
