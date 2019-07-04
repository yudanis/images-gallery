/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images.gallery;

import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.layout.Border;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ytr
 */
public class PanelPerFolder extends javax.swing.JPanel {

    /**
     * Creates new form PanelPerFolder
     */
    public PanelPerFolder() {
        initComponents();
        JLabel lbl = new JLabel(new ImageIcon("kapal.jpg"));
        lbl.setText("asdfsd");

        ImageIconRenderer imgRenderer = new ImageIconRenderer();

        TableColumnModel columnModel = jTable1.getColumnModel();

        for (int i = 0; i < jTable1.getColumnCount(); i++) {

            columnModel.getColumn(i).setCellRenderer(imgRenderer);
        }
        // jTable1.getColumnModel().getColumn(0).setCellRenderer(new ImageIconRenderer());

        jTable1.setTableHeader(null);
        jTable1.setDefaultRenderer(String.class, imgRenderer);
        jTable1.setRowHeight(150);

        jTable1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            
                JOptionPane.showMessageDialog(null, "an image clicked");
            }
        });

    }

    class ImageIconRenderer implements TableCellRenderer {

        JLabel lblImg;

        public ImageIconRenderer() {
            super();
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            if (lblImg == null) {
                TitledBorder titledBorder = new TitledBorder("test");
                titledBorder.setTitleColor(Color.WHITE);
                titledBorder.setTitlePosition(TitledBorder.CENTER);

                int rowHeight = table.getRowHeight();
                TableColumnModel colmodel = table.getColumnModel();
                int colWidth = colmodel.getColumn(column).getWidth();

                Image dimg = ImageHelper.GetScaledImg(colWidth, rowHeight, "kapal6.jpg");
                        // ImageIcon icon = new ImageIcon(dimg);
                lblImg = new JLabel();
                lblImg.setBorder(titledBorder);
                lblImg.setIcon(new ImageIcon(dimg));
                lblImg.setOpaque(false);
                lblImg.setBackground(Color.red);
                return lblImg;
            } else {
                return lblImg;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setBorder(javax.swing.BorderFactory.createTitledBorder("Folder Name"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
