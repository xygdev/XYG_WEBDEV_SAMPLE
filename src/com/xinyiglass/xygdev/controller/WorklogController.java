package com.xinyiglass.xygdev.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xinyiglass.xygdev.entity.WorklogHeaderVO;
import com.xinyiglass.xygdev.service.WorklogService;
import com.xinyiglass.xygdev.util.GlobalInit;
import xygdev.commons.core.BaseController;
import xygdev.commons.core.Server;
 
@Controller
@RequestMapping("/worklog")
@Scope("prototype")
public class WorklogController extends BaseController {
     
    @Autowired
    WorklogService s;
    
    //http://192.168.88.123:8080/XYG_WEBDEV_SAMPLE/worklog/worklog.do
    @RequestMapping("/worklog.do")
    public String worklogHeader(){
        return "ZHS/xygAldWorklog";
    }
    
    @RequestMapping(value = "/getPageH.do", method = RequestMethod.POST)
    public void getPageH() throws Exception
    {       
        GlobalInit.init(true);
        int pageSize=this.getParaToInt("pageSize");
        int pageNo=this.getParaToInt("pageNo");
        boolean goLastPage=this.getParaToBoolean("goLastPage");
        Map<String,Object> conditionMap=new HashMap<String,Object>();
        conditionMap.put("workItem", this.getPara("WORK_ITEM_Q"));
        conditionMap.put("workDate_F", this.getParaToDate("WORK_DATE_F"));
        conditionMap.put("workDate_T", this.getParaToDate("WORK_DATE_T"));
        conditionMap.put("orderBy",  this.getPara("orderby"));
        this.renderStr(s.findForPageH(pageSize, pageNo, goLastPage, conditionMap,loginId));
    }
    
    @RequestMapping(value = "/insertH.do", method = RequestMethod.POST)
    public void insertH() throws Exception
    { 
        WorklogHeaderVO i =this.getEntity(WorklogHeaderVO.class, WorklogHeaderVO.mapCol, "");
        i.setWho(i, "INSERT", userId, loginId);
        this.renderStr(s.insertH(i,loginId).toJsonStr());
    }
    
    @RequestMapping(value = "/preUpdateH.do", method = RequestMethod.POST)
    public void preUpdateH() throws Exception
    {
        Long id = this.getParaToLong("HEADER_ID");
        WorklogHeaderVO l = s.findByIdH(id, loginId);
        this.setSessionAttr("lWorklogHeaderVO", l);
        this.renderStr(s.findByIdForJSONH(id,loginId));
    }
    
    @RequestMapping(value = "/updateH.do", method = RequestMethod.POST)
    public void updateH() throws Exception
    { 
        Long id = this.getParaToLong("HEADER_ID");
        WorklogHeaderVO lWorklogHeaderVO = (WorklogHeaderVO)this.getSessionAttr("lWorklogHeaderVO");
        if (lWorklogHeaderVO ==null){
            throw new RuntimeException("更新数据出错:会话数据已经无效!请返回再重新操作!");
        }
        if (!id.equals(lWorklogHeaderVO.getHeaderId())){
            throw new RuntimeException("更新的数据无法匹配!请重新查询!");
        }
        WorklogHeaderVO u =this.getEntity((WorklogHeaderVO) lWorklogHeaderVO.clone(), WorklogHeaderVO.mapCol, "");
        u.setWho(u, "UPDATE", userId, loginId);
        this.renderStr(s.updateH(lWorklogHeaderVO, u,loginId).toJsonStr());
    }
    
    public static void main(String[] args) {
        //Server.start("WebRoot", 8080, "/XYG_WEBDEV_SAMPLE", 5,"D:\\JSP_MyEclipse\\CDN\\image","/image");
        Server.start("WebRoot", 8080, "/XYG_WEBDEV_SAMPLE", 5);
    }
}