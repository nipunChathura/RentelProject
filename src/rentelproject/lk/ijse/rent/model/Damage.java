
package rentelproject.lk.ijse.rent.model;

public class Damage {
    private String damage_id;
    private String damage_date;
    private String damage_information;
    private double damage_cost;
    
    public Damage() {
    }

    public Damage(String damage_id, String damage_date, String damage_information, double damage_cost) {
        this.damage_id = damage_id;
        this.damage_date = damage_date;
        this.damage_information = damage_information;
        this.damage_cost = damage_cost;
    }

    public Damage(String damageID, String date, String damageInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Damage{" + "damage_id=" + getDamage_id() + ", damage_date=" + getDamage_date() + ", damage_information=" + getDamage_information() + ", damage_cost=" + getDamage_cost() + '}';
    }

    /**
     * @return the damage_id
     */
    public String getDamage_id() {
        return damage_id;
    }

    /**
     * @param damage_id the damage_id to set
     */
    public void setDamage_id(String damage_id) {
        this.damage_id = damage_id;
    }

    /**
     * @return the damage_date
     */
    public String getDamage_date() {
        return damage_date;
    }

    /**
     * @param damage_date the damage_date to set
     */
    public void setDamage_date(String damage_date) {
        this.damage_date = damage_date;
    }

    /**
     * @return the damage_information
     */
    public String getDamage_information() {
        return damage_information;
    }

    /**
     * @param damage_information the damage_information to set
     */
    public void setDamage_information(String damage_information) {
        this.damage_information = damage_information;
    }

    /**
     * @return the damage_cost
     */
    public double getDamage_cost() {
        return damage_cost;
    }

    /**
     * @param damage_cost the damage_cost to set
     */
    public void setDamage_cost(double damage_cost) {
        this.damage_cost = damage_cost;
    }
    
    
    
}
