package com.ombre.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.ombre.app.entity.Student;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> getSearchedStudents(String theName) {
		
		// get the current session
        Session currentSession = entityManager.unwrap(Session.class);
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theName != null && theName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery = currentSession.createQuery("from Student where lower(firstName) like :theName or lower(lastName) like :theName", Student.class);
            theQuery.setParameter("theName", "%" + theName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery = currentSession.createQuery("from Student", Student.class);            
        }
        
        // execute query and get result list
        List<Student> students = theQuery.getResultList();
                
        // return the results        
        return students;
		
	}

}
