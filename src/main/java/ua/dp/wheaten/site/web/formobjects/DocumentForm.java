package ua.dp.wheaten.site.web.formobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentType;
import ua.dp.wheaten.site.root.entities.Partner;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 14.05.15
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentForm {

    @JsonProperty(value = "documentType")
    private String documentType;

    @JsonProperty(value = "partnerId")
    private Integer partner;

  //  private Integer userId;

  //  private List<DocumentDetailsForm> details;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Integer getPartner() {
        return partner;
    }

    public void setPartner(Integer partner) {
        this.partner = partner;
    }
  /*
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<DocumentDetailsForm> getDetails() {
        return details;
    }

    public void setDetails(List<DocumentDetailsForm> details) {
        this.details = details;
    }    */

    @Override
    public String toString() {
        return "DocumentForm{" +
                "documentType='" + documentType + '\'' +
                ", partner='" + partner + '\'' +
         //       ", details=" + details +
                '}';
    }
}
