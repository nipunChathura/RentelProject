
package rentelproject.lk.ijse.rent.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import rentelproject.lk.ijse.rent.db.DBConnection;
import rentelproject.lk.ijse.rent.model.Damage;
import rentelproject.lk.ijse.rent.model.Employee;
import rentelproject.lk.ijse.rent.model.Item;
import rentelproject.lk.ijse.rent.model.Payment;
import rentelproject.lk.ijse.rent.model.Reservation;
import rentelproject.lk.ijse.rent.model.Reservation_ditail;
import rentelproject.lk.ijse.rent.model.Transport;

public class AcceptanceController {
    public static boolean addData(Reservation_ditail resiReservation_ditail,Transport transport,Damage damage,Payment payment) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm1 = conn.prepareStatement("Insert into reservation_ditail Values(?,?,?,?,?,?,?,?)");
        pstm1.setObject(1, resiReservation_ditail.getRid());
        pstm1.setObject(2, resiReservation_ditail.getEmployee_id());
        pstm1.setObject(3, resiReservation_ditail.getItem_code());
        pstm1.setObject(4, resiReservation_ditail.getDamage_id());
        pstm1.setObject(5, resiReservation_ditail.getTransport_id());
        pstm1.setObject(6, resiReservation_ditail.getPayment_id());
        pstm1.setObject(7, resiReservation_ditail.getEx_Charges());
        pstm1.setObject(8, resiReservation_ditail.getAcchual_return_date());
        PreparedStatement pstm2 = conn.prepareStatement("Insert into transport Values(?,?,?)");
        pstm2.setObject(1, transport.getTransport_id());
        pstm2.setObject(2, transport.getTransport_cost());
        pstm2.setObject(3, transport.getDistance());
        PreparedStatement pstm3 = conn.prepareStatement("Insert into damage_ditail Values(?,?,?,?)");
        pstm3.setObject(1, damage.getDamage_id());
        pstm3.setObject(2, damage.getDamage_date());
        pstm3.setObject(3, damage.getDamage_information());
        pstm3.setObject(4, damage.getDamage_cost());
        PreparedStatement pstm4 = conn.prepareStatement("Insert into payment Values(?,?,?)");
        pstm4.setObject(1, payment.getPayment_id());
        pstm4.setObject(2, payment.getAmount());
        pstm4.setObject(3, payment.getPayment_date());
        conn.setAutoCommit(false);
        boolean bool1 = pstm2.executeUpdate()>0;
        boolean bool2 = pstm3.executeUpdate()>0;
        boolean bool3 = pstm4.executeUpdate()>0;
        if(bool1 &&bool2 && bool3){
            boolean done = pstm1.executeUpdate()>0;
            if(done){
                conn.commit();
                return true;
            }else{
                conn.rollback();
                conn.commit();
                return false;
            }
        }else{
            conn.rollback();
            conn.commit();
            return false;
        }
    }
    public static HashMap<String, Reservation> loadData() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select RID,return_date,price from reservation");
        HashMap<String, Reservation> hashMap = new HashMap<String,Reservation>();

        while (rst.next()) {
            Reservation reservation=new Reservation();
            reservation.setRid(rst.getString(1));
            reservation.setReturn_date(rst.getString(2));
            reservation.setPrice(Double.parseDouble(rst.getString(3)));

            hashMap.put(reservation.getRid(), reservation);
        }
        return hashMap;
    }

    public static HashMap<String, Employee> loadEmployeeData() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select employee_ID,employee_salary from Employee");
        HashMap<String, Employee> hashMap = new HashMap<String,Employee>();
        
        while (rst.next()) {            
            Employee employee =new Employee();
            employee.setEmployee_ID(rst.getString(1));
            employee.setEmployee_salary(Double.parseDouble(rst.getString(2)));
            hashMap.put(employee.getEmployee_ID(), employee);
            
        }
        
        return hashMap;
    }
    
    public static HashMap<String, Item> loadItamData() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select item_code,extrar_charge from item");
        HashMap<String,Item> hashMap=new HashMap<String,Item>();
        
        while (rst.next()) {
            Item item = new Item();
            item.setItem_code(rst.getString(1));
            item.setExtrar_charge(Double.parseDouble(rst.getString(2)));
            hashMap.put(item.getItem_code(), item);
        }
        return hashMap;
    }
    
    public String getDamageId() throws ClassNotFoundException, SQLException{
        ResultSet set=DBConnection.getInstance().getConnection().prepareStatement("SELECT damage_ID FROM damage_ditail ORDER BY damage_ID DESC LIMIT 1;").executeQuery();
   
        if(set.next()){
            String tempId=set.getString(1);
            String[] arr = tempId.split("D");
            int id=Integer.parseInt(arr[1]);
            id+=1;
            if(id<10){
                return "D00"+id;
            }else if(id<100){
                return "D0"+id;
            }else{
                return "D"+id;
            }
        }else{
            return "D001";
        }
    }
}
