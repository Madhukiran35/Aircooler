package com.edubridge.app4.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.app4.model.Aircooler;
import com.edubridge.app4.utils.HibernateUtils;

public class AircoolerDao implements AircoolerDaoI {

	@Override
	public void addAircooler(Aircooler aircooler) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.persist(aircooler);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("new Aircooler addedd!");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Aircooler> getAllAircoolers() {
		List<Aircooler> aircoolers = new ArrayList<Aircooler>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			String hql = "from Aircooler";
			Query query = session.createQuery(hql, Aircooler.class);
			aircoolers = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return aircoolers;
	}

	@Override
	public Aircooler getAircoolerById(Integer id) {
		Aircooler aircooler = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			aircooler = session.get(Aircooler.class, id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return aircooler;
	}

	@Override
	public void updateAircooler(Aircooler aircooler) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.merge(aircooler);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("aircooler is updated!");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAircooler(Integer id) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Aircooler aircooler = session.get(Aircooler.class, id);

			if (aircooler != null) {
				session.remove(aircooler);
				tx.commit();
				System.out.println("Aircooler is deleted!");
			} else {
				System.out.println("no aircooler found!");
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAllAircoolers() {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			String hql = "delete from Aircooler";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("All aircoolers are deleted");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}

