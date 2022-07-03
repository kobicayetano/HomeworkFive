package com.ojt.homeworkfive;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.*;
import java.util.Set;
import org.hibernate.query.Query;

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

    @Override
    public void deleteRoleById(int roleId){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            
            Role role = session.get(Role.class, roleId);
            Set<Person> peopleWithRole = role.getPersonSet();

            for(Person person : peopleWithRole){
                person.getRoleSet().remove(role);
                session.update(person);
            }


            session.delete(role);


            transaction=session.beginTransaction();
            transaction.commit();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoleTitleById(int roleId, String newTitle){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Role role = session.get(Role.class, roleId);
            if(role != null){
                Transaction transaction = null;
                transaction=session.beginTransaction();
                role.setTitle(newTitle);
                session.update(role);
                transaction.commit();
            }else{
                System.out.println("Role does not exist with provided Id..");
            }
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role fetchRoleById(int roleId){
        Role role = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            transaction=session.beginTransaction();
            role = session.get(Role.class, roleId);
            if(role != null){
                return role;
            }else{
                System.out.println("Role does not exist with provided Id..");
            }
        
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    

} 



