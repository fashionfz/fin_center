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
<legend>上线下线平板</legend>
<form id="frm" action="modifyTabletOnline.do">
tabletId:<input name="tabletId" type="text"/>
<br />
status:<input name="lineStatus" type="text" />
<br />
<input type="button" onclick="postData('#frm','modifyTabletOnline.do?userId=1')" value="submit"/>
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
