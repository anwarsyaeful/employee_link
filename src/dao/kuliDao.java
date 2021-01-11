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
public class kuliDao {
    public List<absensi> getAll(){
        java.sql.Connection conn = new DBConnection ().connect();
        List<absensi> as = null;
        try{
            as = new ArrayList<>();
            String sql = "SELECT * FROM dt_karyawan";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()){
                absensi a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setBagian(rslt.getString("bagian"));
                a.setNo_hp(rslt.getString("no_hp"));
                a.setAlamat(rslt.getString("alamat"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
    
    public absensi save(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
           String sql = "insert into dt_karyawan(id,nama,bagian,no_hp,alamat) values (?,?,?,?,?)";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getId());
               stmt.setString(2, absen.getNama());
               stmt.setString(3, absen.getBagian());
               stmt.setString(4, absen.getNo_hp());
               stmt.setString(5, absen.getAlamat());
               
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
           String sql = "update dt_karyawan set nama=?,bagian=?,no_hp=?,alamat=? where id=?";
           java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
           try{
               stmt.setString(1, absen.getNama());
               stmt.setString(2, absen.getBagian());
               stmt.setString(3, absen.getNo_hp());
               stmt.setString(4, absen.getAlamat());
               stmt.setString(5, absen.getId());
               
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
           String sql = "select * from dt_karyawan where id='"+a.getId()+"'";
           java.sql.Statement stmt = conn.createStatement();
           java.sql.ResultSet rslt = stmt.executeQuery(sql);
           while (rslt.next()){
                a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setBagian(rslt.getString("bagian"));
                a.setNo_hp(rslt.getString("no_hp"));
                a.setAlamat(rslt.getString("alamat"));
                
           }
        } catch (SQLException ex){
               System.out.println("Error = " + ex);
        } 
        return a;
    }
    
    public absensi delete(absensi absen){
        java.sql.Connection conn = new DBConnection().connect();
        try{
            String sql = "delete from dt_karyawan where id=?";
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
            String sql = "SELECT * FROM dt_karyawan where id like ? OR nama like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + teks + "%");
            stmt.setString(2, "%" + teks + "%");
            java.sql.ResultSet rslt = stmt.executeQuery();
            while (rslt.next()){
                absensi a = new absensi();
                a.setId(rslt.getString("id"));
                a.setNama(rslt.getString("nama"));
                a.setBagian(rslt.getString("bagian"));
                a.setNo_hp(rslt.getString("no_hp"));
                a.setAlamat(rslt.getString("alamat"));
                as.add(a);
            }
        }catch (SQLException ex) {
            System.out.println("Error"+ex);
        }return as;
    }
    
}
