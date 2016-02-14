package ua.dp.wheaten.site.root.repositories;

import com.mysema.query.types.Predicate;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.DocumentDetail;


import java.util.List;

/**
 * Created by kkm on 24.01.2016.
 */
public interface DetailRepository extends CrudRepository<DocumentDetail, Integer>, QueryDslPredicateExecutor<DocumentDetail> {

    List<DocumentDetail> findAll(Predicate predicate);
}
