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
public class gajiDao {
    public List<absensi> getAll(){
        java.sql.Connection conn = new DBConnection ().connect();
        List<absensi> as = null;
        try{
            as = new ArrayList<>();
            String sql = "SELECT * FROM dt_gaji";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()){
                absensi a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setBagian(rslt.getString("bagian"));
                a.setGapok(rslt.getInt("gapok"));
                a.setUangMakan(rslt.getInt("uangMakan"));
                a.setMasuk(rslt.getInt("masuk"));
                a.setGajiTerima(rslt.getInt("gajiTerima"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
    
    public absensi save(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
           String sql = "insert into dt_gaji(id,nama,bagian,gapok,uangMakan,masuk,gajiTerima) values (?,?,?,?,?,?,?)";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getId());
               stmt.setString(2, absen.getNama());
               stmt.setString(3, absen.getBagian());
               stmt.setInt(4, absen.getGapok());
               stmt.setInt(5, absen.getUangMakan());
               stmt.setInt(6, absen.getMasuk());
               stmt.setInt(7, absen.getGajiTerima());
               
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
           String sql = "update dt_gaji set nama=?,bagian=?,gapok=?,uangMakan=?,masuk=?,gajiTerima=? where id=?";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               
               stmt.setString(1, absen.getNama());
               stmt.setString(2, absen.getBagian());
               stmt.setInt(3, absen.getGapok());
               stmt.setInt(4, absen.getUangMakan());
               stmt.setInt(5, absen.getMasuk());
               stmt.setInt(6, absen.getGajiTerima());
               stmt.setString(7, absen.getId());
               
               stmt.executeUpdate();
               JOptionPane.showMessageDialog(null, "data berhasil diubah");     
        } catch (SQLException se){
               System.out.println("Error = " + se);
               JOptionPane.showMessageDialog(null, "data gagal diubah");
        } 
        stmt.close();
    }catch (Exception e){
    }
        return absen;
    }
    
    public absensi getID(absensi a){
        java.sql.Connection conn = new DBConnection().connect();
        try{
           String sql = "select * from dt_gaji where id='"+a.getId()+"'";
           java.sql.Statement stmt = conn.createStatement();
           java.sql.ResultSet rslt = stmt.executeQuery(sql);
           while (rslt.next()){
                a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setBagian(rslt.getString("bagian"));
                a.setGapok(rslt.getInt("gapok"));
                a.setUangMakan(rslt.getInt("uangMakan"));
                a.setMasuk(rslt.getInt("masuk"));
                a.setGajiTerima(rslt.getInt("gajiTerima"));
                
           }
        } catch (SQLException ex){
               System.out.println("Error = " + ex);
        } 
        return a;
    }
    
    public absensi delete(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
            String sql = "delete from dt_gaji where id=?";
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
            String sql = "SELECT * FROM dt_gaji where id like ? OR nama like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + teks + "%");
            stmt.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = stmt.executeQuery();
            while (rslt.next()){
                absensi a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setBagian(rslt.getString("bagian"));
                a.setGapok(rslt.getInt("gapok"));
                a.setUangMakan(rslt.getInt("uangMakan"));
                a.setMasuk(rslt.getInt("masuk"));
                a.setGajiTerima(rslt.getInt("gajiTerima"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
     
    
}
