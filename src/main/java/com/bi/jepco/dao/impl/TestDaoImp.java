package com.bi.jepco.dao.impl;

import com.bi.jepco.entities.Test;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bi.jepco.dao.TestDao;



@Repository
public class TestDaoImp implements TestDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Test book) {
      sessionFactory.getCurrentSession().save(book);
      return book.getId();
   }

   @Override
   public Test get(long id) {
      return sessionFactory.getCurrentSession().get(Test.class, id);
   }

   @Override
   public List<Test> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Test> cq = cb.createQuery(Test.class);
      Root<Test> root = cq.from(Test.class);
      cq.select(root);
      Query<Test> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Test book) {
      Session session = sessionFactory.getCurrentSession();
      Test book2 = session.byId(Test.class).load(id);
      book2.setTitle(book.getTitle());
      book2.setAuthor(book.getAuthor());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Test book = session.byId(Test.class).load(id);
      session.delete(book);
   }

}
