/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Vu Dai Luong
 */
public class Entries {
    private int EntryID;
    private int Category;
    private String Title;
    private String EntryContent;
    private Date DateCreated;
    private Date DateModified;

    public Entries() {
    }

    public Entries(int EntryID, int Category, String Title, String EntryContent, Date DateCreated, Date DateModified) {
        this.EntryID = EntryID;
        this.Category = Category;
        this.Title = Title;
        this.EntryContent = EntryContent;
        this.DateCreated = DateCreated;
        this.DateModified = DateModified;
    }

    public int getEntryID() {
        return EntryID;
    }

    public void setEntryID(int EntryID) {
        this.EntryID = EntryID;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int Category) {
        this.Category = Category;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getEntryContent() {
        return EntryContent;
    }

    public void setEntryContent(String EntryContent) {
        this.EntryContent = EntryContent;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date DateCreated) {
        this.DateCreated = DateCreated;
    }

    public Date getDateModified() {
        return DateModified;
    }

    public void setDateModified(Date DateModified) {
        this.DateModified = DateModified;
    }

    @Override
    public String toString() {
        return "Entries{" + "EntryID=" + EntryID + ", Category=" + Category + ", Title=" + Title + ", EntryContent=" + EntryContent + ", DateCreated=" + DateCreated + ", DateModified=" + DateModified + '}';
    }
    
    
}
