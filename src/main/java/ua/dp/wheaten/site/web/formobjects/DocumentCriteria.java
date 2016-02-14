package ua.dp.wheaten.site.web.formobjects;

import ua.dp.wheaten.site.root.entities.Document;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kkm on 11.02.2016.
 */
public class DocumentCriteria {
    private List<Document.Type> documentTypes = new LinkedList<>();
    private List<Integer> partnerIdList = new LinkedList<>();

    private boolean order;
    private LocalDate from;
    private LocalDate to;

    public List<Document.Type> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<Document.Type> documentTypes) {
        this.documentTypes = documentTypes;
    }

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }



    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public List<Integer> getPartnerIdList() {
        return partnerIdList;
    }

    public void setPartnerIdList(List<Integer> partnerIdList) {
        this.partnerIdList = partnerIdList;
    }
}
