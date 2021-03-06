package cn.linson.xtools.db;

import cn.linson.xtools.domain.ImageInfo;
import cn.linson.xtools.domain.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;


/**
 * Created by Administrator on 2016/5/4.
 */
public class MyDB {
    private final SessionFactory ourSessionFactory;
    private final ServiceRegistry serviceRegistry;

    public MyDB() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public <T> T find(int userId) {
        Session session = getSession();
        T t = (T) session.get(User.class, userId);
        session.close();
        return t;
    }

    public ImageInfo findByImageName(String fileName) {
        Session session = getSession();
        Criteria c = session.createCriteria(ImageInfo.class)
                .add(Restrictions.eq("fileName", fileName));
        ImageInfo imageInfo = null;
        imageInfo = (ImageInfo) c.uniqueResult();
        session.close();
        return imageInfo;
    }

//    public <T> List findAll(T t) {
//        List<T> list = null;
//        Session session = getSession();
//        Criteria c = session.createCriteria(t.getClass().);
//        list = c.list();
//        session.close();
//        return list;
//    }

    public List<ImageInfo> findAllImageInfo() {
        List<ImageInfo> list = null;
        Session session = getSession();
        Criteria c = session.createCriteria(ImageInfo.class);
        list = c.list();
        session.close();
        return list;
    }

    public List<ImageInfo> findImageInfoByType(String type) {
        List<ImageInfo> list = null;
        Session session = getSession();
        Criteria c = session.createCriteria(ImageInfo.class)
                .add(Restrictions.eq("type", type))
                .addOrder(Order.desc("date"));
        list = c.list();
        session.close();
        return list;
    }

    public List<ImageInfo> findImageInfoByType(String type, int results) {
        List<ImageInfo> list = null;
        Session session = getSession();
        Criteria c = session.createCriteria(ImageInfo.class)
                .add(Restrictions.eq("type", type))
                .addOrder(Order.desc("date"))
                .setMaxResults(results);
        list = c.list();
        session.close();
        return list;
    }

    public <T> void delete(T t) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.delete(t);
        tx.commit();
        session.close();
    }
    public <T> void update(T t) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.update(t);
        tx.commit();
        session.close();
    }

    public <T> void add(T t) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
        session.close();
    }

    public <T> T find(T t) {
        Session session = getSession();
        String hql = "from User u where u.username = ? and  u.password = ?";
        Query query = session.createQuery(hql);
        String username = ((User) t).getUsername();
        String password = ((User) t).getPassword();
        query.setString(0, username);
        query.setString(1, password);
        List<T> list = query.list();
        session.close();
        T tt = null;
        if (list.size() == 1) {
            tt = list.get(0);
        }
        return tt;
    }
}
