package com.example.tugas1.Controller;

import com.example.tugas1.Model.*;
import com.example.tugas1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PendudukController {

    @Autowired
    PendudukService pendudukService;


    @Autowired
    KeluargaService keluargaService;

    @Autowired
    KelurahanService kelurahanService;

    @Autowired
    KecamatanService kecamatanService;

    @Autowired
    KotaService kotaService;

    @GetMapping("/penduduk")
    public String inputNIK(@RequestParam(value = "nik", required = false) String nik, Model model){
        if(nik == null){
            model.addAttribute("error", "Tidak ada input NIK.");
            return "view/error";
        }

        PendudukModel pendudukModel = pendudukService.selectPenduduk(nik);
        if(pendudukModel == null){
            model.addAttribute("error", "NIK tidak ditemukan.");
            return "view/error";
        }

        KeluargaModel keluargaModel = keluargaService.selectKeluargaByID(pendudukModel.getId_keluarga());
        Kelurahan kelurahan = kelurahanService.selectKelurahan(keluargaModel.getId_kelurahan());
        Kecamatan kecamatan = kecamatanService.selectKecamatan(kelurahan.getId_kecamatan());
        Kota kota = kotaService.selectKota(kecamatan.getId_kota());

        model.addAttribute("pendudukModel", pendudukModel);
        model.addAttribute("keluargaModel", keluargaModel);
        model.addAttribute("kelurahan", kelurahan);
        model.addAttribute("kecamatan", kecamatan);
        model.addAttribute("kota", kota);

        if(pendudukModel.getJenis_kelamin().equals("1")){
            pendudukModel.setJenis_kelamin("Perempuan");
        } else{
            pendudukModel.setJenis_kelamin("Laki-laki");
        }

        if(pendudukModel.getIs_wni().equals("1")){
            pendudukModel.setIs_wni("WNI");
        }
        else{
            pendudukModel.setIs_wni("WNA");
        }

        if(pendudukModel.getIs_wafat().equals("1")){
            pendudukModel.setIs_wafat("Mati");
        }
        else{
            pendudukModel.setIs_wafat("Hidup");
        }

        return "view/penduduk";
    }
}
