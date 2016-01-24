package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.Operation;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 16.09.15
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
public interface DocumentToOperationService {
    List<Operation> transform(Document document);
}
