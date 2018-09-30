package com.bi.jepco.dao;

import com.bi.jepco.entities.BillParf;

import java.util.List;


public interface BillParfDao {

   public List<BillParf> find(Integer type);

}
