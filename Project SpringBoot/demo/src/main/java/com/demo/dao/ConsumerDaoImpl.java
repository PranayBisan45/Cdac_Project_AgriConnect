package com.demo.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.demo.model.Consumer;

@Repository
public class ConsumerDaoImpl implements ConsumerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	Consumer c = new Consumer();

	@Override
	public void regis(String fIRSTNAME, String lASTNAME, String eMAILID, String aDDRESS, String pINCODE, String sTATE,
			String gENDER, String WhatsApp_Number, String uSER_PASSWORD) {
		// TODO Auto-generated method stub
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("Generate_custom_user_id_CO")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("FIRSTNAME", Types.VARCHAR),
                        new SqlParameter("LASTNAME", Types.VARCHAR),
                        new SqlParameter("EMAILID", Types.VARCHAR),
                        new SqlParameter("ADDRESS", Types.LONGVARCHAR),
                        new SqlParameter("PINCODE", Types.VARCHAR),
                        new SqlParameter("STATE", Types.VARCHAR),
                        new SqlParameter("GENDER", Types.VARCHAR),
                        new SqlParameter("WhatsApp_Number", Types.VARCHAR),
                        new SqlParameter("USER_PASSWORD", Types.VARCHAR));

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("FIRSTNAME", fIRSTNAME);
        inParams.put("LASTNAME", lASTNAME);
        inParams.put("EMAILID", eMAILID);
        inParams.put("ADDRESS", aDDRESS);
        inParams.put("PINCODE", pINCODE);
        inParams.put("STATE", sTATE);
        inParams.put("GENDER", gENDER);
        inParams.put("WhatsApp_Number", WhatsApp_Number);
        inParams.put("USER_PASSWORD", uSER_PASSWORD);

        simpleJdbcCall.execute(inParams);
	}
}