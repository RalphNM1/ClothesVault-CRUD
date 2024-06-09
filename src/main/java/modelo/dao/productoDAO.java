/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;
import modelo.vo.Categoria;
import modelo.vo.Producto;
import modelo.vo.Proveedor;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ralph
 */
public class productoDAO {

    public void insertar(Session session, String nombre, String talla, String descripcion, Double precio, int stock, Proveedor proveedor, Categoria categoria, byte[] imagen) throws Exception {
        Producto p = new Producto(nombre, talla, descripcion, precio, stock, proveedor, categoria, imagen);

        session.save(p);

    }

    public void modificar(Session session, Producto p, String nombre, String talla, String descripcion, Double precio, int stock, Proveedor proveedor, Categoria categoria, byte[] imagen) throws Exception {
        p.setNombre(nombre);
        p.setTalla(talla);
        p.setDescripcion(descripcion);
        p.setPrecio(precio);
        p.setStock(stock);
        p.setProveedor(proveedor);
        p.setCategoria(categoria);
        p.setImagen(imagen); // Almacenar la imagen como un arreglo de bytes
        session.update(p);
    }

    public List<Producto> obtenerTodos(Session session) {
        // Crear la consulta HQL para obtener todos los productos
        String hql = "FROM Producto";

        // Crear la consulta a partir del HQL
        Query<Producto> consulta = session.createQuery(hql, Producto.class);

        // Ejecutar la consulta y obtener la lista de productos
        List<Producto> productos = consulta.list();

        // Devolver la lista de productos
        return productos;

    }

    public Producto buscarProducto(Session session, Long id) {
        Producto p = null;
        Query q = session.createQuery("from Producto p where p.id=:id");

        q.setParameter("id", id);
        p = (Producto) q.uniqueResult();
        return p;
    }

    public void eliminar(Session session, Producto p) {
        session.delete(p);

    }

}
//
