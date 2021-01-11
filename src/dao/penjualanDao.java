/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.DBConnection;
import model.absensi;

/**
 *
 * @author saeful
 */
public class penjualanDao {
    public List<absensi> getAll(){
        java.sql.Connection conn = new DBConnection ().connect();
        List<absensi> as = null;
        try{
            as = new ArrayList<>();
            String sql = "SELECT * FROM dt_penjualan";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()){
                absensi a = new absensi();
                a.setKd_barang(rslt.getString("kd_barang"));
                a.setNama_barang(rslt.getString("nm_barang"));
                a.setQty(rslt.getInt("qty"));
                a.setPenerima(rslt.getString("penerima"));
                a.setTanggal(rslt.getString("tanggal"));
             
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
    
    public absensi save(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
           String sql = "insert into dt_penjualan(kd_barang,nm_barang,qty,penerima,tanggal) values (?,?,?,?,?)";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getKd_barang());
               stmt.setString(2, absen.getNama_barang());
               stmt.setInt(3, absen.getQty());
               stmt.setString(4, absen.getPenerima());
               stmt.setString(5, absen.getTanggal());
               
               stmt.executeUpdate();
               JOptionPane.showMessageDialog(null, "data berhasil disimpan");     
        } catch (SQLException se){
               System.out.println("Error = " + se);
               JOptionPane.showMessageDialog(null, "data gagal disimpan");
        } 
        stmt.close();
    }catch (Exception e){
            System.out.println("Error = " + e);
    }
        return absen;
    }
    
    public absensi update(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
           String sql = "update dt_penjualan set nm_barang=?,qty=?,penerima=?,tanggal=? where kd_barang=?";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getNama_barang());
               stmt.setInt(2, absen.getQty());
               stmt.setString(3, absen.getPenerima());
               stmt.setString(4, absen.getTanggal());
               stmt.setString(5, absen.getKd_barang());
               
               stmt.executeUpdate();
               JOptionPane.showMessageDialog(null, "data berhasil diubah");     
        } catch (SQLException se){
               System.out.println("Error = " + se);
               JOptionPane.showMessageDialog(null, "data gagal diubah");
        } 
        stmt.close();
    }catch (Exception e){
        System.out.println("Error = " + e);
    }
        return absen;
    }
    
    public absensi getID(absensi a){
        java.sql.Connection conn = new DBConnection().connect();
        try{
           String sql = "select * from dt_penjualan where kd_barang='"+a.getKd_barang()+"'";
           java.sql.Statement stmt = conn.createStatement();
           java.sql.ResultSet rslt = stmt.executeQuery(sql);
           while (rslt.next()){
                a = new absensi();
                a.setKd_barang(rslt.getString("kd_barang"));
                a.setNama_barang(rslt.getString("nm_barang"));
                a.setQty(rslt.getInt("qty"));
                a.setPenerima(rslt.getString("penerima"));
                a.setTanggal(rslt.getString("tanggal"));
                
           }
        } catch (SQLException ex){
               System.out.println("Error = " + ex);
        } 
        return a;
    }
    
    public absensi delete(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
            String sql = "delete from dt_penjualan where kd_barang=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            try{
                stmt.setString(1, absen.getKd_barang());
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }catch(SQLException se){
                System.out.println("Error ="+se);
                JOptionPane.showMessageDialog(null, "Data gagal dihapus");
            }
            stmt.close();
        }catch (Exception e){
            System.out.println("Error = " + e);
        }
        return absen;
    }
    
    public List<absensi> searching(String teks){
        java.sql.Connection conn = new DBConnection ().connect();
        List<absensi> as = null;
        try{
            as = new ArrayList<>();
            String sql = "SELECT * FROM dt_penjualan where kd_barang like ? OR nm_barang like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + teks + "%");
            stmt.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = stmt.executeQuery();
            while (rslt.next()){
                absensi a = new absensi();
                a.setKd_barang(rslt.getString("kd_barang"));
                a.setNama_barang(rslt.getString("nm_barang"));
                a.setQty(rslt.getInt("qty"));
                a.setPenerima(rslt.getString("penerima"));
                a.setTanggal(rslt.getString("tanggal"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
     
    
    
    
}
