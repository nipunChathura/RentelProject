
package rentelproject.lk.ijse.rent.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import rentelproject.lk.ijse.rent.db.DBConnection;
import rentelproject.lk.ijse.rent.model.Customer;
import rentelproject.lk.ijse.rent.view.CustomerForm;

public class CustomerController {

    public static boolean addCustomer(rentelproject.lk.ijse.rent.model.Customer customer) throws ClassNotFoundException, SQLException{
        Connection conn =DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement("Insert into Customer Values(?,?,?,?,?)");
       
        stm.setObject(1,customer.getCustomer_id());
        stm.setObject(2,customer.getCustomr_name());
        stm.setObject(3,customer.getCustomer_nic());
        stm.setObject(4,customer.getCustomer_address());
        stm.setObject(5,customer.getCustomer_contact_no());
        return stm.executeUpdate()>0;
    
    }
    public static ArrayList<Customer> loadCustomer() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Customer";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement(); 
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Customer> AllCustomer = new ArrayList<>();
        
        while(rst.next()){
            Customer customer = new Customer();
            customer.setCustomer_id(rst.getString(1));
            customer.setCustomr_name(rst.getString(2));
            customer.setCustomer_address(rst.getString(4));
            customer.setCustomer_nic(rst.getString(3));
            customer.setCustomer_contact_no(Integer.parseInt(rst.getString(5)));
            AllCustomer.add(customer);
        }
        return AllCustomer;
    }
    
    public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement("Update Customer set customer_contact_no=?, customer_name=?, customer_NIC=?, customer_address=? where customer_ID=?");
        stm.setObject(1, customer.getCustomer_contact_no());
        stm.setObject(2, customer.getCustomr_name());
        stm.setObject(3, customer.getCustomer_nic());
        stm.setObject(4, customer.getCustomer_address());
        stm.setObject(5, customer.getCustomer_id());
        
        return stm.executeUpdate()>0;
    }
    
    public static boolean deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Delete from Customer where customer_ID=?");
        pstm.setObject(1, customer.getCustomer_id());
        return pstm.executeUpdate()>0;
    }
    public static ArrayList<String> loadCustomerID() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select customer_ID from Customer");
        ArrayList<String> list= new ArrayList<>();
        while(rst.next()){
            list.add(rst.getString(1));
        }
        return list;
    }
    
    public static String getCastomerId() throws ClassNotFoundException, SQLException{
        ResultSet set=DBConnection.getInstance().getConnection().prepareStatement("SELECT customer_ID FROM customer ORDER BY customer_ID DESC LIMIT 1;").executeQuery();
        if(set.next()){
            String tempId=set.getString(1);
            String[] arr = tempId.split("C");
            int id=Integer.parseInt(arr[1]);
            id+=1;
            if(id<10){
                return "C00"+id;
            }else if(id<100){
                return "C0"+id;
            }else{
                return "C"+id;
            }
        }else{
            return "C001";
        }
    }
}

