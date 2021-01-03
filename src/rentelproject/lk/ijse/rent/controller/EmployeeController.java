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
import rentelproject.lk.ijse.rent.model.Employee;

/**
 *
 * @author Nipun
 */
public class EmployeeController {
    public static boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Insert into employee Values(?,?,?,?,?)");
        pstm.setObject(1, employee.getEmployee_ID());
        pstm.setObject(2, employee.getEmployee_name());
        pstm.setObject(3, employee.getEmployee_address());
        pstm.setObject(4, employee.getEmployee_contact());
        pstm.setObject(5, employee.getEmployee_salary());
        return pstm.executeUpdate()>0;
    }
    
    public static ArrayList<Employee> loadEmployee() throws ClassNotFoundException, SQLException{
        String sql = "select * from employee";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Employee> allEmployee = new ArrayList<>();
        
        while(rst.next()){
            Employee employee = new Employee();
            employee.setEmployee_ID(rst.getString(1));
            employee.setEmployee_name(rst.getString(2));
            employee.setEmployee_address(rst.getString(3));
            employee.setEmployee_contact(Integer.parseInt(rst.getString(4)));
            employee.setEmployee_salary(Double.parseDouble(rst.getString(5)));
            allEmployee.add(employee);
        }
        return allEmployee;
    }
    
    public static boolean updateEmployee(Employee employee) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Update employee set employee_name=?,employee_address=?,employee_contact_no=?,employee_salary=? where employee_ID=?");
        pstm.setObject(1, employee.getEmployee_name());
        pstm.setObject(2, employee.getEmployee_address());
        pstm.setObject(3, employee.getEmployee_contact());
        pstm.setObject(4, employee.getEmployee_salary());
        pstm.setObject(5, employee.getEmployee_ID());
        return pstm.executeUpdate()>0;
    }
    
    public static boolean deleteEmployee(Employee employee) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement("Delete from employee where employee_ID=?");
        pstm.setObject(1, employee.getEmployee_ID());
        return pstm.executeUpdate()>0;
    }
    public static ArrayList<String> getEmployeeID() throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("select employee_ID from employee");
        ArrayList<String> list= new ArrayList<>();
        while(rst.next()){
            list.add(rst.getString(1));
        }
        return list;
    }
    public static String getEmployeeId() throws ClassNotFoundException, SQLException{
        ResultSet set=DBConnection.getInstance().getConnection().prepareStatement("SELECT employee_ID FROM employee ORDER BY employee_ID DESC LIMIT 1;").executeQuery();
        if(set.next()){
            String tempId=set.getString(1);
            String[] arr = tempId.split("E");
            int id=Integer.parseInt(arr[1]);
            id+=1;
            if(id<10){
                return "E00"+id;
            }else if(id<100){
                return "E0"+id;
            }else{
                return "E"+id;
            }
        }else{
            return "E001";
        }
    }
}
