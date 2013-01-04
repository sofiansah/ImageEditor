/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageEditor;

/**
 *
 * @author Sofiansah
 */
import Convert.Im2Bw;
import JImage.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ImageEditor extends javax.swing.JFrame {

    public ImageEditor() throws IOException {
        initComponents();
        initAll();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Explorer");

        jSlider1.setMinimum(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setText("jLabel1");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jSlider1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel1)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jSlider1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jButton1);

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setText("Default");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("BW");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Gray");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(191, 191, 191)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 712, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 390, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        //mendapatkan nilai slider
        String value=String.valueOf(this.jSlider1.getValue());
        //update component JLabel
        this.jLabel1.setText(value+" %");

        // class ResizeImage untuk menangani rescaling citra
        JIResizeImage resize=new JIResizeImage();
        Image image = resize.rescale(this.BICurrent,this.jSlider1.getValue());

        //update component JLabel
        this.setImageButton(jButton1, image);
        
    }//GEN-LAST:event_jSlider1StateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //kotak dialog file browser
        JFileChooser jFileChooser1=new JFileChooser();
        // kotak dialog save
        int cek=jFileChooser1.showOpenDialog(this);
        File file;
        if (cek==JFileChooser.APPROVE_OPTION)
        {

                //nama file
                file = jFileChooser1.getSelectedFile();

                //class JIInputImage untuk menangani file citra
                JIInputImage inputImage;

                inputImage = new JIInputImage();
                inputImage.JIInputImage(file);

                Image image=inputImage.getBufferedImage();

                //update component
                this.setImageButton(jButton1, image);

                //update variabel
                BIDefault=(BufferedImage) image;
                this.BICurrent=(BufferedImage) image;

            try {
                System.out.println(file.getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(ImageEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        //menampilkasn citra default (citra asal)
        this.setImageButton(jButton1, BIDefault);
      

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       
        // class JICreareImage untuk menangani konvert rgb to gray
       JICreateImage createImage =new JICreateImage();
       BufferedImage gray=createImage.createImageRGB2Gray(this.BIDefault);


       // class JIReadBufferedImage untuk mendapatkan nilai pixel citra
       JIReadBufferedImage pixel=new JIReadBufferedImage();
       
       
       // set input untuk format gray
       pixel.setBIGrayColor(gray);
       //mendapatkan nilai pixel citra gray yaitu range 1-256
       int [][]nilaiPixel=pixel.getGray_Int();

       //men konvert range nilai pixel dari rentang 1-256 menjadi format binary
       // yaitu 1 dan 0
        //Class Im2BW untuk menangani konvert citra gray ke bw
       Im2Bw bw=new Im2Bw();
       int [][]binary=bw.im2bwlogical(nilaiPixel);

       // membuat citra dengan format BW
       BufferedImage BW=createImage.createImageBINARY(binary);

       //update component JButton
       this.setImageButton(jButton1, BW);
       
       //update citra sekarang (current)
       this.BICurrent=BW;

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // class JICreareImage untuk menangani konvert RGB ke gray
       JICreateImage create=new JICreateImage();
       BufferedImage gray=create.createImageRGB2Gray(BIDefault);
       //update component JButton
       Image image=gray;
       this.jButton1.setIcon(new ImageIcon(image));

       //update citra sekarang (Current)
       this.BICurrent=gray;
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         //kotak dialog file browser
        JFileChooser jFileChooser1=new JFileChooser();
        // kotak dialog save
        int cek=jFileChooser1.showSaveDialog(this);
        File file;
        if (cek==JFileChooser.APPROVE_OPTION)
        {
            try {
                //nama file
                file = jFileChooser1.getSelectedFile();
                //mendapatkan citra dari JButton
                ImageIcon icon = (ImageIcon) this.jButton1.getIcon();
                Image image2 = (BufferedImage) icon.getImage();
                //Casting Class  Image kedalam BufferedImage
                BufferedImage BI = (BufferedImage) image2;
                // class JISaveImage untuk menangani save
                JISaveImage save = new JISaveImage();
                save.JISaveImage(BI, file.getAbsolutePath());
                try
                {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException ex)
                {
                    Logger.getLogger(ImageEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(ImageEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void initAll() throws IOException{
        String value=String.valueOf(this.jSlider1.getValue());
        this.jLabel1.setText(value+" %");       
        
    }
    private void setImageButton(JButton button,BufferedImage BI){
        Image image =BI;
        button.setIcon(new ImageIcon(image));
    }
    private void setImageButton(JButton button,Image image){
        
        button.setIcon(new ImageIcon(image));
    }
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ImageEditor().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ImageEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
    BufferedImage BIDefault;
    BufferedImage BICurrent;
    
}
