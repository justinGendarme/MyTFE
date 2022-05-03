package com.example.MyTFE.model.DAO;

import com.example.MyTFE.model.Diabetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DiabeticDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("diabetic")
                .usingGeneratedKeyColumns("id_diabetic");
    }

    public Diabetic getDiabById(int id){
        return jdbcTemplate.queryForObject("select * from Diabetic where id_diabetic=?", new DiabeticRowMapper(),id);
    }

    public List<Diabetic> getAllDiab(){
        return jdbcTemplate.query("select * from Diabetic",new DiabeticRowMapper());

    }
    public boolean loggin(String mail, String mdp)
    {
        DiabeticDAO diaDao = new DiabeticDAO();
        List<Diabetic> listDia = diaDao.getAllDiab();
        for (int i = 0; i < listDia.size(); i++)
        {
            if((listDia.get(i).getMail().equals(mail))&&(listDia.get(i).getPassword().equals(mdp)))
            {
                return true;
            }
        }
        return  false;
    }

    private final class DiabeticRowMapper implements RowMapper<Diabetic> {
        @Override
        public Diabetic mapRow(ResultSet rs, int rowNum) throws SQLException{
            Diabetic diabetic = new Diabetic();
            diabetic.setId_diabetic(rs.getInt("id_diabetic"));
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
