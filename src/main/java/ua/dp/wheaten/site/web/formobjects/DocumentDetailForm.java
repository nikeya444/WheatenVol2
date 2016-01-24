package ua.dp.wheaten.site.web.formobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.ProductType;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 08.06.15
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentDetailForm implements ValueObject {
    @JsonProperty(value = "productId")
    private Product product;
    private Integer quantity;
    private Double price;
  //  private BigDecimal sum;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
   /*
    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

          */

    @Override
    public String toString() {
        return "DocumentDetailsForm{" +
                "productId='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
