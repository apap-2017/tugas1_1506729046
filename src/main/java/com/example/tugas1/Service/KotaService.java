package com.example.tugas1.Service;

import com.example.tugas1.Model.Kota;

import java.util.List;

public interface KotaService {
    Kota selectKota(String id);
    List<Kota> selectAllKota();
}

