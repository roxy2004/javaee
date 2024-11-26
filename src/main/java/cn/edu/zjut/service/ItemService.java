package cn.edu.zjut.service;

import java.util.List;
import java.util.ArrayList;
import cn.edu.zjut.dao.ItemDAO;
import cn.edu.zjut.util.HibernateUtil;
import org.hibernate.Session;

public class ItemService {
    private List items = new ArrayList();
    public Session getSession() {
        return HibernateUtil.getSession();
    }
    public List getAllItems() {
        Session session=this.getSession();
        ItemDAO dao = new ItemDAO();
        dao.setSession(session);
        List items = dao.findAll();
        HibernateUtil.closeSession();
        return items;
    }
//    public List findByHql() {
//        Session session=this.getSession();
//        ItemDAO dao = new ItemDAO();
//        dao.setSession(session);
//        String hql = "select item.ipk.title, item.cost from Item as item";
//        List list = dao.findByHql(hql);
//        HibernateUtil.closeSession();
//        return list;
//    }
    public List<Object[]> findByHql() {
        Session session = this.getSession();
        ItemDAO dao = new ItemDAO();
        dao.setSession(session);
        String hql = "select item.ipk.title, item.cost, (select avg(i.cost) from Item i) as avgCost " +
                "from Item as item " +
                "where item.cost > (select avg(i.cost) from Item i) " +
                "order by item.cost desc";
        List<Object[]> list = dao.findByHql(hql);
        HibernateUtil.closeSession();
        return list;
    }
}
