package com.biz.email.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.mapper.EmailMapper;
import com.biz.email.model.EmailVO;

@Service
public class EmailService {

	@Autowired
	EmailMapper emailMapper;
	
	@Autowired
	ServletContext servletContext;
	
	public List<EmailVO> selectAll(){
		
		return emailMapper.selectAll();
	}
	
	public EmailVO findByID(long id) {
		
		return emailMapper.findByID(id);
	}
	
	public int insert(EmailVO emailVO, MultipartHttpServletRequest request) {
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sd=new SimpleDateFormat("HH:mm:ss");
		Date d=new Date();
		String today = sf.format(d);
		String time = sd.format(d);
		emailVO.setS_date(today);
		emailVO.setS_time(time);
		
		List<MultipartFile> files=request.getFiles("s_files");
		
		String realPath=servletContext.getRealPath("/files/");
		File dir=new File(realPath);
		if(!dir.exists()) dir.mkdir();
		if(files.get(0)!=null) {
			String realName=files.get(0).getOriginalFilename();
			String saveName=UUID.randomUUID().toString()+realName;
			File saveFile=new File(realPath, saveName);
			try {
				files.get(0).transferTo(saveFile);
				emailVO.setS_file1(saveName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(files.get(1)!=null) {
			String realName=files.get(1).getOriginalFilename();
			String saveName=UUID.randomUUID().toString()+realName;
			File saveFile=new File(realPath, saveName);
			try {
				files.get(1).transferTo(saveFile);
				emailVO.setS_file2(saveName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return emailMapper.insert(emailVO);
	}
	
	public int update(EmailVO emailVO) {
		
		
		
		
		
		
		
		
		return emailMapper.update(emailVO);
	}
	
	public int delete(long id) {
		
		return emailMapper.delete(id);
	}
}






















