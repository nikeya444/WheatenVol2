package ua.dp.wheaten.site.web.formobjects;

import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentDetail;

import javax.print.Doc;
import java.util.List;

/**
 * Created by kkm on 04.02.2016.
 */
public class DocumentWrapper {
    private Document document;
    private List<DocumentDetail> details;

    public DocumentWrapper() {
    }

    public DocumentWrapper(Document document) {
        this.document = document;
        this.details = document.getDetails();
    }

    public DocumentWrapper(Document document, List<DocumentDetail> details) {
        this.document = document;
        this.details = details;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<DocumentDetail> getDetails() {
        return details;
    }

    public void setDetails(List<DocumentDetail> details) {
        this.details = details;
    }
}
