package com.biz.email.model;

import org.apache.ibatis.jdbc.SQL;

public class EmailSQL {

	public String insertSQL() {
		
		SQL sql=new SQL().INSERT_INTO("tbl_emails")
				.VALUES("id", "seq_email.nextval")
				.VALUES("from_email", "#{from_email}")
				.VALUES("to_email", "#{to_email}")
				.VALUES("s_date", "#{s_date}")
				.VALUES("s_time", "#{s_time}")
				.VALUES("s_subject", "#{s_subject}")
				.VALUES("s_content", "#{s_content}")
				.VALUES("s_file1", "#{s_file1}")
				.VALUES("s_file2", "#{s_file2}");
		
		return sql.toString();
	}
	
	public String updateSQL() {
		
		SQL sql=new SQL().UPDATE("tbl_emails")
				.SET("from_email=#{from_email}")
				.SET("to_email=#{to_email}")
				.SET("s_date=#{s_date}")
				.SET("s_time=#{s_time}")
				.SET("s_subject=#{s_subject}")
				.SET("s_content=#{s_content}")
				.SET("s_file1=#{s_file2}")
				.SET("s_file2=#{s_file2}")
				.WHERE("id=#{id}");
		
		return sql.toString();
	}
}
