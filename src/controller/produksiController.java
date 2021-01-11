/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.produksiDao;
import java.util.List;
import model.absensi;

/**
 *
 * @author saeful
 */
public class produksiController {
    private produksiDao absensidao = new produksiDao();
    
    public List<absensi> getAll(){
        return absensidao.getAll();
    }
    
    public absensi save(absensi absen){
        return absensidao.save(absen);
    }
    
    public absensi getID(absensi a){
        return absensidao.getID(a);
    }
    
    public absensi update(absensi absen){
        return absensidao.update(absen);
    }
    
    public absensi delete(absensi absen){
        return absensidao.delete(absen);
    }
    
    public List<absensi> searching(String teks){
        return absensidao.searching(teks);
    }
    
    
}
