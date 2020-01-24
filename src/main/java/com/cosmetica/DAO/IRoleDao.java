package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Role;
@Repository
public interface IRoleDao  extends JpaRepository<Role, Integer> {

}
