package controlador.factory;

import modelo.dao.categoriaDAO;
import modelo.dao.productoDAO;
import modelo.dao.proveedorDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Session Factory could not be created." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public static Transaction beginTx(Session s) {

        if (s.getTransaction() == null || !s.getTransaction().isActive()) {
            return s.beginTransaction();
        }
        return sessionFactory.getCurrentSession().getTransaction();
    }

    public static void commitTx(Session s) {
        if (s.getTransaction().isActive()) {
            s.getTransaction().commit();
        }
    }

    public static void rollbackTx(Session s) {
        if (s.getTransaction().isActive()) {
            s.getTransaction().rollback();
        }
    }

    public static productoDAO getProductoDAO() {
        return new productoDAO();
    }

    public static proveedorDAO getProveedorDAO() {
        return new proveedorDAO();
    }

    public static categoriaDAO getCategoriaDAO() {
        return new categoriaDAO();
    }

}
