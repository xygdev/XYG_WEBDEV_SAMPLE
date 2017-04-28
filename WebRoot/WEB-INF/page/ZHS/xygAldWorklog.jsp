<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" import="java.util.*" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>工作日志管理</title>
    <base href="<%=basePath%>"> 
    <meta http-equiv="content-type" content="text/html;charset=gb2312">
    <link rel="stylesheet" href="plugin/css/font-awesome.min.css">
    <link rel="stylesheet" href="plugin/css/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="plugin/css/public.css">
    <link rel="stylesheet" type="text/css" href="plugin/css/basic/user.css">
    <link rel="stylesheet" href="plugin/css/cutpic.css" type="text/css" /> 
    <script src="plugin/js/webSocket.js"></script>
    <script type="text/javascript" src="plugin/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="plugin/jQuery/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="plugin/css/jquery.datetimepicker.css">
    <script src="plugin/jQuery/jquery.datetimepicker.full.js"></script>
    <script src="plugin/js/xygdev.commons.js"></script>
  </head> 
  <body>
    <div id="container">
      <!-- 数据加载动画 start -->
        <div class="ajax_loading">
        <i class="fa fa-spinner fa-pulse fa-4x" style="color:white"></i>
      </div>
      <!-- 数据加载动画 end -->
    
      <!-- 主表格区域 start -->
      <div class="table">
        <table id="worklogHeader" data-table="worklogHeader">
            <tr>
             <th class="DEPARTMENT_CODE" style="display:none" data-column="db">部门代码</th>
             <th class="DEPARTMENT_DESC" data-column="db">部门名称</th>
     	     <th class="WORK_GROUP" style="display:none" data-column="db">工作组</th>
     	     <th class="WORK_GROUP_DESC" data-column="db">工作组名称</th>
     	     <th class="WORK_ITEM" data-column="db">工作事项</th>
     	     <th class="WORK_REQ_DOCUMENT" data-column="db">工作文档</th>
     	     <th class="WORK_REQUEST_NAME" data-column="db">申请人</th>
     	     <th class="WORK_OWNER_NAME" data-column="db">负责人</th>
     	     <th class="WORK_DATE" data-column="db">工作日期</th>
     	     <th class="DESCRIPTION" data-column="db">描述</th>
     	     <th class="HEADER_ID" style="display:none" data-column="hidden">&nbsp;</th>
              <th class="ACTION" data-column="normal">操作</th>
            </tr>
            <tr>
     	    <td class="DEPARTMENT_CODE" style="display:none" data-column="db"></td>
            <td class="DEPARTMENT_DESC" data-column="db"></td>
     	    <td class="WORK_GROUP" style="display:none" data-column="db"></td>
     	    <td class="WORK_GROUP_DESC" data-column="db"></td>
     	    <td class="WORK_ITEM" data-column="db"></td>
     	    <td class="WORK_REQ_DOCUMENT" data-column="db"></td>
     	    <td class="WORK_REQUEST_NAME" data-column="db"></td>
     	    <td class="WORK_OWNER_NAME" data-column="db"></td>
     	    <td class="WORK_DATE" data-column="db"></td>
     	    <td class="DESCRIPTION" data-column="db"></td>
     	    <td class="HEADER_ID" style="display:none" data-column="hidden">&nbsp;</td>
              <td class="ACTION" data-column="normal">
                 <i class="fa fa-pencil fa-fw update pointer hidden" data-show="true" title="更新" data-reveal-id="ui" data-dismissmodalclass="close-ui-frame" data-crudtype="pre-update" data-preupdateurl="worklog/preUpdateH.do" data-type="update" data-updateparam=["HEADER_ID",".HEADER_ID"]></i>
               </td>
            </tr>
        </table>
      </div>
      <!-- 主表格区域 end -->
   
      <!-- 主表格按钮区域 start -->
      <div class="table_button" id="table" data-table="worklogHeader">
        <div class="setting">
          <i class="fa fa-cog pointer" data-reveal-id="setting" title="表格设置" data-dismissmodalclass="close-setting"></i>
        </div>
        <div class="setting">
          <i class="fa fa-search pointer" data-reveal-id="query" data-key="true" title="条件查询" data-dismissmodalclass="close-query-frame"></i>
        </div>
        <div class="setting">
          <i class="fa fa-user-plus pointer" data-reveal-id="ui" data-key="true" title="新增" data-dismissmodalclass="close-ui-frame" data-crudtype="pre-insert" data-type="insert" data-func="" data-revealfunc="$().afterReveal(); " ></i>
        </div>
        <div class="setting">
          <i id="refresh" class="fa fa-refresh pointer" title="刷新数据" data-pagetype="refresh" data-pageframe="table"></i>
        </div>
        <div id="setting">
          <!-- 设置菜单区域 start -->
          <jsp:include page="./public/setting.jsp" >
            <jsp:param name="rdtable" value="#worklogHeader" />
            <jsp:param name="odtable" value="#worklogHeader" />
            <jsp:param name="pageframe" value="table" />
          </jsp:include>
          <!-- 设置菜单区域 end -->    
        </div>
        <div>
          <!-- 分页按钮区域 start -->
          <jsp:include page="./public/pageArrow.jsp" >
            <jsp:param name="pageframe" value="table" />
            <jsp:param name="func" value="" />
          </jsp:include>
          <!-- 分页按钮区域 end -->
          <input type="hidden" data-type="size" id="page_size" value="10"/>
          <input type="hidden" data-type="number" id="page_no" value="1"/>
          <input type="hidden" data-type="orderby" id="ORDER_BY" value="HEADER_ID"/> 
          <input type="hidden" data-type="cond"/>
          <input type="hidden" data-type="url" value="worklog/getPageH.do"/>
          <input type="hidden" data-type="jsontype" value="table"/> 
        </div>
      </div>
      <!-- 主表格按钮区域 end --> 
   
      <!-- 定义列区域 start --> 
      <jsp:include page="./public/rowdefine.jsp"></jsp:include>
      <!-- 定义列区域 end -->
    
      <!-- 多维排序区域 start -->
      <jsp:include page="./public/orderby.jsp"></jsp:include>
      <!-- 多维排序区域 end -->
   
      <!-- 个人配置区域 start -->
      <jsp:include page="./public/config.jsp"></jsp:include>
      <!-- 个人配置区域 end -->
     
      <!-- lov区域 start -->
      <jsp:include page="./public/lov.jsp"></jsp:include>
      <!-- lov区域 end -->
      
      <!-- 条件查询区域start -->
      <div id="query" class="query_frame">    
        <div class="title pointer"> 
          <span><i class="fa fa-user"></i>&nbsp;查询</span>
        </div>
        <a class="close-query-frame" data-type="close">&#215;</a>
        <div class="line"></div>
        <div class="content">
          <form>
            <label for='WORK_ITEM_Q' class='left mid'>工作事项:</label> 
            <input type='text' id='WORK_ITEM_Q' name='WORK_ITEM_Q' class='left mid' data-modify='true' />        
          	<br style="clear:both"/>
            <label for="START_DATE_F" class="left mid">工作日期:</label>
            <input type="text" id="WORK_DATE_F" name="WORK_DATE_F" class="left long" data-datatype="date" placeholder="起始日期"/>
            <input type="text" id="WORK_DATE_T" name="WORK_DATE_T" class="left long" data-datatype="date" placeholder="截止日期"/>
          </form> 
        </div>
        <div class="foot">     
          <button class="right pointer"  data-buttonframe="table" data-keyup="enter" data-crudtype="query" data-pageframe="query">查询</button>
        </div> 
      </div>
      <!-- 条件查询区域end -->
     
      <!-- 更新/新增区域 start -->
      <div id="ui" class="update_frame" style="height: 530px;width:700px;">    
        <div class="title pointer">     
          <span data-type="update"><i class="fa fa-user fa-1x" aria-hidden="true"></i>&nbsp;更新</span>
          <span data-type="insert"><i class="fa fa-user fa-1x" aria-hidden="true"></i>&nbsp;新增</span>
        </div>
        <a class="close-ui-frame" data-type="close">&#215;</a>
        <div class="line"></div>
        <div class="content">
          <form id="updateData">
            <input type="hidden" id="HEADER_ID"  name="HEADER_ID" data-update="db"/>
            <label for='DEPARTMENT_CODE' class='left'>部门代码</label>
            <select class='left long' id='DEPARTMENT_CODE' name='DEPARTMENT_CODE' data-update="db" required='required' data-notnull="true" data-listurl="list/getDeptCode.do"></select> 
            <label for='WORK_GROUP' class='left'>工作组</label>
            <select class='left long' id='WORK_GROUP' name='WORK_GROUP' data-update="db" required='required' data-notnull="true" data-listurl="list/getWorkGroup.do" data-extparam=["TAG"] data-extparamid=["#DEPARTMENT_CODE"]></select> 
            <br style="clear:both"/>
            <label for="WORK_REQUEST_NAME" class="left">申请人</label> 
            <input type="text" id="WORK_REQUEST_NAME" name="WORK_REQUEST_NAME" data-update="db" class="left short" data-modify="true" required="required" data-pageframe="ui" data-lovbtn="WORK_REQUEST_LOV" data-suffixflag="true" data-param="FULL_NAME"/>
            <input type="hidden" id="WORK_REQUEST_PID" name="WORK_REQUEST_PID" data-update="db"/>
            <input type="button" id="WORK_REQUEST_LOV" class="left button pointer" data-pageframe="lov" data-reveal-id="lov" data-key="true" data-callback="ui" data-bg="lov-modal-bg" data-dismissmodalclass="close-lov" data-lovname="人员查询" data-queryurl="lov/getEmpPage.do" data-jsontype="empLOV" data-defaultquery="true" data-th=["名称","工号","邮件","电话","人员ID"] data-td=["FULL_NAME","EMPLOYEE_NUMBER","EMAIL_ADDRESS","WORK_TELEPHONE","PERSON_ID&none"] data-selectname=["人员名称","人员工号"] data-selectvalue=["FULL_NAME","EMPLOYEE_NUMBER"] data-choose=[".PERSON_ID",".FULL_NAME"] data-recid=["#WORK_REQUEST_PID","#WORK_REQUEST_NAME"] value="···"/>
            <br style="clear:both"/>
            <label for="WORK_OWNER_NAME" class="left">处理人</label> 
            <input type="text" id="WORK_OWNER_NAME" name="WORK_OWNER_NAME" data-update="db" class="left short" data-modify="true" required="required" data-pageframe="ui" data-lovbtn="WORK_OWNER_LOV" data-suffixflag="true" data-param="FULL_NAME"/>
            <input type='hidden' id='WORK_OWNER_PID' name='WORK_OWNER_PID' data-update="db" />
            <input type="button" id="WORK_OWNER_LOV" class="left button pointer" data-pageframe="lov" data-reveal-id="lov" data-key="true" data-callback="ui" data-bg="lov-modal-bg" data-dismissmodalclass="close-lov" data-lovname="人员查询" data-queryurl="lov/getEmpPage.do" data-jsontype="empLOV" data-defaultquery="true" data-th=["名称","工号","邮件","电话","人员ID"] data-td=["FULL_NAME","EMPLOYEE_NUMBER","EMAIL_ADDRESS","WORK_TELEPHONE","PERSON_ID&none"] data-selectname=["人员名称","人员工号"] data-selectvalue=["FULL_NAME","EMPLOYEE_NUMBER"] data-choose=[".PERSON_ID",".FULL_NAME"] data-recid=["#WORK_OWNER_PID","#WORK_OWNER_NAME"] value="···"/>
            <br style="clear:both"/>
            <label for="WORK_DATE" class="left">工作日期</label>
            <input type="text" id="WORK_DATE" name="WORK_DATE" data-update="db" data-datatype="date" class="left"/>
            <br style="clear:both"/>
            <label for="WORK_ITEM" class="left">工作事项</label>
            <textarea type='text' id='WORK_ITEM' name='WORK_ITEM' data-update="db" required='required' class='left'></textarea>
            <br style="clear:both"/>
            <label for="WORK_REQ_DOCUMENT" class="left">需求文档</label>
            <input type="text" id="WORK_REQ_DOCUMENT" name="WORK_REQ_DOCUMENT" data-update="db" class="left"/>
            <br style="clear:both"/>
            <label for="DESCRIPTION" class="left">描述</label>
            <textarea type='textarea' id='DESCRIPTION' name='DESCRIPTION' data-update="db"  class='left'></textarea>
          </form>
        </div>
        <div class="foot">     
          <button class="right update_confirm pointer" data-type="update" data-keyup="enter" data-crudtype="update" data-pageframe="ui" data-updateurl="worklog/updateH.do" data-func="">提交更新</button>
          <button class="right update_confirm pointer" data-type="insert" data-keyup="enter" data-crudtype="insert" data-pageframe="ui" data-inserturl="worklog/insertH.do" data-func="">新增</button>
        </div>    
      </div> 
      <!-- 更新/新增用户区域 end -->
     
      <!-- 用户信息存放区域 start -->
      <input type="hidden" id="USER_ID" value="${USER_ID}"/>  
      <input type="hidden" id="INTERACT_CODE" value="WORKLOGHEADER"/> 
      <!-- 用户信息存放区域 end -->  
    </div>   
    
    <script>     
        $(function() {
            //设置拖拽
            $("#ui").draggable({ handle: ".title"});
            $("#detail").draggable({ handle: ".title"});
            $("#detail_ui").draggable({ handle: ".title"});
            $("#query").draggable({ handle: ".title"});
            
            //初始化CRUD和LOV条件查询
            $().crudListener();    
            $().revealListener();       
            
            //新增的时候执行的代码
            $.fn.afterReveal = function(){
    		    $('#WORK_DATE').val(new Date().format('yyyy-MM-dd hh:mm:ss'));
    		    $('label[for="DEPARTMENT_CODE"]').click();
    		    $().listExtInit();//带有多级联动List的时候必须要用到的初始化！否则新增的时候会有bug。
            }
            
            //默认值
            //$('#START_DATE_F').val(new Date().addMonths(-2).format('yyyy-MM-dd hh:mm:ss'));
            //$('#START_DATE_T').val(new Date().format('yyyy-MM-dd hh:mm:ss'));
            //日期选择
            $('input[data-datatype="date"]').datetimepicker({
                  lang:"ch",           //语言选择中文
                  timepicker:true,    //启用时间选项
                  format:"Y-m-d H:i:s",      //格式化日期
                  step: 30,
                  showOnClick: true
            });
        });
        
        jQuery.json={
            getContent:function(data,JSONtype){  
                if(JSONtype=='table'){
                    var mapRowArray=
                    [
                    ['.HEADER_ID','HEADER_ID']
                    ,['.DEPARTMENT_CODE','DEPARTMENT_CODE']
                    ,['.DEPARTMENT_DESC','DEPARTMENT_DESC']
                    ,['.WORK_GROUP','WORK_GROUP']
                    ,['.WORK_GROUP_DESC','WORK_GROUP_DESC']
                    ,['.WORK_ITEM','WORK_ITEM']
                    ,['.WORK_REQ_DOCUMENT','WORK_REQ_DOCUMENT']
                    ,['.WORK_REQUEST_PID','WORK_REQUEST_PID']
                    ,['.WORK_REQUEST_NAME','WORK_REQUEST_NAME']
                    ,['.WORK_OWNER_PID','WORK_OWNER_PID']
                    ,['.WORK_OWNER_NAME','WORK_OWNER_NAME']
                    ,['.WORK_DATE','WORK_DATE']
                    ,['.DESCRIPTION','DESCRIPTION']
                    ];
                    $().mapContentJson(data,'#worklogHeader',mapRowArray);
                    $().crudListener();
                    $().revealListener(); 
                }else if(JSONtype=='empLOV'){
        	    	var mapRowArray=[
        	    	 'FULL_NAME'
        	    	,'EMPLOYEE_NUMBER'
        	    	,'EMAIL_ADDRESS'
        	    	,'WORK_TELEPHONE'
        	    	,'PERSON_ID'
        	    	];
        	    	$().mapContentJson(data,'.contentbox',mapRowArray);         	    
        	    }
               },    
               getUpdateJSON:function(data){  
                   if(pageframe=='ui'){ 
                    var mapRowArray=
                    [
                    ['#HEADER_ID','HEADER_ID']
                    ,['#DEPARTMENT_CODE','DEPARTMENT_CODE']
                    ,['#DEPARTMENT_DESC','DEPARTMENT_DESC']
                    ,['#WORK_GROUP','WORK_GROUP',function(){$().listCreator($('#WORK_GROUP')[0]);}]
                    ,['#WORK_GROUP_DESC','WORK_GROUP_DESC']
                    ,['#WORK_ITEM','WORK_ITEM']
                    ,['#WORK_REQ_DOCUMENT','WORK_REQ_DOCUMENT']
                    ,['#WORK_REQUEST_PID','WORK_REQUEST_PID']
                    ,['#WORK_REQUEST_NAME','WORK_REQUEST_NAME']
                    ,['#WORK_OWNER_PID','WORK_OWNER_PID']
                    ,['#WORK_OWNER_NAME','WORK_OWNER_NAME']
                    ,['#WORK_DATE','WORK_DATE']
                    ,['#DESCRIPTION','DESCRIPTION']
                    ];
                       $().mapUpdateJson(data,mapRowArray);    
                   }       
               },
               getMSG:function(data){
                   pageMinRow=parseInt(data.pageMinRow);
                pageMaxRow=parseInt(data.pageMaxRow);
                firstPageFlag=data.firstPageFlag;
                lastPageFlag=data.lastPageFlag;
                   totalPages=data.totalPages;
               }
           }
    </script>
    <script type="text/javascript" src="plugin/layer/layer.js"></script>
    <script type="text/javascript" src="plugin/js/data.validate.js"></script>
    <script type="text/javascript" src="plugin/js/jQuery.reveal.js"></script> 
    <script type="text/javascript" src="plugin/js/jQuery.page.js"></script>
    <script type="text/javascript" src="plugin/js/jQuery.lov.js"></script> 
    <script type="text/javascript" src="plugin/js/jQuery.crud.js"></script> 
    <script type="text/javascript" src="plugin/js/jQuery.rowdefine.js"></script>
    <script type="text/javascript" src="plugin/js/jQuery.irr.orderby.js"></script>   
    <script type="text/javascript" src="plugin/js/jQuery.irr.init.js"></script>   
  </body>
</html>