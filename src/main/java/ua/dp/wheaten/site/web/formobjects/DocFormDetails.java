package ua.dp.wheaten.site.web.formobjects;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 02.08.15
 * Time: 1:26
 * To change this template use File | Settings | File Templates.
 */
public class DocFormDetails {
    private String product;
    private Integer quantity;
    private Double price;
    //  private BigDecimal sum;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
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
