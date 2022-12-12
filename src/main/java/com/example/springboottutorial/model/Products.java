package com.example.springboottutorial.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @Column(columnDefinition = "productCode", name = "productCode", nullable = false, unique = true)
    private String productCode;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productLine")
    private String productLine;

    @Column(name = "productScale")
    private String productScale;

    @Column(name = "productVendor")
    private String productVendor;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(columnDefinition = "quantityInStock", name = "quantityInStock")
    private int quantityInStock;

    @Column(columnDefinition = "buyPrice", name = "buyPrice")
    private float buyPrice;

    @Column(name = "MSRP")
    private float MSRP;

    @Column(name = "productImageLink")
    private String productImageLink;

    public Products() {
    }

    public Products(String productCode, String productName, String productLine,
                    String productScale, String productVendor, String productDescription, int quantityInStock, float buyPrice, float MSRP, String productImageLink) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
        this.productImageLink = productImageLink;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getMSRP() {
        return MSRP;
    }

    public void setMSRP(float MSRP) {
        this.MSRP = MSRP;
    }

    public String getProductImageLink() {
        return productImageLink;
    }

    public void setProductImageLink(String productImageLink) {
        this.productImageLink = productImageLink;
    }
}
