<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="item" items="${list}" varStatus="status" >
		<tr>
			<td>
			 <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${item.id}'><i class="layui-icon">&#xe605;</i></div>
            </td>
			<td>${item.username}</td>
			<td>${item.unit}</td>
			<td>${item.floors}</td>
			<td>${item.homecode}</td>
			<td>${item.tel}</td>
			<td style="color:red">
				${item.remark}
			</td>
            <td>
              <a title="删除登记信息" onclick="register_del('${item.id}')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
            </td>
    </tr>          
</c:forEach>
<script>
selectaudio();
</script>
