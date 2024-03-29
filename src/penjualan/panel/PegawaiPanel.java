/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package penjualan.panel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import penjualan.entity.PegawaiEntity;
import penjualan.implement.PegawaiImplement;
import penjualan.interfc.PegawaiInterface;

/**
 *
 * @author fadildesk
 */
public class PegawaiPanel extends javax.swing.JPanel {
 List<PegawaiEntity> record = new ArrayList<PegawaiEntity>();
    PegawaiInterface plgServis;
    int row;
    String jenisKelamin = "";

    /**
     * Creates new form PegawaiView
     */
    public PegawaiPanel() {
        initComponents();

        plgServis = new PegawaiImplement();
        tablePegawai.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = tablePegawai.getSelectedRow();
                if (row != -1) {
                    isiText();
                    simpanButton.setEnabled(false);
                    txt_idPegawai.setEnabled(false);
                }
            }
        });
        this.statusAwal();
    }

    void statusAwal() {
        kosongkanText();
        loadData();
        isiTabel();
    }

    void kosongkanText() {
        this.txt_idPegawai.setText("");
        this.txt_namaPegawai.setText("");
        this.txt_alamat.setText("");
        this.txt_noTelepon.setText("");
        rBtn_LK.setSelected(false);
        rBtn_PR.setSelected(false);
        jenisKelamin = "";
    }

    void loadData() {
        try {
            record = plgServis.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiPanel.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    void isiTabel() {
        Object data[][] = new Object[record.size()][5];
        int x = 0;

        for (PegawaiEntity brg : record) {
            data[x][0] = brg.getIdPegawai();
            data[x][1] = brg.getNama();
            data[x][2] = brg.getJenisKelamin();
            data[x][3] = brg.getAlamat();
            data[x][4] = brg.getNoTelp();
            x++;
        }
        String judul[] = {"id_pelanggan", "nama_pelanggan", "jenis_kelamin",
            "alamat", "no_telepon"};
        tablePegawai.setModel(new DefaultTableModel(data, judul));
//        jScrollPane2.setViewportView(tablePegawai);
    }

    void isiText() {
        PegawaiEntity plg = record.get(row);
        this.txt_idPegawai.setText(plg.getIdPegawai());
        this.txt_namaPegawai.setText(plg.getNama());
        this.txt_alamat.setText(plg.getAlamat());
        this.txt_noTelepon.setText(plg.getNoTelp());
        if (plg.getJenisKelamin().equals("L")) {
            rBtn_LK.setSelected(true);
        }
        if (plg.getJenisKelamin().equals("P")) {
            rBtn_PR.setSelected(true);
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

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePegawai = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        simpanButton = new javax.swing.JButton();
        ubahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_noTelepon = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        rBtn_LK = new javax.swing.JRadioButton();
        rBtn_PR = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txt_namaPegawai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_idPegawai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        tablePegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jumlah", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePegawai);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(200, 139));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        jPanel5.add(simpanButton, new java.awt.GridBagConstraints());

        ubahButton.setText("Ubah");
        ubahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahButtonActionPerformed(evt);
            }
        });
        jPanel5.add(ubahButton, new java.awt.GridBagConstraints());

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });
        jPanel5.add(hapusButton, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel5, new java.awt.GridBagConstraints());

        jLabel6.setText("No Tlp");

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane3.setViewportView(txt_alamat);

        jLabel7.setText("Alamat");

        rBtn_LK.setText("Laki - Laki");
        rBtn_LK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn_LKActionPerformed(evt);
            }
        });

        rBtn_PR.setText("Perempuan");

        jLabel8.setText("Jenis Kelamin");

        jLabel9.setText("Nama");

        jLabel10.setText("ID Pelanggan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(rBtn_LK)
                            .addGap(37, 37, 37)
                            .addComponent(rBtn_PR))
                        .addComponent(jScrollPane3)
                        .addComponent(txt_namaPegawai)
                        .addComponent(txt_idPegawai))
                    .addComponent(txt_noTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_idPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_namaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rBtn_LK)
                    .addComponent(rBtn_PR))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_noTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Transaksi Penjualan");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Pegawai");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(229, 229, 229))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(195, 195, 195)
                    .addComponent(jLabel11)
                    .addContainerGap(195, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(24, 24, 24)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(257, 257, 257)
                    .addComponent(jLabel11)
                    .addContainerGap(257, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        try {
            PegawaiEntity pelanggan = new PegawaiEntity();
            pelanggan.setIdPegawai(txt_idPegawai.getText());
            pelanggan.setNama(txt_namaPegawai.getText());
            if (rBtn_LK.isSelected()) {
                jenisKelamin = "L";
            }
            if (rBtn_PR.isSelected()) {
                jenisKelamin = "P";
            }
            pelanggan.setJenisKelamin(jenisKelamin);
            pelanggan.setAlamat(txt_alamat.getText());
            pelanggan.setNoTelp(txt_noTelepon.getText());
            plgServis.insert(pelanggan);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
        } catch (Exception e) {
            Logger.getLogger(PegawaiEntity.class.getName()).log(Level.SEVERE,
                null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void ubahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahButtonActionPerformed
        try {
            PegawaiEntity pelanggan = new PegawaiEntity();
            pelanggan.setIdPegawai(txt_idPegawai.getText());
            pelanggan.setNama(txt_namaPegawai.getText());
            if (rBtn_LK.isSelected()) {
                jenisKelamin = "L";
            }
            if (rBtn_PR.isSelected()) {
                jenisKelamin = "P";
            }
            pelanggan.setJenisKelamin(jenisKelamin);
            pelanggan.setAlamat(txt_alamat.getText());
            pelanggan.setNoTelp(txt_noTelepon.getText());
            plgServis.update(pelanggan);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data berhasil diubah");
        } catch (Exception e) {
            Logger.getLogger(PegawaiEntity.class.getName()).log(Level.SEVERE,
                null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_ubahButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        PegawaiEntity pelanggan = new PegawaiEntity();
        String idPegawai = txt_idPegawai.getText();
        try {
            plgServis.delete(idPegawai);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } catch (Exception e) {
            Logger.getLogger(PegawaiEntity.class.getName()).log(Level.SEVERE,
                null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void rBtn_LKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn_LKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtn_LKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rBtn_LK;
    private javax.swing.JRadioButton rBtn_PR;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTable tablePegawai;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_idPegawai;
    private javax.swing.JTextField txt_namaPegawai;
    private javax.swing.JTextField txt_noTelepon;
    private javax.swing.JButton ubahButton;
    // End of variables declaration//GEN-END:variables
}
