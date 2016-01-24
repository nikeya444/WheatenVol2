package ua.dp.wheaten.site.root.services;

import ua.dp.wheaten.site.root.entities.PersistableObject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 05.08.15
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public interface DeserializeService {
    PersistableObject getOne(Integer id, String className);
}
