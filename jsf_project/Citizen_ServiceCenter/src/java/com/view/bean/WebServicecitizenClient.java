/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view.bean;

import com.c_s_center.webserviceinvoce1.WebServiceCSCenter1;
import com.c_s_center.webserviceinvoce1.WebServiceCSCenter1_Service;
import com.model.entity.citizen;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Ahmadkh
 */
@ManagedBean
@SessionScoped

public class WebServicecitizenClient {

   public WebServicecitizenClient() {
        
            citizen = new citizen();
            addcitizen = new citizen();
            searchcitizen = new citizen();
            
            citizenList = new ArrayList<citizen>();
          //  citizenList = get_citizenlist(getls());
    }
    

    public static WebServiceCSCenter1 WebServiceCSCenter1;
    public static WebServiceCSCenter1_Service WebServiceCSCenter1_Service;
    //****

    public static WebServiceCSCenter1 getWebServiceCSCenter1() {
        return WebServiceCSCenter1;
    }

    public static WebServiceCSCenter1_Service getWebServiceCSCenter1_Service() {
        return WebServiceCSCenter1_Service;
    }

    public static void setWebServiceCSCenter1(WebServiceCSCenter1 WebServiceCSCenter1) {
        WebServicecitizenClient.WebServiceCSCenter1 = WebServiceCSCenter1;
    }

    public static void setWebServiceCSCenter1_Service(WebServiceCSCenter1_Service WebServiceCSCenter1_Service) {
        WebServicecitizenClient.WebServiceCSCenter1_Service = WebServiceCSCenter1_Service;
    }

    @PostConstruct
    public void init() {
        try {

            WebServiceCSCenter1_Service = new WebServiceCSCenter1_Service();
            WebServiceCSCenter1 = WebServiceCSCenter1_Service.getWebServiceCSCenter1Port();

        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    }
/////////////////////////////////////////////////////

    //********************************************************//
    private citizen citizen;
    private citizen searchcitizen;
  private  List<citizen> citizenList;
  private citizen addcitizen;

    public citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(citizen citizen) {
        this.citizen = citizen;
    }

    public void setSearchcitizen(citizen searchcitizen) {
        this.searchcitizen = searchcitizen;
    }

    public void setCitizenList(List<citizen> citizenList) {
        this.citizenList = citizenList;
    }

    public void setAddcitizen(citizen addcitizen) {
        this.addcitizen = addcitizen;
    }

    public citizen getSearchcitizen() {
        return searchcitizen;
    }

    public List<citizen> getCitizenList() {
        return citizenList;
    }

    public citizen getAddcitizen() {
        return addcitizen;
    }





    public  boolean AreEqual(String a, String b) {
        if (a.equalsIgnoreCase("")) {
            return true;
        } else {
            return a.equalsIgnoreCase(b);
        }
    }

    public  boolean ArenumEqual(int a, int b) {
        if (a == 0) {
            return true;
        } else if (a == b) {
            return true;
        } else {
            return false;
        }
    }

    public  List<citizen> get_citizenlist(String soso) {
        List<citizen> citizen1List = new ArrayList<citizen>();
        String[] parts = soso.split("@");
        for (int i = 0; i < parts.length; i++) {
            String[] info = parts[i].split("-");
            System.out.println(i + "=" + info[0] + "|" + info[1] + "|" + info[2] + info[3] + "|" + info[4] + "|" + info[5] + "|" + info[6] + "|" + info[7] + "|" + info[8] + "\n");
            citizen c1 = new citizen(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], info[5], info[6], Integer.parseInt(info[7]), info[8]);
            citizen1List.add(c1);
        }

        return citizen1List;
    }

    public  String getls() {
        WebServiceCSCenter1_Service = new WebServiceCSCenter1_Service();
        WebServiceCSCenter1 = WebServiceCSCenter1_Service.getWebServiceCSCenter1Port();
        String koko = WebServiceCSCenter1.getcitizenList();
     
        return koko;
    }
    public List<citizen> search1() {

         citizenList = get_citizenlist(getls());
        List<citizen> citizen1List = new ArrayList<citizen>();
        citizen ciz = new citizen();
        for (citizen ci : citizenList) {
            if (ArenumEqual(searchcitizen.getNum_id(), ci.getNum_id()) && AreEqual(searchcitizen.getName(), ci.getName()) && AreEqual(searchcitizen.getFname(), ci.getFname()) && AreEqual(searchcitizen.getMname(), ci.getMname()) && AreEqual(searchcitizen.getNname(), ci.getNname()) && AreEqual(searchcitizen.getNum_reg(), ci.getNum_reg())) {
                citizen1List.add(ci);
            }

        }

        citizenList = citizen1List;
        return citizenList;
    }

    public String redirect2Add() {
        searchcitizen=new citizen();
        return "ADD_SHONMOATEN.xhtml?faces-redirect=true";
    }
        public String redirect2EDIT() {
       //citizenList = get_citizenlist(getls());
        return "Edit_SHOONMOATEN_M.xhtml?faces-redirect=true";
    }

    public void addcitizen() {
 WebServiceCSCenter1_Service = new WebServiceCSCenter1_Service();
        WebServiceCSCenter1 = WebServiceCSCenter1_Service.getWebServiceCSCenter1Port();
        WebServiceCSCenter1.addcitizen(citizen.getId(),citizen.getName(), citizen.getFname(), citizen.getMname(), citizen.getNname(), citizen.getNum_reg(), citizen.getSex(), citizen.getNum_id(), citizen.getMstatus());
          //citizenList = get_citizenlist(getls());
          
          citizen=new citizen();
         
       
    }

    public String deletecitizenlist(citizen citizen) {
        citizen.setEditable(true);
       
        int ido = 0;
        for (citizen order : citizenList) {
            if (order.isEditable() == true) {
                ido = order.getId();
                
            }

        }

        WebServiceCSCenter1_Service = new WebServiceCSCenter1_Service();
        WebServiceCSCenter1 = WebServiceCSCenter1_Service.getWebServiceCSCenter1Port();
        WebServiceCSCenter1.deletecitizen(ido);
       // citizenDao.deletecitizen(pDel);
        citizenList = new ArrayList<citizen>();
        //citizenList = get_citizenlist(getls());
        return "citizen.xhtml?faces-redirect=true";
    }

    public String saveAction() {
     WebServiceCSCenter1_Service = new WebServiceCSCenter1_Service();
        WebServiceCSCenter1 = WebServiceCSCenter1_Service.getWebServiceCSCenter1Port();
        //get all existing value but set "editable" to false 
        for (citizen order : citizenList) {
            order.setEditable(false);
         
        //final String Name, final String Fname, final String Mname,final String Nname,final String Num_reg,final String Sex,final int Num_id,final String Mstatus
         WebServiceCSCenter1.updatecitizen(order.getId(),order.getName(), order.getFname(), order.getMname(), order.getNname(), order.getNum_reg(), order.getSex(), order.getNum_id(), order.getMstatus());
        }

        //return to current page
        return null;

    }
//
    public String editAction1(citizen order) {
        
        order.editable = true;
        return null;
    }
    //**********************************************************//

    public static void main(String[] args) {
        // TODO Auto-generated method stub
 WebServicecitizenClient x=new WebServicecitizenClient();

    }
    
}
