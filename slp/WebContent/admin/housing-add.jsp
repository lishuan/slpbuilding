<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                  <span class="x-red">*</span>单元
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="unit" name="unit" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>总楼层数
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="floors" name="floors" required="" lay-verify="required"
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
          var form = layui.form
          ,layer = layui.layer;

          //监听提交
          form.on('submit(add)', function(data){
            $.post('../housing/submithousing.do',{
            	unit:$("#unit").val(),
            	floors:$("#floors").val()
            },function(data){
                //res就是返回的结果
                if (data == "") {
	            		layer.alert("增加成功", {icon: 6},function () {
	                        // 获得frame索引
	                        var index = parent.layer.getFrameIndex(window.name);
	                        //关闭当前frame
	                        parent.layer.close(index);
	                    });
	                }
	                else {
	                    alert(data);
	                    $("#unit").val("");
	                    $("#floors").val("");
	                }
       		});
       		return false;
          });
        });
    </script>
    
</body>
</html>