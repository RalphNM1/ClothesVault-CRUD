/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.factory.HibernateUtil;
import javax.swing.JDialog;
import modelo.dao.categoriaDAO;
import modelo.dao.productoDAO;
import modelo.dao.proveedorDAO;
import org.hibernate.Session;
import vista.CRUDProducto;
import vista.vistaCRUD;

/**
 *
 * @author ralph
 */
public class controlador {

    public static Session session;
    public static productoDAO proDAO;
    public static proveedorDAO provDAO;
    public static categoriaDAO catDAO;
    public static vistaCRUD ventana = new vistaCRUD();
    public static CRUDProducto ventanaCRUDProducto = new CRUDProducto(ventana, true);

    public static void iniciar() {
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
    }

    public static void iniciar(JDialog ventana) {

        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setVisible(true);

    }

    public static void iniciaSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        proDAO = HibernateUtil.getProductoDAO();
        provDAO = HibernateUtil.getProveedorDAO();
        catDAO = HibernateUtil.getCategoriaDAO();

    }

    public static void cerrarSession() {
        session.close();
    }

    public static void insertarProducto() throws Exception {
      proDAO.insertar(session,
                ventanaCRUDProducto.getTfNombreProducto().getText().trim(),
                ventanaCRUDProducto.getTfMarcaProducto().getText().trim(),
                ventanaCRUDProducto.getTfTallaProducto().getText().trim(),
                ventanaCRUDProducto.getTfDescripcionProducto().getText().trim(),
                Double.parseDouble(ventanaCRUDProducto.getTfPrecioProducto().getText().trim()),
                Integer.parseInt(ventanaCRUDProducto.getTfStockProducto().getText().trim()),
                provDAO.buscarProveedor(session, Integer.parseInt(ventanaCRUDProducto.getTfIdProveedorProducto().getText().trim())),
                catDAO.buscarProveedor(session, ventanaCRUDProducto.getTfCategoria().getText().trim()),
                 ventanaCRUDProducto.getUrlImagen().trim());

    }

}
