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
import model.company;

/**
 *
 * @author Vu Dai Luong
 */
public class CompanyDAO extends DBContext{

    public List<company> getALLCompany() {
        List<company> list = new ArrayList<>();
        try {
            String sql = "select*from Company";
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
                        .category_id(rs.getInt(9))
                        .profesion(rs.getString(10)).build();
                list.add(cp);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new CompanyDAO().getALLCompany());
    }

    public List<company> getCompaniesByCategoryId(int categoryId) {
        List<company> list = new ArrayList<>();
        try {
            String sql = "select * from company where Company.category_id = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                company com = company.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .quantity(rs.getInt(3))
                        .salary(rs.getDouble(4))
                        .description(rs.getString(5))
                        .imagine(rs.getString(6))
                        .create_date(rs.getString(7))
                        .phone(rs.getInt(8))
                        .category_id(rs.getInt(9))
                        .profesion(rs.getString(10)).build();
                list.add(com);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<company> getProductsWithPagging(int page, int PAGE_SIZE) {
        List<company> list = new ArrayList<>();
        try {
            String sql = "select * from company order by id\n"
                    + "offset (?-1)*? row fetch next ? rows only";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
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
                        .category_id(rs.getInt(9))
                        .profesion(rs.getString(10)).build();
                list.add(cp);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getTotalProducts() {
        List<company> list = new ArrayList<>();
        try {
            String sql = "select COUNT(id) from company";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<company> search(String keyword) {
       List<company> list = new ArrayList<>();
        try {
            String sql = "select * from company where name like ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
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
                        .category_id(rs.getInt(9))
                        .profesion(rs.getString(10)).build();
                list.add(cp);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public company getCompanyById(int companyId) {
        try {
            String sql = "select * from company where id = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, companyId);
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
                        .category_id(rs.getInt(9))
                        .profesion(rs.getString(10)).build();
               return cp;
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }

}
