package com.example.shopping;

public class Products {
    String  proId;
    String proName;
    int unitPrice ;
    String description;
    String manufacturer;
    String category;
    int noOfStock;

    String fileName;
    String quantity;

    public Products(String string, String string1, String string2, String string3, String string4, String string5, String string6, String string7) {
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String  quantity) {
        this.quantity = quantity;
    }

    public Products(String  proId, String proName, int unitPrice, String description, String manufacturer, String category, int noOfStock) {
        this.proId = proId;
        this.proName = proName;
        this.unitPrice = unitPrice;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
        this.noOfStock = noOfStock;
    }

    public Products() {
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfStock() {
        return noOfStock;
    }

    public void setNoOfStock(int noOfStock) {
        this.noOfStock = noOfStock;
    }

    @Override
    public String toString() {
        return "Products{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", category='" + category + '\'' +
                ", noOfStock=" + noOfStock +
                '}';
    }
}
