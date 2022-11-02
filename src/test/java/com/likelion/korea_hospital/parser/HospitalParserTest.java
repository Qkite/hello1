package com.likelion.korea_hospital.parser;

import com.likelion.korea_hospital.dao.HospitalDao;
import com.likelion.korea_hospital.domain.Hospital;
import com.likelion.korea_hospital.service.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Spring Boot가 스캔을 해서 등록한 Bean을 Test에서 쓸 수 있게 함
// 테스트파일이 likelion.korea_hospital.parser의 하위에 존재하지 않아서 factory의 클래스를 지정해주어서 사용할 수 있다.
@SpringBootTest
class HospitalParserTest {

    String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
    String line770 = "\"770\",\"의원\",\"01_01_02_P\",\"5710000\",\"PHMA119974360079041100017\",\"19970706\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"295-5001\",\"\",\"362856\",\"충청북도 청주시 서원구 분평동 1202번지 2호\",\"충청북도 청주시 서원구 월평로 69 (분평동)\",\"28792\",\"유림가정의학과의원\",\"20170905183709\",\"I\",\"2018-08-31 23:59:59.0\",\"의원\",\"244003.914471\",\"345700.272648\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",";

    @Autowired // new ReadLineContext()를 하지 않도록 해줌 --> Singleton --> GC가 생성되지 않도록 도와줌
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    HospitalDao hospitalDao;
    // HospitalDao에 @Component라는 annotation이 붙음
    // Spring Boot의 @ComponentScan이 @Component annotation이 달린 클래스를 전부 Bean으로 등록함
    // Factory를 만들어 @Bean을 등록하지 않아도 Autowired 가능하다

    @Autowired
    HospitalService hospitalService;


//    @Test
//    @DisplayName("factory가 잘 돌아가는지 확인하기")
//    void testA() throws IOException {
//
//        List<Hospital> hospitalList= hospitalReadLineContext.readByLine("C:\\Users\\yeonji\\Desktop\\fulldata_01_01_02_P_의원_utf_8.csv");
//        assertTrue(hospitalList.size()>100000);
//    }
//
//    @Test
//    @DisplayName("Hospital이 insert가 잘 되는지")
//    void testB() throws IOException {
//
//        HospitalParser hp = new HospitalParser();
//        Hospital hospital = hp.parse(line1);
//        hospitalDao.add(hospital);
//        assertEquals(hospitalDao.getCount(), 1);
//        assertEquals(hospitalDao.findById(1).getHospitalName(), "효치과의원");
//        assertEquals(hospitalDao.findById(1).getLicenseDate(), LocalDateTime.of(1999, 6, 12, 0, 0, 0));
//    }
//
//    @Test
//    @DisplayName("csv 1줄은 Hospital로 잘 만드는지 TEST")
//    void testC() throws IOException {
//
//
//        HospitalParser hp = new HospitalParser();
//        Hospital hospital = hp.parse(line1);
//
//        assertEquals(1, hospital.getId());
//        assertEquals("의원", hospital.getOpenServiceName());
//        assertEquals(3620000,hospital.getOpenLocalGovernmentCode());
//        assertEquals("PHMA119993620020041100004",hospital.getManagementNumber());
//        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate()); //19990612
//        assertEquals(1, hospital.getBusinessStatus());
//        assertEquals(13, hospital.getBusinessStatusCode());
//        assertEquals("062-515-2875", hospital.getPhone());
//        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress());
//        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());
//        assertEquals("효치과의원", hospital.getHospitalName());
//        assertEquals("치과의원", hospital.getBusinessTypeName());
//        assertEquals(1, hospital.getHealthcareProviderCount());
//        assertEquals(0, hospital.getPatientRoomCount());
//        assertEquals(0, hospital.getTotalNumberOfBeds());
//        assertEquals(52.29f, hospital.getTotalAreaSize());
//    }
//
//    @Test
//    @DisplayName("데이터 베이스에서 데이터가 잘 제거되는지")
//
//    void testD(){
//
//        assertEquals(hospitalDao.getCount(), 0);
//    }
//
//    @Test
//    @DisplayName("10만건 이상이 잘 등록되었는지 확인")
//    void testE() throws IOException {
//        String filename="C:\\Users\\yeonji\\Desktop\\fulldata_01_01_02_P_의원_utf_8.csv";
//        int cnt = this.hospitalService.insertLargeVolumeHospitalData(filename);
//        assertTrue(cnt>1000);
//        assertTrue(cnt > 10000);
//        System.out.printf("파싱된 데이터 개수: %d", cnt);
//    }

}