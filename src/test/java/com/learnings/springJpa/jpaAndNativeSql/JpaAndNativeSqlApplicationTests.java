package com.learnings.springJpa.jpaAndNativeSql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.learnings.springJpa.jpaAndNativeSql.entities.Student;
import com.learnings.springJpa.jpaAndNativeSql.repos.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class JpaAndNativeSqlApplicationTests {
	@Autowired
	StudentRepository repo;

	@Test
	void contextLoads() {
		Student s1 = new Student();
		s1.setFirstName("Arun");
		s1.setLastName("kumar");
		s1.setScore(90);
		Student s2 = new Student();
		s2.setFirstName("Surya");
		s2.setLastName("Prakash");
		s2.setScore(50);
		repo.save(s1);
		repo.save(s2);
	}
	@Test
	void findAllStudents(){
		System.out.println(repo.findAllStudents());
	}
	@Test
	void getAllStudentFirstNameAndLastName() {
		repo.getAllStudentFirstNameAndLastName().forEach(obj->{
			System.out.println(obj[0]+" "+obj[1]);
		});
	}
	@Test
	void findAllStudentsByFirstName() {
		System.out.println(repo.findAllStudentsByFirstName("Arun"));
	}
	@Test
	void findAllStudentsByScoreRange() {
		System.out.println(repo.findAllStudentsByScoreRange(80, 90));
	}

	@Transactional
	@Rollback(false) // Only in test
	@Test
	void deleteStudentByFirstName() {
		repo.deleteStudentByFirstName("Surya");
	}

	@Test
	void findAllStudentByPage() {
		System.out.println(repo.findAllStudentByPage(PageRequest.of(0, 2,Direction.DESC,"id")));
	}
	@Test
	void findAllStudentByNQ() {
		System.out.println(repo.findAllStudentByNQ());
	}
	@Test
	void findAllStudentByFirstNameNQ() {
		System.out.println(repo.findAllStudentByFirstNameNQ("Arun"));
	}
}
