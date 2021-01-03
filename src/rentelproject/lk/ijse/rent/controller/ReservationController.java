/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentelproject.lk.ijse.rent.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import rentelproject.lk.ijse.rent.db.DBConnection;
import rentelproject.lk.ijse.rent.model.Reservation;

/**
 *
 * @author Nipun
 */
public class ReservationController {
    public static boolean addReservation(Reservation reservation) throws ClassNotFoundException, SQLException{
        Connection conn= DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Insert into reservation Values(?,?,?,?,?)");
        pstm.setObject(1,reservation.getRid());
        pstm.setObject(2,reservation.getCustomer_id());
        pstm.setObject(3,reservation.getReturn_date());
        pstm.setObject(4,reservation.getPrice());
        pstm.setObject(5,reservation.getReservation_date_time());
        return pstm.executeUpdate()>0; 
    }
    
    public static ArrayList<Reservation> loadReservation() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM reservation";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement(); 
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Reservation> AllReservation = new ArrayList<>();
        
        while(rst.next()){
            Reservation reservation1 =new Reservation();
            reservation1.setRid(rst.getString(1));
            reservation1.setCustomer_id(rst.getString(2));
            reservation1.setReturn_date(rst.getString(3));
            reservation1.setPrice(Double.parseDouble(rst.getString(4)));
            reservation1.setReservation_date_time(rst.getString(5));
            AllReservation.add(reservation1);
        }
        return AllReservation;
    }
    
    
    
    public static boolean deleteReservation(Reservation reservation) throws ClassNotFoundException, SQLException{
        Connection conn= DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Delete from reservation where RID=?");
        pstm.setObject(1,reservation.getRid());
        return pstm.executeUpdate()>0; 
    }
    
    public static ArrayList<String> getRID() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select RID from reservation");
        ArrayList<String> list= new ArrayList<>();
        while(rst.next()){
            list.add(rst.getString(1));
        }
        return list;
    }

    public static ArrayList<String> getItemCode() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select item_code from item");
        ArrayList<String> list= new ArrayList<>();
        while(rst.next()){
            list.add(rst.getString(1));
        }
        return list;
    }
    
    public String getRId() throws ClassNotFoundException, SQLException{
        ResultSet set=DBConnection.getInstance().getConnection().prepareStatement("SELECT RID FROM reservation ORDER BY RID DESC LIMIT 1;").executeQuery();
   
        if(set.next()){
            String tempId=set.getString(1);
            String[] arr = tempId.split("R");
            int id=Integer.parseInt(arr[1]);
            id+=1;
            if(id<10){
                return "R00"+id;
            }else if(id<100){
                return "R0"+id;
            }else{
                return "R"+id;
            }
        }else{
            return "R001";
        }
    }
}
