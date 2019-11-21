import com.yl.po.Emp;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Administrator
 * @create 2019-11-20-10:08
 */
public class test {
    @org.junit.Test
    public void test(){
        //1.获取sessionfactory  会话工厂
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        //2.生产会话 通过opensession  获取session对象
        Session session=sessionFactory.openSession();
        //3.开启一个事务
        Transaction transaction =session.beginTransaction();
        //4.执行查询  get(要查询的类型,参数)
        Emp emp1=(Emp) session.get(Emp.class,1);
        System.out.println("emp1 = " + emp1);
        /*transaction.commit();
        session.close();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();*/
        Emp emp= (Emp)session.load(Emp.class,1);
        System.out.println("emp = " + emp);
        //4.2执行查询 （查询单条数据） hql 语句
        String hql="from Emp where id=?";
        String hql1="from Emp where id=:id";
        Query query = session.createQuery(hql);
        query.setParameter(0,1);
        Object o = query.uniqueResult();
        System.out.println("o = " + o);
        //5查询全部
        Query query1=session.createQuery("from Emp");
        List<Emp> list = query1.list();
        for (Emp emp2 : list) {
            System.out.println("emp2 = " + emp2);
        }
        //6sql查询
        SQLQuery query2 = session.createSQLQuery("select * from Emp");
           query2.addEntity(Emp.class);
        List list1 = query2.list();
        for (Object o1 : list1) {
            System.out.println("o1 = " + o1);
        }
    }
}
