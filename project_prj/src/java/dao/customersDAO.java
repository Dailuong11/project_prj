/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.customers;

/**
 *
 * @author Vu Dai Luong
 */
public class customersDAO extends DBContext{

    public void insertCustomes(String name, String Email, String role, String descriosion, int phone) {
        String query = "INSERT INTO [dbo].[customers]\n"
                + "           ([name]\n"
                + "           ,[gmail]\n"
                + "           ,[description]\n"
                + "           ,[phone])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, role);
            ps.setString(3, descriosion);
            ps.setInt(4, phone);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public customers getCustomerByID (String id){
        try {
            String query = "select * from customers where id = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                customers cu = customers.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .gmail(rs.getString(3))
                        .role(rs.getString(4))
                        .description(rs.getString(5))
                        .phone(rs.getInt(6)).build();
                return cu;
            }
        } catch (Exception ex) {
            
            Logger.getLogger(customersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
            
            
    
}
