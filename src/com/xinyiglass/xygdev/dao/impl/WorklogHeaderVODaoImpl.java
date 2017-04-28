package com.xinyiglass.xygdev.dao.impl;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xinyiglass.xygdev.dao.WorklogHeaderVODao;
import com.xinyiglass.xygdev.entity.WorklogHeaderVO;
import xygdev.commons.entity.PlsqlRetValue;
import xygdev.commons.entity.SqlResultSet;
import xygdev.commons.springjdbc.DevJdbcDaoSupport;
import xygdev.commons.util.TypeConvert;
 
@Repository("WorklogHeaderVODao")
public class WorklogHeaderVODaoImpl extends DevJdbcDaoSupport implements WorklogHeaderVODao{
 
   @Autowired
   WorklogHeaderVODaoImpl(DataSource dataSource) {
      setDataSource(dataSource);
   }
 
   //Insert
   public PlsqlRetValue insert(WorklogHeaderVO vo) throws Exception{
      String sql = 
       "  begin "
     + "  XYG_ALD_WORKLOG_PKG.INSERT_HEADER( "
     + "   :HEADER_ID "
     + "  ,:DEPARTMENT_CODE "
     + "  ,:WORK_GROUP "
     + "  ,:WORK_ITEM "
     + "  ,:WORK_REQ_DOCUMENT "
     + "  ,:WORK_REQUEST_PID "
     + "  ,:WORK_OWNER_PID "
     + "  ,:WORK_DATE "
     + "  ,:DESCRIPTION "
     + "  ,:CREATED_BY "
     + "  ,:CREATION_DATE "
     + "  ,:LAST_UPDATED_BY "
     + "  ,:LAST_UPDATE_DATE "
     + "  ,:LAST_UPDATE_LOGIN "
     + " ,:"+PlsqlRetValue.RETCODE
     + " ,:"+PlsqlRetValue.ERRBUF
     + " ); "
     + "end;";
      Map<String,Object> paramMap=new HashMap<String,Object>();
      paramMap.put("HEADER_ID", vo.getHeaderId());
      paramMap.put("DEPARTMENT_CODE", vo.getDepartmentCode());
      paramMap.put("WORK_GROUP", vo.getWorkGroup());
      paramMap.put("WORK_ITEM", vo.getWorkItem());
      paramMap.put("WORK_REQ_DOCUMENT", vo.getWorkReqDocument());
      paramMap.put("WORK_REQUEST_PID", vo.getWorkRequestPid());
      paramMap.put("WORK_OWNER_PID", vo.getWorkOwnerPid());
      paramMap.put("WORK_DATE", TypeConvert.u2tDate(vo.getWorkDate()));
      paramMap.put("DESCRIPTION", vo.getDescription());
      paramMap.put("CREATED_BY", vo.getCreatedBy());
      paramMap.put("CREATION_DATE", TypeConvert.u2tDate(vo.getCreationDate()));
      paramMap.put("LAST_UPDATED_BY", vo.getLastUpdatedBy());
      paramMap.put("LAST_UPDATE_DATE", TypeConvert.u2tDate(vo.getLastUpdateDate()));
      paramMap.put("LAST_UPDATE_LOGIN", vo.getLastUpdateLogin());
      return this.getDevJdbcTemplate().executeForRetValue(sql, paramMap);
   }
 
   //Lock
   public PlsqlRetValue lock(WorklogHeaderVO vo) throws Exception{
      String sql = 
       "  begin "
     + "  XYG_ALD_WORKLOG_PKG.LOCK_HEADER( "
     + "   :HEADER_ID "
     + "  ,:DEPARTMENT_CODE "
     + "  ,:WORK_GROUP "
     + "  ,:WORK_ITEM "
     + "  ,:WORK_REQ_DOCUMENT "
     + "  ,:WORK_REQUEST_PID "
     + "  ,:WORK_OWNER_PID "
     + "  ,:WORK_DATE "
     + "  ,:DESCRIPTION "
     + "  ,:CREATED_BY "
     + "  ,:CREATION_DATE "
     + "  ,:LAST_UPDATED_BY "
     + "  ,:LAST_UPDATE_DATE "
     + "  ,:LAST_UPDATE_LOGIN "
     + " ,:"+PlsqlRetValue.RETCODE
     + " ,:"+PlsqlRetValue.ERRBUF
     + " ); "
     + "end;";
      Map<String,Object> paramMap=new HashMap<String,Object>();
      paramMap.put("HEADER_ID", vo.getHeaderId());
      paramMap.put("DEPARTMENT_CODE", vo.getDepartmentCode());
      paramMap.put("WORK_GROUP", vo.getWorkGroup());
      paramMap.put("WORK_ITEM", vo.getWorkItem());
      paramMap.put("WORK_REQ_DOCUMENT", vo.getWorkReqDocument());
      paramMap.put("WORK_REQUEST_PID", vo.getWorkRequestPid());
      paramMap.put("WORK_OWNER_PID", vo.getWorkOwnerPid());
      paramMap.put("WORK_DATE", TypeConvert.u2tDate(vo.getWorkDate()));
      paramMap.put("DESCRIPTION", vo.getDescription());
      paramMap.put("CREATED_BY", vo.getCreatedBy());
      paramMap.put("CREATION_DATE", TypeConvert.u2tDate(vo.getCreationDate()));
      paramMap.put("LAST_UPDATED_BY", vo.getLastUpdatedBy());
      paramMap.put("LAST_UPDATE_DATE", TypeConvert.u2tDate(vo.getLastUpdateDate()));
      paramMap.put("LAST_UPDATE_LOGIN", vo.getLastUpdateLogin());
      return this.getDevJdbcTemplate().executeForRetValue(sql, paramMap);
   }
 
