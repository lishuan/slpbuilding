<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
<%@include file="/admin/head.html"%>
<script type="text/javascript">
	    var totalcount;
	    var page=1;
	    var pagesize=5;
        $(document).ready(function () {
            GetTotalCount();
        });

	function GetTotalCount() {
		var data = "";
		$.ajax({
			url : "../register/searchlistregistercount.do",
			cache : false,
			type : 'POST',
			dataType : "json",
			data : {
				page: page,
	             pagesize:pagesize,
				unit:$("#unit").val(),
				floors:$("#floors").val(),
				homecode:$("#homecode").val()
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
			url : "../register/searchlistregister.do",
			cache : false,
			type : 'POST',
			dataType : "html",
			data : {
				page : page,
				pagesize : pagesize,
				unit:$("#unit").val(),
				floors:$("#floors").val(),
				homecode:$("#homecode").val()
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
            <fieldset class="layui-elem-field">
              <legend style="color:red;">最新登记</legend>
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
      	 <button class="layui-btn"  lay-submit="" lay-filter="sreach" ><i class="layui-icon">&#xe615;</i></button>
	  </form>
         
      </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('信息登记','../register/gethousing.do',470,430)"><i class="layui-icon"></i>登记</button>
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
            <th>所属单元</th>
            <th>所属楼层</th>
            <th>所属房间</th>
            <th>联系电话</th>
            <th>登记内容</th>
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
            </fieldset>
        </div>
        <script>
        layui.use(['form','layer','laydate'], function(){
            $ = layui.jquery;
          var form = layui.form //from表单模块
          ,layer = layui.layer //样式模块
          ,laydate = layui.laydate; //时间模块
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
          form.on('submit(sreach)',function(data){
        	  GetTotalCount();
        	  return false;
          });
         
          
        });
        function register_del(id){
            layer.confirm('确认要删除吗？',function(index){
                //发异步删除数据
                $.ajax({
  	            url:"../register/delregister.do",
  	            data:{
  	            	id:id
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
            	            url:"../register/delregister.do",
            	            data:{
            	            	id:d
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