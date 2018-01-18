/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.dao;


import com.model.entity.cs;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.view.util.HibernateUtil;

/**
 *
 * @author Zein
 */
public class csDao {


    //private static final long serialVersionUID = 1L;
	//private static Logger log = Logger.getLogger(LoginBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";


	public static String addcs(cs p){
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
	public static String editAction(cs order) {

        order.editable=true;
        order.setEditable(true);
        return null;
    }
        public static List<cs> list(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		List<cs> listResult=null;
		try{
			tx=session.beginTransaction();
			listResult=session.createQuery("From cs").list();
			tx.commit();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace();
	      }finally {
	         session.close();
	      }
		return listResult;
	}

	public static String updatecs(cs cs){
		String result=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.update(cs); 
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
	
	public static String deletecs(cs cs){
		String result=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.delete(cs); 
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
        
        public static cs listById(Integer csId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		Query query=null;
		cs listResult=null;
		try{
			tx=session.beginTransaction();
			query=session.createQuery("From cs where id=:id");
			query.setInteger("id",csId);
			listResult=(cs)query.uniqueResult();
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
