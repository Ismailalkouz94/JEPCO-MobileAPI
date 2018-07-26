package com.bi.jepco.service;

import com.bi.jepco.entities.Test;
import java.util.List;


public interface TestService {

   long save(Test book);
   Test get(long id);
   List<Test> list();
   void update(long id, Test book);
   void delete(long id);
}
