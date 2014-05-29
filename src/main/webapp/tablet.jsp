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
<legend>平板设备功能</legend>
<ul>
<li><a href="getTablet.do?userId=123&userId=1">查询平板设备</a></li>
<br />
<li><a href="addTablet.jsp">注册平板设备</a></li>
<br />
<li><a href="modifyTabletStatus.jsp">停用启用平板</a></li>
<br />
<li><a href="modifyLineStatus.jsp">上线下线平板</a></li>
<br />
<li><a href="modifyTablet.jsp">修改平板设备</a></li>
<br />
<li><a href="getCamaraByTabletId.do?tabletId=1&userId=1">查询管理摄像头</a></li>
</ul>
</fieldset> 
</td>
</tr>
</table>
<br />
<br />
<br />
<a href="index.jsp">返回</a>
</body>
</html>
