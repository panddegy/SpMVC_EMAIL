package com.biz.email.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.email.model.EmailSQL;
import com.biz.email.model.EmailVO;

public interface EmailMapper {

	@Select(" select * from tbl_emails order by s_date desc, s_time desc ")
	public List<EmailVO> selectAll();
	@Select(" select * from tbl_emails where id=#{id} ")
	public EmailVO findByID(long id);
	@InsertProvider(type=EmailSQL.class, method="insertSQL")
	public int insert(EmailVO emailVO);
	@UpdateProvider(type=EmailSQL.class, method="updateSQL")
	public int update(EmailVO emailVO);
	@Delete(" delete from tbl_emails where id=#{id} ")
	public int delete(long id);
	
}

