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
public class produksiDao {
    public List<absensi> getAll(){
        java.sql.Connection conn = new DBConnection ().connect();
        List<absensi> as = null;
        try{
            as = new ArrayList<>();
            String sql = "SELECT * FROM dt_produksi";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()){
                absensi a = new absensi();
                a.setId(rslt.getString("id"));
                a.setKd_barang(rslt.getString("kd_barang"));
                a.setNama_barang(rslt.getString("nm_barang"));
                a.setTanggal(rslt.getString("tanggal"));
                a.setStock(rslt.getInt("stock"));
                a.setQty(rslt.getInt("qty"));
                a.setTotal_stock(rslt.getInt("total"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
    
    public absensi save(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
           String sql = "insert into dt_produksi(id,kd_barang,nm_barang,tanggal,stock,qty,total) values (?,?,?,?,?,?,?)";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getId());
               stmt.setString(2, absen.getKd_barang());
               stmt.setString(3, absen.getNama_barang());
               stmt.setString(4, absen.getTanggal());
               stmt.setInt(5, absen.getQty());
               stmt.setInt(6, absen.getStock());
               stmt.setInt(7, absen.getTotal_stock());
               
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
           String sql = "update dt_produksi set kd_barang=?,nm_barang=?,tanggal=?,stock=?,qty=?,total=? where id=?";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getKd_barang());
               stmt.setString(2, absen.getNama_barang());
               stmt.setString(3, absen.getTanggal());
               stmt.setInt(4, absen.getStock());
               stmt.setInt(5, absen.getQty());
               stmt.setInt(6, absen.getTotal_stock());
               stmt.setString(7, absen.getId());
               
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
           String sql = "select * from dt_produksi where id='"+a.getId()+"'";
           java.sql.Statement stmt = conn.createStatement();
           java.sql.ResultSet rslt = stmt.executeQuery(sql);
           while (rslt.next()){
                a = new absensi();
                a.setId(rslt.getString("id"));
                a.setKd_barang(rslt.getString("kd_barang"));
                a.setNama_barang(rslt.getString("nm_barang"));
                a.setTanggal(rslt.getString("tanggal"));
                a.setStock(rslt.getInt("stock"));
                a.setQty(rslt.getInt("qty"));
                a.setTotal_stock(rslt.getInt("total"));
                
           }
        } catch (SQLException ex){
               System.out.println("Error = " + ex);
        } 
        return a;
    }
    
    public absensi delete(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
            String sql = "delete from dt_produksi where id=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            try{
                stmt.setString(1, absen.getId());
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }catch(SQLException se){
                System.out.println("Error ="+se);
                JOptionPane.showMessageDialog(null, "Data gagal dihapus");
            }
            stmt.close();
        }catch (Exception e){
        }
        return absen;
    }
    
    public List<absensi> searching(String teks){
        java.sql.Connection conn = new DBConnection ().connect();
        List<absensi> as = null;
        try{
            as = new ArrayList<>();
            String sql = "SELECT * FROM dt_produksi where id like ? OR kd_barang like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + teks + "%");
            stmt.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = stmt.executeQuery();
            while (rslt.next()){
                absensi a = new absensi();
                a.setId(rslt.getString("id"));
                a.setKd_barang(rslt.getString("kd_barang"));
                a.setNama_barang(rslt.getString("nm_barang"));
                a.setTanggal(rslt.getString("tanggal"));
                a.setStock(rslt.getInt("stock"));
                a.setQty(rslt.getInt("qty"));
                a.setTotal_stock(rslt.getInt("total"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
     
}
