package com.example.tugas1.Controller;

import com.example.tugas1.Model.*;
import com.example.tugas1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class KeluargaController {

    @Autowired
    KeluargaService keluargaService;

    @Autowired
    PendudukService pendudukService;

    @Autowired
    KelurahanService kelurahanService;

    @Autowired
    KecamatanService kecamatanService;

    @Autowired
    KotaService kotaService;

    @GetMapping("/keluarga")
    public String inputNKK(@RequestParam(value = "nkk", required = false) String nkk, Model model){

        if(nkk == null){
            model.addAttribute("error", "Tidak ada input NKK.");
            return "view/error";
        }

        KeluargaModel keluarga = keluargaService.selectKeluarga(nkk);

        if(keluarga == null){
            model.addAttribute("error", "NKK tidak ditemukan.");
            return "view/error";
        }

        List<PendudukModel> anggota = pendudukService.selectAnggotaKeluarga(keluarga.getId());
        Kelurahan kelurahan = kelurahanService.selectKelurahan(keluarga.getId_kelurahan());
        Kecamatan kecamatan = kecamatanService.selectKecamatan(kelurahan.getId_kecamatan());
        Kota kota = kotaService.selectKota(kecamatan.getId_kota());

        model.addAttribute("keluarga", keluarga);
        model.addAttribute("anggota", anggota);
        model.addAttribute("kelurahan", kelurahan);
        model.addAttribute("kecamatan", kecamatan);
        model.addAttribute("kota", kota);

        for(int i = 0 ; i < anggota.size(); i++){
            if(anggota.get(i).getIs_wni().equals("1")){
                anggota.get(i).setIs_wni("WNI");
            }
            else{
                anggota.get(i).setIs_wni("WNA");
            }

            if(anggota.get(i).getJenis_kelamin().equals("1")){
                anggota.get(i).setJenis_kelamin("Perempuan");
            }
            else{
                anggota.get(i).setJenis_kelamin("Laki-laki");
            }
        }

        return "view/keluarga";
    }

}
