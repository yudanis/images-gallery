/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images.gallery;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author ytr
 */
public class PanelGalleryDesktop extends javax.swing.JPanel {

    /**
     * Creates new form PanelGalleryDesktop
     */
    public PanelGalleryDesktop() {
        initComponents();
        JPanel panel = new JPanel();        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new PanelPerFolder());
        panel.add(new PanelPerFolder());
        
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setPreferredSize(panel.getPreferredSize());
        this.setLayout(new BorderLayout());
        this.add(scroll);
        this.setPreferredSize(scroll.getPreferredSize());
        this.repaint();
        
    }

    public static void main(String ...args){
        JFrame frame = new JFrame();
        PanelGalleryDesktop panel = new PanelGalleryDesktop();
        frame.setContentPane(panel);
        frame.setPreferredSize(panel.getPreferredSize());
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
