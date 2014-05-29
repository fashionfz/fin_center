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
<fieldset  width="300px">
<legend>离线认证日志上报</legend>
<form id="frm" action="addTabletEvent.do" style="{width:300px}">
<textarea name="xml" rows="20" cols="100">
<Message>
<TabletEvent id="" tabletId="" number="" tabletName ="" tabletAddress="" beginTime="2014-02-02 00:20:20" 
  endTime="2014-02-02 10:20:20" tabletUsers=""  type="" status="">
  <TabletUser id="" time="2014-02-02 07:20:20"/>
</TabletEvent> 
</Message>
</textarea>
<br />
<input type="button" onclick="postData('#frm','addTabletEvent.do?userId=1')" value="submit"/>
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
