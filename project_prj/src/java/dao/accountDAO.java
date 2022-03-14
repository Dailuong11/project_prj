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
public class accountDAO extends DBContext {

    public account login(String user, String pass) {
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
                        .displayname(rs.getString(2))
                        .username(rs.getString(3))
                        .password(rs.getString(4))
                        .role(rs.getString(5))
                        .build();
                return ac;
            }
        } catch (Exception ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public account checkAccountExist(String user) {
        try {
            String query = "select*from Account where username = ?";

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account ac = account.builder()
                        .id(rs.getInt(1))
                        .displayname(rs.getString(2))
                        .username(rs.getString(3))
                        .password(rs.getString(4))
                        .role(rs.getString(5)).build();
                return ac;
            }
        } catch (Exception ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void singup(String displayname, String user, String pass) {

        try {
            String query = "INSERT INTO [dbo].[Account]\n"
                    + "           ([displayname]\n"
                    + "           ,[username]\n"
                    + "           ,[passwords]\n"
                    + "           ,[role])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,'user')";

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, displayname);
            ps.setString(2, user);
            ps.setString(3, pass);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
