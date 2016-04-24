package ua.dp.wheaten.site.web.rest;

import org.springframework.web.bind.annotation.*;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.services.DocumentService;
import ua.dp.wheaten.site.web.formobjects.SearchCriteria;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kkm on 24.02.2016.
 */
@RestController
@RequestMapping(value = "documents")
public class DocumentController {

    private static Map<Document.Type, String> descriptions;

    @Inject
    private DocumentService documentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Document> showDocuments(@RequestParam(value = "status", required = false, defaultValue = "true") boolean status) {
        System.out.println(status);
        List<Document> documents = documentService.findByStatus(status);
        return documents;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Document showOneDocument(@PathVariable Integer id) {
        return documentService.getOne(id);
    }

    @RequestMapping(value = "types", method = RequestMethod.GET)
    public Set<Map.Entry<Document.Type, String>> sendTypes() {
        return descriptions.entrySet();
    }

    static {
        descriptions = new LinkedHashMap<Document.Type, String>() {{
            put(Document.Type.PURCHASE, "Покупка");
            put(Document.Type.REFUND, "Возврат");
            put(Document.Type.SALE, "Продажа");
            put(Document.Type.WRITEOFF, "Списание");
            put(Document.Type.MOVEMENT, "Перемещение");
        }};
    }
}
