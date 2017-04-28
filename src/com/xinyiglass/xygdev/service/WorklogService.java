package com.xinyiglass.xygdev.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xinyiglass.xygdev.dao.WorklogHeaderVODao;
import com.xinyiglass.xygdev.entity.WorklogHeaderVO;

import xygdev.commons.entity.PlsqlRetValue;
import xygdev.commons.page.PagePub;
import xygdev.commons.springjdbc.DevJdbcSubProcess;
import xygdev.commons.sqlStmt.SqlStmtPub;
 
@Service
@Transactional(rollbackFor=Exception.class)//指定checked的异常Exception也要回滚！
public class WorklogService {
    
    @Autowired
    WorklogHeaderVODao hDao;
    @Autowired
    PagePub pagePub;
    
    public PlsqlRetValue insertH(WorklogHeaderVO vo,Long loginId) throws Exception{
        PlsqlRetValue ret=hDao.insert(vo);
        if(ret.getRetcode()!=0){
            DevJdbcSubProcess.setRollbackOnly();
        }
        return ret;
    }
    
    public PlsqlRetValue updateH(WorklogHeaderVO lVO,WorklogHeaderVO uVO,Long loginId) throws Exception
    { 
        PlsqlRetValue ret=hDao.lock(lVO);
        if(ret.getRetcode()==0){
            ret=hDao.update(uVO);
        }else{
            DevJdbcSubProcess.setRollbackOnly();
        }
        return ret;
    }
    
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public String findForPageH(int pageSize,int pageNo,boolean goLastPage,Map<String,Object> conditionMap,Long loginId) throws Exception{
        Map<String,Object> paramMap=new HashMap<String,Object>();
        StringBuffer sqlBuff = new StringBuffer();
        sqlBuff.append("select A.* from XYG_ALD_WORKLOG_HEADERS_V A WHERE 1=1");
        sqlBuff.append(SqlStmtPub.getAndStmt("WORK_ITEM",conditionMap.get("workItem"),paramMap));
        sqlBuff.append(SqlStmtPub.getAndStmt("WORK_DATE",conditionMap.get("workDate_F"),conditionMap.get("workDate_T"),paramMap));
        sqlBuff.append(" ORDER BY "+conditionMap.get("orderBy"));
        return pagePub.qPageForJson(sqlBuff.toString(), paramMap, pageSize, pageNo, goLastPage);
    }       
    
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public WorklogHeaderVO findByIdH(Long id,Long loginId) throws Exception{
        return hDao.findById(id);
    }
    
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public String findByIdForJSONH(Long id,Long loginId) throws Exception{
        return hDao.findByIdForJSON(id).toJsonStr();
    }
}
