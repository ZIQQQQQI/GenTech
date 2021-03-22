import Outil.HibernateConn;
import metier.Magasin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class UnitTest {
    @Test
    public void test(){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Magasin magasin=new Magasin();
        magasin.setIdMagasin("2");
        session.save(magasin);
        transaction.commit();
    }
}
