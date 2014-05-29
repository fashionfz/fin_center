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
<form action="saveTabletGroup.do">
userId:<input name="userId" type="text" value="0000000000000000000000000000001" style="{width:200px}"/>
<br />
xml:<textarea name="xml" cols="40" rows="20">
<Message>
  <TabletGroup id="" name="">
     <Tablet id=""/>
     <User id=""/>
  </TabletGroup>
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
</body>
</html>
