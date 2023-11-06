package com.SpringJPA.springdatajpa.repository;

import com.SpringJPA.springdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
@Repository
public interface StudentRepository extends JpaRepository<Student ,Long>{
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    //public List<Student> findByFirstNameNotNull(String name);
    public List<Student> findByGuardianName(String guardianName);

    // JPQL we have to use the name of the Class
    @Query("Select s from Student s where s.email = ?1")
    public Student getStudentByEmailAddress(String emailId);

    @Query("Select s.firstName from Student s where s.email = ?1")
    public String getFirstNameByEmailAddress(String emailId);

    // Here we use actual table and column name for native queries
    @Query(
            value = "Select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    public String getFirstNameByEmailAddressNative( @Param("emailId") String emailId);

    @Modifying
    @Transactional // For the transaction operation when all the operations are important and if one got errored everything is rolle back
    @Query(
            value = "update tbl_student set first_name = :firstName where email_address = :emailId",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId( @Param("firstName") String firstName , @Param("emailId") String emailId);


}
