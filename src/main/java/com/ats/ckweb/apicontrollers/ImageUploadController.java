package com.ats.ckweb.apicontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ats.ckweb.model.ImageUploadResponse;
import com.ats.ckweb.model.Info;
import com.ats.ckweb.repository.CustomerRepo;

@Controller
public class ImageUploadController {
	
	//@Value("${PROFILE_IMAGE_UPLOAD_URL}")
	//private String PROFILE_PIC_URL;

	private static String PROFILE_PIC_URL = "C://Users/MAXADMIN/Desktop/Report/";
	//private static String PROFILE_PIC_URL = "/opt/apache-tomcat-8.5.49/webapps/uploads/profile/";
	
	@Autowired CustomerRepo customerRepo;

	@RequestMapping(value = { "/uploadProfilePic" }, method = RequestMethod.POST)
	public @ResponseBody ImageUploadResponse uploadProfilePic(@RequestParam("file") MultipartFile uploadfile,@RequestParam("custId") int custId) {

		ImageUploadResponse res=new ImageUploadResponse();
		Info info = new Info();

		System.out.println("File Name " + uploadfile.getOriginalFilename());
		String fileName ="";
		
		try {

			Calendar cal = Calendar.getInstance();

			Random random = new Random();
			int randomInt = random.nextInt(100);

			String ext = uploadfile.getOriginalFilename().split("\\.")[1];
			fileName = cal.getTimeInMillis() + "_" + randomInt + "." + ext;

			saveUploadedFile(uploadfile, fileName);
			
			int update=customerRepo.updateProfilePic(custId, fileName);
			if(update>0) {
				res.setFileName(fileName);
				info.setError(false);
				info.setMessage("File uploaded successfully");
			}else{
				info.setError(true);
				info.setMessage("File upload failed");
			}

		} catch (IOException e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("File upload failed");
		}
		
		
		res.setInfo(info);

		return res;
	}

	// save file
	private void saveUploadedFile(MultipartFile file, String imageName) throws IOException {

		try {

			Path path = null;

			path = Paths.get(PROFILE_PIC_URL + imageName);

			byte[] bytes = file.getBytes();

			Files.write(path, bytes);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
