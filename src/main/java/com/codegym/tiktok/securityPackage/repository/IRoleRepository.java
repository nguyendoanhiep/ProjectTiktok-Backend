package com.codegym.tiktok.securityPackage.repository;


import com.codegym.tiktok.securityPackage.model.Role;
import com.codegym.tiktok.securityPackage.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
