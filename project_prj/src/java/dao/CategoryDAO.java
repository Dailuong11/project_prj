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

/**
 *
 * @author Vu Dai Luong
 */
public class CategoryDAO extends DBContext{

    public List<category> getALLCategories() {
        List<category> list = new ArrayList<>();
        try {
            String sql = "select * from Category";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                category category = new category(rs.getInt(1), rs.getString(2));
                category Category = category.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2)).build();
                list.add(Category);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }

}
