
package rentelproject.lk.ijse.rent.model;

public class Payment {
    private String payment_id;
    private double amount;
    private String payment_date;

    public Payment() {
    }

    public Payment(String payment_id, double amount, String payment_date) {
        this.payment_id = payment_id;
        this.amount = amount;
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "Payment{" + "payment_id=" + payment_id + ", amount=" + amount + ", payment_date=" + payment_date + '}';
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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the payment_date
     */
    public String getPayment_date() {
        return payment_date;
    }

    /**
     * @param payment_date the payment_date to set
     */
    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
    
    
}
