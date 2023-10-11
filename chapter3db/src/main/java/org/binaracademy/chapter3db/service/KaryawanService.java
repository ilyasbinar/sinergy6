package org.binaracademy.chapter3db.service;

import org.binaracademy.chapter3db.model.DetailKaryawan;
import org.binaracademy.chapter3db.model.Karyawan;
import org.binaracademy.chapter3db.repository.DetailKaryawanRepository;
import org.binaracademy.chapter3db.repository.KaryawanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class KaryawanService {
//    @Autowired
//    KaryawanRepository karyawanRepository;

    private final KaryawanRepository karyawanRepository;
    private final DetailKaryawanRepository detailKaryawanRepository;


    public KaryawanService(KaryawanRepository karyawanRepository, DetailKaryawanRepository detailKaryawanRepository){
        this.karyawanRepository=karyawanRepository;
        this.detailKaryawanRepository = detailKaryawanRepository;
    }



    public Karyawan getById(Long id){
        Optional<Karyawan> karyawanOptional = karyawanRepository.findById(id);
        if(karyawanOptional.isPresent()){
            return karyawanOptional.get();
        }
        throw new RuntimeException();
    }

    public Karyawan create(Karyawan karyawan){
        karyawan.setCreatedDate(LocalDateTime.now());
        return karyawanRepository.save(karyawan);
    }

    public List<Karyawan> getAll() {
        return karyawanRepository.findAll();
    }

    public void deleteAll() {
        karyawanRepository.deleteAll();
    }

    public DetailKaryawan createDetail(DetailKaryawan detailKaryawan) {
        detailKaryawan.setCreatedDate(LocalDateTime.now());
        return detailKaryawanRepository.save(detailKaryawan);
    }
}
