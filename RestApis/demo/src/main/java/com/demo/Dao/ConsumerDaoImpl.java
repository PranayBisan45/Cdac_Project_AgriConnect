package com.demo.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ConsumerDaoImpl implements ConsumerDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall jdbcCall;

    @Autowired
    public ConsumerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("Generate_custom_user_id_CO");
    }

    @Transactional
    public boolean uploadData(String firstname, String lastname, String EmailId, String address, String pincode, String state,
                              String gender, String whatsApp_Number, String userPassword) {
        try {
            
            Map<String, Object> inParams = new HashMap<>();
            inParams.put("firstname", firstname);
            inParams.put("lastname", lastname);
            inParams.put("EmailId", EmailId);
            inParams.put("address", address);
            inParams.put("pincode", pincode);
            inParams.put("state", state);
            inParams.put("gender", gender);
            inParams.put("whatsApp_Number", whatsApp_Number);
            inParams.put("user_Password", userPassword);
            

            jdbcCall.declareParameters(
                    new SqlParameter("firstname", Types.VARCHAR),
                    new SqlParameter("lastname", Types.VARCHAR),
                    new SqlParameter("EmailId", Types.VARCHAR),
                    new SqlParameter("address", Types.VARCHAR),
                    new SqlParameter("pincode", Types.VARCHAR),
                    new SqlParameter("state", Types.VARCHAR),
                    new SqlParameter("gender", Types.VARCHAR),
                    new SqlParameter("whatsApp_Number", Types.VARCHAR),
                    new SqlParameter("user_Password", Types.VARCHAR));

            jdbcCall.execute(inParams);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

