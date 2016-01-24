package ua.dp.wheaten.site.web.formobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by kkm on 14.01.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingDocumentDTO {

    private String documentType;
    private String partnerName;
    private String storageName;
    private Date incomingDate;
    private boolean posted;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partner) {
        this.partnerName = partner;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public Date getIncomingDate() {
        return incomingDate;
    }

    public void setIncomingDate(Date incomingDate) {
        this.incomingDate = incomingDate;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }
}
