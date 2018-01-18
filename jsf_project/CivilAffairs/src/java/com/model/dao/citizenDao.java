/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.dao;

import com.model.entity.citizen;
import com.view.util.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Zein
 */
public class citizenDao {



	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	public static String addcitizen(citizen p){
		String result=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.save(p);
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

        @SuppressWarnings("unchecked")
		public static List<citizen> list(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		List<citizen> listResult=null;
		try{
			tx=session.beginTransaction();
			listResult=session.createQuery("From citizen").list();
			tx.commit();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace();
	      }finally {
	         session.close();
	      }
		return listResult;
	}

	public static String updatecitizen(citizen citizen){
		String result=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.update(citizen); 
	          
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
	
	public static String deletecitizen(citizen citizen){
		String result=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.delete(citizen); 
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
        
        public static citizen listById(Integer citizenId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		Query query=null;
		citizen listResult=null;
		try{
			tx=session.beginTransaction();
			query=session.createQuery("From citizen where id=:id");
			query.setInteger("id",citizenId);
			listResult=(citizen)query.uniqueResult();
			tx.commit();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return listResult;
	}
        public static String editAction(citizen order) {

            order.editable=true;
            order.setEditable(true);
            return null;
        }
        
        public static List<citizen> search(String name){
    		Session session = HibernateUtil.getSessionFactory().openSession();
    		Transaction tx=null;
    		List<citizen> listResult=null;
    		
    		try{
    			tx=session.beginTransaction();
    			listResult=session.createQuery("From citizen where Name=:name").list();
    			System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                
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
