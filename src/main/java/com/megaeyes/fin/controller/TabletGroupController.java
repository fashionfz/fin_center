/**  
 * Project Name:fin_center  
 * File Name:TabletGroupController.java  
 * Package Name:com.megaeyes.fin.controller  
 * Date:2014年2月17日下午4:05:30  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/  
  
package com.megaeyes.fin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.megaeyes.fin.common.Constants;
import com.megaeyes.fin.common.Message;
import com.megaeyes.fin.po.TabletGroup;
import com.megaeyes.fin.po.User;
import com.megaeyes.fin.service.TabletGroupService;
import com.megaeyes.fin.utill.XmlUtil;

/**
 *
 * ClassName: TabletGroupController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2014年2月17日 下午4:27:42 <br/>
 *
 * @author dengbin ibcm@qq.com
 * @version
 * @since JDK 1.6
 */
@Controller
public class TabletGroupController {

    /***/
    @Autowired
    private TabletGroupService groupService;
    /**
     * groupService.
     *
     * @return  the groupService
     * @since   JDK 1.6
     */
    public final TabletGroupService getGroupService() {
        return groupService;
    }
    /**
     * groupService.
     *
     * @param   groupService    the groupService to set
     * @since   JDK 1.6
     */
    public final void setGroupService(
            final TabletGroupService groupService) {
        this.groupService = groupService;
    }
    /**
     *
     * getTabletGroup:查询设备组列表. <br/>
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @return tag
     * @throws IOException 
     * @since JDK 1.6
     */
    @RequestMapping("/getTabletGroup")
    public void getTabletGroup(
            @RequestParam(value = "userId", required = true)
            final String userId ,
            final HttpServletResponse response) throws IOException {
        List<TabletGroup> list = groupService.getTabletGroup(userId);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    /**
     *
     * getTabletGroupDetail:查询平板设备详情. <br/>
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param tabletGroupId
     * @return tag
     * @throws IOException 
     * @since JDK 1.6
     */
    @RequestMapping("/getTabletGroupDetail")
    public void getTabletGroupDetail(
            final String userId ,
            final String tabletGroupId ,
            final HttpServletResponse response) throws IOException {
        TabletGroup group =  groupService.
                getTabletGroupDetail(userId, tabletGroupId);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(group);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    /**
     *
     * saveTabletGroup:3.3.3.2  设备组新增修改. <br/>
        <Message>
           <TabletGroup id=”设备组ID” name=””>
                <MboxTablet id=”平板ID”/>
                 ……………
               <User id=”用户ID”/>
                 ……
           </TabletGroup>
        </Message>
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param group
     * @throws IOException 
     * @since JDK 1.6
     */
    @RequestMapping("/saveTabletGroup")
    public void saveTabletGroup(
            @RequestParam(value = "userId" , required = true)
            final String userId ,
            @RequestParam(value = "xml" , required = true)
            final String xml ,
            final HttpServletResponse response) throws IOException {
        TabletGroup group = (TabletGroup)
                XmlUtil.stringToObject(xml, TabletGroup.class);
        groupService.saveTabletGroup(userId, group);
        response.getWriter().write(
                XmlUtil.objectToString(
                        new Message(Constants.RESULT_SUCCESS)));
    }
    /**
     *
     * getSystemUser:查询系统用户. <br/>
     *
     * @author dengbin ibcm@qq.com
     * @param response
     * @throws IOException
     * @since JDK 1.6
     */
    @RequestMapping("/getSystemUser")
    public void getSystemUser(
            @RequestParam(value = "userId" , required = true)
            final String userId ,
            final HttpServletResponse response) throws IOException {
        Message message = new Message(Constants.RESULT_SUCCESS);
        List<User> list = groupService.getSystemUser();
        message.setObject(list);
        response.getWriter().write(
                XmlUtil.objectToString(message));
    }
    /**
     *
     * removeTabletGroup:删除平板设备. <br/>
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param tabletGroupId
     * @param response
     * @throws IOException
     * @since JDK 1.6
     */
    @RequestMapping("/removeTabletGroup")
    public void removeTabletGroup(
            @RequestParam(value = "userId" , required = true)
            final String userId ,
            @RequestParam(value = "tabletGroupId" , required = true)
            final String tabletGroupId ,
            final HttpServletResponse response) throws IOException {
        groupService.removeTabletGroup(userId, tabletGroupId);
        response.getWriter().write(
                XmlUtil.objectToString(
                        new Message(Constants.RESULT_SUCCESS)));
    }
}
