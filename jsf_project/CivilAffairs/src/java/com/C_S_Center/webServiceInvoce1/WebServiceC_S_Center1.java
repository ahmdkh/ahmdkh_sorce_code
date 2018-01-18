/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.C_S_Center.webServiceInvoce1;

import com.model.dao.citizenDao;
import com.model.entity.citizen;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Ahmadkh
 */
@WebService(serviceName = "WebServiceC_S_Center1")
public class WebServiceC_S_Center1 {
    @WebMethod
    public String addcitizen(final int id,final String Name, final String Fname, final String Mname,final String Nname,final String Num_reg,final String Sex,final int Num_id,final String Mstatus) {
        citizen c1 = new citizen(id,Name, Fname, Mname, Nname, Num_reg, Sex, Num_id, Mstatus);
        return citizenDao.addcitizen(c1);

    }

    @WebMethod
    public void deletecitizen(int id) {
        citizen pDel = new citizen();
        pDel = citizenDao.listById(id);
        citizenDao.deletecitizen(pDel);

    }

    @WebMethod
    public void updatecitizen(final int id,final String Name, final String Fname, final String Mname,final String Nname,final String Num_reg,final String Sex,final int Num_id,final String Mstatus) {
        citizen c1 = new citizen(id,Name, Fname, Mname, Nname, Num_reg, Sex, Num_id, Mstatus);
        System.out.println("SEX="+Sex);
        citizenDao.updatecitizen(c1);
    }

    @WebMethod
    public String getcitizenList() {

        //
        String soso="";
    	List<citizen> citizenList=citizenDao.list();
    	  
       
        for (citizen ci : citizenList) {
          
         soso+=""+ci.getId()+"-"+ci.getName()+"-"+ci.getFname()+"-"+ci.getMname()+"-"+ci.getNname()+"-"+ci.getNum_reg()+"-"+ci.getSex()+"-"+ci.getNum_id()+"-"+ci.getMstatus()+"@";
        
        }
        System.out.println("*************"+soso);
        return soso;
    }
    
  
}
