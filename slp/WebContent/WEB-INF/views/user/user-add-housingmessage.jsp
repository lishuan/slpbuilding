<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/admin/head.html"%>
<title>Insert title here</title>
</head>
<body>
<div class="x-body">
        <form class="layui-form">
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>用户姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${item.username}" readonly="readonly">
                  <input id="userid" style="display:none" value="${item.userid}">
              </div>
          </div>
           <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>所属单元
              </label>
              <div class="layui-input-inline" >
                 <select name="contrller" id="unit" lay-filter="unit" >
                 <option value="">请选择所属单元</option>
	              	<c:forEach var="item" items="${unitlist}">
						<option value="${item.unit}">${item.unit}单元</option>
					</c:forEach>
            	</select>
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>所属楼层
              </label>
              <div class="layui-input-inline">
                 <select name="contrller" id="floors" lay-filter="floors">
                 <option value="">请选择所属楼层</option>
	              	<!-- 遍历 -->
            	</select>
              </div>
          </div>
           <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>房间编号
              </label>
              <div class="layui-input-inline">
                  <select name="contrller" id="homecode" lay-filter="homecode" >
                 <option value="">请选择房间编号</option>
	              	<!-- 遍历 -->
            	</select>
            	
              </div>
          </div>
          <div class="layui-form-item" >
              <label class="layui-form-label">
                  <span class="x-red">*</span>房间类型
              </label>
              <div class="layui-input-inline" >
                  <select name="contrller" id="hometype" >
 	              <option>默认</option>
	              
            	</select><div style="color:red">0:单间&nbsp;&nbsp;1:小套&nbsp;&nbsp;2:大套</div>
              </div>
          </div>

          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>房租(元/月)
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="homerent" name="homerent" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" >
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                 	 分配
              </button>
              <a  class="layui-btn" onclick="x_admin_close()">取消</a>
          </div>
          </form>
      </div>
    
    <script>
        
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        //监听单元下拉框变化
          form.on('select(unit)',function(data){
             	    $.post("../housing/getlisthousingfloors.do",{unit: data.value},function(data){
             	    	$("#floors").empty();
             	    		$.each(JSON.parse(data),function(i,v){
             	    			$("#floors").append("<option value='" + v.floors + "'>" + v.floors +"楼"+ "</option>");
             	    			$("#homecode").empty();
             	    			$("#hometype").empty();
             	    		})
             	    		form.render('select');
             	    })
             	   
          });  
          //监听楼层下拉框变化
          form.on('select(floors)',function(data){
             	    $.post("../housing/getlisthousinghome.do",{unit:$("#unit").val(),floors:$("#floors").val()},function(data){
             	    	$("#homecode").empty();
             	    	$("#hometype").empty();
             	    		$.each(JSON.parse(data),function(i,v){
             	    			$("#homecode").append("<option value='" + v.homecode + "'>" + v.homecode+ "</option>");
             	    			$("#hometype").empty();
             	    			
             	    		})
             	    		form.render('select');
             	    })
             	   
          }); 
        //监听房间下拉框变化
          form.on('select(homecode)',function(data){
             	    $.post("../housing/getlisthousinghometype.do",{unit:$("#unit").val(),floors:$("#floors").val(),homecode:$("#homecode").val()},function(data){
             	    	$("#hometype").empty();
             	    		
             	    		$.each(JSON.parse(data),function(i,v){
             	    			$("#hometype").append("<option  value='" + v.hometype + "'>" + v.hometype+ "</option>"
             	    					+"<option id=\"housingmessageid\" style=\"display:none\" value='" + v.id + "'></option>");
             	    			
             	    		})
             	    		form.render('select');
             	    })
             	   
          });  
          //监听提交
          form.on('submit(add)', function(data){
        	  $.post("../tenantsmessage/submittenantsmessage.do",{
        		  userid:$("#userid").val(),
        		  unit:$("#unit").val(),
        		  floors:$("#floors").val(),
        		  homecode:$("#homecode").val(),
        		  homerent:$("#homerent").val(),
        		  housingmessageid:$("#housingmessageid").val()
        	  },function(data){
        		  if(data==""){
        			  layer.alert("分配成功", {icon: 6},function () {
	                        // 获得frame索引
	                        var index = parent.layer.getFrameIndex(window.name);
	                        //关闭当前frame
	                        parent.layer.close(index);
	                    });
        		  }else{
        			  alert(data);
        		  }
        	  });
        	  return false;
          });
        });
        
    </script>
    
</body>
</html>