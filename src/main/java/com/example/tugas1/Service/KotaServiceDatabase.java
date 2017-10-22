package com.example.tugas1.Service;

import com.example.tugas1.DAO.KotaDAO;
import com.example.tugas1.Model.Kota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KotaServiceDatabase implements KotaService {

    @Autowired
    KotaDAO kotaDAO;

    @Override
    public Kota selectKota(String id){
        return kotaDAO.selectKota(id);
    }

    @Override
    public List<Kota> selectAllKota(){
        return kotaDAO.selectAllKota();
    }
}
