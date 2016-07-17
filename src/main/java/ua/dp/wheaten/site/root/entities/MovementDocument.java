package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kkm on 03.07.2016.
 */
@Entity
@Table(name = "MOVEMENT_DOCUMENTS")
public class MovementDocument extends PersistableObjectAudit {

    public static final DocumentType TYPE = DocumentType.MOVEMENT;

    @Column(name = "DATE_OF_DOCUMENT")
    private LocalDate dateOfDocument;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<MovementDetail> details = new LinkedList<>();

    public LocalDate getDateOfDocument() {
        return dateOfDocument;
    }

    public void setDateOfDocument(LocalDate dateOfDocument) {
        this.dateOfDocument = dateOfDocument;
    }

    public List<MovementDetail> getDetails() {
        return details;
    }

    public void setDetails(List<MovementDetail> details) {
        this.details = details;
    }

    public void addDetail(MovementDetail detail) {
        this.details.add(detail);
    }

    public void addAll(Collection<MovementDetail> details) {
        this.details.addAll(
                details.stream()
                        .peek(d -> d.setDocument(this))
                        .collect(Collectors.toList())
        );
    }

    public DocumentType getType() {
        return TYPE;
    }
}
