/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class account {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password; 
    private int isadmin;
}