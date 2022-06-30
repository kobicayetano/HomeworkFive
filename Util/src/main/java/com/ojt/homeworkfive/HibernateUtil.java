package com.ojt.homeworkfive;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.File;

public class HibernateUtil{

  public static SessionFactory getSessionFactory(){
    String path = "Util/src/main/resources/hibernate.cfg.xml";
    File file = new File(path);
    SessionFactory sessionFactory = new Configuration().configure(file).buildSessionFactory();
    return sessionFactory;
  }


}