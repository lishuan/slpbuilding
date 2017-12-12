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
                  <span class="x-red">*</span>车位代号
              </label>
              <div class="layui-input-inline">
                 <select name="contrller" id="carpositioncode" >
                 <option value="">请选择车位代号</option>
	              	<!-- 遍历 -->
            	</select>
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>价格(元/月)
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="positionprice" name="positionprice" required="" lay-verify="required"
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
             	    $.post("../carposition/getlistcarpositioncode.do",{unit: data.value},function(data){
             	    	$("#carpositioncode").empty();
             	    		$.each(JSON.parse(data),function(i,v){
             	    			$("#carpositioncode").append("<option value='" + v.carpositioncode + "'>" + v.carpositioncode +"号车位"+ "</option>"
             	    					+"<option id=\"carpositionid\" style=\"display:none\"value='" + v.id + "'></option>");
             	    		})
             	    		form.render('select');
             	    })
             	   
          });  
          //监听提交
          form.on('submit(add)', function(data){
        	  $.post("../carpositionmessage/submitcarpositionmessage.do",{
        		  userid:$("#userid").val(),
        		  unit:$("#unit").val(),
        		  carpositionid:$("#carpositionid").val(),
        		  carpositioncode:$("#carpositioncode").val(),
        		  positionprice:$("#positionprice").val()
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