/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConn {
    static Connection c;
    public static void getMyConn()throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/Repair_shop";
    c=DriverManager.getConnection(url,"root","vv82840");
    }
    public static void save(String sql)throws Exception{
        if(c==null)
            getMyConn();
        c.createStatement().executeUpdate(sql);
    }
    public static  ResultSet search(String sql)throws Exception{
        if(c==null)
            getMyConn();
        ResultSet rs=c.createStatement().executeQuery(sql);
        return rs;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class jdbc {
    public static void main(String [] args){
        String url="jdbc:mysql://localhost:3306/jdbc";
        String user="root";
        String password="vv82840";
        String query="SELECT * FROM users";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url, user, password);
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(query);
           
            
            String name;
            int age;
            while(result.next()){
                name=result.getString(1);
                age=result.getInt(2);
                System.out.println (name+""+age);
                //connection close();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
}
}

