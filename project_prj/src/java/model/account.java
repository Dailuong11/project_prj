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
public class account {
    private int id;
    private String username;
    private String password;
    private String displayname;
    private String adress;
    private String email;
    private int phone;
    private String description;

    public account() {
    }

    public account(int id, String username, String password, String displayname, String adress, String email, int phone, String description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayname = displayname;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "account{" + "id=" + id + ", username=" + username + ", password=" + password + ", displayname=" + displayname + ", adress=" + adress + ", email=" + email + ", phone=" + phone + ", description=" + description + '}';
    }
    
    
}
