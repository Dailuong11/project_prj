/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Vu Dai Luong
 */
public class company {
    private int id;
    private String name;
    private int quantity;
    private double salary;
    private String description;
    private String imagine;
    private  String create_date;
    private int phone;
    private int category_id;

    public company() {
    }

    public company(int id, String name, int quantity, double salary, String description, String imagine, String create_date, int phone, int category_id) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.salary = salary;
        this.description = description;
        this.imagine = imagine;
        this.create_date = create_date;
        this.phone = phone;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "company{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", salary=" + salary + ", description=" + description + ", imagine=" + imagine + ", create_date=" + create_date + ", phone=" + phone + ", category_id=" + category_id + '}';
    }
    
    
    
}
