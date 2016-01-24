package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.DocumentDetail;

/**
 * Created by kkm on 24.01.2016.
 */
public interface DetailRepository extends CrudRepository<DocumentDetail, Integer> {
}
