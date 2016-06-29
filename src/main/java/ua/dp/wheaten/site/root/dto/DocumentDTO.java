package ua.dp.wheaten.site.root.dto;

import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.validation.Date;
import ua.dp.wheaten.site.root.validation.groups.DefaultGroup;
import ua.dp.wheaten.site.root.validation.groups.InGroup;
import ua.dp.wheaten.site.root.validation.groups.OutGroup;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkm on 21.06.2016.
 */
public class DocumentDTO {

    private Document.Type type;

    @NotNull(groups = {InGroup.class, OutGroup.class})
    private Partner partner;

    @Date(groups = DefaultGroup.class)
    private LocalDate dateOfDocument;

    @Size(min = 1)
    @Valid
    private List<DetailDTO> details = new ArrayList<>();

    private boolean status;

    public Document.Type getType() {
        return type;
    }

    public void setType(Document.Type type) {
        this.type = type;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public LocalDate getDateOfDocument() {
        return dateOfDocument;
    }

    public void setDateOfDocument(LocalDate dateOfDocument) {
        this.dateOfDocument = dateOfDocument;
    }

    public List<DetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<DetailDTO> details) {
        this.details = details;
    }

    public void addDetailForm(DetailDTO detailForm) {
        this.details.add(detailForm);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DocumentForm{" +
                "type=" + type +
                ", partner=" + partner +
                ", dateOfDocument=" + dateOfDocument +
                ", details=" + details +
                ", status=" + status +
                '}';
    }
}
