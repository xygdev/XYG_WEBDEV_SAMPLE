
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" import="java.util.*" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>XYG_ALD_DEPT_V</title>
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
        <table id="dept" data-table="dept">
            <tr>
              <th class="DEPT_ID" data-column="db">DEPT_ID</th>
              <th class="DEPT_CODE" data-column="db">部门代码</th>
              <th class="DEPT_NAME" data-column="db">DEPT_NAME</th>
              <th class="DEPT_TYPE_CODE" data-column="db">DEPT_TYPE_CODE</th>
              <th class="DEPT_TYPE_DESC" data-column="db">DEPT_TYPE_DESC</th>
              <th class="ENABLE_DATE" data-column="db">ENABLE_DATE</th>
              <th class="DISABLED_DATE" data-column="db">DISABLED_DATE</th>
              <th class="REMARK" data-column="db">REMARK</th>
              <th class="ACTION" data-column="normal">操作</th>
            </tr>
            <tr>
              <td class="DEPT_ID" data-column="db"></td>
              <td class="DEPT_CODE" data-column="db"></td>
              <td class="DEPT_NAME" data-column="db"></td>
              <td class="DEPT_TYPE_CODE" data-column="db"></td>
              <td class="DEPT_TYPE_DESC" data-column="db"></td>
              <td class="ENABLE_DATE" data-column="db"></td>
              <td class="DISABLED_DATE" data-column="db"></td>
              <td class="REMARK" data-column="db"></td>
              <td class="ACTION" data-column="normal">
                 <i class="fa fa-pencil fa-fw update pointer hidden" data-show="true" title="更新" data-reveal-id="ui" data-dismissmodalclass="close-ui-frame" data-crudtype="pre-update" data-preupdateurl="dept/preUpdate.do" data-type="update" data-updateparam=["DEPT_ID",".DEPT_ID"]></i>
               </td>
            </tr>
        </table>
      </div>
      <!-- 主表格区域 end -->
   
      <!-- 主表格按钮区域 start -->
      <div class="table_button" id="table" data-table="dept">
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
            <jsp:param name="rdtable" value="#dept" />
            <jsp:param name="odtable" value="#dept" />
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
          <input type="hidden" data-type="orderby" id="ORDER_BY" value="DEPT_ID"/> 
          <input type="hidden" data-type="cond"/>
          <input type="hidden" data-type="url" value="dept/getPage.do"/>
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
            <label for="DEPT_NAME_Q" class="left mid">字符查询(样例):</label> 
            <input type="text" id="DEPT_NAME_Q" name="DEPT_NAME" class="left mid" data-modify="true" />    
              <br style="clear:both"/>
            <label for="ENABLE_DATE_F" class="left mid">日期查询(样例):</label>
            <input type="text" id="ENABLE_DATE_F" name="ENABLE_DATE_F" class="left long" data-datatype="date" placeholder="起始日期"/>
            <input type="text" id="ENABLE_DATE_T" name="ENABLE_DATE_T" class="left long" data-datatype="date" placeholder="截止日期"/>
          </form> 
        </div>
        <div class="foot">     
          <button class="right pointer"  data-buttonframe="table" data-keyup="enter" data-crudtype="query" data-pageframe="query">查询</button>
        </div> 
      </div>
      <!-- 条件查询区域end -->
     
      <!-- 更新/新增区域 start -->
      <div id="ui" class="update_frame" style="height: 380px;width:700px;">    
        <div class="title pointer">     
          <span data-type="update"><i class="fa fa-user fa-1x" aria-hidden="true"></i>&nbsp;更新</span>
          <span data-type="insert"><i class="fa fa-user fa-1x" aria-hidden="true"></i>&nbsp;新增</span>
        </div>
        <a class="close-ui-frame" data-type="close">&#215;</a>
        <div class="line"></div>
        <div class="content">
          <form id="updateData">
            <input type="hidden" id="DEPT_ID"  name="DEPT_ID" data-update="db"/>
            <label for="DEPT_CODE" class="left">部门代码</label>
            <input type="text" id="DEPT_CODE" name="DEPT_CODE" data-update="db" required="required" class="left"/>
            <br style="clear:both"/>
            <label for="DEPT_NAME" class="left">DEPT_NAME</label>
            <input type="text" id="DEPT_NAME" name="DEPT_NAME" data-update="db" required="required" class="left"/>
            <br style="clear:both"/>
            <label for="DEPT_TYPE_CODE" class="left">DEPT_TYPE_CODE</label>
            <input type="text" id="DEPT_TYPE_CODE" name="DEPT_TYPE_CODE" data-update="db" required="required" class="left"/>
            <label for="DEPT_TYPE_DESC" class="left">DEPT_TYPE_DESC</label>
            <input type="text" id="DEPT_TYPE_DESC" name="DEPT_TYPE_DESC" data-update="db" class="left"/>
            <br style="clear:both"/>
            <label for="ENABLE_DATE" class="left">ENABLE_DATE</label>
            <input type="text" id="ENABLE_DATE" name="ENABLE_DATE" data-update="db" data-datatype="date"  required="required" class="left"/>
            <br style="clear:both"/>
            <label for="DISABLED_DATE" class="left">DISABLED_DATE</label>
            <input type="text" id="DISABLED_DATE" name="DISABLED_DATE" data-update="db" data-datatype="date" class="left"/>
            <br style="clear:both"/>
            <label for="REMARK" class="left">REMARK</label>
            <input type="text" id="REMARK" name="REMARK" data-update="db" class="left"/>
            <br style="clear:both"/>
          </form>
        </div>
        <div class="foot">     
          <button class="right update_confirm pointer" data-type="update" data-keyup="enter" data-crudtype="update" data-pageframe="ui" data-updateurl="dept/update.do" data-func="">提交更新</button>
          <button class="right update_confirm pointer" data-type="insert" data-keyup="enter" data-crudtype="insert" data-pageframe="ui" data-inserturl="dept/insert.do" data-func="">新增</button>
        </div>    
      </div> 
      <!-- 更新/新增用户区域 end -->
     
      <!-- 用户信息存放区域 start -->
      <input type="hidden" id="USER_ID" value="${USER_ID}"/>  
      <input type="hidden" id="INTERACT_CODE" value="DEPT"/> 
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
                //$('#ENABLE_DATE').val(new Date().format('yyyy-MM-dd hh:mm:ss'));
                //$('label[for="DEPT_CODE"]').click();
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
                    ['.DEPT_ID','DEPT_ID']
                    ,['.DEPT_CODE','DEPT_CODE']
                    ,['.DEPT_NAME','DEPT_NAME']
                    ,['.DEPT_TYPE_CODE','DEPT_TYPE_CODE']
                    ,['.DEPT_TYPE_DESC','DEPT_TYPE_DESC']
                    ,['.ENABLE_DATE','ENABLE_DATE']
                    ,['.DISABLED_DATE','DISABLED_DATE']
                    ,['.REMARK','REMARK']
                    ];
                    $().mapContentJson(data,'#dept',mapRowArray);
                    $().crudListener();
                    $().revealListener(); 
                }
               },    
               getUpdateJSON:function(data){  
                   if(pageframe=='ui'){ 
                    var mapRowArray=
                    [
                    ['#DEPT_ID','DEPT_ID']
                    ,['#DEPT_CODE','DEPT_CODE']
                    ,['#DEPT_NAME','DEPT_NAME']
                    ,['#DEPT_TYPE_CODE','DEPT_TYPE_CODE']
                    ,['#DEPT_TYPE_DESC','DEPT_TYPE_DESC']
                    ,['#ENABLE_DATE','ENABLE_DATE']
                    ,['#DISABLED_DATE','DISABLED_DATE']
                    ,['#REMARK','REMARK']
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