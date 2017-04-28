package com.xinyiglass.xygdev.dao;

import com.xinyiglass.xygdev.entity.DeptVO;
import xygdev.commons.entity.PlsqlRetValue;
import xygdev.commons.entity.SqlResultSet;
 
public interface DeptVODao {
   public PlsqlRetValue insert(DeptVO vo) throws Exception;
   public PlsqlRetValue lock(DeptVO vo) throws Exception;
   public PlsqlRetValue update(DeptVO vo) throws Exception;
   public PlsqlRetValue delete(Long id) throws Exception;
   public DeptVO findById(Long id) throws Exception;
   public SqlResultSet findByIdForJSON(Long id) throws Exception;
}
