package com.learnings.springJpa.jpaAndNativeSql.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learnings.springJpa.jpaAndNativeSql.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	
	@Query("from Student")
	List<Student> findAllStudents();
	
	@Query("select firstName,lastName from Student")
	List<Object[]> getAllStudentFirstNameAndLastName();
	
	@Query("from Student where firstName=:firstNam")
	List<Student> findAllStudentsByFirstName(@Param("firstNam") String firstName);
	
	@Query("from Student where score>=:min and score<=:max")
	List<Student> findAllStudentsByScoreRange(@Param("min") int min,@Param("max") int max);
	
	@Modifying
	@Query("Delete from Student where firstName=:firstName")
	void deleteStudentByFirstName(@Param("firstName")String firstName);
	
	@Query("from Student")
	List<Student> findAllStudentByPage(Pageable pageable);
	
	@Query(value="select * from student",nativeQuery=true)
	List<Student> findAllStudentByNQ();
	
	@Query(value="select * from student where fname=:firstName",nativeQuery=true)
	List<Student> findAllStudentByFirstNameNQ(@Param("firstName")String firstName);
	
} 
