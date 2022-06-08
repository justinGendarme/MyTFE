package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DoctorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Doctor> getAllDoct(){
        return jdbcTemplate.query("SELECT * FROM Doctor",new DoctorDAO.DoctorRowMapper());
    }

    public Doctor getDoctorById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Doctor WHERE id_doctor=?", new DoctorDAO.DoctorRowMapper(),id);
    }

    private final class DoctorRowMapper implements RowMapper<Doctor> {
        @Override
        public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Doctor doc = new Doctor();
            doc.setId_doctor(rs.getInt("id_doctor"));
            doc.setName(rs.getString("name"));
            doc.setPhone(rs.getString("phone"));
            doc.setMail(rs.getString("mail"));
            doc.setAddress(rs.getString("address"));
            doc.setDescription(rs.getString("description"));
            return doc;

        }

    }
}
