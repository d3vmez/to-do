package com.todo.serviceSOA.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.todo.serviceSOA.dao.IToDoDAO;
import com.todo.serviceSOA.model.ToDo;
import com.todo.serviceSOA.model.ToDoStatus;
import com.todo.serviceSOA.util.HibernateUtil;

public class ToDoDAO implements IToDoDAO{
	
	private Logger log = Logger.getLogger(this.getClass());
	private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
	private static Session session = null;

	@Override
	public Optional<ToDo> getById(int id) {

		ToDo todo = null;
		Optional<ToDo> optional = null;

		try {
			// Obtener el objeto Session de SessionFactory
			session = sessionFactory.openSession();

			// Empezar transacción
			session.beginTransaction();
			todo = (ToDo) session.get(ToDo.class, id);

		} catch (HibernateException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}

		}

		if (todo == null) {
			log.warn("Not found todo with id: " + id);
			return Optional.empty();
		}

		optional = Optional.of(todo);

		return optional;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ToDo> getAllByStatus(ToDoStatus status) {

		List<ToDo> todos = new ArrayList<>();

		try {
			// Obtener el objeto Session de SessionFactory
			session = sessionFactory.openSession();

			// Empezar transacción
			session.beginTransaction();

			todos = (List<ToDo>) session
					.createQuery("FROM ToDo a WHERE a.toDoStatus Like :status")
					.setParameter("status", status).list();
		} catch (HibernateException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}

		}

		return todos;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ToDo> getAll() {
		List<ToDo> todos = new ArrayList<>();

		try {
			// Obtener el objeto Session de SessionFactory
			session = sessionFactory.openSession();

			// Empezar transacción
			session.beginTransaction();

			todos = (List<ToDo>) session.createQuery("FROM ToDo a ").list();

		} catch (HibernateException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}

		}

		return todos;
	}

	@Override
	public ToDo save(ToDo todo) {

		try {
			// Obtener el objeto Session de SessionFactory
			session = sessionFactory.openSession();

			// Empezar transacción
			session.beginTransaction();
			
			java.util.Date fecha = new java.util.Date();
			java.sql.Date fechaSQl = new Date(fecha.getTime());
			todo.setStarDate(fechaSQl);

			
			session.saveOrUpdate(todo);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("aaa");
			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}

		}

		return todo;
	}

	@Override
	public void deleteById(int id) {
		
		try {
			// Obtener el objeto Session de SessionFactory
			session = sessionFactory.openSession();

			// Empezar transacción
			session.beginTransaction();
			session.createQuery("DELETE FROM ToDo a WHERE a.id = :id").setParameter("id", id).executeUpdate();
			session.getTransaction().commit();
			
		} catch (HibernateException e) {

			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}

		}

	}

}
