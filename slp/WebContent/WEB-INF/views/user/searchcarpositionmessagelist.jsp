<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="item" items="${list}" varStatus="status" >
		<tr>
			<td>${status.index+1}</td>
			<td>${item.username}</td>
			<td>${item.unit}单元</td>
			<td>${item.carpositioncode}号车位</td>
			<td>${item.positionprice}元/月</td>
			<td style="color:red">
				<c:if test="${item.carpositionstatus==1}">
					租用中
				</c:if>
			</td>
			<td>${item.addtime}</td>
            <td>
              <a title="释放车位" onclick="member_del('${item.carpositionid}')" href="javascript:;">
                <i class="layui-icon">&#x1007;</i>退车位
              </a>
              </td>
    </tr>          
</c:forEach>
