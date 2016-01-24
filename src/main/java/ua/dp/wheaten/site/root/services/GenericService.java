package ua.dp.wheaten.site.root.services;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 08.08.15
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public interface GenericService<T, ID extends Serializable> {

    public T getOne(ID id);

    public List<T> getAll();

    public void save(T object);

    public void saveList(List<T> list);

    public void delete(T object);
}
