package com.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.models.PasswordModel;

@Repository
public interface PassWordRepository extends JpaRepository<PasswordModel, Integer> {

	PasswordModel findByUid(String uid);

}
