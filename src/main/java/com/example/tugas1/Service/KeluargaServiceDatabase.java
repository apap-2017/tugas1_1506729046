package com.example.tugas1.Service;

import com.example.tugas1.DAO.KeluargaDAO;
import com.example.tugas1.Model.KeluargaModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class KeluargaServiceDatabase implements KeluargaService {

    @Autowired
    private KeluargaDAO keluargaDAO;

    @Override
    public List<KeluargaModel> selectAllKeluarga ()
    {
        return keluargaDAO.selectAllKeluarga();
    }

    @Override
    public KeluargaModel selectKeluargaByID(String id){
        return keluargaDAO.selectKeluargaByID(id);
    }

    @Override
    public KeluargaModel selectKeluarga(String nkk){
        return keluargaDAO.selectKeluarga(nkk);
    }

    @Override
    public List<KeluargaModel> selectSimilarNKK(String nkk) {
        return keluargaDAO.selectSimilarNKK(nkk);
    }

    @Override
    public void addKeluarga(KeluargaModel keluargaModel){
        keluargaDAO.addKeluarga(keluargaModel);
    }

    @Override
    public void updateKeluarga(KeluargaModel keluargaModel){
        keluargaDAO.updateKeluarga(keluargaModel);
    }
}
