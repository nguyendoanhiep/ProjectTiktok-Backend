package com.codegym.tiktok.securityPackage.service.impl;


import com.codegym.tiktok.securityPackage.model.Role;
import com.codegym.tiktok.securityPackage.model.RoleName;
import com.codegym.tiktok.securityPackage.repository.IRoleRepository;
import com.codegym.tiktok.securityPackage.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
