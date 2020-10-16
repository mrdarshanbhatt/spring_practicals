package com.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvc.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	UserModel findByFname(String fname);

	@Query(value = "select * from user where uid=?", nativeQuery = true)
	UserModel findByUid(String uid);

	UserModel deleteByUid(String uid);

	UserModel findByEmail(String email);

}
