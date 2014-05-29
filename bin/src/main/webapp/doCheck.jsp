<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>

<table width="400px">
<tr>
<td align="center">
<fieldset  width="300px">
<legend>停用启用平板</legend>
<form action="doTabletCheck.do" style="{width:300px}">
tabletEventId:<input name="tabletEventId" type="text"/>
<br />
tabletId:<input name="tabletId" type="text"/>
<br />
brushTime:<input name="brushTime" type="text" />
<br />
tabletUserId:<input name="tabletUserId" type="text" />
<br />
<input type="submit" value="submit"/>
</form>
</fieldset>
</td>
</tr>
</table>
<br />
<br />
<br />
<a href="tablet.jsp">返回</a>
</body>
</html>
