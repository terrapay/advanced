
package com.karaca.hibernateintro;

import com.karaca.hibernateintro.common.Users;
import com.karaca.hibernateintro.persistence.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HibernateApp {
    
    private static Session session;
    
    public static void main(String[] args){
        // -1- Create SessionFactory & get Session from it
        session = HibernateUtil.getSessionFactory().openSession();
        // -2- Add Users to Table
        registerNewUser("kemalsamikaraca" , "java-developer" , "kskaraca@gmail.com");
        // -3- HQL example 
        Query query = session.createQuery("from Users");//select * from users
//        query.
        List list = query.list();
        // -4- Print Table
        System.out.println("\n\nJava-Hibernate CRUD-HQL example\n");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Users user = (Users)iterator.next();
            System.out.println(user.getId() + " - " + user.getUsername() + " - " + user.getEmail());
        }
        System.out.println("\nEnd of Java-Hibernate CRUD-HQL example\n");
        
        // -5- Close Connection
        HibernateUtil.shutdown(); 
    }
    public static void registerNewUser(String username, String password, String mail){
        // -- 1 -- Transaction begin
        session.beginTransaction();
        
        // -- 2 -- Set user values
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(mail);
        
        // -- 3 -- Transaction commit 
        session.save(user);
        session.getTransaction().commit(); 
    }
    
}

