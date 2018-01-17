
package com.model.dao;

import com.model.entity.citizen;
import com.model.entity.login;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.view.util.HibernateUtil;

/**
 *
 * @author
 */
 
public class loginDao {
    
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	public static  String erule = "";
	public static  String eusername = "";
	public static String chack(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
      
        String b="error";
		Transaction tx=null;
               
		Query query=null;
		login listResult=null;
		try{
			tx=session.beginTransaction();
			query=session.createQuery("From login where username=:username AND password=:password");
			query.setString("username",username);
                        query.setString("password",password);
			listResult=(login)query.uniqueResult();
                        
			tx.commit();
                        
                        try{
                        if(!listResult.equals(null))
                        {
                            b=SUCCESS;
                          
                        erule=listResult.getRule();
                        eusername=listResult.getUsername();
                        
                        }
                        }
                        catch(Exception ex)
                        {
                            b=ERROR;
                        }
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return b;
    }
    public static String addlogin(login p){
		String result=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.save(p);
                 
	         tx.commit();
	  //       log.debug("New Record : " + p + ", wasCommitted : " + tx.wasCommitted());
	         result = SUCCESS;
	      }catch (HibernateException e) {
	         if (tx!=null) {
	        	 tx.rollback();
	        	 result = ERROR;
	        	 e.printStackTrace();
	         }

	      }finally {
	         session.close();
	      }
	      return result;
	}
    public static List<login> list(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		List<login> listResult=null;
		try{
			tx=session.beginTransaction();
			listResult=session.createQuery("From login").list();
			tx.commit();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace();
	      }finally {
	         session.close();
	      }
		return listResult;
	}
    public static String updatelogin(login login){
		String result=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.update(login); 
	         tx.commit();
	        
	         result = SUCCESS;
	      }catch (HibernateException e) {
	         if (tx!=null) {
	        	 tx.rollback();
	        	 result = ERROR;
	        	 e.printStackTrace();
	         }
	          
	      }finally {
	         session.close(); 
	      }
	      return result;
	}
    public static String deletelogin(login login){
		String result=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
                 
	         session.delete(login); 
	         tx.commit();
	        
	         result = SUCCESS;
	      }catch (HibernateException e) {
	         if (tx!=null) {
	        	 tx.rollback();
	        	 result = ERROR;
	        	 e.printStackTrace();
	         }
	          
	      }finally {
	         session.close(); 
	      }
	      return result;
	}
    public static login listById(Integer loginId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		Query query=null;
		login listResult=null;
		try{
			tx=session.beginTransaction();
			query=session.createQuery("From login where id=:id");
			query.setInteger("id",loginId);
			listResult=(login)query.uniqueResult();
			tx.commit();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return listResult;
	}
        
  

}