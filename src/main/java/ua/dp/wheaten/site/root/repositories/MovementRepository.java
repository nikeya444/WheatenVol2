package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.MovementDocument;

import java.util.List;

/**
 * Created by kkm on 03.07.2016.
 */
public interface MovementRepository extends CrudRepository<MovementDocument, Integer> {
    List<MovementDocument> findAll();
}
