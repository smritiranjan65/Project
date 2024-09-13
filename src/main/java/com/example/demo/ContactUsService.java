package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {
	
	@Autowired
	ContactUsRepository CuR;
	
	public String SaveContactUs(String name, String email, String message) {
		try {
			ContactUs CuS = new ContactUs();
			
			CuS.setName(name);
			CuS.setEmail(email);
			CuS.setMessage(message);
			CuR.save(CuS);
			return "saved";
		}catch (Exception e) {
			e.printStackTrace();
			return "not saved";
		}
	}
	
	public Iterable <ContactUs> show(){
		return CuR.findAll();
	}

}
