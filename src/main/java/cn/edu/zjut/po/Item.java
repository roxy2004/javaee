package cn.edu.zjut.po;

import java.sql.Blob;
public class Item {
    private ItemPK ipk;
    private String description;
    private float cost;
    public Item() {
    }
    public Item(ItemPK ipk, String description, float cost) {
        this.ipk=ipk;
        this.description=description;
        this.cost=cost;
    }
    public ItemPK getIpk() {
        return ipk;
    }
    public void setIpk(ItemPK ipk) {
        this.ipk = ipk;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
}