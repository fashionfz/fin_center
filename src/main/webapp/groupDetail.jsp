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
<fieldset>
<legend>停用启用平板</legend>
<form action="getTabletGroupDetail.do">
userId:<input name="userId" type="text" value="0000000000000000000000000000001" style="{width:200px}"/>
<br />
tabletGroupId:<input name="tabletGroupId" type="text" style="{width:200px}"/>
<br />
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
</body>
</html>
