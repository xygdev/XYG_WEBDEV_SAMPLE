package com.xinyiglass.xygdev.dao;

import com.xinyiglass.xygdev.entity.WorklogHeaderVO;
import xygdev.commons.entity.PlsqlRetValue;
import xygdev.commons.entity.SqlResultSet;
 
public interface WorklogHeaderVODao {
   public PlsqlRetValue insert(WorklogHeaderVO vo) throws Exception;
   public PlsqlRetValue lock(WorklogHeaderVO vo) throws Exception;
   public PlsqlRetValue update(WorklogHeaderVO vo) throws Exception;
   public PlsqlRetValue delete(Long id) throws Exception;
   public WorklogHeaderVO findById(Long id) throws Exception;
   public SqlResultSet findByIdForJSON(Long id) throws Exception;
}
 