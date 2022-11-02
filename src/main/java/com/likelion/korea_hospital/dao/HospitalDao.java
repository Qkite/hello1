package com.likelion.korea_hospital.dao;

import com.likelion.korea_hospital.domain.Hospital;
import com.likelion.korea_hospital.parser.HospitalParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class HospitalDao {

    // @Autowired를 쓰는 것보다 요즘에는 private final을 쓰는 것을 선호
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // List<Hospital>에 있는 데이터가 loop을 돌면서 Hospital db로 들어감
    public void add(Hospital hospital){
        String sql = "INSERT INTO `likelion-db`.`nation_wide_hospitals` " +
                "(`id`, `open_service_name`, `open_local_government_code`, `management_number`, `license_date`, `business_status`, `business_status_code`, `phone`, `full_address`, `road_name_address`, `hospital_name`, `business_type_name`, `healthcare_provider_count`, `patient_room_count`, `total_number_of_beds`, `total_area_size`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql, hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(),hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(), hospital.getBusinessStatusCode(),
                hospital.getPhone(), hospital.getFullAddress(), hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName(), hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getTotalAreaSize());

    }

    public int getCount(){
        String sql = "select count(id) from nation_wide_hospitals";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);

    }

    public void deleteAll(){
        String sql = "delete from nation_wide_hospitals";
        this.jdbcTemplate.update(sql);
    }

    public void deleteById(int id){
        String sql = "delete from nation_wide_hospitals where id = ?";
        this.jdbcTemplate.update(sql, id);
    }


    public Hospital findById(int id){
        RowMapper<Hospital> rowMapper = (rs, rowNum) -> {
            Hospital hospital = new Hospital();
            hospital.setId(rs.getInt("id"));
            hospital.setHospitalName(rs.getString("hospital_name"));
            hospital.setTotalAreaSize(rs.getFloat("total_area_size"));
            hospital.setOpenServiceName(rs.getString("open_service_name"));
            hospital.setOpenLocalGovernmentCode(rs.getInt("open_local_government_code"));
            hospital.setManagementNumber(rs.getString("management_number"));
            hospital.setLicenseDate(rs.getDate("license_date").toLocalDate().atTime(0,0,0));
            hospital.setBusinessStatus(rs.getInt("business_status"));
            hospital.setBusinessStatusCode(rs.getInt("business_status_code"));
            hospital.setPhone(rs.getString("phone"));
            hospital.setFullAddress(rs.getString("full_address"));
            hospital.setRoadNameAddress(rs.getString("road_name_address"));
            hospital.setBusinessTypeName(rs.getString("business_type_name"));
            hospital.setHealthcareProviderCount(rs.getInt("healthcare_provider_count"));
            hospital.setPatientRoomCount(rs.getInt("patient_room_count"));
            hospital.setTotalNumberOfBeds(rs.getInt("total_number_of_beds"));

            return hospital;
        };
        return this.jdbcTemplate.queryForObject("select * from nation_wide_hospitals where id = ?", rowMapper,id);

    }
}
