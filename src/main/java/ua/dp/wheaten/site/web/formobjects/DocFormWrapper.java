package ua.dp.wheaten.site.web.formobjects;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 05.08.15
 * Time: 22:55
 * To change this template use File | Settings | File Templates.
 */
public class DocFormWrapper implements ValueObject {
    private DocumentForm document;
    private List<DocumentDetailForm> details;

    public DocumentForm getDocument() {
        return document;
    }

    public void setDocument(DocumentForm document) {
        this.document = document;
    }

    public List<DocumentDetailForm> getDetails() {
        return details;
    }

    public void setDetails(List<DocumentDetailForm> details) {
        this.details = details;
    }
}
