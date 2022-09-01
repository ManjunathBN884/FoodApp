package com.example.demoProject02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoProject02.dao.AdminDao;
import com.example.demoProject02.dto.Admin;

@Service
public class LoginService {
@Autowired
AdminDao adminDao;


}
