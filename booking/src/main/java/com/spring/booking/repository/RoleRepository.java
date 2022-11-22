package com.spring.booking.repository;

import com.spring.booking.model.Role;
import com.spring.booking.model.RoleType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleType(RoleType roleType);

}
