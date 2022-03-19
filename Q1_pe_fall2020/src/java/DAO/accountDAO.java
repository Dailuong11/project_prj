/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;

import model.Account;

/**
 *
 * @author Vu Dai Luong
 */
public class accountDAO {

    public Account login(String name, String pass) {
         try {
            //mo ket noi
            String sql = "select * from Account where accountid = ? and password = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account(rs.getString(1), rs.getString(2));
                return account;
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
}
