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
public class Item {
    private String item_code;
    private String catargory_id;
    private double pre_day_cost;
    private double extrar_charge;

    public Item() {
    }

    public Item(String item_code, String catargory_id, double pre_day_cost, double extrar_charge) {
        this.item_code = item_code;
        this.catargory_id = catargory_id;
        this.pre_day_cost = pre_day_cost;
        this.extrar_charge = extrar_charge;
    }

    @Override
    public String toString() {
        return "Item{" + "item_code=" + getItem_code() + ", catargory_id=" + getCatargory_id() + ", pre_day_cost=" + getPre_day_cost() + ", extrar_charge=" + getExtrar_charge() + '}';
    }

    /**
     * @return the item_code
     */
    public String getItem_code() {
        return item_code;
    }

    /**
     * @param item_code the item_code to set
     */
    public void setItem_code(String item_code) {
        this.item_code = item_code;
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
     * @return the pre_day_cost
     */
    public double getPre_day_cost() {
        return pre_day_cost;
    }

    /**
     * @param pre_day_cost the pre_day_cost to set
     */
    public void setPre_day_cost(double pre_day_cost) {
        this.pre_day_cost = pre_day_cost;
    }

    /**
     * @return the extrar_charge
     */
    public double getExtrar_charge() {
        return extrar_charge;
    }

    /**
     * @param extrar_charge the extrar_charge to set
     */
    public void setExtrar_charge(double extrar_charge) {
        this.extrar_charge = extrar_charge;
    }

    
    
}
