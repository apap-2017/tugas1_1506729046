package com.example.tugas1.Service;

import com.example.tugas1.Model.PendudukModel;

import java.util.List;

public interface PendudukService {

    List<PendudukModel> selectAllPenduduk();
    List<PendudukModel> selectAnggotaKeluarga(String id);
    List<PendudukModel> selectSimilarNIK(String nik);
    PendudukModel selectPenduduk(String nik);
    void addPenduduk(PendudukModel pendudukModel);
    void updatePenduduk(PendudukModel pendudukModel);
    void nonaktifkanPenduduk(String nik);
    List<PendudukModel> selectPendudukByKelurahan(String id_kelurahan);
}
