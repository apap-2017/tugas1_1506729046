package com.example.tugas1.Service;

import com.example.tugas1.DAO.KecamatanDAO;
import com.example.tugas1.Model.Kecamatan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KecamatanServiceDatabase implements KecamatanService {

    @Autowired
    KecamatanDAO kecamatanDAO;

    @Override
    public Kecamatan selectKecamatan(String id){
        return kecamatanDAO.selectKecamatan(id);
    }

    @Override
    public List<Kecamatan> selectAllKecamatan(String kota){
        return kecamatanDAO.selectAllKecamatan(kota);
    }

    @Override
    public List<Kecamatan> selectAllKecamatan(){
        return kecamatanDAO.selectAllKecamatans();
    }
}
