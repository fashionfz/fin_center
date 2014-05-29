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
<form action="modifyTabletStatus.do" style="{width:300px}">
userId:<input name="userId" type="text" value="0000000000000000000000000000001" style="{width:300px}"/>
<br />
tabletId:<input name="tabletId" type="text"/>
<br />
status:<input name="status" type="text" />
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
