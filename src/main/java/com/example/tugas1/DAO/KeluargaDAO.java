package com.example.tugas1.DAO;

import com.example.tugas1.Model.KeluargaModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KeluargaDAO {

    @Select("select * from keluarga")
    List<KeluargaModel> selectAllKeluarga();

    @Select("select * from keluarga where nomor_kk = #{nkk}")
    KeluargaModel selectKeluarga(@Param("nkk") String nkk);

    @Select("select * from keluarga where id = #{id}")
    KeluargaModel selectKeluargaByID(@Param("id") String id);

    @Select("select * from keluarga where nomor_kk LIKE #{nkk}")
    List<KeluargaModel> selectSimilarNKK(@Param("nkk") String nkk);

    @Insert("insert into keluargaModel (nomor_kk, alamat, rt, rw, id_kelurahan, is_tidak_berlaku) values (#{nomor_kk}, #{alamat}, #{rt}, #{rw}, #{id_kelurahan}, #{is_tidak_berlaku})")
    void addKeluarga(KeluargaModel keluargaModel);

    @Update("update keluargaModel set nomor_kk = #{nomor_kk}, alamat = #{alamat}, rt = #{rt}, rw = #{rw}, id_kelurahan = #{id_kelurahan}, is_tidak_berlaku = #{is_tidak_berlaku} where id = #{id}")
    void updateKeluarga(KeluargaModel keluargaModel);
}
