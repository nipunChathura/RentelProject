
package rentelproject.lk.ijse.rent.model;

public class Reservation {
    private String rid;
    private String customer_id;
    private String return_date;
    private String reservation_date_time;
    private double price;

    public Reservation() {
    }

    public Reservation(String rid, String customer_id, String return_date, String reservation_date_time, double price) {
        this.rid = rid;
        this.customer_id = customer_id;
        this.return_date = return_date;
        this.reservation_date_time = reservation_date_time;
        this.price = price;
    }

    public Reservation(String rid, String customerID, double price, String returnDate, String reservation_date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String toString() {
        return "Rservation{" + "rid=" + getRid() + ", customer_id=" + getCustomer_id() + ", return_date=" + getReturn_date() + ", reservation_date_time=" + getReservation_date_time() + ", price=" + getPrice() + '}';
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
     * @return the customer_id
     */
    public String getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the return_date
     */
    public String getReturn_date() {
        return return_date;
    }

    /**
     * @param return_date the return_date to set
     */
    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    /**
     * @return the reservation_date_time
     */
    public String getReservation_date_time() {
        return reservation_date_time;
    }

    /**
     * @param reservation_date_time the reservation_date_time to set
     */
    public void setReservation_date_time(String reservation_date_time) {
        this.reservation_date_time = reservation_date_time;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
