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
                 <select name="contrller" id="floors" lay-verify="required">
                 <option value="">请选择所属楼层</option>
	              	<!-- 遍历 -->
            	</select>
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>房间类型
              </label>
              <div class="layui-input-inline">
                 <select name="contrller" id="hometype" lay-verify="required">
	              <option value="">请选择房间类型</option>
	              <option value="0">单间</option>
	              <option value="1">小套</option>
	              <option value="2">大套</option>
            	</select>
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>房间编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="homecode" name="homecode" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">增加</button>
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
             	    $.post("../housing/getlisthousingfloors.do",{unit: data.value},function(data){
             	    	
             	    	if (data.length > 0) {
             	    		$("#floors").empty();
             	    		
             	    		$.each(JSON.parse(data),function(i,v){
             	    			$("#floors").append("<option value='" + v.floors + "'>" + v.floors +"楼"+ "</option>");
             	    			form.render('select');
             	    		})
             	    	}
             	    })
             	   
          });   
          //监听提交
          form.on('submit(add)', function(data){
            $.post('../housingmessage/submithousingmessage.do',{
            	unit:$("#unit").val(),
            	floors:$("#floors").val(),
            	hometype:$("#hometype").val(),
            	homecode:$("#homecode").val()
            },function(data){
                //res就是返回的结果
                if (data == "") {
	                        /* // 获得frame索引
	                        var index = parent.layer.getFrameIndex(window.name);
	                        //关闭当前frame
	                        parent.layer.close(index); */
	            			 layer.confirm('增加成功', {icon: 6, title:'点击确定继续添加'}, function(index){
	            				  //do something
	            				   $("#homecode").val("");
	            				   layer.close(index);
	            			});
	            			
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