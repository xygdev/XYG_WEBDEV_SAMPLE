package com.xinyiglass.xygdev.dao.impl;


import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xinyiglass.xygdev.dao.DeptVODao;
import com.xinyiglass.xygdev.entity.DeptVO;
import xygdev.commons.entity.PlsqlRetValue;
import xygdev.commons.entity.SqlResultSet;
import xygdev.commons.springjdbc.DevJdbcDaoSupport;
import xygdev.commons.util.TypeConvert;
 
@Repository("DeptVODao")
public class DeptVODaoImpl extends DevJdbcDaoSupport implements DeptVODao{
 
   @Autowired
   DeptVODaoImpl(DataSource dataSource) {
      setDataSource(dataSource);
   }
 
   //Insert
   public PlsqlRetValue insert(DeptVO vo) throws Exception{
      String sql = 
       "  begin "
     + "  XYG_ALD_DEPT_PKG.INSERT_DEPT( "
     + "   :DEPT_ID "
     + "  ,:DEPT_CODE "
     + "  ,:DEPT_NAME "
     + "  ,:DEPT_TYPE_CODE "
     + "  ,:ENABLE_DATE "
     + "  ,:DISABLED_DATE "
     + "  ,:REMARK "
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
      paramMap.put("DEPT_ID", vo.getDeptId());
      paramMap.put("DEPT_CODE", vo.getDeptCode());
      paramMap.put("DEPT_NAME", vo.getDeptName());
      paramMap.put("DEPT_TYPE_CODE", vo.getDeptTypeCode());
      paramMap.put("ENABLE_DATE", TypeConvert.u2tDate(vo.getEnableDate()));
      paramMap.put("DISABLED_DATE", TypeConvert.u2tDate(vo.getDisabledDate()));
      paramMap.put("REMARK", vo.getRemark());
      paramMap.put("CREATED_BY", vo.getCreatedBy());
      paramMap.put("CREATION_DATE", TypeConvert.u2tDate(vo.getCreationDate()));
      paramMap.put("LAST_UPDATED_BY", vo.getLastUpdatedBy());
      paramMap.put("LAST_UPDATE_DATE", TypeConvert.u2tDate(vo.getLastUpdateDate()));
      paramMap.put("LAST_UPDATE_LOGIN", vo.getLastUpdateLogin());
      return this.getDevJdbcTemplate().executeForRetValue(sql, paramMap);
   }
 
   //Lock
   public PlsqlRetValue lock(DeptVO vo) throws Exception{
      String sql = 
       "  begin "
     + "  XYG_ALD_DEPT_PKG.LOCK_DEPT( "
     + "   :DEPT_ID "
     + "  ,:DEPT_CODE "
     + "  ,:DEPT_NAME "
     + "  ,:DEPT_TYPE_CODE "
     + "  ,:ENABLE_DATE "
     + "  ,:DISABLED_DATE "
     + "  ,:REMARK "
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
      paramMap.put("DEPT_ID", vo.getDeptId());
      paramMap.put("DEPT_CODE", vo.getDeptCode());
      paramMap.put("DEPT_NAME", vo.getDeptName());
      paramMap.put("DEPT_TYPE_CODE", vo.getDeptTypeCode());
      paramMap.put("ENABLE_DATE", TypeConvert.u2tDate(vo.getEnableDate()));
      paramMap.put("DISABLED_DATE", TypeConvert.u2tDate(vo.getDisabledDate()));
      paramMap.put("REMARK", vo.getRemark());
      paramMap.put("CREATED_BY", vo.getCreatedBy());
      paramMap.put("CREATION_DATE", TypeConvert.u2tDate(vo.getCreationDate()));
      paramMap.put("LAST_UPDATED_BY", vo.getLastUpdatedBy());
      paramMap.put("LAST_UPDATE_DATE", TypeConvert.u2tDate(vo.getLastUpdateDate()));
      paramMap.put("LAST_UPDATE_LOGIN", vo.getLastUpdateLogin());
      return this.getDevJdbcTemplate().executeForRetValue(sql, paramMap);
   }
 
   //Update
   public PlsqlRetValue update(DeptVO vo) throws Exception{
      String sql = 
       "  begin "
     + "  XYG_ALD_DEPT_PKG.UPDATE_DEPT( "
     + "   :DEPT_ID "
     + "  ,:DEPT_CODE "
     + "  ,:DEPT_NAME "
     + "  ,:DEPT_TYPE_CODE "
     + "  ,:ENABLE_DATE "
     + "  ,:DISABLED_DATE "
     + "  ,:REMARK "
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
      paramMap.put("DEPT_ID", vo.getDeptId());
      paramMap.put("DEPT_CODE", vo.getDeptCode());
      paramMap.put("DEPT_NAME", vo.getDeptName());
      paramMap.put("DEPT_TYPE_CODE", vo.getDeptTypeCode());
      paramMap.put("ENABLE_DATE", TypeConvert.u2tDate(vo.getEnableDate()));
      paramMap.put("DISABLED_DATE", TypeConvert.u2tDate(vo.getDisabledDate()));
      paramMap.put("REMARK", vo.getRemark());
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
     + "  XYG_ALD_DEPT_PKG.DELETE_DEPT( "
     + " :DEPT_ID "
     + " ,:"+PlsqlRetValue.RETCODE
     + " ,:"+PlsqlRetValue.ERRBUF
     + " ); "
     + "end;";
      Map<String,Object> paramMap=new  HashMap<String,Object>();
      paramMap.put("DEPT_ID", id);
      return this.getDevJdbcTemplate().executeForRetValue(sql, paramMap);
   }
 
   public DeptVO findById(Long id) throws Exception{
      Map<String,Object> paramMap=new  HashMap<String,Object>();
      paramMap.put("1", id);
      return this.getDevJdbcTemplate().queryForObject(
       "SELECT * FROM XYG_ALD_DEPT_V WHERE DEPT_ID = :1"
       , paramMap
       , new DeptVO());
   }
 
   public SqlResultSet findByIdForJSON(Long id) throws Exception{
      String sql = "SELECT * FROM XYG_ALD_DEPT_V WHERE DEPT_ID = :1";
      Map<String,Object> paramMap=new  HashMap<String,Object>();
      paramMap.put("1", id);
      return this.getDevJdbcTemplate().queryForResultSet(sql, paramMap);
   }
}