/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view.bean;


import com.model.dao.loginDao;
import com.model.entity.login;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 
 */
@ManagedBean
@SessionScoped
public class loginManagedBean {
    private login login;
    private List<login> loginList;

    public login getLogin() {
        return login;
    }

    public List<login> getLoginList() {
        return loginList;
    }

    public void setLogin(login login) {
        this.login = login;
    }

    public void setLoginList(List<login> loginList) {
        this.loginList = loginList;
    }
    

    public loginManagedBean() {
         login= new login();
        loginList= new ArrayList<login>();
    }
     @PostConstruct
    public void init()
    {
        loginList=loginDao.list();
    }
     
     
     
     public String log() {
      
     	login.setUsername(login.getUsername());
     	login.setPassword(login.getPassword());
     	
         String ss = loginDao.chack(login.getUsername(), login.getPassword());
         
      
         if (ss == "success") {
         	
             if (loginDao.erule.equalsIgnoreCase("1")) {
                 return "Edit_SHOONMOATEN_M.xhtml?faces-redirect=true";
             } else if (loginDao.erule.equalsIgnoreCase("2")) {
                 return "Edit_SHOONMOATEN_EM.xhtml?faces-redirect=true";
             } else 
             {
                 return "error.xhtml?faces-redirect=true";
             }


         } else {
             return "error.xhtml?faces-redirect=true";
         }
     }
        public String redirect2View()
    {
//       loginList= new ArrayList<login>();
//        loginList=loginDao.list();
        return "success.xhtml?faces-redirect=true";
    }
    
      public void addlogin()
    {

        loginDao.addlogin(login);
        loginList= new ArrayList<login>();
        loginList=loginDao.list();
    }
     
}
