package recep.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import recep.entity.HangiKurs;
import recep.entity.Person;
import recep.entity.SorgulaEntity;



public class DAO {
	
	SessionFactory sessionFactory;

	public DAO() {
		sessionFactory = new Configuration().configure("/recep/resource/hibernate.cfg.xml").buildSessionFactory();
	}

	public void addValue(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx =null;
		try{
		tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		}catch (Exception e) {
			if(tx != null)
				tx.rollback();
		}finally {
			session.close();
		}			
	}
	
	public void deleteValue(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx =null;
		try{
		tx = session.beginTransaction();
		session.delete(obj);
		tx.commit();
		}catch (Exception e) {
			if(tx != null)
				tx.rollback();
		}finally {
			session.close();
		}			
	}
	
	public List<HangiKurs> getHangiKursList() {
		Session session = sessionFactory.openSession();
		List<HangiKurs> list=null;
		try {

			list = session.createCriteria(HangiKurs.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		return list;
	}

	public List<Person> sorgula(SorgulaEntity sorgulaEntity) {
		Session session = sessionFactory.openSession();
		List<Person> myList = null;
		try{
			Criteria criteria = session.createCriteria(Person.class);
			if(sorgulaEntity.getAd() != null && sorgulaEntity.getAd().length() > 0)
				criteria.add(Restrictions.ilike("ad", sorgulaEntity.getAd()));
			
			if(sorgulaEntity.getSoyad() != null && sorgulaEntity.getSoyad().length() > 0)
				criteria.add(Restrictions.ilike("soyad", sorgulaEntity.getSoyad()));
			
			if(sorgulaEntity.getHangiKurs() != null && sorgulaEntity.getHangiKurs().length() > 0)
				criteria.add(Restrictions.ilike("hangiKurs", sorgulaEntity.getHangiKurs()));
			
//			criteria.add(Restrictions.between("gorusmeZamani", sorgulaEntity.getBasTarihi(), sorgulaEntity.getBitisTarihi()));
			if(sorgulaEntity.getBasTarihi() != null)
				criteria.add(Restrictions.ge("gorusmeZamani", sorgulaEntity.getBasTarihi()));
			
			if(sorgulaEntity.getSonTarihi() != null)
				criteria.add(Restrictions.lt("gorusmeZamani", sorgulaEntity.getSonTarihi()));
			
			if(sorgulaEntity.getType() != 0)
				criteria.add(Restrictions.eq("gorusmeTipi", sorgulaEntity.getType()));
			
			myList = (List<Person>)criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}	
		return myList;
	}
	
	public List<HangiKurs> sorgulaHangiKurs(String value) {
		Session session = sessionFactory.openSession();
		List<HangiKurs> myList = null;
		try{
			Criteria criteria = session.createCriteria(HangiKurs.class);
			
			if( value.length() > 0)
				criteria.add(Restrictions.ilike("kursAdi", value));
			
		
			myList = (List<HangiKurs>)criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}	
		return myList;
	}

}
