package com.xinyiglass.xygdev.entity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.beans.factory.FactoryBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
 
import xygdev.commons.core.BaseEntity;
 
@SuppressWarnings("rawtypes")
@Component("DeptVO")
public class DeptVO extends BaseEntity  implements FactoryBean,RowMapper<DeptVO>, Cloneable {
   //备注：该Entity对应的数据库对象是：XYG_ALD_DEPT_V
   public static final Map<String, String> mapCol = new HashMap<String, String>();
   static {
      mapCol.put("deptId", "DEPT_ID");
      mapCol.put("deptCode", "DEPT_CODE");
      mapCol.put("deptName", "DEPT_NAME");
      mapCol.put("deptTypeCode", "DEPT_TYPE_CODE");
      mapCol.put("deptTypeDesc", "DEPT_TYPE_DESC");
      mapCol.put("enableDate", "ENABLE_DATE");
      mapCol.put("disabledDate", "DISABLED_DATE");
      mapCol.put("remark", "REMARK");
      mapCol.put("createdBy", "CREATED_BY");
      mapCol.put("creationDate", "CREATION_DATE");
      mapCol.put("lastUpdatedBy", "LAST_UPDATED_BY");
      mapCol.put("lastUpdateDate", "LAST_UPDATE_DATE");
      mapCol.put("lastUpdateLogin", "LAST_UPDATE_LOGIN");
   }
 
   private Long deptId;
   private String deptCode;
   private String deptName;
   private String deptTypeCode;
   private String deptTypeDesc;
   private java.util.Date enableDate;
   private java.util.Date disabledDate;
   private String remark;
   private Long createdBy;
   private java.util.Date creationDate;
   private Long lastUpdatedBy;
   private java.util.Date lastUpdateDate;
   private Long lastUpdateLogin;
 
   //GET&SET Method
   public Long getDeptId() {
      return deptId;
   }
   public void setDeptId(Long deptId) {
      this.deptId = deptId;
   }
   public String getDeptCode() {
      return deptCode;
   }
   public void setDeptCode(String deptCode) {
      this.deptCode = deptCode;
   }
   public String getDeptName() {
      return deptName;
   }
   public void setDeptName(String deptName) {
      this.deptName = deptName;
   }
   public String getDeptTypeCode() {
      return deptTypeCode;
   }
   public void setDeptTypeCode(String deptTypeCode) {
      this.deptTypeCode = deptTypeCode;
   }
   public String getDeptTypeDesc() {
      return deptTypeDesc;
   }
   public void setDeptTypeDesc(String deptTypeDesc) {
      this.deptTypeDesc = deptTypeDesc;
   }
   public java.util.Date getEnableDate() {
      return enableDate;
   }
   public void setEnableDate(java.util.Date enableDate) {
      this.enableDate = enableDate;
   }
   public java.util.Date getDisabledDate() {
      return disabledDate;
   }
   public void setDisabledDate(java.util.Date disabledDate) {
      this.disabledDate = disabledDate;
   }
   public String getRemark() {
      return remark;
   }
   public void setRemark(String remark) {
      this.remark = remark;
   }
   public Long getCreatedBy() {
      return createdBy;
   }
   public void setCreatedBy(Long createdBy) {
      this.createdBy = createdBy;
   }
   public java.util.Date getCreationDate() {
      return creationDate;
   }
   public void setCreationDate(java.util.Date creationDate) {
      this.creationDate = creationDate;
   }
   public Long getLastUpdatedBy() {
      return lastUpdatedBy;
   }
   public void setLastUpdatedBy(Long lastUpdatedBy) {
      this.lastUpdatedBy = lastUpdatedBy;
   }
   public java.util.Date getLastUpdateDate() {
      return lastUpdateDate;
   }
   public void setLastUpdateDate(java.util.Date lastUpdateDate) {
      this.lastUpdateDate = lastUpdateDate;
   }
   public Long getLastUpdateLogin() {
      return lastUpdateLogin;
   }
   public void setLastUpdateLogin(Long lastUpdateLogin) {
      this.lastUpdateLogin = lastUpdateLogin;
   }
 
   @Override
   public Object clone() {
     DeptVO h = null;  
     try{  
        h = (DeptVO)super.clone();  
     }catch(CloneNotSupportedException e) {  
        e.printStackTrace();  
     }  
     return h;  
   } 
    
   @Override
   public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
      return (DeptVO) mapRowCreator(DeptVO.class,mapCol,rs,rowNum);
   }
   @Override
   public Object getObject() throws Exception {
      return null;
   }
   @Override
   public Class getObjectType() {
      return null;
   }
   @Override
   public boolean isSingleton() {
      return false;
   }
 
}