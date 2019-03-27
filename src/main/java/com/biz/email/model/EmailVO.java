package com.biz.email.model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailVO {
		
	private long id;
	private String from_email, to_email;
	private String s_date, s_time;
	private String s_subject;
	private String s_content;
	private String s_file1, s_file2;
	private LinkedList<MultipartFile> s_files;
	
}
