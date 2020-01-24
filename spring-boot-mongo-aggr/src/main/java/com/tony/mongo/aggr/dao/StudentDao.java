package com.tony.mongo.aggr.dao;


import com.tony.mongo.aggr.domain.Student;

import java.util.List;

/**
 * @author tony
 */
public interface StudentDao {

    /**
     * Insert
     *
     * @param student Student object
     */
    void saveStudent(Student student);

    /**
     * Delete
     *
     * @param id ID
     */
    void removeStudent(Integer id);

    /**
     * Modify
     *
     * @param student Student info
     */
    void updateStudent(Student student);

    /**
     * Query by ID
     *
     * @param id ID
     * @return Query result
     */
    Student findById(Integer id);

    /**
     * Find all
     *
     * @return Result of student List
     */
    List<Student> findAll();

    /**
     * Union table for querying
     *
     * @return Result object
     */
    Object findStudentAndGrade();
}