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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.category;
import model.company;

/**
 *
 * @author Vu Dai Luong
 */
public class CompanyDAO {

    public List<company> getALLCompany() {
            List<company> list = new ArrayList<>();
        try {
            String sql = "select * from Company";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                company cp = company.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .quantity(rs.getInt(3))
                        .salary(rs.getDouble(4))
                        .description(rs.getString(5))
                        .imagine(rs.getString(6))
                        .create_date(rs.getString(7))
                        .phone(rs.getInt(8))
                        .category_id(rs.getInt(9)).build();
                list.add(cp);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
