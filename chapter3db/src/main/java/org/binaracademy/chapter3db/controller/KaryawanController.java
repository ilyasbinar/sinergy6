package org.binaracademy.chapter3db.controller;

import org.binaracademy.chapter3db.model.DetailKaryawan;
import org.binaracademy.chapter3db.model.Karyawan;
import org.binaracademy.chapter3db.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class KaryawanController {
//    @Autowired
//    KaryawanService karyawanService;

    private final KaryawanService karyawanService;
    @Autowired
    public KaryawanController(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }



    public void initiateData(){
        Karyawan ilyas = new Karyawan("Ilyas", LocalDate.now());
        Karyawan ren = new Karyawan("Ren", LocalDate.now());
        Karyawan nur = new Karyawan("Nur", LocalDate.now());
        Karyawan aulia = new Karyawan("Aulia", LocalDate.now());
        Karyawan hifni = new Karyawan("Hifni", LocalDate.now());
        Karyawan fajar = new Karyawan("Fajar", LocalDate.now());

        List<Karyawan> karyawans = new ArrayList<>();
        karyawans.add(ilyas);
        karyawans.add(ren);
        karyawans.add(nur);
        karyawans.add(aulia);
        karyawans.add(hifni);
        karyawans.add(fajar);

        for(Karyawan karyawan:karyawans){
            add(karyawan);
        }
    }

    public void home(){
        List<Karyawan> karyawans = karyawanService.getAll();
        karyawans.forEach(Karyawan::print);
        show(1L);
    }

    public void add(Karyawan karyawan){
        karyawanService.create(karyawan);
    }

    public void show(Long id){
        Karyawan karyawan = karyawanService.getById(id);
        karyawan.print();
    }

    public void deleteAll() {
        karyawanService.deleteAll();
    }

    public void addDetail(Long karyawanId){
        Karyawan karyawan = karyawanService.getById(karyawanId);
        DetailKaryawan detailKaryawan = new DetailKaryawan("2222","2222");
        detailKaryawan.setKaryawan(karyawan);
        karyawanService.createDetail(detailKaryawan);
    }
}
