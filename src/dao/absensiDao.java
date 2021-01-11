/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
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
public class absensiDao {
    public List<absensi> getAll(){
        java.sql.Connection conn = new DBConnection ().connect();
        List<absensi> as = null;
        try{
            as = new ArrayList<>();
            String sql = "SELECT * FROM dt_absensi";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()){
                absensi a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setTanggal(rslt.getString("tanggal"));
                a.setKeterangan(rslt.getString("keterangan"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
    
    public absensi save(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
           String sql = "insert into dt_absensi(id,nama,tanggal,keterangan) values (?,?,?,?)";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getId());
               stmt.setString(2, absen.getNama());
               stmt.setString(3, absen.getTanggal());
               stmt.setString(4, absen.getKeterangan());
               
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
           String sql = "update dt_absensi set nama=?,tanggal=?,keterangan=? where id=?";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getNama());
               stmt.setString(2, absen.getTanggal());
               stmt.setString(3, absen.getKeterangan());
               stmt.setString(4, absen.getId());
               
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
           String sql = "select * from dt_absensi where id='"+a.getId()+"'";
           java.sql.Statement stmt = conn.createStatement();
           java.sql.ResultSet rslt = stmt.executeQuery(sql);
           while (rslt.next()){
                a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setTanggal(rslt.getString("tanggal"));
                a.setKeterangan(rslt.getString("keterangan"));
                
           }
        } catch (SQLException ex){
               System.out.println("Error = " + ex);
        } 
        return a;
    }
    
    public absensi delete(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
            String sql = "delete from dt_absensi where id=?";
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
            String sql = "SELECT * FROM dt_absensi where id like ? OR nama like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + teks + "%");
            stmt.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = stmt.executeQuery();
            while (rslt.next()){
                absensi a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setTanggal(rslt.getString("tanggal"));
                a.setKeterangan(rslt.getString("keterangan"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
     
    
}
