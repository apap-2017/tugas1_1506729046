package com.example.tugas1.Service;

import com.example.tugas1.DAO.KecamatanDAO;
import com.example.tugas1.Model.Kecamatan;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface KecamatanService {

    Kecamatan selectKecamatan(String id);
    List<Kecamatan> selectAllKecamatan(String kota);
    List<Kecamatan> selectAllKecamatan();
}
