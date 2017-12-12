<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="item" items="${list}" varStatus="status" >
		<tr>
			<td>${status.index+1}</td>
			<td>${item.username}</td>
			<td>${item.unit}单元</td>
			<td>${item.floors}楼</td>
			<td>${item.homecode}</td>
			<td>
				<c:if test="${item.hometype==0}">
					单间
				</c:if>
				<c:if test="${item.hometype==1}">
					小套
				</c:if> 
				<c:if test="${item.hometype==2}">
					大套
				</c:if>  
			</td>
			<td>${item.homerent}元/月</td>
			<td style="color:red">
				<c:if test="${item.homestatus==1}">
					租用中
				</c:if>
			</td>
			<td>${item.tel}</td>
			<td>${item.addtime}</td>
            <td>
              <a title="退房" onclick="member_del('${item.housingmessageid}')" href="javascript:;">
                <i class="layui-icon">&#x1007;</i>退房
              </a>
              </td>
    </tr>          
</c:forEach>
