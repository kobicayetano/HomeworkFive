package com.ojt.homeworkfive;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.*;
import java.util.Set;
public class PersonDAOImpl implements PersonDAO{

	@Override
	public void addPerson(Person person){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = null;
			transaction=session.beginTransaction();
        	session.save(person);   
        	transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}


	@Override
	public Person fetchPerson(int personId){
		Person person = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = null;
			transaction=session.beginTransaction();
			person = session.get(Person.class, personId);
			if(person != null){
				return person;
			}else{
				System.out.println("Person does not exist with provided Id..");
			}
		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void updatePersonLastnameById(int personId, String newLastname){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Person person = session.get(Person.class, personId);
			if(person != null){
				Transaction transaction = null;
				transaction=session.beginTransaction();
				person.setLastName(newLastname);
				session.update(person);
				transaction.commit();
			}else{
				System.out.println("Person does not exist with provided Id..");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePersonById(int personId){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Person person = session.get(Person.class, personId);
			if(person != null){
				Transaction transaction = null;
				transaction=session.beginTransaction();
				session.delete(person);
				transaction.commit();
			}else{
				System.out.println("Person does not exist with provided Id..");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePersonRoleById(int personId, int roleId){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Person person = session.get(Person.class, personId);
            Role role = session.get(Role.class, roleId);
            Set set = person.getRoleSet();
            if(role != null){
                Transaction transaction = null;
                transaction=session.beginTransaction();
                set.remove(role);

                transaction.commit();
            }else{
                System.out.println("Role does not exist with provided Id..");
            }
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
	}

} 

        