package com.model.entity;
public class citizen {
	
	 private int id;
	    private String Name;
	    private String Fname;
	    private String Mname;
	    private String Nname;
         private String Mstatus;
         public boolean  editable=false;
          private String Num_reg;
	    private String Sex;
	    private int Num_id;
   public citizen() {
   }
          

   public citizen(int id, String Name, String Fname, String Mname, String Nname, String Num_reg, String Sex, int Num_id, String Mstatus) {
       this.id = id;
       this.Name = Name;
       this.Fname = Fname;
       this.Mname = Mname;
       this.Nname = Nname;
       this.Num_reg = Num_reg;
       this.Sex = Sex;
       this.Num_id = Num_id;
       this.Mstatus = Mstatus;
   }

   public void setFname(String Fname) {
       this.Fname = Fname;
   }

   public void setMname(String Mname) {
       this.Mname = Mname;
   }

   public void setMstatus(String Mstatus) {
       this.Mstatus = Mstatus;
   }

   public void setName(String Name) {
       this.Name = Name;
   }

   public void setNname(String Nname) {
       this.Nname = Nname;
   }

   public void setNum_id(int Num_id) {
       this.Num_id = Num_id;
   }

   public void setNum_reg(String Num_reg) {
       this.Num_reg = Num_reg;
   }

   public void setSex(String Sex) {
       this.Sex = Sex;
   }

   public void setEditable(boolean editable) {
       this.editable = editable;
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

   public String getMstatus() {
       return Mstatus;
   }

   public String getName() {
       return Name;
   }

   public String getNname() {
       return Nname;
   }

   public int getNum_id() {
       return Num_id;
   }

   public String getNum_reg() {
       return Num_reg;
   }

   public String getSex() {
       return Sex;
   }

   public boolean isEditable() {
       return editable;
   }

   public int getId() {
       return id;
   }
          

}