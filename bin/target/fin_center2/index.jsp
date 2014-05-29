<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
      
    <style type="text/css">
    .icon-system{
    background:url('images/weihu.gif') no-repeat center center;
    }
    .icon-user{
    background:url('images/dbrmanage.gif') no-repeat center center;
    }   
    .icon-role{
    background:url('images/addservice.png') no-repeat center center;
    }     
    .icon-device{
    background:url('images/workspace.gif') no-repeat center center;
    }
    .icon-home{
    background:url('images/menu.gif') no-repeat center center;
    } 
    .icon-menu{
    background:url('images/rolemenu.gif') no-repeat center center;
    }   
    .icon-config{
    background:url('images/myconsle.png') no-repeat center center;
    }  
    .icon-licence{
    background:url('images/cc.png') no-repeat center center;
    }    
    .icon-checkreport{
    background:url('images/nn.png') no-repeat center center;
    }   
    .icon-about{
    background:url('images/uu.png') no-repeat center center;
    }   
    .icon-dvr{
    background:url('images/ll.png') no-repeat center center;
    }     
    .icon-group{
    background:url('images/qq.png') no-repeat center center;
    }  
    .icon-log{
    background:url('images/ww.png') no-repeat center center;
    }                       
    </style>      
</head>

<body id="cc" class="easyui-layout">
	<div data-options="region:'north',border:false" style="background:#FFFFFF;padding:0px">
	    <div style="padding:0px;border:1px solid #ddd;margin-top:0px;background:#ffffff">
	        <a href="#" class="easyui-menubutton" data-options="menu:'#mm1',iconCls:'icon-edit'">平板设备功能</a>
	        <a href="#" class="easyui-menubutton" data-options="menu:'#mm3',iconCls:'icon-device'">平板组功能</a>
	        <a href="#" class="easyui-menubutton" data-options="menu:'#mm2',iconCls:'icon-device'">钞箱人员功能</a>
	        <a href="#" class="easyui-menubutton" data-options="menu:'#mm4',iconCls:'icon-system'">交接事件功能</a>
	    </div>
	    <div id="mm1" style="width:150px;">
	        <a id="check_report1" href="javascript:openUrl('getTablet.do?userId=123&xml=1')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-checkreport'">查询平板设备
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	        <a id="check_history1" href="javascript:openUrl('addTablet.jsp')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-checkreport'">注册平板设备
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	        <a id="check_log1" href="javascript:openUrl('modifyTabletStatus.jsp')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-log'">停用启用平板
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	        <div class="menu-sep"></div>
	        <a id="config1" href="javascript:openUrl('modifyLineStatus.jsp')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-config'">上线下线平板
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	        <a id="config1" href="javascript:openUrl('modifyTablet.jsp')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-config'">修改平板设备
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	    </div>
	    <div id="mm3" style="width:150px;">
	        <a id="device1" href="javascript:openUrl('getTabletGroup.do?userId=1')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-dvr'">查询组
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a id="group1" href="javascript:openUrl('groupDetail.jsp')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-group'">组详细
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a id="savegroup" href="javascript:openUrl('saveGroup.jsp')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-group'">保存组
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>            	        
	    </div>	    
	    <div id="mm2" style="width:150px;">
	        <a id="device1" href="javascript:openUrl('device.html')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-dvr'">DVR管理
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a id="group1" href="javascript:openUrl('devicegroup.html')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-group'">设备组管理
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>	
	    </div>
        <div id="mm4" style="width:150px;">
            <a id="sys_user1" href="javascript:openUrl('beginCheck.jsp')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-user'">启动认证
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a id="sys_role1" href="javascript:openUrl('role.html')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-role'">刷指纹
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a id="sys_menu1" href="javascript:openUrl('menu.html')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-menu'">结束认证
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <div class="menu-sep"></div>
            <a id="sys_service1" href="javascript:openUrl('service.html')" class="easyui-linkbutton" data-options="disabled:false,plain:true,iconCls:'icon-menu'">服务管理
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>            
        </div>    
	</div>
	<div id="content" data-options="region:'center',title:'测试区'">
	   <iframe id="center" src="" frameborder="no" width="100%" scrolling="no" 
	   style="margin-top: -4px;"  
	   height="100%"></iframe>
	</div>  
    
</body>
</html>
