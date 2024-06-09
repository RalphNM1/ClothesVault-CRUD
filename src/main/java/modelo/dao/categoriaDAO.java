/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.vo.Categoria;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ralph
 */
public class categoriaDAO {

    public Categoria buscarCategoria(Session session, String nombre) {
        Categoria c = null;
        Query q = session.createQuery("from Categoria c where c.nombre=:nombre");

        q.setParameter("nombre", nombre);
        c = (Categoria) q.uniqueResult();
        return c;
    }
    
    public void cargacombo(Session session, DefaultComboBoxModel modelocombo) throws Exception {
        Categoria p;
        Query q = session.createQuery("from Categoria p");

        List<Categoria> listaCategorias = q.list();
        Iterator it = listaCategorias.iterator();

        while (it.hasNext()) {
            modelocombo.addElement(it.next());
        }
    }
}
