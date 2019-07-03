/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images.gallery;

import java.awt.ComponentOrientation;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sun.nio.ch.DefaultAsynchronousChannelProvider;

/**
 *
 * @author ytr
 */
public class ImagesGallery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();
        PanelPerFolder ppf = new PanelPerFolder();
        frame.setContentPane(ppf);
        frame.setSize(ppf.getPreferredSize());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
/*
        String path = "/home/ytr/infoglobal/ana/Pictures/2017 10 27";
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        DefaultListModel listModel = new DefaultListModel();
        int count = 0;
        for (int i = 0; i < listOfFiles.length; i++)
        {
            System.out.println("check path"+listOfFiles[i]);
            String name = listOfFiles[i].toString();
            // load only JPEGs
            if ( name.endsWith("jpg") ) {
                ImageIcon ii = null;
                try {
                    Image img = ImageIO.read(listOfFiles[i]).getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);
                    ii = new ImageIcon(img);
                } catch (IOException ex) {
                    Logger.getLogger(ImagesGallery.class.getName()).log(Level.SEVERE, null, ex);
                }
                listModel.add(count++, ii);
                
            }
        }
        JList lsm=new JList(listModel);
        lsm.setVisibleRowCount(1);
        JScrollPane jsp = new JScrollPane(lsm);
        jsp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jsp.revalidate();
        jsp.repaint();
        frame.add(jsp);

        frame.pack();
        frame.setVisible(true);*/
    }
    
}
