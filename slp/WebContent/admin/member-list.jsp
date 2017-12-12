<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    var pagesize=6;
        $(document).ready(function () {
            GetTotalCount();
        });

	function GetTotalCount() {
		var data = "";
		$.ajax({
			url : "../user/searchlistusercount.do",
			cache : false,
			type : 'POST',
			dataType : "json",
			data : {
				page: page,
	             pagesize:pagesize,
				username:$("#username").val(),
				idcode:$("#idcode").val(),
				addtime:$("#addtime").val()
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
			url : "../user/searchlistuser.do",
			cache : false,
			type : 'POST',
			dataType : "html",
			data : {
				page : page,
				pagesize : pagesize,
				username:$("#username").val(),
				idcode:$("#idcode").val(),
				addtime:$("#addtime").val()
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
        <div class="layui-form layui-col-md12 x-so">
          
          <input type="text" id="username"name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
          <input type="text" id="idcode"name="username"  placeholder="请输入身份证号" autocomplete="off" class="layui-input">
          <input class="layui-input" placeholder="入住日期" name="end" id="addtime">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach" onclick="GetTotalCount()"><i class="layui-icon">&#xe615;</i></button>
        </div>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./member-add.jsp',470,430)"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px;width:40%"></span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <!-- <input type="checkbox" onclick="getAll(this)"/> -->
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>用户姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>手机号码</th>
            <th>身份证</th>
            <th>入住日期</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody id="list">
          
        </tbody>
      </table>
      <div class="page">
        <!-- <div>
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="next" href="">&gt;&gt;</a>
        </div> -->
      </div>

    </div>
    <script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#addtime' //指定元素
        });
      });
      /*用户信息-删除*/
      function member_del(id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $.ajax({
	            url:"../user/deluser.do",
	            data:{
	            	userid:id
	            },
	            type:"post",
	            dataType:"json",
	            success:function(data){
	            	if (data == "") {
	            		layer.msg('已删除!',{icon:1,time:2000});
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
      function delAll () {
        var data = tableCheck.getData();
        if(data==""){
    		layer.msg('请勾选要删除的数据!',{icon:2,time:2000});
    	}else{
    		var d = data.toString();
        layer.confirm('确认要删除吗？',function(index){
        		//一次请求去后面多次执行删除，不能多次请求删除，所以不用each
        		/* $.each(data,function(){ */
            		$.ajax({
        	            url:"../user/deluser.do",
        	            data:{
        	            	userid:d
        	            },
        	            type:"post",
        	            dataType:"json",
        	            success:function(data){
        	            	if (data == "") {
        	            		layer.msg('已删除!',{icon:1,time:2000});
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
            	}) 
       /*  }); */
    	}
      }
    </script>
    	
</body>
</html>