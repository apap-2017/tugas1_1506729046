package com.example.tugas1.Service;

import com.example.tugas1.Model.KeluargaModel;

import java.util.List;

public interface KeluargaService {
    List<KeluargaModel> selectAllKeluarga();
    List<KeluargaModel> selectSimilarNKK(String nkk);
    KeluargaModel selectKeluarga(String nkk);
    KeluargaModel selectKeluargaByID(String id);
    void addKeluarga(KeluargaModel keluargaModel);
    void updateKeluarga(KeluargaModel keluargaModel);
}
