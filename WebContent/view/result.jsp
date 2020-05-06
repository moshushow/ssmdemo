<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.zhangb.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.td td{
		width: 100px;
	}
	.table{
		text-align: center;
		margin: 0 auto;
	}
</style>
</head>
<body>
<%
	Protocol pt = ((Protocol)request.getAttribute("ps"));
%>
 
	<table class="table">
		<tr class="td">
			<td>ID</td>
			<td>编码</td>
			<td>名称</td>
			<td style="width: 200px">描述</td>
		</tr>
<%if(pt!=null){%>
		<tr class="td">
			<td><%=pt.getId()%></td>
			<td><%=pt.getCode()%></td>
			<td><%=pt.getName()%></td>
			<td><%=pt.getDescription()%></td>
		</tr>
	<%}else{ %>
		<tr class="td">
			<td style="color: red;">暂无相关数据!</td>
		</tr>
<%} %>
	</table>
 
</body>
</html>
