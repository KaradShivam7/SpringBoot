package com.file.fileupload.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.fileupload.Repository.Student_repo;

@RestController
public class Student_controller {
	
	@Autowired
	private Student_repo repo;
	
	
	@PostMapping("/upload")
	public String uploadfile(@RequestPart MultipartFile file[]) throws IllegalStateException, IOException {
		
		StringBuffer names =new StringBuffer();
		for(MultipartFile s:file) {
			names.append(s.getOriginalFilename()).append("\n");
			String path="F:\\uploads";
			File file1=new File(path+"/"+s.getOriginalFilename());
			//file1.createNewFile();
			s.transferTo(file1);
		}
		return names   + " file uploaded successfully!!!";
	}
	
	
	@PostMapping("/upl")
	public ResponseEntity<String> upload2(@RequestPart MultipartFile file2) throws IllegalStateException, IOException {
		String path="F:\\uploads";
		File file1=new File(path+"/"+file2.getOriginalFilename());
		if(file1.exists()) {
		 throw new FileAlreadyExistsException("File Already Exist!!!");
		}
		else {
		//file1.createNewFile();
		file2.transferTo(file1);
		}
		return new ResponseEntity<String>(file2.getOriginalFilename()+ " file uploaded successfully!!!",HttpStatus.CREATED);
	}
}
