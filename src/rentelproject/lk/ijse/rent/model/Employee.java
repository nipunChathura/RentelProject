
package rentelproject.lk.ijse.rent.model;

public class Employee {
    private String employee_ID;
    private String employee_name;
    private String employee_address;
    private int employee_contact;
    private double employee_salary; 

    public Employee() {
    }

    public Employee(String employee_ID, String employee_name, String employee_address, int employee_contact, double employee_salary) {
        this.employee_ID = employee_ID;
        this.employee_name = employee_name;
        this.employee_address = employee_address;
        this.employee_contact = employee_contact;
        this.employee_salary = employee_salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "employee_ID=" + employee_ID + ", employee_name=" + employee_name + ", employee_address=" + employee_address + ", employee_contact=" + employee_contact + ", employee_salary=" + employee_salary + '}';
    }
    
    
    /**
     * @return the employee_ID
     */
    public String getEmployee_ID() {
        return employee_ID;
    }

    /**
     * @param employee_ID the employee_ID to set
     */
    public void setEmployee_ID(String employee_ID) {
        this.employee_ID = employee_ID;
    }

    /**
     * @return the employee_name
     */
    public String getEmployee_name() {
        return employee_name;
    }

    /**
     * @param employee_name the employee_name to set
     */
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    /**
     * @return the employee_address
     */
    public String getEmployee_address() {
        return employee_address;
    }

    /**
     * @param employee_address the employee_address to set
     */
    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    /**
     * @return the employee_contact
     */
    public int getEmployee_contact() {
        return employee_contact;
    }

    /**
     * @param employee_contact the employee_contact to set
     */
    public void setEmployee_contact(int employee_contact) {
        this.employee_contact = employee_contact;
    }

    /**
     * @return the employee_salary
     */
    public double getEmployee_salary() {
        return employee_salary;
    }

    /**
     * @param employee_salary the employee_salary to set
     */
    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }
    
    
}
