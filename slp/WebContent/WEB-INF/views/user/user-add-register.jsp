<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/admin/head.html"%>
 
</head>
<body>
<div class="x-body">
        <form class="layui-form">
           <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>所属单元
              </label>
              <div class="layui-input-inline" >
                 <select name="contrller" id="unit" lay-filter="unit" lay-verify="required">
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
                 <select name="contrller" id="floors" lay-filter="floors" lay-verify="required">
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
                 <select name="contrller" id="homecode" lay-filter="homecode" lay-verify="required">
                 <option value="">请选择房间编号</option>
	              	<!-- 遍历 -->
            	</select>
            	
              </div>
          </div>
          <div class="layui-form-item" style="display:none;">
              <div class="layui-input-inline" id="username">
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>登记内容
              </label>
    		<div class="layui-input-block">
      			<textarea id="remark" placeholder="请输入登记信息" class="layui-textarea" lay-verify="required"></textarea>
    		</div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                 	 登记
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
             	    		})
             	    		form.render('select');
             	    })
             	   
          });  
          //监听楼层下拉框变化
          form.on('select(floors)',function(data){
             	    $.post("../housing/getlisthousinghome.do?homestatus=1",{unit:$("#unit").val(),floors:$("#floors").val()},function(data){
             	    	$("#homecode").empty();
             	    	$("#hometype").empty();
             	    		$.each(JSON.parse(data),function(i,v){
             	    			$("#homecode").append("<option value='" + v.homecode + "'>" + v.homecode+ "</option>");
             	    			
             	    		})
             	    		form.render('select');
             	    })
             	   
          }); 
          //监听房间下拉框变化
          form.on('select(homecode)',function(data){
             	    $.post("../tenantsmessage/getlisttenantsmessageuserid.do",{
             	    	unit:$("#unit").val(),
             	    	floors:$("#floors").val(),
             	    	homecode:$("#homecode").val()
             	    },function(data){
             	    	$.each(JSON.parse(data),function(i,v){
             	    		$("#username").append("<input id=\"userid\"  value='" + v.userid + "'/>");
             	    	})
             	    })
             	   
          });  
          //监听提交
          form.on('submit(add)', function(data){
        	  $.post("../register/submitregister.do",{
        		  userid:$("#userid").val(),
        		  unit:$("#unit").val(),
        		  floors:$("#floors").val(),
        		  homecode:$("#homecode").val(),
        		  remark:$("#remark").val()
        	  },function(data){
        		  if(data==""){
        			  layer.alert("登记成功", {icon: 6},function () {
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