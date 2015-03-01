/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LSBMethod.PVD9;
import LSBMethod.PVD4;
import LSBMethod.Standard;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import vigenerecipher.VigenereCipher;

/**
 *
 * @author HP
 */
public class Intfc extends javax.swing.JFrame {

    PVD9 pvd9;
	PVD4 pvd4;
    
    /**
     * Creates new form Intfc
     */
    public Intfc() {
        
//        JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        setContentPane(pane);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        panelForCover = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelForStego = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabelStegoImg = new javax.swing.JLabel();
        PSNRLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Steganografi Citra Digital");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1024, 600));
        setResizable(false);

        jButton4.setText("Browse");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel6.setText("Stego image : ...");

        jLabel7.setText("Kunci :");

        jLabel8.setText("Metode :");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Standard LSB");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("PVD4");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("PVD9");

        jButton5.setText("Ekstrak!");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jLabel9.setText("Pesan hasil ekstraksi :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton7.setText("Save pesan");

        jInternalFrame3.setTitle("Stego Image");
        jInternalFrame3.setVisible(true);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton5)))
                        .addGap(45, 45, 45)
                        .addComponent(jRadioButton6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton7)
                    .addComponent(jInternalFrame3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButton7)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ekstraksi", jPanel3);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setText("Cover image: ...");

        jButton2.setText("Browse");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Browse");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("File pesan: ...");

        jLabel3.setText("Kunci :");

        jLabel4.setText("Metode :");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Standard LSB");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("PVD4");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("PVD9");

        jButton1.setText("Sisipkan!");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Nilai PSNR :");

        jButton6.setText("Save stego image");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelForCoverLayout = new javax.swing.GroupLayout(panelForCover);
        panelForCover.setLayout(panelForCoverLayout);
        panelForCoverLayout.setHorizontalGroup(
            panelForCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForCoverLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        panelForCoverLayout.setVerticalGroup(
            panelForCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForCoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Cover image :");

        jLabel13.setText("Stego image :");

        javax.swing.GroupLayout panelForStegoLayout = new javax.swing.GroupLayout(panelForStego);
        panelForStego.setLayout(panelForStegoLayout);
        panelForStegoLayout.setHorizontalGroup(
            panelForStegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForStegoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(panelForStegoLayout.createSequentialGroup()
                .addComponent(jLabelStegoImg)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelForStegoLayout.setVerticalGroup(
            panelForStegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForStegoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelStegoImg)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton3)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2)))
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PSNRLabel))
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelForStego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(panelForCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(114, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jLabel2))
                    .addComponent(panelForCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(5, 5, 5)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel13))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(PSNRLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addComponent(panelForStego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Penyisipan", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
	
	// get cover image path file
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        JFileChooser fc = new JFileChooser();
        String sb = "";
        String fullPath = "";
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retval = fc.showOpenDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
                    File selectedfile = fc.getSelectedFile();
                    sb += selectedfile.getName();
                    fullPath += selectedfile.getAbsolutePath();
                    Image img;
            try {
                img = ImageIO.read(selectedfile);
                    img = img.getScaledInstance(333, 222, 1);
                    ImageIcon ii = new ImageIcon(img);
                    this.jLabel10.setIcon(ii);
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
                    this.fileImg = fullPath;
                    this.jLabel1.setText("Cover image : "+fullPath);
        }
    }//GEN-LAST:event_jButton2MouseClicked
	
	// get input file path
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        JFileChooser fc = new JFileChooser();
        String sb = "";
        String fullPath = "";
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retval = fc.showOpenDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
                    File selectedfile = fc.getSelectedFile();
                    sb += selectedfile.getName();
                    fullPath += selectedfile.getAbsolutePath();
                    this.jLabel2.setText("File pesan : "+fullPath);
                    this.filePT = fullPath;
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel1MouseClicked
	
	// hide message to cover image
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(buttonGroup1.isSelected(jRadioButton2.getModel())){ // PVD4
			try {
                String filename = jLabel1.getText(); //image
                String infile = jLabel2.getText();	//plainteks
				String key = jTextField1.getText();
                filename = filename.replace("\\", "\\\\").substring(14);
                infile = infile.replace("\\", "\\\\").substring(13);
                pvd4 = new PVD4(filename);
                pvd4.process("hide",key,infile);
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
		} else if(buttonGroup1.isSelected(jRadioButton3.getModel())){
            try {
                String filename = jLabel1.getText();
                String infile = jLabel2.getText();
				String key = jTextField1.getText();
                filename = filename.replace("\\", "\\\\").substring(14);
                infile = infile.replace("\\", "\\\\").substring(13);
                pvd9 = new PVD9(filename,infile,key);
                pvd9.hideMsg();
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            try {
                this.std = new Standard(fileImg, filePT, "", jTextField1.getText());
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
            String fromPtx = "";
            try {

                std.stegonize();
                //bagian ini hanya menampilkan stego image ke form, belum menyimpannya
                stegoImg = std.img.stream;
                InputStream in = new ByteArrayInputStream(std.img.stream);
                Image bImageFromConvert;
                bImageFromConvert = ImageIO.read(in);
                System.out.println("TES 3");
                bImageFromConvert = bImageFromConvert.getScaledInstance(333, 222, 1);
                System.out.println("TES 4");
                ImageIcon ii = new ImageIcon(bImageFromConvert);
                System.out.println("TES 5");
                this.jLabel11.setIcon(ii);
                System.out.println("Selesai!");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked
	
	// save stego image
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
        String nf = "";
        FileFilter ft = new FileNameExtensionFilter("BMP Files", "bmp");
        jf.addChoosableFileFilter(ft);
        int retval = jf.showSaveDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION){
            File savedFile = jf.getSelectedFile();
            nf += savedFile.getAbsolutePath();
            nf += ".bmp";
            if (buttonGroup1.isSelected(jRadioButton2.getModel())){
                try {
                    pvd4.Flush(nf);
                } catch (IOException ex) {
                    Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (buttonGroup1.isSelected(jRadioButton3.getModel())){
                try {
                    pvd9.Flush(nf);
                } catch (IOException ex) {
                    Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                try{
                std.saveStegoImg(nf);
    //                InputStream in = new ByteArrayInputStream(stegoImg);
    //                Image stegoToSave = ImageIO.read(in);
    //                File outputfile = new File(nf);
    //                ImageIO.write((RenderedImage) stegoToSave, "bmp", outputfile);
                } catch (java.io.IOException e){
                    System.out.println("Error saving file.");
                }
                
            }
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        //hanya menampilkan stego image ke window, belum membuat objek Standard
        JFileChooser fc = new JFileChooser();
        String sb = "";
        String fullPath = "";
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retval = fc.showOpenDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
                    File selectedfile = fc.getSelectedFile();
                    sb += selectedfile.getName();
                    fullPath += selectedfile.getAbsolutePath();
                    Image img;
            try {
                img = ImageIO.read(selectedfile);
                    img = img.getScaledInstance(333, 222, 1);
                    ImageIcon ii = new ImageIcon(img);
                    this.jLabel14.setIcon(ii);
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
                    this.fileStg = fullPath;
                    this.jLabel6.setText("Stego image : "+fullPath);
        }
    }//GEN-LAST:event_jButton4MouseClicked
	
	// Extract message from stego image
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        if(buttonGroup2.isSelected(jRadioButton5.getModel())){ // PV4
			try {
                String filename = jLabel6.getText();
                filename = filename.replace("\\", "\\\\").substring(14);
				String key = jTextField1.getText();
                pvd4 = new PVD4(filename);
				pvd4.process("extract",key,"");
                jTextArea1.setText(pvd4.getPlainTeks());
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
		}else if (buttonGroup2.isSelected(jRadioButton6.getModel())){
            try {
                String filename = jLabel6.getText();
                filename = filename.replace("\\", "\\\\").substring(14);
                System.out.println(filename);
				String key = jTextField1.getText();
                pvd9 = new PVD9(filename,"",key);
                jTextArea1.setText(pvd9.extractMsg());
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            try {
                // TODO add your handling code here:
                String ss = "";
    //            Common stego = new Common(fileStg);
    //            stego.writeToByte(fileStg);
                std = new Standard("","",fileStg,"");
                for(int i=400; i<416; i++){
                        ss += std.stimg.getBits(std.stimg.stream[i]).charAt(7);
    //                    System.out.println(stego.getBits(stego.stream[i]));
                }
                //cek string of bit pesan yang dihasilkan, sama tidak dengan string of bit pesan asli?
                System.out.println("value ss: "+ss);
                String hasil_ext = "";
                hasil_ext = std.stimg.bitToText(ss);
                //cek hasil ekstraksi, apakah sama dengan pesan asli?
                System.out.println("value hasil: "+hasil_ext);
    //            String[] sbyte = ss.split( " " );
    //            StringBuilder sb = new StringBuilder();
    //            for ( int i = 0; i < ss.length(); i+=8 ) { 
    //                String ascii = ss.substring(i, i+8);
    //                int temp = Integer.parseInt(ascii,2);
    //                sb.append( (char)temp );
    //                System.out.println((char)temp);
    //            }   
    //            StringBuilder strb = new StringBuilder();
    //            for (int i =0; i<ss.length();i+=8){
    //                strb.append((char)Integer.parseInt(ss.substring(i, i+8), 2));
    //            }
    //           
    //            System.out.println("break "+sb.toString());
    //            this.jTextArea1.setText(sb.toString());
    //            System.out.println("Selesai!");
            } catch (IOException ex) {
                Logger.getLogger(Intfc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    // return array of bits in a certain byte
    public String getBits(byte b){
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
    
    // change a bit in a certain of byte
    public byte changeBit(byte b, int pos, int val){
        if (val==1){
            b = (byte) (b | (1 << (pos-1)));
        }
        if (val==0){
            b = (byte) (b & ~(1 << (pos-1)));
        }
        return b;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Intfc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Intfc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Intfc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intfc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Intfc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PSNRLabel;
    public javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelStegoImg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel panelForCover;
    private javax.swing.JPanel panelForStego;
    // End of variables declaration//GEN-END:variables
    public String fileImg, fileStg;
    public String filePT;
    byte[] stegoImg;
    JScrollPane scrPane = new JScrollPane(jPanel1);
    public Standard std;
}
