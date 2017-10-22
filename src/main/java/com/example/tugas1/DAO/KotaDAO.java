package com.example.tugas1.DAO;

import com.example.tugas1.Model.Kota;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KotaDAO {

    @Select("select * from kota where id = #{id}")
    Kota selectKota(String id);

    @Select("select * from kota")
    List<Kota> selectAllKota();
}
