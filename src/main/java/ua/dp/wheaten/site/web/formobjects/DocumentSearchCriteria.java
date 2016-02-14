package ua.dp.wheaten.site.web.formobjects;

import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import ua.dp.wheaten.site.root.entities.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by kkm on 07.02.2016.
 */
public class DocumentSearchCriteria {

  //  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate from;
  //  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate to;
    private List<Document.Type> documentTypes;


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

    public List<Document.Type> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<Document.Type> documentTypes) {
        this.documentTypes = documentTypes;
    }
}
