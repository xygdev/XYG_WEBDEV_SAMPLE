package com.xinyiglass.xygdev.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xinyiglass.xygdev.entity.DeptVO;
import com.xinyiglass.xygdev.service.DeptVOService;
import com.xinyiglass.xygdev.util.GlobalInit;
import xygdev.commons.core.BaseController;
import xygdev.commons.core.Server;
 
@Controller
@RequestMapping("/dept")
@Scope("prototype")
public class DeptVOController extends BaseController {
     
    @Autowired
    DeptVOService s;
    
    //http://192.168.88.123:8080/XYG_WEBDEV_SAMPLE/dept/dept.do
    @RequestMapping("/dept.do")
    public String dept(){
        return "ZHS/xygAldDept";
    }
    
    @RequestMapping(value = "/getPage.do", method = RequestMethod.POST)
    public void getPage() throws Exception
    {       
        GlobalInit.init(true);
        int pageSize=this.getParaToInt("pageSize");
        int pageNo=this.getParaToInt("pageNo");
        boolean goLastPage=this.getParaToBoolean("goLastPage");
        Map<String,Object> conditionMap=new HashMap<String,Object>();
        //conditionMap.put("workItem", this.getPara("WORK_ITEM"));
        //conditionMap.put("workDate_F", this.getParaToDate("WORK_DATE_F"));
        //conditionMap.put("workDate_T", this.getParaToDate("WORK_DATE_T"));
        conditionMap.put("orderBy",  this.getPara("orderby"));
        this.renderStr(s.findForPage(pageSize, pageNo, goLastPage, conditionMap,loginId));
    }
    
    @RequestMapping(value = "/insert.do", method = RequestMethod.POST)
    public void insert() throws Exception
    { 
        DeptVO i =this.getEntity(DeptVO.class, DeptVO.mapCol, "");
        i.setWho(i, "INSERT", userId, loginId);
        this.renderStr(s.insert(i,loginId).toJsonStr());
    }
    
    @RequestMapping(value = "/preUpdate.do", method = RequestMethod.POST)
    public void preUpdate() throws Exception
    {
        Long id = this.getParaToLong("DEPT_ID");
        DeptVO l = s.findById(id, loginId);
        this.setSessionAttr("lDeptVO", l);
        this.renderStr(s.findByIdForJSON(id,loginId));
    }
    
    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    public void update() throws Exception
    { 
        Long id = this.getParaToLong("DEPT_ID");
        DeptVO lDeptVO = (DeptVO)this.getSessionAttr("lDeptVO");
        if (lDeptVO ==null){
            throw new RuntimeException("更新数据出错:会话数据已经无效!请返回再重新操作!");
        }
        if (!id.equals(lDeptVO.getDeptId())){
            throw new RuntimeException("更新的数据无法匹配!请重新查询!");
        }
        DeptVO u =this.getEntity((DeptVO) lDeptVO.clone(), DeptVO.mapCol, "");
        u.setWho(u, "UPDATE", userId, loginId);
        this.renderStr(s.update(lDeptVO, u,loginId).toJsonStr());
    }
    
    public static void main(String[] args) {
        //Server.start("WebRoot", 8080, "/XYG_WEBDEV_SAMPLE", 5,"D:\\JSP_MyEclipse\\CDN\\image","/image");
        Server.start("WebRoot", 8080, "/XYG_WEBDEV_SAMPLE", 5);
    }
}
