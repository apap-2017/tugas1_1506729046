package com.example.tugas1.DAO;

import com.example.tugas1.Model.Kelurahan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KelurahanDAO {

    @Select("select * from kelurahan where id = #{id}")
    Kelurahan selectKelurahan(String id);

    @Select("select * from kelurahan where id_kecamatan = #{kecamatan}")
    List<Kelurahan> selectAllKelurahan(String kecamatan);

    @Select("select * from kelurahan")
    List<Kelurahan> selectAllKelurahans();
}
