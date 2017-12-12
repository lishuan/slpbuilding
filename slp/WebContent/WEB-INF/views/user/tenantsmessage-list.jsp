<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/admin/head.html"%>
   <title>欢迎页面-X-admin2.0</title>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
	    var totalcount;
	    var page=1;
	    var pagesize=9;
        $(document).ready(function () {
            GetTotalCount();
        });

	function GetTotalCount() {
		var data = "";
		$.ajax({
			url : "../tenantsmessage/searchlisttenantsmessagecount.do",
			cache : false,
			type : 'POST',
			dataType : "json",
			data : {
				page: page,
	             pagesize:pagesize,
					username:$("#username").val(),
					idcode:$("#idcode").val(),
					addtime:$("#addtime").val(),
					unit:$("#unit").val(),
					homecode:$("#homecode").val(),
					floors:$("#floors").val(),
					tel:$("#tel").val()
			},
			success : function(data) {
				totalcount = data;
				page = 1;
				SearchBtn(page);
				
			},
			error : function(data) {
				alert(data.responseText);
			}
		});

	}

	function SearchBtn(cpage) {
		page = cpage;
		var data = "";
		$.ajax({
			url : "../tenantsmessage/searchlisttenantsmessage.do",
			cache : false,
			type : 'POST',
			dataType : "html",
			data : {
				page : page,
				pagesize : pagesize,
				username:$("#username").val(),
				idcode:$("#idcode").val(),
				addtime:$("#addtime").val(),
				unit:$("#unit").val(),
				homecode:$("#homecode").val(),
				floors:$("#floors").val(),
				tel:$("#tel").val()
			},
			success : function(data) {
				$("#list").html(data);
				$(".x-right").html(GetPageBar(totalcount,page,pagesize));
			},
			error : function(data) {
				alert(data.responseText);
			}
		});

	} 
</script>
</head>
<body>
<div class="x-nav">
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
	    <form class="layui-form layui-col-md12 x-so">
	      <div class="layui-inline">
	        <select name="unit" id="unit"lay-search lay-filter="unit">
	          <option value="">所属单元</option>
	     		<c:forEach var="item" items="${unitlist}">
						<option value="${item.unit}">${item.unit}单元</option>
				</c:forEach>
	        </select>
      	</div>
          <div class="layui-inline">
	        <select name="floors"id="floors"lay-search lay-filter="floors">
	          <option value="">所属楼层</option>
	      
	        </select>
      	</div>
      	<div class="layui-inline">
	        <select name="homecode" id="homecode" lay-search lay-search>
	          <option value="">所属房间</option>
	         
	        </select>
      	</div>
	  </form>
        <div class="layui-form layui-col-md12 x-so">
          <input type="text" id="username"name="username"  placeholder="请输入租客姓名" autocomplete="off" class="layui-input" >
          <input type="text" id="tel"name="tel"  placeholder="请输入租客手机号" autocomplete="off" class="layui-input">
          <input type="text" id="idcode"name="idcode"  placeholder="请输入身份证号" autocomplete="off" class="layui-input">
          <input class="layui-input" placeholder="起租日期" name="end" id="addtime">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach" onclick="GetTotalCount()"><i class="layui-icon">&#xe615;</i></button>
        </div>
      </div>
      
      <table class="layui-table">
        <thead>
          <tr>
            <th>序号</th>
            <th>租客姓名</th>
            <th>所属单元</th>
            <th>所属楼层</th>
            <th>所属房间</th>
            <th>房间类型</th>
            <th>租金</th>
            <th>租赁状态</th>
            <th>联系电话</th>
            <th>起租日期</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody id="list">
          
        </tbody>
      </table>
      <xblock class="xblock">
        
        <span class="x-right" style="line-height:40px;width:40%"></span>
      </xblock>

    </div>
     <script>
     
     layui.use(['form','layer','laydate'], function(){
         $ = layui.jquery;
       var form = layui.form //from表单模块
       ,layer = layui.layer //样式模块
       ,laydate = layui.laydate; //时间模块
       //执行一个laydate实例
       
        //监听单元下拉框变化
        form.on('select(unit)',function(data){
           	    $.post("../housing/getlisthousingfloors.do",{unit: data.value},function(data){
           	    	$("#floors").empty();
           	    	$("#homecode").empty();
           	    		$.each(JSON.parse(data),function(i,v){
           	    			$("#floors").append("<option value='" + v.floors + "'>" + v.floors +"楼"+ "</option>");
           	    			$("#homecode").empty();
           	    		})
           	    		form.render('select');
           	    })
           	   
        });  
        //监听楼层下拉框变化
        form.on('select(floors)',function(data){
           	    $.post("../housing/getlisthousinghome.do?homestatus=1",{unit:$("#unit").val(),floors:$("#floors").val()},function(data){
           	    	$("#homecode").empty();
           	    		$.each(JSON.parse(data),function(i,v){
           	    			$("#homecode").append("<option value='" + v.homecode + "'>" + v.homecode+ "</option>");
           	    			
           	    		})
           	    		form.render('select');
           	    })
           	   
        }); 
        laydate.render({
            elem: '#addtime' //指定元素
        });
      });
      /*退房-修改所租房间状态*/
       function member_del(id){
          layer.confirm('确认要退房吗？',function(index){
              //发异步删除数据
              $.ajax({
	            url:"../tenantsmessage/deltenantsmessage.do",
	            data:{
	            	housingmessageid:id
	            },
	            type:"post",
	            dataType:"json",
	            success:function(data){
	            	if (data == "") {
	            		layer.msg('房间已退!',{icon:1,time:2000});
	            		GetTotalCount();
	                }
	                else {
	                    alert(data);
	                }
	            },
	            error : function(data) {
					alert(data.responseText);
				}
	        });
          });
      } 
    
   </script> 
    	
</body>
</html>