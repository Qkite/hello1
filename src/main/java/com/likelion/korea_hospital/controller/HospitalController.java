package com.likelion.korea_hospital.controller;


import com.likelion.korea_hospital.dao.HospitalDao;
import com.likelion.korea_hospital.domain.Hospital;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/korea-hospital-data")
public class HospitalController {

    private final HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }


    // add - postmapping, delete - deletemapping, select문 이용 - findById, getCount는 getmapping

    // body에서 입력을 받아들일 수 있게
    @PostMapping(value = "/add")
    public String add(@RequestBody Hospital hospital){

        // add를 Hospital의 형태로 받으므로 body에 hospital의 variable의 이름을 넣어주어야 한다!!!
        // date를 변환해주어야 하는 문제

        hospitalDao.add(hospital);

        return "ID: " + hospital.getId() + " " + hospital.getHospitalName() + "의 정보가 입력되었습니다.";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable int id){
        Hospital deletedData = hospitalDao.findById(id);
        hospitalDao.deleteById(id);
        return "ID: " + deletedData.getId() + " " + deletedData.getHospitalName() + "의 정보가 삭제되었습니다.";
    }

    @DeleteMapping(value = "/delete-all")
    public String deleteAll(){
        hospitalDao.deleteAll();
        return "모든 데이터가 삭제되었습니다.";
    }


    @GetMapping(value = "/get/{id}")
    public String getDate(@PathVariable int id){
        Hospital findData = hospitalDao.findById(id);
        String status = null;
        if (findData.getBusinessStatus() == 1){
            status = "영업중";
            
        } else if (findData.getBusinessStatus() == 2) {
            status = "휴업";
            
        } else if (findData.getBusinessStatus() == 3) {
            status = "폐업";
            
        } else if (findData.getBusinessStatus() == 4) {
            status = "영업 취소/말소";
        }

        return "ID: " +findData.getId() + " 병원 이름: " + findData.getHospitalName()
                + "\n주소: " + findData.getFullAddress() + ", 도로명주소: " + findData.getRoadNameAddress()
                + "\n의료진수" + findData.getHealthcareProviderCount() + " 병상 수" + findData.getTotalNumberOfBeds() + " 병원 면적" + findData.getRoadNameAddress()
                + "\n 영업 상태" + status;
    }



}
