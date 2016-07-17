package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.services.GenericService;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 06.05.15
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */

public abstract class AbstractGenericService<T, ID extends Serializable>
                        implements GenericService<T, ID> {

    protected abstract CrudRepository<T, ID> getRepository();

    public AbstractGenericService() {
    }

    @Override
    @Transactional
    public T getOne(ID id) {
        return getRepository().findOne(id);
    }

    @Override
    @Transactional
    public List<T> findAll() {
        return (List<T>) this.getRepository().findAll();
    }

    @Override
    @Transactional
    public void save(T object) {
        getRepository().save(object);
    }

    @Override
    @Transactional
    public void saveList(List<T> list) {
        getRepository().save(list);
    }

    @Override
    @Transactional
    public void delete(T object) {
        getRepository().delete(object);
    }

    @Transactional
    public void update(ID key, T source) {
        throw new UnsupportedOperationException("Update should be overriden");
    }
}
