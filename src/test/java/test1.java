import com.yl.po.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

/**
 * @author Administrator
 * @create 2019-11-21-9:23
 */
public class test1 {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @Before
    public void before(){
    sessionFactory=new Configuration().configure().buildSessionFactory();
    session=sessionFactory.openSession();
    transaction=session.beginTransaction();
    }

    @Test
    public  void testget(){
        Object o = session.get(Emp.class, 1);
        System.out.println("o = " + o);
    }
    @Test
    public  void testload(){
        Object o = session.load(Emp.class, 2);
        System.out.println("o = " + o);
    }
    @Test
    public  void testinsert(){
        Serializable save = session.save(new Emp("20", "zhangsan", 20, 5000, "开发部"));
    }
    @Test
    public  void testdelete(){
        Object o = session.get(Emp.class, 6);
        session.delete(o);
    }
    @Test
    public  void testupdate(){
        session.update(new Emp(3,"20", "zhangsan", 20, 5000, "开发部"));
    }

    @Test
    public  void testupdate1(){
        Emp emp=new Emp(7,"20", "王五", 20, 5000, "开发部");
        session.saveOrUpdate(emp);
    }

    @After
    public void after(){
        transaction.commit();
        session.close();
    }
}
