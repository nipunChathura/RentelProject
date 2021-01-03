/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentelproject.lk.ijse.rent.model;

/**
 *
 * @author Nipun
 */
public class Catargory {
    private String catargory_id;
    private String name;
    private int quantity;

    public Catargory() {
    }
    
    
    
    public Catargory(String catargory_id, String name, int quantity) {
        this.catargory_id = catargory_id;
        this.name = name;
        this.quantity = quantity;
    }

    

    /**
     * @return the catargory_id
     */
    public String getCatargory_id() {
        return catargory_id;
    }

    /**
     * @param catargory_id the catargory_id to set
     */
    public void setCatargory_id(String catargory_id) {
        this.catargory_id = catargory_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Catargory{" + "catargory_id=" + getCatargory_id() + ", name=" + getName() + ", quantity=" + getQuantity() + '}';
    }
    
}
