package com.xinyiglass.xygdev.service;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.xinyiglass.xygdev.dao.DeptVODao;
import com.xinyiglass.xygdev.entity.DeptVO;
import xygdev.commons.entity.PlsqlRetValue;
import xygdev.commons.page.PagePub;
import xygdev.commons.springjdbc.DevJdbcSubProcess;
 
@Service
@Transactional(rollbackFor=Exception.class)//指定checked的异常Exception也要回滚！
public class DeptVOService {
    
    @Autowired
    DeptVODao dao;
    @Autowired
    PagePub pagePub;
    
    public PlsqlRetValue insert(DeptVO vo,Long loginId) throws Exception{
        PlsqlRetValue ret=dao.insert(vo);
        if(ret.getRetcode()!=0){
            DevJdbcSubProcess.setRollbackOnly();
        }
        return ret;
    }
    
    public PlsqlRetValue update(DeptVO lVO,DeptVO uVO,Long loginId) throws Exception
    { 
        PlsqlRetValue ret=dao.lock(lVO);
        if(ret.getRetcode()==0){
            ret=dao.update(uVO);
        }else{
            DevJdbcSubProcess.setRollbackOnly();
        }
        return ret;
    }
    
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public String findForPage(int pageSize,int pageNo,boolean goLastPage,Map<String,Object> conditionMap,Long loginId) throws Exception{
        Map<String,Object> paramMap=new HashMap<String,Object>();
        StringBuffer sqlBuff = new StringBuffer();
        sqlBuff.append("select A.* from XYG_ALD_DEPT_V A WHERE 1=1");
        //sqlBuff.append(SqlStmtPub.getAndStmt("WORK_ITEM",conditionMap.get("workItem"),paramMap));
        //sqlBuff.append(SqlStmtPub.getAndStmt("WORK_DATE",conditionMap.get("workDate_F"),conditionMap.get("workDate_T"),paramMap));
        sqlBuff.append(" ORDER BY "+conditionMap.get("orderBy"));
        return pagePub.qPageForJson(sqlBuff.toString(), paramMap, pageSize, pageNo, goLastPage);
    }       
    
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public DeptVO findById(Long id,Long loginId) throws Exception{
        return dao.findById(id);
    }
    
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public String findByIdForJSON(Long id,Long loginId) throws Exception{
        return dao.findByIdForJSON(id).toJsonStr();
    }
}
