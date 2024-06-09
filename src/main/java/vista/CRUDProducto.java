/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.controlador;
import static controlador.controlador.ventanaCRUDProducto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.vo.Categoria;
import modelo.vo.Proveedor;

/**
 *
 * @author ralph
 */
public class CRUDProducto extends javax.swing.JDialog {

    public static DefaultComboBoxModel modelocomboProv = new DefaultComboBoxModel();
    public static DefaultComboBoxModel modelocomboCat = new DefaultComboBoxModel();

    /**
     * Creates new form CRUDProducto
     */
    public CRUDProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.getCmbCategorias().setModel(modelocomboCat);
        this.getCmbProveedores().setModel(modelocomboProv);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNombreProducto = new javax.swing.JTextField();
        tfTallaProducto = new javax.swing.JTextField();
        tfDescripcionProducto = new javax.swing.JTextField();
        tfPrecioProducto = new javax.swing.JTextField();
        tfStockProducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btCargarImagen = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbProveedores = new javax.swing.JComboBox<>();
        cmbCategorias = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btInsertar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRUD Producto");
        setBackground(new java.awt.Color(153, 153, 255));
        setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel4.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tallas");

        jLabel5.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Descripción");

        jLabel6.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Precio");

        jLabel7.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Stock");

        jLabel2.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");

        tfNombreProducto.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N

        tfTallaProducto.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N

        tfDescripcionProducto.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N

        tfPrecioProducto.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N

        tfStockProducto.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ID Proveedor");

        btCargarImagen.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        btCargarImagen.setText("Cargar Imagen");
        btCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarImagenActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Categoría");

        cmbProveedores.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        cmbProveedores.setPreferredSize(new java.awt.Dimension(64, 24));

        cmbCategorias.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        cmbCategorias.setPreferredSize(new java.awt.Dimension(64, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbProveedores, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCargarImagen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(tfStockProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfPrecioProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfDescripcionProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfTallaProducto, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(tfTallaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(tfDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(tfPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(tfStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 190));

        btInsertar.setFont(new java.awt.Font("SF Pro Text", 1, 24)); // NOI18N
        btInsertar.setText("INSERTAR");
        btInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertarActionPerformed(evt);
            }
        });

        btModificar.setFont(new java.awt.Font("SF Pro Text", 1, 24)); // NOI18N
        btModificar.setText("MODIFICAR");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        btBorrar.setFont(new java.awt.Font("SF Pro Text", 1, 24)); // NOI18N
        btBorrar.setText("BORRAR");
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   private byte[] imagenBytes;

    public byte[] getImagenBytes() {
        return imagenBytes;
    }

    public void setImagenBytes(byte[] imagenBytes) {
        this.imagenBytes = imagenBytes;
    }

    private void btCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarImagenActionPerformed
        // Create a JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione una imagen");

        // Show the dialog to select a file
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file = fileChooser.getSelectedFile();
            try {
                // Convert the file to a byte array
                imagenBytes = Files.readAllBytes(file.toPath());
                // Show success message
                JOptionPane.showMessageDialog(this, "Imagen cargada exitosamente.");
            } catch (IOException ex) {
                Logger.getLogger(CRUDProducto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen.");
            }
        }
    }//GEN-LAST:event_btCargarImagenActionPerformed


    private void btInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertarActionPerformed
        try {
            // TODO add your handling code here:
            controlador.insertarProducto();
            controlador.llenarTablaProductos(tablaProductos);
            controlador.limpiarCampos();
            JOptionPane.showMessageDialog(this, "Producto insertado correctamente");

        } catch (Exception ex) {
            Logger.getLogger(CRUDProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Producto no insertado");

        }
    }//GEN-LAST:event_btInsertarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            controlador.modificarProducto();
            controlador.llenarTablaProductos(tablaProductos);
            JOptionPane.showMessageDialog(this, "Producto modificado correctamente");

        } catch (Exception ex) {
            Logger.getLogger(CRUDProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Producto no modificado");

        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        // TODO add your handling code here:
        try {
            // Obtener el índice de la fila seleccionada
            int filaSeleccionada = tablaProductos.getSelectedRow();
            if (filaSeleccionada != -1) { // Si hay una fila seleccionada
                // Obtener el ID del producto seleccionado en la tabla
                Long idProducto = (Long) tablaProductos.getValueAt(filaSeleccionada, 0);
                System.out.println("id " + idProducto);
                // Eliminar el producto de la base de datos
                controlador.eliminarProducto(idProducto);
                // Actualizar la tabla
                controlador.llenarTablaProductos(tablaProductos);
                controlador.limpiarCampos();
                JOptionPane.showMessageDialog(this, "Producto borrado correctamente");

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(CRUDProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btBorrarActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        // TODO add your handling code here:

        controlador.mostrarProductos();

    }//GEN-LAST:event_tablaProductosMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        controlador.llenarTablaProductos(tablaProductos);
        controlador.cargarcombo();
    }//GEN-LAST:event_formWindowOpened

    public JTextField getTfDescripcionProducto() {
        return tfDescripcionProducto;
    }

    public void setTfDescripcionProducto(JTextField tfDescripcionProducto) {
        this.tfDescripcionProducto = tfDescripcionProducto;
    }


    public JTextField getTfNombreProducto() {
        return tfNombreProducto;
    }

    public void setTfNombreProducto(JTextField tfNombreProducto) {
        this.tfNombreProducto = tfNombreProducto;
    }

    public JTextField getTfPrecioProducto() {
        return tfPrecioProducto;
    }

    public void setTfPrecioProducto(JTextField tfPrecioProducto) {
        this.tfPrecioProducto = tfPrecioProducto;
    }

    public JTextField getTfStockProducto() {
        return tfStockProducto;
    }

    public void setTfStockProducto(JTextField tfStockProducto) {
        this.tfStockProducto = tfStockProducto;
    }

    public JTextField getTfTallaProducto() {
        return tfTallaProducto;
    }

    public void setTfTallaProducto(JTextField tfTallaProducto) {
        this.tfTallaProducto = tfTallaProducto;
    }

    public JTable getTablaProductos() {
        return tablaProductos;
    }

    public void setTablaProductos(JTable tablaProductos) {
        this.tablaProductos = tablaProductos;
    }

    public JComboBox<Categoria> getCmbCategorias() {
        return cmbCategorias;
    }

    public void setCmbCategorias(JComboBox<Categoria> cmbCategorias) {
        this.cmbCategorias = cmbCategorias;
    }

    public JComboBox<Proveedor> getCmbProveedores() {
        return cmbProveedores;
        
    }

    public void setCmbProveedores(JComboBox<Proveedor> cmbProveedores) {
        this.cmbProveedores = cmbProveedores;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btCargarImagen;
    private javax.swing.JButton btInsertar;
    private javax.swing.JButton btModificar;
    private javax.swing.JComboBox<Categoria> cmbCategorias;
    private javax.swing.JComboBox<Proveedor> cmbProveedores;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField tfDescripcionProducto;
    private javax.swing.JTextField tfNombreProducto;
    private javax.swing.JTextField tfPrecioProducto;
    private javax.swing.JTextField tfStockProducto;
    private javax.swing.JTextField tfTallaProducto;
    // End of variables declaration//GEN-END:variables
}
