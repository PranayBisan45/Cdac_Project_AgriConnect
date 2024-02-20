package com.demo.Dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDetailsDaoImpl implements TransactionDetailsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unused")
	@Override
	public boolean Transaction(String uid, String eMAIL, long cNO, int cVV, String cNAME, String eXP_DATE, double aMOUNT) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("Generate_and_insert_TID_Tdetails");
		
		simpleJdbcCall.declareParameters(
                new SqlParameter("UID", Types.VARCHAR),
                new SqlParameter("EMAIL", Types.VARCHAR),
                new SqlParameter("CNO", Types.BIGINT),
                new SqlParameter("CVV", Types.INTEGER),
                new SqlParameter("CNAME", Types.VARCHAR),
                new SqlParameter("EXP_DATE", Types.VARCHAR),
                new SqlParameter("AMOUNT", Types.DOUBLE)
        ).withoutProcedureColumnMetaDataAccess();
		
		 Map<String, Object> hm = new HashMap<>();
         hm.put("UID", uid);
         hm.put("EMAIL", eMAIL);
         hm.put("CNO", cNO);
         hm.put("CVV", cVV);
         hm.put("CNAME", cNAME);
         hm.put("EXP_DATE", eXP_DATE);
         hm.put("AMOUNT", aMOUNT);
         
         Map<String, Object> result = simpleJdbcCall.execute(hm);
         return (hm != null) ? true : false;
	}
}
 