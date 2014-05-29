<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<script type="text/javascript" src="js/megatools.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<body>

<table width="400px">
<tr>
<td align="center">
<fieldset  width="300px">
<legend>停用启用平板</legend>
<form id="frm">
tabletEventId:<input name="tabletEventId" type="text"/>
<br />
PadWorkID:<input name="PadWorkID" type="text"/>
<br />
beginTime:<input name="beginTime" type="text" />
<br />
<input type="button" onclick="postData('#frm','beginTabletCheck.do?userId=1')" value="submit"/>
</form>
</fieldset>
</td>
</tr>

<tr>
<td align="center">
<fieldset>
<legend>查询结果</legend>
<textarea id="resultXML" rows="20" cols="100"></textarea>
</fieldset>
</td>
</tr>

</table>
</body>
</html>
