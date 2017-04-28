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
@Component("WorklogHeaderVO")
public class WorklogHeaderVO extends BaseEntity  implements FactoryBean,RowMapper<WorklogHeaderVO>, Cloneable {
   //备注：该VO对应的对象是：XYG_ALD_WORKLOG_HEADERS_V
   public static final Map<String, String> mapCol = new HashMap<String, String>();
   static {
      mapCol.put("rowId", "ROW_ID");
      mapCol.put("headerId", "HEADER_ID");
      mapCol.put("departmentCode", "DEPARTMENT_CODE");
      mapCol.put("departmentDesc", "DEPARTMENT_DESC");
      mapCol.put("workGroup", "WORK_GROUP");
      mapCol.put("workGroupDesc", "WORK_GROUP_DESC");
      mapCol.put("workItem", "WORK_ITEM");
      mapCol.put("workReqDocument", "WORK_REQ_DOCUMENT");
      mapCol.put("workRequestPid", "WORK_REQUEST_PID");
      mapCol.put("workRequestName", "WORK_REQUEST_NAME");
      mapCol.put("workOwnerPid", "WORK_OWNER_PID");
      mapCol.put("workOwnerName", "WORK_OWNER_NAME");
      mapCol.put("workDate", "WORK_DATE");
      mapCol.put("description", "DESCRIPTION");
      mapCol.put("createdBy", "CREATED_BY");
      mapCol.put("creationDate", "CREATION_DATE");
      mapCol.put("lastUpdatedBy", "LAST_UPDATED_BY");
      mapCol.put("lastUpdateDate", "LAST_UPDATE_DATE");
      mapCol.put("lastUpdateLogin", "LAST_UPDATE_LOGIN");
   }
 
   private String rowId;
   private Long headerId;
   private String departmentCode;
   private String departmentDesc;
   private String workGroup;
   private String workGroupDesc;
   private String workItem;
   private String workReqDocument;
   private Long workRequestPid;
   private String workRequestName;
   private Long workOwnerPid;
   private String workOwnerName;
   private java.util.Date workDate;
   private String description;
   private Long createdBy;
   private java.util.Date creationDate;
   private Long lastUpdatedBy;
   private java.util.Date lastUpdateDate;
   private Long lastUpdateLogin;
 
   //GET&SET Method
   public String getRowId() {
      return rowId;
   }
   public void setRowId(String rowId) {
      this.rowId = rowId;
   }
   public Long getHeaderId() {
      return headerId;
   }
   public void setHeaderId(Long headerId) {
      this.headerId = headerId;
   }
   public String getDepartmentCode() {
      return departmentCode;
   }
   public void setDepartmentCode(String departmentCode) {
      this.departmentCode = departmentCode;
   }
   public String getDepartmentDesc() {
      return departmentDesc;
   }
   public void setDepartmentDesc(String departmentDesc) {
      this.departmentDesc = departmentDesc;
   }
   public String getWorkGroup() {
      return workGroup;
   }
   public void setWorkGroup(String workGroup) {
      this.workGroup = workGroup;
   }
   public String getWorkGroupDesc() {
      return workGroupDesc;
   }
   public void setWorkGroupDesc(String workGroupDesc) {
      this.workGroupDesc = workGroupDesc;
   }
   public String getWorkItem() {
      return workItem;
   }
   public void setWorkItem(String workItem) {
      this.workItem = workItem;
   }
   public String getWorkReqDocument() {
      return workReqDocument;
   }
   public void setWorkReqDocument(String workReqDocument) {
      this.workReqDocument = workReqDocument;
   }
   public Long getWorkRequestPid() {
      return workRequestPid;
   }
   public void setWorkRequestPid(Long workRequestPid) {
      this.workRequestPid = workRequestPid;
   }
   public String getWorkRequestName() {
      return workRequestName;
   }
   public void setWorkRequestName(String workRequestName) {
      this.workRequestName = workRequestName;
   }
   public Long getWorkOwnerPid() {
      return workOwnerPid;
   }
   public void setWorkOwnerPid(Long workOwnerPid) {
      this.workOwnerPid = workOwnerPid;
   }
   public String getWorkOwnerName() {
      return workOwnerName;
   }
   public void setWorkOwnerName(String workOwnerName) {
      this.workOwnerName = workOwnerName;
   }
   public java.util.Date getWorkDate() {
      return workDate;
   }
   public void setWorkDate(java.util.Date workDate) {
      this.workDate = workDate;
   }
   public String getDescription() {
      return description;
   }
   public void setDescription(String description) {
      this.description = description;
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
     WorklogHeaderVO h = null;  
     try{  
        h = (WorklogHeaderVO)super.clone();  
     }catch(CloneNotSupportedException e) {  
        e.printStackTrace();  
     }  
     return h;  
   } 
    
   @Override
   public WorklogHeaderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
      return (WorklogHeaderVO) mapRowCreator(WorklogHeaderVO.class,mapCol,rs,rowNum);
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
