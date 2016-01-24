package ua.dp.wheaten.site.root.repositories;

import ua.dp.wheaten.site.root.entities.IncomingDocument;

/**
 * Created by kkm on 16.01.2016.
 */
public interface InDocRepository {
    public IncomingDocument getOne(Integer id);
}
