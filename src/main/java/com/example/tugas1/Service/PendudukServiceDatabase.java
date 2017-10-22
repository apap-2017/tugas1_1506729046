package com.example.tugas1.Service;

import com.example.tugas1.DAO.PendudukDAO;
import com.example.tugas1.Model.PendudukModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendudukServiceDatabase implements PendudukService{

    @Autowired
    private PendudukDAO pendudukDAO;

    @Override
    public List<PendudukModel> selectAllPenduduk(){
        return pendudukDAO.selectAllPenduduk();
    }

    @Override
    public PendudukModel selectPenduduk(String nik){
        return pendudukDAO.selectPenduduk(nik);
    }

    @Override
    public List<PendudukModel> selectAnggotaKeluarga(String id){
        return pendudukDAO.selectAnggotaKeluarga(id);
    }

    @Override
    public List<PendudukModel> selectSimilarNIK(String nik){
        return pendudukDAO.selectSimilarNIK(nik + "%");
    }

    @Override
    public void addPenduduk(PendudukModel pendudukModel){
        pendudukDAO.addPenduduk(pendudukModel);
    }

    @Override
    public void updatePenduduk (PendudukModel pendudukModel){
        pendudukDAO.updatePenduduk(pendudukModel);
    }

    @Override
    public void nonaktifkanPenduduk(String nik){
        pendudukDAO.nonaktifkanPenduduk(nik);
    }

    @Override
    public List<PendudukModel> selectPendudukByKelurahan(String id_kelurahan){
        return pendudukDAO.selectPendudukByKelurahan(id_kelurahan);
    }
}
