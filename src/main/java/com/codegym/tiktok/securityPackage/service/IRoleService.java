package com.codegym.tiktok.securityPackage.service;
import com.codegym.tiktok.securityPackage.model.Role;
import com.codegym.tiktok.securityPackage.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
