package com.personal.depository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.depository.entity.Nominee;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee, Integer> {
	List<Nominee> findAllByUserId(Integer userId);

}
