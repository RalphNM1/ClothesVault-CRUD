/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import modelo.vo.Categoria;
import modelo.vo.Producto;
import modelo.vo.Proveedor;
import org.hibernate.Session;

/**
 *
 * @author ralph
 */
public class productoDAO {

    public void insertar(Session session, String nombre, String marca, String talla, String descripcion, Double precio, int stock, Proveedor proveedor, Categoria categoria, String imagen_url) throws Exception {
        Producto p = new Producto(nombre, marca, talla, descripcion, precio, stock, proveedor, categoria, imagen_url);

        session.save(p);

    }
}
//
