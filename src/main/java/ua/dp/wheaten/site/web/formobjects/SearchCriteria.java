package ua.dp.wheaten.site.web.formobjects;

/**
 * Created by kkm on 10.02.2016.
 */
public class SearchCriteria {
    private DocumentCriteria documentCriteria;
    private DetailCriteria detailCriteria;

    public DocumentCriteria getDocumentCriteria() {
        return documentCriteria;
    }

    public void setDocumentCriteria(DocumentCriteria documentCriteria) {
        this.documentCriteria = documentCriteria;
    }

    public DetailCriteria getDetailCriteria() {
        return detailCriteria;
    }

    public void setDetailCriteria(DetailCriteria detailCriteria) {
        this.detailCriteria = detailCriteria;
    }
}
