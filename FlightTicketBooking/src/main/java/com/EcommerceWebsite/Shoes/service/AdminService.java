package com.EcommerceWebsite.Shoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceWebsite.Shoes.bean.Admin;
import com.EcommerceWebsite.Shoes.repository.AdminRepository;
import com.EcommerceWebsite.Shoes.util.JsonResponseUtil;

import java.util.List;
import java.util.Map;

@Service
public class AdminService {
	@Autowired
	public AdminRepository adminRepo;

	public Map<String, Object> updateAdmin(Admin admin) {
		adminRepo.save(admin);
		return JsonResponseUtil.createJsonResponse("Data Updates", 200, "");
		
	}
	
	public Map<String, Object> validateAdmin(String username, String password) {
		List<Admin> admin = adminRepo.getAdminByUserNameAndPassword(username, password);
		String msg = "Validation Failed";
		int status_code = 401;
		if (admin.size() > 0){
			msg = "Admin Validated";
			status_code = 200;
		}
		return JsonResponseUtil.createJsonResponse(msg, status_code, admin);
	}
	
}
