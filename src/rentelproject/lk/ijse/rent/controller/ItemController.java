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
import rentelproject.lk.ijse.rent.model.Item;

/**
 *
 * @author Nipun
 */
public class ItemController {
    public static boolean addItem(Item item) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Insert into item Values(?,?,?,?)");
        pstm.setObject(1, item.getItem_code());
        pstm.setObject(2, item.getCatargory_id());
        pstm.setObject(3, item.getPre_day_cost());
        pstm.setObject(4, item.getExtrar_charge());
        return pstm.executeUpdate()>0;
    }
    
    public static ArrayList<Item> loadItem() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select * from item");
        ArrayList<Item> allItem = new ArrayList<>();
        
        while (rst.next()) {            
            Item item = new Item();
            item.setItem_code(rst.getString(1));
            item.setCatargory_id(rst.getString(2));
            item.setPre_day_cost(Double.parseDouble(rst.getString(3)));
            item.setExtrar_charge(Double.parseDouble(rst.getString(4)));
            allItem.add(item);
        }
        return allItem;
    }
    
    public static boolean updateItem(Item item) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Update item set catargory_id=?,pre_day_cost=?,extrar_charge=? where item_code=?");
        pstm.setObject(1, item.getCatargory_id());
        pstm.setObject(2, item.getPre_day_cost());
        pstm.setObject(3, item.getExtrar_charge());
        pstm.setObject(4, item.getItem_code());
        return pstm.executeUpdate()>0;
    }
    
    public static boolean deleteItem(Item item) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Delete from item where item_code=?");
        pstm.setObject(1, item.getItem_code());
        return pstm.executeUpdate()>0;
    }
    public static String getItemCode() throws ClassNotFoundException, SQLException{
        ResultSet set=DBConnection.getInstance().getConnection().prepareStatement("SELECT item_code FROM item ORDER BY item_code DESC LIMIT 1;").executeQuery();
        if(set.next()){
            String tempId=set.getString(1);
            String[] arr = tempId.split("I");
            int id=Integer.parseInt(arr[1]);
            id+=1;
            if(id<10){
                return "I00"+id;
            }else if(id<100){
                return "I0"+id;
            }else{
                return "I"+id;
            }
        }else{
            return "I001";
        }
    }
}
