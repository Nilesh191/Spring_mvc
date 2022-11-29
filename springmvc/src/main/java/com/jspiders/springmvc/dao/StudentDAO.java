package com.jspiders.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.dto.StudentDTO;

@Repository
public class StudentDAO implements StudentDAOInterface{
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("student");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		entityManagerFactory.close();
		entityManager.close();
		try {
			entityTransaction.rollback();
		} catch (TransactionException e) {
			System.out.println("transaction cannot be rollbacked");
		}
	}
	public void addStudent(String name,String email,String userName,String password,String standard)
	{
		openConnection();
		entityTransaction.begin();
		StudentDTO student=new StudentDTO();
		student.setName(name);
		student.setEmail(email);
		student.setUserName(userName);
	    student.setPassword(password);
	    student.setStandard(standard);
		entityManager.persist(student);
		entityTransaction.commit();
		closeConnection();
	}
	@Override
	public void adStudent(String name, String email, String userName, String password) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public StudentDTO login(String userName, String password) {
		openConnection();

		entityTransaction.begin();

		String jpql = "from StudentDTO where userName = '" + userName + "' and password = '" + password + "'";

		Query query = entityManager.createQuery(jpql);
		try {
			StudentDTO student = (StudentDTO) query.getSingleResult();
			if (student != null) {
				closeConnection();
				return student;
			}
			closeConnection();
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	@Override
	public List<StudentDTO> viewAllStudents() {
		openConnection();

		entityTransaction.begin();

		String jpql = "from StudentDTO";

		Query query = entityManager.createQuery(jpql);
		List<StudentDTO> students = query.getResultList();

		closeConnection();
		return students;
	}

	@Override
	public StudentDTO removeStudent(int id) {
		openConnection();
		entityTransaction.begin();
		StudentDTO student = entityManager.find(StudentDTO.class, id);
		entityManager.remove(student);
		entityTransaction.commit();
		closeConnection();
		return student;
	}
	@Override
	public StudentDTO searchStudent(int id) {
		openConnection();
		entityTransaction.begin();
		StudentDTO student = entityManager.find(StudentDTO.class, id);
		closeConnection();
		return student;
	}

	@Override
	public StudentDTO updateStudent(int id, String name, String email, String userName, String password) {
		openConnection();
		entityTransaction.begin();
		StudentDTO student = entityManager.find(StudentDTO.class, id);
		student.setName(name);
		student.setEmail(email);
		student.setUserName(userName);
		student.setPassword(password);
		entityManager.persist(student);
		entityTransaction.commit();
		closeConnection();
		return student;
	}
	
}
