package com.bi.jepco.service.impl;

import com.bi.jepco.entities.Test;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bi.jepco.dao.TestDao;
import com.bi.jepco.service.TestService;


@Service
@Transactional
public class TestServiceImp implements TestService {

   @Autowired
   private TestDao bookDao;

   @Override
   public long save(Test book) {
      return bookDao.save(book);
   }

   @Override
   public Test get(long id) {
      return bookDao.get(id);
   }

   @Override
   public List<Test> list() {
      return bookDao.list();
   }

   @Override
   public void update(long id, Test book) {
      bookDao.update(id, book);
   }

   @Override
   public void delete(long id) {
      bookDao.delete(id);
   }

}
