package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Periodic_review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class Periodic_reviewDAO {
    private JdbcTemplate jdbcTemplate;

    private final class Periodic_reviewRowMapper implements RowMapper<Periodic_review> {
        @Override
        public Periodic_review mapRow(ResultSet rs, int rowNum) throws SQLException {
            Periodic_review prw = new Periodic_review();
            prw.setId_review(rs.getInt("id_review"));
            prw.setId_diabetic(rs.getInt("id_diabetic"));
            prw.setId_doctor(rs.getInt("id_doctor"));
            prw.setDate(rs.getDate("date"));
            prw.setWeight(rs.getInt("weight"));
            prw.setArterialPressure(rs.getInt("arterialPressure"));
            prw.setCholesterol(rs.getInt("cholesterol"));
            prw.setHdlcholesterol(rs.getInt("hdlcholesterol"));
            prw.setTriglycerides(rs.getInt("triglycerides"));
            prw.setUrea(rs.getInt("urea"));
            prw.setCreatinine(rs.getInt("creatinine"));
            prw.setGlycatedHemoglobin(rs.getInt("glycatedHemoglobin"));
            prw.setProteinuria(rs.getInt("proteinuria"));
            prw.setMicroalbuminuria(rs.getInt("microalbuminuria"));
            prw.setEyeFluangiography(rs.getString("eyeFluangiography"));
            prw.setOther(rs.getString("other"));
            return prw;
        }

    }
}
