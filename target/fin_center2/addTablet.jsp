<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>

<table width="500px">
<tr>
<td align="center">
<fieldset>
<legend>注册平板设备</legend>
<form action="registTablet.do">
userId:<input name="userId" type="text" value="0000000000000000000000000000001" />
<br />
sessionId:<input name="sessionId" type="text"/>
<br />
xml:<textarea name="xml" rows="20" cols="30">
<Message>
<Tablet id="" name="" address="" deviceNumber="" ip="" port="" linkMan="" phone=""/>
</Message>
</textarea>
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
