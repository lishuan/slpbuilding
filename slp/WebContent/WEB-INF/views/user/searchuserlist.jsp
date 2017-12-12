<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="item" items="${list}" varStatus="status" >
		<tr>
			<td>
			 <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${item.userid}'><i class="layui-icon">&#xe605;</i></div>
            </td>
			<td>${item.username}</td>
			<td>${item.age}</td>
			<td>
				<c:if test="${item.sex==0}">
					男
				</c:if> 
				<c:if test="${item.sex==1}">
					女
				</c:if>
			</td>
			<td>${item.tel}</td>
			<td>${item.idcode}</td>
			<td>${item.addtime}</td>
            <td>
            <a title="分配住房"  onclick="x_admin_show('分配住房','../user/getusername.do?userid=${item.userid }',470,500)" href="javascript:;">
                <i class="layui-icon">&#xe68e;</i>
              </a>
              <a title="分配车位"  onclick="x_admin_show('分配车位','../user/getusername.do?userid=${item.userid }&carposition=carposition',470,400)" href="javascript:;">
                <i class="layui-icon">&#xe628;</i>
              </a>
              <a title="删除用户信息" onclick="member_del('${item.userid}')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
              </td>
    </tr>          
</c:forEach>
<script>
selectaudio();
</script>
