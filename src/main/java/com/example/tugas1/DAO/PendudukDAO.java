package com.example.tugas1.DAO;

import com.example.tugas1.Model.PendudukModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PendudukDAO{

    @Select("select * from penduduk")
    List<PendudukModel> selectAllPenduduk();

    @Select("select * from penduduk where nik = #{nik}")
    PendudukModel selectPenduduk(@Param("nik") String nik);

    @Select("select * from penduduk where nik LIKE #{nik}")
    List<PendudukModel> selectSimilarNIK(@Param("nik") String nik);

    @Select("select * from penduduk where id_keluarga = #{id}")
    List<PendudukModel> selectAnggotaKeluarga(@Param("id") String id);

    @Insert("insert into pendudukModel ( nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat) values ( #{nik}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}, #{jenis_kelamin}, #{is_wni}, #{id_keluarga}, #{agama}, #{pekerjaan}, #{status_perkawinan}, #{status_dalam_keluarga}, #{golongan_darah}, #{is_wafat})")
    void addPenduduk(PendudukModel pendudukModel);

    @Update("update penduduk set is_wafat = 1 where nik = #{nik}")
    void nonaktifkanPenduduk(String nik);

    @Update("update pendudukModel set nik = #{nik}, nama = #{nama}, tempat_lahir = #{tempat_lahir}, tanggal_lahir = #{tanggal_lahir}, jenis_kelamin = #{jenis_kelamin}, is_wni = #{is_wni}, id_keluarga = #{id_keluarga}, agama = #{agama}, pekerjaan = #{pekerjaan}, status_perkawinan = #{status_perkawinan}, status_dalam_keluarga = #{status_dalam_keluarga}, golongan_darah = #{golongan_darah}, is_wafat = #{is_wafat} where id = #{id}")
    void updatePenduduk(PendudukModel pendudukModel);

    @Select("select * from penduduk p, keluarga k where p.id_keluarga = k.id and id_kelurahan = #{id_kelurahan}")
    List<PendudukModel> selectPendudukByKelurahan(String id_kelurahan);
}
