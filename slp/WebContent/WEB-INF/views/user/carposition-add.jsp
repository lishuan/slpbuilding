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
                  <span class="x-red">*</span>所属单元
              </label>
              <div class="layui-input-inline" id="maxcarpositioncode" >
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
                  <span class="x-red">*</span>车位数量
              </label>
              <div class="layui-input-inline" >
                <input type="text" id="carpositionsum"name="carpositionsum"  placeholder="请输入车位数量" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="add">增加</button>
              <a  class="layui-btn" onclick="x_admin_close()">取消</a>
          </div>
          </form>
      </div>
    
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form,layer = layui.layer;
          //监听下拉框变化
          form.on('select(unit)',function(data){
             	    $.post("../carposition/getmaxcarpositioncode.do",{unit: data.value},function(data){
             	    	
             	    	if (data.length > 0) {
             	    		
             	    		$.each(JSON.parse(data),function(i,v){
             	    			$("#maxcarpositioncode").append("<input id=\"sumcode\" style=\"display:none\" value='" + v.maxcarpositioncode + "'></option>");
             	    		})
             	    	}
             	    })
             	   
          });   
          //监听提交
          form.on('submit(add)', function(data){
            $.post('../carposition/submitcarposition.do',{
            	unit:$("#unit").val(),
            	maxcarpositioncode:$("#sumcode").val(),
            	carpositionsum:$("#carpositionsum").val()
            },function(data){
                //res就是返回的结果
                if (data == "") {
                	layer.alert("增加成功", {icon: 6},function () {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                    });
	            			/*  layer.confirm('增加成功', {icon: 6, title:'点击确定继续添加'}, function(index){
	            				  //do something
	            				   $("#carpositionsum").val("");
	            				   layer.close(index);
	            			}); */
	            			
	                }
	                else {
	                    alert(data);
	                }
       		});
       		return false;
          }); 
        });
    </script>
    
</body>
</html>