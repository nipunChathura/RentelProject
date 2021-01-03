
package rentelproject.lk.ijse.rent.model;

public class Reservation_ditail {
   private String rid;
   private String item_code;
   private String damage_id;
   private String employee_id;
   private String transport_id;
   private String payment_id;
   private double Ex_Charges;
   private String acchual_return_date;

    public Reservation_ditail() {
    }

    public Reservation_ditail(String rid, String item_code, String damage_id, String employee_id, String transport_id, String payment_id, double Ex_Charges, String acchual_return_date) {
        this.rid = rid;
        this.item_code = item_code;
        this.damage_id = damage_id;
        this.employee_id = employee_id;
        this.transport_id = transport_id;
        this.payment_id = payment_id;
        this.Ex_Charges = Ex_Charges;
        this.acchual_return_date = acchual_return_date;
    }

    @Override
    public String toString() {
        return "Reservation_ditail{" + "rid=" + getRid() + ", item_code=" + getItem_code() + ", damage_id=" + getDamage_id() + ", employee_id=" + getEmployee_id() + ", transport_id=" + getTransport_id() + ", payment_id=" + getPayment_id() + ", Ex_Charges=" + getEx_Charges() + ", acchual_return_date=" + getAcchual_return_date() + '}';
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
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
     * @return the employee_id
     */
    public String getEmployee_id() {
        return employee_id;
    }

    /**
     * @param employee_id the employee_id to set
     */
    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    /**
     * @return the transport_id
     */
    public String getTransport_id() {
        return transport_id;
    }

    /**
     * @param transport_id the transport_id to set
     */
    public void setTransport_id(String transport_id) {
        this.transport_id = transport_id;
    }

    /**
     * @return the payment_id
     */
    public String getPayment_id() {
        return payment_id;
    }

    /**
     * @param payment_id the payment_id to set
     */
    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    /**
     * @return the Ex_Charges
     */
    public double getEx_Charges() {
        return Ex_Charges;
    }

    /**
     * @param Ex_Charges the Ex_Charges to set
     */
    public void setEx_Charges(double Ex_Charges) {
        this.Ex_Charges = Ex_Charges;
    }

    /**
     * @return the acchual_return_date
     */
    public String getAcchual_return_date() {
        return acchual_return_date;
    }

    /**
     * @param acchual_return_date the acchual_return_date to set
     */
    public void setAcchual_return_date(String acchual_return_date) {
        this.acchual_return_date = acchual_return_date;
    }

   
   
   
}
