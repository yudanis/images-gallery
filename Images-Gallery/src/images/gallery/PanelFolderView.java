/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images.gallery;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ytr
 */
public class PanelFolderView extends javax.swing.JPanel {

    /**
     * Creates new form PanelFolderView
     */
    int rowHeight = 50;
    int padding = 20;

    public PanelFolderView() {
        initComponents();

        initJTableData();
        initJtableView();

        setJtableAction();

    }

    void initJtableView() {

        FolderCellRenderer renderer = new FolderCellRenderer();
        TableColumnModel columnModel = jTable1.getColumnModel();

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(renderer);
        }
        jTable1.setTableHeader(null);
        jTable1.setRowHeight(rowHeight + padding);
    }

    public static void main(String... args) {
        JFrame frame = new JFrame();
        PanelFolderView panel = new PanelFolderView();
        frame.setContentPane(panel);
        frame.setSize(panel.getPreferredSize());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initJTableData() {

        MyModel model = new MyModel();
        jTable1.setModel(model);
        File[] directories = new File("/home/ytr/infoglobal/ana/Pictures").listFiles(File::isDirectory);

        for (int i = 0; i < directories.length; i++) {
            model.allFolder.add(directories[i].toPath());
        }
    }

    private void setJtableAction() {

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                JDialog dlg = new JDialog();
                PanelPerFolder panel = new PanelPerFolder();
                dlg.setContentPane(panel);
                dlg.setSize(panel.getPreferredSize());
                dlg.pack();
                dlg.setVisible(true);
                dlg.setAlwaysOnTop(true);
            }

        });
    }

    class FolderCellRenderer implements TableCellRenderer {

        JLabel lbl = null;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            if (lbl == null) {
                Image img = ImageHelper.GetScaledImg(rowHeight, rowHeight, "folder.png");
                lbl = new JLabel(new ImageIcon(img));

            }
            
            Path path = (Path) value;
            setTitle(path.getFileName().toString());
            return lbl;

        }
        void setTitle(String title){
            
            TitledBorder titledBorder = new TitledBorder(title);
            titledBorder.setTitlePosition(TitledBorder.BOTTOM);
            lbl.setBorder(titledBorder);
        }

    }

    class MyModel extends AbstractTableModel {

        ArrayList<Path> allFolder = new ArrayList<>();

        @Override
        public int getRowCount() {
            return allFolder.size() / getColumnCount();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            int idx = rowIndex * getColumnCount() + columnIndex;
            return allFolder.get(idx);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}