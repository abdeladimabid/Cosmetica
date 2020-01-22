package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Role;

public interface IRoleDao  extends JpaRepository<Role, Integer> {

}
