<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/megatools.js"></script>
<body>

<table width="100%">
<tr>
<td align="center">
<fieldset>
<legend>注册平板</legend>
<form id="frm" action="registTablet.do">
<textarea name="xml" rows="20" cols="100">
<Message>
<Tablet id="" name="" address="" deviceNumber="" ip="" port="" linkMan="" phone=""/>
</Message>
</textarea>
<br />
<input type="button" onclick="postData('#frm','registTablet.do?userId=1')" value="submit"/>
</form>
</fieldset>
</td>
</tr>

<tr>
<td align="center">
<fieldset>
<legend>注册结果</legend>
<textarea id="resultXML" rows="20" cols="100"></textarea>
</fieldset>
</td>
</tr>
</table>
</body>
</html>
