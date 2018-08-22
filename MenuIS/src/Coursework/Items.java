/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coursework;

/**
 *
 * @author 
 */
public class Items {
    private int productId;
    private String name;
    private String category;
    private String group;
    private String size;
    private int quantity;
    private int price;

    public Items(Object[] data){
        productId = (Integer)data[0];
        name = String.valueOf(data[1]);
        category = String.valueOf(data[2]);
        group = String.valueOf(data[3]);
        size = String.valueOf(data[4]);
        quantity = (Integer)data[5];
        price = (Integer)data[6];
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    } 
}
