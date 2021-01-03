
package rentelproject.lk.ijse.rent.model;

public class Customer {
    private String customer_id;
    private String customr_name;
    private String customer_nic;
    private String customer_address;
    private int customer_contact_no;

    public Customer() {
    }

    public Customer(String customer_id, String customr_name, String customer_nic, String customer_address, int customer_contact_no) {
        this.customer_id = customer_id;
        this.customr_name = customr_name;
        this.customer_nic = customer_nic;
        this.customer_address = customer_address;
        this.customer_contact_no = customer_contact_no;
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customer_id + ", customr_name=" + customr_name + ", customer_nic=" + customer_nic + ", customer_address=" + customer_address + ", customer_contact_no=" + customer_contact_no + '}';
    }

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
     * @return the customer_name
     */
    public String getCustomr_name() {
        return customr_name;
    }

    /**
     * @param customr_name the customer_name to set
     */
    public void setCustomr_name(String customr_name) {
        this.customr_name = customr_name;
    }

    /**
     * @return the customer_nic
     */
    public String getCustomer_nic() {
        return customer_nic;
    }

    /**
     * @param customer_nic the customer_nic to set
     */
    public void setCustomer_nic(String customer_nic) {
        this.customer_nic = customer_nic;
    }

    /**
     * @return the customer_address
     */
    public String getCustomer_address() {
        return customer_address;
    }

    /**
     * @param customer_address the customer_address to set
     */
    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    /**
     * @return the customer_contact_no
     */
    public int getCustomer_contact_no() {
        return customer_contact_no;
    }

    /**
     * @param customer_contact_no the customer_contact_no to set
     */
    public void setCustomer_contact_no(int customer_contact_no) {
        this.customer_contact_no = customer_contact_no;
    }

    
    
    }
