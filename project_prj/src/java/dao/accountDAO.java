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
import model.account;


/**
 *
 * @author Vu Dai Luong
 */
public class accountDAO {
    public account login(String user, String pass){
        try {
            String query = "select*from Account where username = ? and passwords = ?";
            
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                account ac = account.builder()
                        .id(rs.getInt(1))
                        .username(rs.getString(2))
                        .password(rs.getString(3))
                        .isadmin(rs.getString(4)).build();
              return ac;
            }
        } catch (Exception ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;
        }
    }

