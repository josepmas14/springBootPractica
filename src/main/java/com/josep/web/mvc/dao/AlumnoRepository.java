package com.josep.web.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josep.web.mvc.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	

}
