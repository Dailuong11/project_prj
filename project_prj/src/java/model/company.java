/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Vu Dai Luong
 */
@Builder
@Getter
@Setter
@ToString
public class company {
    private int id;
    private String name;
    private int quantity;
    private double salary;
    private String description;
    private String imagine;
    private Date create_date;
    private String phone;
    private int category_id;
    private String profesion;
    private String accountid;
}
