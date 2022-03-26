package com.codegym.tiktok.securityPackage.service.impl;


import com.codegym.tiktok.securityPackage.service.IRegistrationService;
import com.codegym.tiktok.securityPackage.service.IUserService;
import com.codegym.tiktok.userPackage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
    @Autowired
    IUserService userService;

    @Override
    public void register(User user) {
        userService.save(user);
    }
}
