package com.ojt.homeworkfive;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.*;

public class RoleDAOImpl implements RoleDAO{


    @Override
    public void addRole(Role role){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            transaction=session.beginTransaction();
            session.save(role);   
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

} 



