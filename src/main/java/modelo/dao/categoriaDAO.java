/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import modelo.vo.Categoria;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ralph
 */
public class categoriaDAO {

    public Categoria buscarProveedor(Session session, String nombre) {
        Categoria c = null;
        Query q = session.createQuery("from Categoria c where c.nombre=:nombre");

        q.setParameter("nombre", nombre);
        c = (Categoria) q.uniqueResult();
        return c;
    }
}
