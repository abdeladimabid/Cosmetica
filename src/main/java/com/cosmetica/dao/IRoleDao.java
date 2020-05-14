package com.cosmetica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Role;
@Repository
public interface IRoleDao  extends JpaRepository<Role, Integer> {

}
