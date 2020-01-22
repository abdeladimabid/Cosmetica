package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.User;

public interface IUserDao  extends JpaRepository<User, Integer> {

}
