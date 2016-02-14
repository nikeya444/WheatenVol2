package ua.dp.wheaten.site.root.repositories;

import com.mysema.query.types.Predicate;
import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.web.formobjects.SearchCriteria;

import java.util.List;

/**
 * Created by kkm on 10.02.2016.
 */
public interface DocumentRepositoryCustom {
    List<Document> findAllByCriteria(Predicate predicate);
}
