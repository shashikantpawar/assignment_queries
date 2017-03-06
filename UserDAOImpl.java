package com.nt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.bo.UserBO;
import com.nt.utility.HibernateUtil;

public class UserDAOImpl implements UserDAO{

	public int registerUser(UserBO bo) {
		Session session = null;
		Transaction tx = null;
		UserBO tempBo = null;
		int count = 0;
		//get Session object
		session = HibernateUtil.getSession();
		tempBo = session.get(UserBO.class,bo.getUserName());
		System.out.println("DAOIMPl::--"+bo);
		if(tempBo == null && (bo.getUserName().trim().length() >= 1)){
			try{
				tx = session.beginTransaction();
				String s = (String)session.save(bo);
				count = s.length();
				tx.commit();
			}catch(Exception e){
				tx.rollback();
			}
		}else{
			count= 0;
		}	
		return count;
	}

	public int updateUserInfo(UserBO bo) {
		Session session = null;
		Transaction tx = null;
		UserBO tempBo = null;
		int count = 0;
		//get Session object
		session = HibernateUtil.getSession();
		tempBo = session.get(UserBO.class,bo.getUserName());
		bo.setPassword(tempBo.getPassword());
			try{
				tx = session.beginTransaction();
				session.delete(tempBo);
				session.save(bo);
				tx.commit();
				++count ;
			}catch(Exception e){
				tx.rollback();
			}
		return count;
	}

	public int deleteUser(String userName) {
		Session session = null;
		Transaction tx = null;
		UserBO tempBo = null;
		int count = 0;
		//get Session object
		session = HibernateUtil.getSession();
		tempBo = session.get(UserBO.class,userName);
		if(tempBo != null){
			try{
				tx = session.beginTransaction();
				session.delete(tempBo);
				tx.commit();
				++count;
			}catch(Exception e){
				tx.rollback();
			}
		}else{
			count = 0;
		}
		return count;

	}

	@Override
	public List retriveData() {
		Session session = null;
		List<UserBO> userList = null;
		Criteria criteria = null;
		//
		session = HibernateUtil.getSession();
		criteria = session.createCriteria(UserBO.class);
		userList = criteria.list();
		return userList;
	}
}
