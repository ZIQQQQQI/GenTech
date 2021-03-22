package Outil;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/22
 */

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import  org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateConn {
    private static  final SessionFactory SESSION_FACTORY ;
    static {
        try{
            Configuration configuration=new Configuration();
            configuration.configure("GenTech.cfg.xml");


            SESSION_FACTORY = configuration.buildSessionFactory();
        }
        catch (HibernateException ex)
        {
            /*----- Exception -----*/
            System.err.println("Initial SessionFactory creation failed.\n" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

   /*
    * @param
    * @return org.hibernate.SessionFactory
    * @author TANG
    * @date 2021/3/22 21:13
    */
    public static SessionFactory getSessionFactory(){return SESSION_FACTORY;}


}


