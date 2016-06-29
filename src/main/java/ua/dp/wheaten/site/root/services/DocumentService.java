package ua.dp.wheaten.site.root.services;

import org.springframework.validation.annotation.Validated;
import ua.dp.wheaten.site.root.dto.DocumentDTO;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.web.formobjects.SearchCriteria;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 08.08.15
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
@Validated
public interface DocumentService extends GenericService<Document, Integer> {
    void save(DocumentDTO dto);
    List<Document> findByType(DocumentType type);
    void updateStatus(Integer id, boolean status);
    List<Document> findByDocumentTypeAndStatus(boolean status, Document.Type type);
    List<Document> findAllByCriteria(SearchCriteria searchCriteria);
    List<Document> findByStatus(boolean status);
    void update(Integer id, Document document);
    void delete(Integer id);
}