   //Update
   public PlsqlRetValue update(WorklogHeaderVO vo) throws Exception{
      String sql = 
       "  begin "
     + "  XYG_ALD_WORKLOG_PKG.UPDATE_HEADER( "
     + "   :HEADER_ID "
     + "  ,:DEPARTMENT_CODE "
     + "  ,:WORK_GROUP "
     + "  ,:WORK_ITEM "
     + "  ,:WORK_REQ_DOCUMENT "
     + "  ,:WORK_REQUEST_PID "
     + "  ,:WORK_OWNER_PID "
     + "  ,:WORK_DATE "
     + "  ,:DESCRIPTION "
     + "  ,:CREATED_BY "
     + "  ,:CREATION_DATE "
     + "  ,:LAST_UPDATED_BY "
     + "  ,:LAST_UPDATE_DATE "
     + "  ,:LAST_UPDATE_LOGIN "
     + " ,:"+PlsqlRetValue.RETCODE
     + " ,:"+PlsqlRetValue.ERRBUF
     + " ); "
     + "end;";
      Map<String,Object> paramMap=new HashMap<String,Object>();
      paramMap.put("HEADER_ID", vo.getHeaderId());
      paramMap.put("DEPARTMENT_CODE", vo.getDepartmentCode());
      paramMap.put("WORK_GROUP", vo.getWorkGroup());
      paramMap.put("WORK_ITEM", vo.getWorkItem());
      paramMap.put("WORK_REQ_DOCUMENT", vo.getWorkReqDocument());
      paramMap.put("WORK_REQUEST_PID", vo.getWorkRequestPid());
      paramMap.put("WORK_OWNER_PID", vo.getWorkOwnerPid());
      paramMap.put("WORK_DATE", TypeConvert.u2tDate(vo.getWorkDate()));
      paramMap.put("DESCRIPTION", vo.getDescription());
      paramMap.put("CREATED_BY", vo.getCreatedBy());
      paramMap.put("CREATION_DATE", TypeConvert.u2tDate(vo.getCreationDate()));
      paramMap.put("LAST_UPDATED_BY", vo.getLastUpdatedBy());
      paramMap.put("LAST_UPDATE_DATE", TypeConvert.u2tDate(vo.getLastUpdateDate()));
      paramMap.put("LAST_UPDATE_LOGIN", vo.getLastUpdateLogin());
      return this.getDevJdbcTemplate().executeForRetValue(sql, paramMap);
   }
 
   //Delete
   public PlsqlRetValue delete(Long id) throws Exception{
      String sql = 
       "  begin "
     + "  XYG_ALD_WORKLOG_PKG.DELETE_HEADER( "
     + " :HEADER_ID "
     + " ,:"+PlsqlRetValue.RETCODE
     + " ,:"+PlsqlRetValue.ERRBUF
     + " ); "
     + "end;";
      Map<String,Object> paramMap=new  HashMap<String,Object>();
      paramMap.put("HEADER_ID", id);
      return this.getDevJdbcTemplate().executeForRetValue(sql, paramMap);
   }
 
   public WorklogHeaderVO findById(Long id) throws Exception{
      Map<String,Object> paramMap=new  HashMap<String,Object>();
      paramMap.put("1", id);
      return this.getDevJdbcTemplate().queryForObject(
       "SELECT * FROM XYG_ALD_WORKLOG_HEADERS_V WHERE HEADER_ID = :1"
       , paramMap
       , new WorklogHeaderVO());
   }
 
   public SqlResultSet findByIdForJSON(Long id) throws Exception{
      String sql = "SELECT * FROM XYG_ALD_WORKLOG_HEADERS_V WHERE HEADER_ID = :1";
      Map<String,Object> paramMap=new  HashMap<String,Object>();
      paramMap.put("1", id);
      return this.getDevJdbcTemplate().queryForResultSet(sql, paramMap);
   }
}