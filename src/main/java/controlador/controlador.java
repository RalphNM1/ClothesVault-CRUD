/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.factory.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.dao.categoriaDAO;
import modelo.dao.productoDAO;
import modelo.dao.proveedorDAO;
import modelo.vo.Categoria;
import modelo.vo.Producto;
import modelo.vo.Proveedor;
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

        session.beginTransaction();

        try {

            proDAO.insertar(session,
                    ventanaCRUDProducto.getTfNombreProducto().getText().trim(),
                    ventanaCRUDProducto.getTfTallaProducto().getText().trim(),
                    ventanaCRUDProducto.getTfDescripcionProducto().getText().trim(),
                    Double.parseDouble(ventanaCRUDProducto.getTfPrecioProducto().getText().trim()),
                    Integer.parseInt(ventanaCRUDProducto.getTfStockProducto().getText().trim()),
                    provDAO.buscarProveedor(session, ((Proveedor) ventanaCRUDProducto.getCmbProveedores().getSelectedItem()).getId()),
                    catDAO.buscarCategoria(session, ((Categoria) ventanaCRUDProducto.getCmbCategorias().getSelectedItem()).getNombre()),
                    ventanaCRUDProducto.getImagenBytes());
            session.getTransaction().commit();
        } catch (NumberFormatException ex) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos");
        } catch (Exception ex1) {
            session.getTransaction().rollback();
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    public static void modificarProducto() throws Exception {
        try {
            session.beginTransaction();

            JTable tablaProductos = ventanaCRUDProducto.getTablaProductos();

            int filaSeleccionada = tablaProductos.getSelectedRow();
            proDAO.modificar(session, proDAO.buscarProducto(session, (Long) tablaProductos.getValueAt(filaSeleccionada, 0)),
                    ventanaCRUDProducto.getTfNombreProducto().getText().trim(),
                    ventanaCRUDProducto.getTfTallaProducto().getText().trim(),
                    ventanaCRUDProducto.getTfDescripcionProducto().getText().trim(),
                    Double.parseDouble(ventanaCRUDProducto.getTfPrecioProducto().getText().trim()),
                    Integer.parseInt(ventanaCRUDProducto.getTfStockProducto().getText().trim()),
                    provDAO.buscarProveedor(session, ((Proveedor) ventanaCRUDProducto.getCmbProveedores().getSelectedItem()).getId()),
                    catDAO.buscarCategoria(session, ((Categoria) ventanaCRUDProducto.getCmbCategorias().getSelectedItem()).getNombre()),
                    ventanaCRUDProducto.getImagenBytes());

            session.getTransaction().commit();
        } catch (NumberFormatException ex) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos");
        } catch (Exception ex1) {
            session.getTransaction().rollback();
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    public static void llenarTablaProductos(JTable tabla) {
        session.beginTransaction();

        // Obtener los datos de los productos de la base de datos
        List<Producto> productos = proDAO.obtenerTodos(session);

        // Crear el modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        // Añadir las columnas al modelo de tabla
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Talla");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Categoría");

        // Iterar sobre la lista de productos y agregar cada producto como una fila en el modelo de tabla
        for (Producto producto : productos) {
            Object[] fila = {
                producto.getId(),
                producto.getNombre(),
                producto.getTalla(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getProveedor().getNombre(),
                producto.getCategoria().getNombre()
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo de tabla a la tabla en la interfaz de usuario
        tabla.setModel(modelo);

        session.getTransaction().commit();

    }

    public static void cargarcombo() {
        try {
            session.beginTransaction();
            provDAO.cargacombo(session, ventanaCRUDProducto.modelocomboProv);
            catDAO.cargacombo(session, ventanaCRUDProducto.modelocomboCat);

            HibernateUtil.commitTx(session);
        } catch (Exception ex) {
            session.getTransaction().rollback();
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void mostrarProductos() { // EDITTEXT
        JTable tablaProductos = ventanaCRUDProducto.getTablaProductos();

        int filaSeleccionada = tablaProductos.getSelectedRow();

        if (filaSeleccionada != -1) { // Verificar si se seleccionó alguna fila
            // Obtener los datos de la fila seleccionada
            String nombre = (String) tablaProductos.getValueAt(filaSeleccionada, 1);
            String talla = (String) tablaProductos.getValueAt(filaSeleccionada, 2);
            String descripcion = (String) tablaProductos.getValueAt(filaSeleccionada, 3);
            String precio = String.valueOf(tablaProductos.getValueAt(filaSeleccionada, 4));
            String stock = String.valueOf(tablaProductos.getValueAt(filaSeleccionada, 5));
            String idProveedor = String.valueOf(tablaProductos.getValueAt(filaSeleccionada, 6));
            String categoria = (String) tablaProductos.getValueAt(filaSeleccionada, 7);

            // Configurar los valores en los campos de texto
            ventanaCRUDProducto.getTfNombreProducto().setText(nombre);
            ventanaCRUDProducto.getTfTallaProducto().setText(talla);
            ventanaCRUDProducto.getTfDescripcionProducto().setText(descripcion);
            ventanaCRUDProducto.getTfPrecioProducto().setText(precio);
            ventanaCRUDProducto.getTfStockProducto().setText(stock);

            // Obtener el índice del proveedor en el combo de proveedores
            int indiceProveedor = obtenerIndiceProveedor(idProveedor);
            ventanaCRUDProducto.getCmbProveedores().setSelectedIndex(indiceProveedor);

            // Obtener el índice de la categoría en el combo de categorías
            int indiceCategoria = obtenerIndiceCategoria(categoria);
            ventanaCRUDProducto.getCmbCategorias().setSelectedIndex(indiceCategoria);
        }
    }

    private static int obtenerIndiceProveedor(String nombreProveedor) {
        JComboBox<Proveedor> cmbProveedores = ventanaCRUDProducto.getCmbProveedores();
        for (int i = 0; i < cmbProveedores.getItemCount(); i++) {
            Proveedor proveedor = cmbProveedores.getItemAt(i);
            if (proveedor.getNombre().equals(nombreProveedor)) {
                return i;
            }
        }
        return -1;
    }

    private static int obtenerIndiceCategoria(String categoria) {
        JComboBox<Categoria> cmbCategorias = ventanaCRUDProducto.getCmbCategorias();
        for (int i = 0; i < cmbCategorias.getItemCount(); i++) {
            Categoria cat = cmbCategorias.getItemAt(i);
            if (cat.getNombre().equals(categoria)) {
                return i;
            }
        }
        return -1;
    }

    public static void eliminarProducto(Long idProducto) {
        try {
            session.beginTransaction();
            Producto producto = proDAO.buscarProducto(session, idProducto);
            if (producto != null) {
                proDAO.eliminar(session, producto);
                session.getTransaction().commit();
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public static void limpiarCampos() {

        ventanaCRUDProducto.getTfNombreProducto().setText("");
        ventanaCRUDProducto.getTfTallaProducto().setText("");
        ventanaCRUDProducto.getTfDescripcionProducto().setText("");
        ventanaCRUDProducto.getTfPrecioProducto().setText("");
        ventanaCRUDProducto.getTfStockProducto().setText("");
    }

}
