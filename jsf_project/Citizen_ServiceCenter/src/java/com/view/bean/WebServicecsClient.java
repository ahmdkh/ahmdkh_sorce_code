/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view.bean;

import com.c_s_center.webserviceinvoce.WebServiceCSCenter;
import com.c_s_center.webserviceinvoce.WebServiceCSCenter_Service;
import com.model.entity.cs;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Ahmadkh
 */
@Named(value = "webServicecsClient")
@SessionScoped
public class WebServicecsClient implements Serializable {

    private cs cs;
    private List<cs> csList;
    private cs searchcs = new cs();

    public cs getCs() {
        return cs;
    }

    public List<cs> getCsList() {
        return csList;
    }

    public cs getSearchcs() {
        return searchcs;
    }

    public static WebServiceCSCenter getWebServiceCSCenter() {
        return WebServiceCSCenter;
    }

    public static WebServiceCSCenter_Service getWebServiceCSCenter_Service() {
        return WebServiceCSCenter_Service;
    }

    public void setCs(cs cs) {
        this.cs = cs;
    }

    public void setCsList(List<cs> csList) {
        this.csList = csList;
    }

    public void setSearchcs(cs searchcs) {
        this.searchcs = searchcs;
    }

    public static void setWebServiceCSCenter(WebServiceCSCenter WebServiceCSCenter) {
        WebServicecsClient.WebServiceCSCenter = WebServiceCSCenter;
    }

    public static void setWebServiceCSCenter_Service(WebServiceCSCenter_Service WebServiceCSCenter_Service) {
        WebServicecsClient.WebServiceCSCenter_Service = WebServiceCSCenter_Service;
    }

    public static WebServiceCSCenter WebServiceCSCenter;
    public static WebServiceCSCenter_Service WebServiceCSCenter_Service;

    public WebServicecsClient() {
        cs = new cs();
        searchcs = new cs();
        csList = new ArrayList<cs>();
        //csList = get_cslist(getls());
    }

    @PostConstruct
    public void init() {
        try {
            WebServiceCSCenter_Service = new WebServiceCSCenter_Service();
            WebServiceCSCenter = WebServiceCSCenter_Service.getWebServiceCSCenterPort();
//            cs = new cs();
//            searchcs = new cs();
//            csList = new ArrayList<cs>();
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    }
    ///*********************************//

    public List<cs> get_cslist(String soso) {
        List<cs> cs1List = new ArrayList<cs>();
        String[] parts = soso.split("@");
        for (int i = 0; i < parts.length; i++) {
            String[] info = parts[i].split("-");
            System.out.println(i + "=" + info[0] + "|" + info[1] + "|" + info[2] + info[3] + "|" + info[4] + "|" + info[5] + "|" + info[6] + "|" + info[7] + "\n");
            cs c1 = new cs(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], info[5], info[6], info[7]);
            cs1List.add(c1);
        }

        return cs1List;
    }

    public String getls() {
        WebServiceCSCenter_Service = new WebServiceCSCenter_Service();
        WebServiceCSCenter = WebServiceCSCenter_Service.getWebServiceCSCenterPort();
        String soso = WebServiceCSCenter.getcsList();
        System.out.println("+++=" + soso);
        return soso;
    }

    public static boolean AreEqual(String a, String b) {
        if (a.equalsIgnoreCase("")) {
            return true;
        } else {
            return a.equalsIgnoreCase(b);
        }
    }

    public List<cs> search1() {

        csList = get_cslist(getls());
        List<cs> cs1List = new ArrayList<cs>();
        for (cs ci : csList) {
            if (AreEqual(searchcs.getName(), ci.getName()) && AreEqual(searchcs.getFname(), ci.getFname()) && AreEqual(searchcs.getMname(), ci.getMname()) && AreEqual(searchcs.getNname(), ci.getNname()) && AreEqual(searchcs.getPadob(), ci.getPadob())) {
                cs1List.add(ci);
            }
        }
        csList = cs1List;
        return csList;
    }

    public void addcs() {
        WebServiceCSCenter_Service = new WebServiceCSCenter_Service();
        WebServiceCSCenter = WebServiceCSCenter_Service.getWebServiceCSCenterPort();
        WebServiceCSCenter.addcs(cs.getId(), cs.getName(), cs.getFname(), cs.getMname(), cs.getPadob(), cs.getNationality(), cs.getToffense(), cs.getNname());
       // csList = get_cslist(getls());
        cs=new cs();
    }

    public String deletecslist(cs cs) {
        cs.setEditable(true);
        cs pDel = new cs();
        int ido = 0;
        for (cs order : csList) {
            if (order.isEditable() == true) {
                ido = order.getId();
            }

        }

        //return to current page
        WebServiceCSCenter_Service = new WebServiceCSCenter_Service();
        WebServiceCSCenter = WebServiceCSCenter_Service.getWebServiceCSCenterPort();
        WebServiceCSCenter.deletecs(ido);

        csList = new ArrayList<cs>();
        //csList = get_cslist(getls());
        return "cs.xhtml?faces-redirect=true";
    }

    public String redirect2Add() {
        searchcs = new cs();
        return "ADD_Criminal_security.xhtml?faces-redirect=true";
    }

    public String redirect2EDIT() {
        csList = get_cslist(getls());
        return "Edit_Criminal_security_M.xhtml?faces-redirect=true";
    }

    public String saveAction() {

        WebServiceCSCenter_Service = new WebServiceCSCenter_Service();
        WebServiceCSCenter = WebServiceCSCenter_Service.getWebServiceCSCenterPort();
        for (cs order : csList) {
            order.setEditable(false);
            WebServiceCSCenter.updatecs(order.getId(), order.getName(), order.getFname(), order.getMname(), order.getPadob(), order.getNationality(), order.getToffense(), order.getNname());
        }

        //return to current 
        return null;

    }

    public String editAction1(cs order) {

        order.editable = true;
        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebServicecsClient x = new WebServicecsClient();

    }
}
