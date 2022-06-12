package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Diabetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DiabeticDAO {

    @Autowired
    public JdbcTemplate jdbcTemplate;



    public SimpleJdbcInsert simpleJdbcInsert;


    public void delDiab(int idDiab)
    {
        String sql = "DELETE FROM Diabetic WHERE id_diabetic = ?";
        jdbcTemplate.update(sql,idDiab);
    }

    public void addDiab (Diabetic dia)
    {
        String sql="INSERT INTO Diabetic (id_doctor,name,firstname,birthdate,mail," +
                        "password,phone,emergencyContact,address) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,
                    dia.getId_doctor(),dia.getName(),dia.getFirstname(),dia.getBirthdate(),dia.getMail(),dia.getPassword(),
                    dia.getPhone(),dia.getEmergencyContact(),dia.getAddress());
    }


    public Diabetic getDiabById(int id){
        return jdbcTemplate.queryForObject("select * from Diabetic where id_diabetic=?", new DiabeticRowMapper(),id);
    }

    public Diabetic getDiaByMail(String ml){
        return jdbcTemplate.queryForObject("select * from Diabetic where mail=?", new DiabeticRowMapper(),ml);
    }

    public List<Diabetic> getAllDiab(){
        return jdbcTemplate.query("SELECT * FROM Diabetic",new DiabeticRowMapper());
    }

    private final class DiabeticRowMapper implements RowMapper<Diabetic> {
        @Override
        public Diabetic mapRow(ResultSet rs, int rowNum) throws SQLException{
            Diabetic diabetic = new Diabetic();
            diabetic.setId_diabetic(rs.getInt("id_diabetic"));
            diabetic.setId_doctor(rs.getInt("id_doctor"));
            diabetic.setName(rs.getString("name"));
            diabetic.setFirstname(rs.getString("firstname"));
            diabetic.setBirthdate(rs.getDate("birthdate"));
            diabetic.setMail(rs.getString("mail"));
            diabetic.setPassword(rs.getString("password"));
            diabetic.setPhone(rs.getString("phone"));
            diabetic.setEmergencyContact(rs.getString("emergencyContact"));
            diabetic.setAddress(rs.getString("address"));
            return diabetic;
        }

    }
}
