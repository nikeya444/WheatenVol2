package ua.dp.wheaten.site.root.dto.old;

import ua.dp.wheaten.site.root.entities.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kkm on 05.05.2016.
 */
public class DocumentDTO_OLD {
    private Document.Type type;
    private String partnerName;
    private LocalDate dateOfDocument;
    private boolean status;
    private List<DocumentDetailDTO> details = new LinkedList<>();

    public Document.Type getType() {
        return type;
    }

    public void setType(Document.Type type) {
        this.type = type;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public LocalDate getDateOfDocument() {
        return dateOfDocument;
    }

    public void setDateOfDocument(LocalDate dateOfDocument) {
        this.dateOfDocument = dateOfDocument;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DocumentDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<DocumentDetailDTO> details) {
        this.details = details;
    }

    public static DocumentDTO_OLD init() {
        DocumentDTO_OLD dto = new DocumentDTO_OLD();
        dto.setDetails(Collections.singletonList(new DocumentDetailDTO()));
        return dto;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "type=" + type +
                ", partnerName='" + partnerName + '\'' +
                ", dateOfDocument=" + dateOfDocument +
                ", details=" + details +
                '}';
    }

    /**
     * Created by kkm on 05.05.2016.
     */
    public static class DocumentDetailDTO {
        private String productName;
        private Integer quantity;
        private BigDecimal sum;
        private String storageName;
        private BigDecimal price;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getStorageName() {
            return storageName;
        }

        public void setStorageName(String storageName) {
            this.storageName = storageName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getSum() {
            return sum;
        }

        public void setSum(BigDecimal sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "DocumentDetailDTO{" +
                    "productName='" + productName + '\'' +
                    ", quantity=" + quantity +
                    ", sum=" + sum +
                    ", storageName='" + storageName + '\'' +
                    '}';
        }
    }
}
