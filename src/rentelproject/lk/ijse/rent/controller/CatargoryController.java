/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentelproject.lk.ijse.rent.controller;

import static com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import rentelproject.lk.ijse.rent.db.DBConnection;
import rentelproject.lk.ijse.rent.model.Catargory;

/**
 *
 * @author Nipun
 */
public class CatargoryController {
    public static boolean addCatargory(Catargory catargory) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Insert into catargory Values(?,?,?)");
        pstm.setObject(1,catargory.getCatargory_id());
        pstm.setObject(2,catargory.getName());
        pstm.setObject(3,catargory.getQuantity());
        return pstm.executeUpdate()>0;      
    }
    
    public static ArrayList<Catargory> loadCatargory() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select * from catargory");
        ArrayList<Catargory> allCatargory = new ArrayList<>();
        
        while(rst.next()){
            Catargory catargory = new Catargory();
            catargory.setCatargory_id(rst.getString(1));
            catargory.setName(rst.getString(2));
            catargory.setQuantity(Integer.parseInt(rst.getString(3)));
            allCatargory.add(catargory);
        }
        return allCatargory;
    }
    
    public static boolean updateCatargory(Catargory catargory) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Update catargory set name=?,quantity=? where catargory_id=?");
        pstm.setObject(1, catargory.getName());
        pstm.setObject(2, catargory.getQuantity());
        pstm.setObject(3, catargory.getCatargory_id());
        return pstm.executeUpdate()>0;
    }
    
    public static boolean deleteCatargory(Catargory catargory) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Delete from catargory where catargory_id=?");
        pstm.setObject(1, catargory.getCatargory_id());
        return pstm.executeUpdate()>0;
    }
    
    public ArrayList<String> loadCatargoryID() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("SELECT catargory_id FROM catargory");
        ResultSet set = pstm.executeQuery();
        ArrayList<String> list= new ArrayList<>();
        while(set.next()){
            list.add(set.getString(1));
        }
        return list;  
    }
    
    public String getCatargoryId() throws ClassNotFoundException, SQLException{
        ResultSet set=DBConnection.getInstance().getConnection().prepareStatement("SELECT catargory_id FROM catargory ORDER BY catargory_id DESC LIMIT 1;").executeQuery();
        if(set.next()){
            String tempId=set.getString(1);
            String[] arr = tempId.split("CC");
            int id=Integer.parseInt(arr[1]);
            id+=1;
            if(id<10){
                return "CC00"+id;
            }else if(id<100){
                return "CC0"+id;
            }else{
                return "CC"+id;
            }
        }else{
            return "CC001";
        }
    }
}
