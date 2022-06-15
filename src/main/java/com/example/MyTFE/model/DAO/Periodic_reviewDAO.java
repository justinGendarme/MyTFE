package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Periodic_review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Periodic_reviewDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addReview(Periodic_review pr)
    {
        String sql = "INSERT INTO periodic_review (id_diabetic,id_doctor,date,nexmonth,weight,arterialPressure," +
                "cholesterol,hdlcholesterol,triglycerides,urea,creatinine,glycatedHemoglobin," +
                "proteinuria,microalbuminuria,eyeFluoangiography,other) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,pr.getId_diabetic(),pr.getId_doctor(),pr.getDate(),pr.getNexmonth(),pr.getWeight(),pr.getArterialPressure(),pr.getCholesterol(),
                pr.getHdlcholesterol(),pr.getTriglycerides(),pr.getUrea(),pr.getCreatinine(),pr.getGlycatedHemoglobin(),pr.getProteinuria(),
                pr.getMicroalbuminuria(),pr.getEyeFluoangiography(),pr.getOther());
    }

    public List<Periodic_review> getAllRevFromId(int id)
    {
        return jdbcTemplate.query("SELECT * FROM periodic_review where id_diabetic=?",new Periodic_reviewRowMapper(),id);
    }

    public Periodic_review getRevById(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM periodic_review where id_review=?", new Periodic_reviewRowMapper(),id);
    }

    private final class Periodic_reviewRowMapper implements RowMapper<Periodic_review> {
        @Override
        public Periodic_review mapRow(ResultSet rs, int rowNum) throws SQLException {
            Periodic_review prw = new Periodic_review();
            prw.setId_review(rs.getInt("id_review"));
            prw.setId_diabetic(rs.getInt("id_diabetic"));
            prw.setId_doctor(rs.getInt("id_doctor"));
            prw.setDate(rs.getDate("date"));
            prw.setNexmonth(rs.getString("nexmonth"));
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
            prw.setEyeFluoangiography(rs.getString("eyeFluoangiography"));
            prw.setOther(rs.getString("other"));
            return prw;
        }

    }
}
