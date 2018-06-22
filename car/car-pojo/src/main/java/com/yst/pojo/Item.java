package com.yst.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Item  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1710073067368653450L;

	private Integer id;

    private String name;

    private Integer status;

    private Integer brandModleId;

    private String labels;

    private Integer propertyType;

    private BigDecimal priceHigh;

    private BigDecimal priceLow;

    private Boolean isAuto;

    private Boolean isChinese;

    private Integer speedBox;

    private Integer priority;

    private Date createTime;

    private Integer stock;

    private String country;

    private String imgStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBrandModleId() {
        return brandModleId;
    }

    public void setBrandModleId(Integer brandModleId) {
        this.brandModleId = brandModleId;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels == null ? null : labels.trim();
    }

    public Integer getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }

    public BigDecimal getPriceHigh() {
        return priceHigh;
    }

    public void setPriceHigh(BigDecimal priceHigh) {
        this.priceHigh = priceHigh;
    }

    public BigDecimal getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(BigDecimal priceLow) {
        this.priceLow = priceLow;
    }

    public Boolean getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(Boolean isAuto) {
        this.isAuto = isAuto;
    }

    public Boolean getIsChinese() {
        return isChinese;
    }

    public void setIsChinese(Boolean isChinese) {
        this.isChinese = isChinese;
    }

    public Integer getSpeedBox() {
        return speedBox;
    }

    public void setSpeedBox(Integer speedBox) {
        this.speedBox = speedBox;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getImgStr() {
        return imgStr;
    }

    public void setImgStr(String imgStr) {
        this.imgStr = imgStr == null ? null : imgStr.trim();
    }
}