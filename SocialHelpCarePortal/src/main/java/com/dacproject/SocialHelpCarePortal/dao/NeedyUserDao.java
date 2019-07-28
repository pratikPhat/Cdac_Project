package com.dacproject.SocialHelpCarePortal.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dacproject.SocialHelpCarePortal.model.User;



@Repository
@Transactional
public class NeedyUserDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(SocialDao sw) {
    getSession().save(sw);
  }
  
	public List<User> listVolunteer() {
		String hql="FROM User E WHERE E.type = '" + "needy" + "'";
		List<User> needyList = getSession().createQuery(hql).list();
		return needyList;
	}

}