package com.model.entity;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zein
 */
public class cs {
    private int id;
   private String Name;
   private String Mname;
   private String Fname;
   private String Nname;
   public boolean  editable=false;
   private String Padob;
   private String Nationality;
   private String Toffense;
 
   public cs() {
   }

   public cs( int id,String Name, String Mname, String Fname, String Nname, String Padob, String Nationality, String Toffense) {
      this.id = id;
       this.Name = Name;
       this.Mname = Mname;
       this.Fname = Fname;
       this.Nname = Nname;
       this.Padob = Padob;
       this.Nationality = Nationality;
       this.Toffense = Toffense;
   }
   

   public void setFname(String Fname) {
       this.Fname = Fname;
   }
   public void setEditable(boolean editable) {
       this.editable = editable;
   }
   public boolean isEditable() {
       return editable;
   }
   public void setMname(String Mname) {
       this.Mname = Mname;
   }

   public void setName(String Name) {
       this.Name = Name;
   }

   public void setNationality(String Nationality) {
       this.Nationality = Nationality;
   }

   public void setNname(String Nname) {
       this.Nname = Nname;
   }

   public void setPadob(String Padob) {
       this.Padob = Padob;
   }

   public void setToffense(String Toffense) {
       this.Toffense = Toffense;
   }

   public void setId(int id) {
       this.id = id;
   }
  

   public String getFname() {
       return Fname;
   }

   public String getMname() {
       return Mname;
   }

   public String getName() {
       return Name;
   }

   public String getNationality() {
       return Nationality;
   }

   public String getNname() {
       return Nname;
   }

   public String getPadob() {
       return Padob;
   }

   public String getToffense() {
       return Toffense;
   }

   public int getId() {
       return id;
   }


}
