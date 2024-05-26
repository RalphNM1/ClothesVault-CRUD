/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import modelo.vo.Proveedor;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ralph
 */
public class proveedorDAO {
       public Proveedor buscarProveedor(Session session, int id) {
        Proveedor p = null;
        Query q = session.createQuery("from Proveedor p where p.id=:id");

        q.setParameter("id", id);
        p = (Proveedor) q.uniqueResult();
        return p;
    }
}
