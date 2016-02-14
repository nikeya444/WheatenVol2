package ua.dp.wheaten.site.web.formobjects;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kkm on 11.02.2016.
 */
public class DetailCriteria {

    private List<Integer> productIdList = new LinkedList<>();
    private List<Integer> storageIdList = new LinkedList<>();
    private BigDecimal sumMin;
    private BigDecimal sumMax;
    private Integer quantityMin;
    private Integer quantityMax;

    public List<Integer> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Integer> productIdList) {
        this.productIdList = productIdList;
    }

    public List<Integer> getStorageIdList() {
        return storageIdList;
    }

    public void setStorageIdList(List<Integer> storageIdList) {
        this.storageIdList = storageIdList;
    }

    public BigDecimal getSumMin() {
        return sumMin;
    }

    public void setSumMin(BigDecimal sumMin) {
        this.sumMin = sumMin;
    }

    public BigDecimal getSumMax() {
        return sumMax;
    }

    public void setSumMax(BigDecimal sumMax) {
        this.sumMax = sumMax;
    }

    public Integer getQuantityMin() {
        return quantityMin;
    }

    public void setQuantityMin(Integer quantityMin) {
        this.quantityMin = quantityMin;
    }

    public Integer getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(Integer quantityMax) {
        this.quantityMax = quantityMax;
    }
}
