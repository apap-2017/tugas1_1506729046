package com.example.tugas1.Service;

import com.example.tugas1.Model.Kelurahan;

import java.util.List;

public interface KelurahanService {

    Kelurahan selectKelurahan(String id);
    List<Kelurahan> selectAllKelurahan(String kecamatan);
    List<Kelurahan> selectAllKelurahan();
}
