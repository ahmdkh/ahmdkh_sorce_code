/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.C_S_Center.webServiceInvoce;

import com.model.dao.CalcDao;
import com.model.dao.csDao;
import com.model.entity.cs;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Ahmadkh
 */
@WebService(serviceName = "WebServiceC_S_Center")
public class WebServiceC_S_Center {
 
    @WebMethod
    public String addcs(final int id,final String Name, final String Fname, final String Mname, final String Padob, final String Nationality, final String Toffense, final String Nname) {
        cs c1 = new cs(id,Name, Mname, Fname, Nname, Padob, Nationality, Toffense);
        return csDao.addcs(c1);

    }


    @WebMethod
    public void deletecs(int id) {
        cs pDel = new cs();
        pDel = csDao.listById(id);
        csDao.deletecs(pDel);

    }

    @WebMethod
    public void updatecs(final int id,final String Name, final String Fname, final String Mname, final String Padob, final String Nationality, final String Toffense, final String Nname) {
        cs c1 = new cs(id,Name, Mname, Fname, Nname, Padob, Nationality, Toffense);
        csDao.updatecs(c1);
    }

    @WebMethod
    public String getcsList() {

        //
        String soso="";
    	List<cs> csList=csDao.list();
    	  
       
        for (cs ci : csList) {
          
         soso+=""+ci.getId()+"-"+ci.getName()+"-"+ci.getMname()+"-"+ci.getFname()+"-"+ci.getNname()+"-"+ci.getPadob()+"-"+ci.getNationality()+"-"+ci.getToffense()+"@";
         
        }
        return soso;
    }
}
