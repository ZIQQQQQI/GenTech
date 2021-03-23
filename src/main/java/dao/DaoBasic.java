package dao;

import Outil.HibernateConn;
import org.hibernate.Session;

public interface DaoBasic {

    Session session= HibernateConn.getSessionFactory().getCurrentSession();


}
