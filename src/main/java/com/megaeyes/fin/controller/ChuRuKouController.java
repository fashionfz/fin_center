/**
 * Project Name:fin_center
 * File Name:ChuRuKouController.java
 * Package Name:com.megaeyes.fin.controller
 * Date:2014年3月5日下午5:25:09
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
import com.megaeyes.fin.common.Constants;
import com.megaeyes.fin.common.Message;
import com.megaeyes.fin.po.churukou.DetailInfo;
import com.megaeyes.fin.po.churukou.Device;
import com.megaeyes.fin.po.churukou.Door;
import com.megaeyes.fin.po.churukou.Group;
import com.megaeyes.fin.po.churukou.Strategy;
import com.megaeyes.fin.service.ChuRuKouService;
import com.megaeyes.fin.utill.XmlUtil;

/**
 * ClassName:ChuRuKouController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年3月5日 下午5:25:09 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
@Controller
public class ChuRuKouController {
    
    
    @Autowired
    private ChuRuKouService service;

    
    /**
     * service.
     *
     * @return  the service
     * @since   JDK 1.6
     */
    public final ChuRuKouService getService() {
        return service;
    }
    /**
     * service.
     *
     * @param   service    the service to set
     * @since   JDK 1.6
     */
    public final void setService(ChuRuKouService service) {
        this.service = service;
    }
    //2.6.2.3.1 查询指定机构下的所有控制器和门
    /*
     * curOrganId:当前的要查询的机构id
        hasChild:是否包含子查询,0： 不包含，1：包含
        isAssigned:是否已经分配到组，0全部，1未分配，2已分配
        searchName:指定的控制器名称，模糊查询条件，为空时忽略此字段
        
        
        <Message code=“0000”descript=””>
<Device id=”” organId=””  organName=”” name="" deviceNo="" manufacture=”” >
<Door id=”” chanel=”1” name=”门1” status=“0”/>
….
 </Device >
…….. 
 </ message>
        
        code：本次操作的返回码
        descript：返回码描述
        organId:所属父机构id
        organName:所属父机构名称
        name:控制器名称
        deviceNo:控制器id
        manufacture:生产厂商
        status:0离线，1在线门开，2在线门关
        chanel:门通道id

     */
    @RequestMapping("/querySpecialOrganDoors")
    public void querySpecialOrganDoors(String curOrganId,
            String hasChild,String isAssigned,String searchName,HttpServletResponse response) throws IOException {
        
        Message message = new Message(Constants.RESULT_SUCCESS);
        List<Device> list = service.querySpecialOrganDoors(curOrganId, hasChild, isAssigned, searchName);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.2.3.3 查询指定门禁状态以及关联设备
    /*
     * doorId:门id
     * 
     * 
     * <Message code=“0000”descript=””>
<DetailInfo  ip="1.1.1.1" status=””>
<Device name=”” type=””/>
<Device name=”” type=””/>
…….
<DetailInfo> 
 </message>


     * code：本次操作的返回码
        descript：返回码描述
        ip：当前控制器的IP地址
        name：关联设备的名称
        type ：关联设备的类型，目前需要返回摄像头以及摄像头绑定的对讲机
     */
    @RequestMapping("/queryDetailDoorStatus")
    public void queryDetailDoorStatus(String doorId,HttpServletResponse response) throws IOException {
        
        Message message = new Message(Constants.RESULT_SUCCESS);
        DetailInfo info = service.queryDetailDoorStatus(doorId);
        message.setObject(info);
        response.getWriter().write(XmlUtil.objectToString(message));
        
    }
    //2.6.3.2.1 新建&修改控制器组
    /*
     * xml=
     * <Message>
         <Group groupId=”” groupName=”” organId=””>
          <Device id=”” >
           ….
        ….
          <Device id=””>
        </Group>
        </Message>
        
        groupId  等于空时：表示新建；
                        非空时：表示修改组,修改时，先执行清空操作，再添加将xml内的控制器
                        groupName 组名称
                        organId：所属机构ID
                        id：控制器id
           <Message code=“0000”descript=””>
            <GroupId id=”” />
            </Message>
            
            code：本次操作的返回码
            descript：返回码描述
            id:如果是新建，则返回新建的组id
     */
    @RequestMapping("/createOrModifyDoorGroup")
    public void createOrModifyDoorGroup(String xml,
            HttpServletResponse response) throws IOException {
        Group group = (Group) XmlUtil.stringToObject(xml, Group.class);
        service.createOrModifyDoorGroup(group);
        String result = "<Message code='0000' descript='操作成功'><GroupId id='' /></Message>";
        response.getWriter().write(result);
    }
    //2.6.3.2.2 更新组策略应用状态
    /*
     * <Message>
     <Device id=”” isApplyGroupStrategy =””>
         ….
    ….
        <Device id=”” isApplyGroupStrategy =””>
    </Message>
    
    
    <message code=“0000”descript=””>
        </ message>

     */
    @RequestMapping("/UpdateDoorGroupStatus")
    public void UpdateDoorGroupStatus(String xml,HttpServletResponse response) throws IOException {
        List<Object> list = XmlUtil.stringToList(xml, Device.class);
        service.UpdateDoorGroupStatus(list);
        response.getWriter().write(XmlUtil.objectToString(new Message(Constants.RESULT_SUCCESS)));
    }
    //2.6.3.2.3 删除控制器组
    /*
     * <Message code=“0000”descript=””>
        </Message>
     */
    @RequestMapping("/deleteDoorGroup")
    public void deleteDoorGroup(String groupId,
            HttpServletResponse response) throws IOException {
        service.deleteDoorGroup(groupId);
        response.getWriter().write(
                XmlUtil.objectToString(new Message(Constants.RESULT_SUCCESS)));
    }
    //2.6.3.2.4 查询指定机构下的控制器组
    /*
     * curOrganId:当前的要查询的机构id
        hasChild:是否包含子查询,0： 不包含，1：包含
        searchName:指定的控制器组名称，模糊查询条件，为空时忽略此字段
        
        <Message code=“0000”descript=””>
            <Group id=”11” name="控制器组1"/>
            …….. 
             </Message >
     */
    @RequestMapping("/querySpecialDoorGroup")
    public void querySpecialDoorGroup(String curOrganId,String hasChild,
            String searchName,HttpServletResponse response) throws IOException {
        List<Group> list = service.querySpecialDoorGroup(curOrganId, hasChild, searchName);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.3.2.5   查询控制器组下所有的控制器
    /*
     * groupId:要查询的组id
     * <Message code=“0000”descript=””>
            <Device id=”” deviceNo=”” name=”” isApplyGroupStrategy=”” doorAcessIp=””doorAcessPort=””>
               ….
            ….
             <Device id=”” deviceNo=”” name=”” isApplyGroupStrategy=”” doorAcessIp=”” doorAcessPort=””>
            </Message >
            
            code：本次操作的返回码
            descript：返回码描述
            id:控制器id
            deviceNo:控制器编号
            name:控制器名称
            isApplyGroupStrategy:是否已应用了组策略，0：未应用，1：已应用
            doorAcessIp:该控制器的接入IP
            doorAcessPort该控制器的接入端口

     */
    @RequestMapping("/queryGroupForAssignedDevice")
    public void queryGroupForAssignedDevice(
            String groupId,HttpServletResponse response) throws IOException {
        List<Device> list = service.queryGroupForAssignedDevice(groupId);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.3.2.6 查询组策略
    /*
     * groupId:要查询的组id
        controlId:控制器id
        groupId不为空时表示查询的是组策略，组策略只存在1个，每次保存执行覆盖操作
        controlId不为空时表示查询的是指定控制器的策略，策略可以存在多个，每次保存执行增量操作

        Message code=“0000”descript=””>
         <Strategy doorChanel=”” doorDir=”” validateType=”” doorStratyge=”” beginTime=”” endTime=”” cardOfCenter=”” cardOfLocal=”” centerUser=”” />  
        …
        …
        </Message >
            doorChanel:门通道id，单门控制器永远为1，双门通道范围为1,2
            doorDir:应用策略的门方向0：进门，1：出门，2：进门+出门
            validateType:开门验证方式，0：仅本地授权，1：仅中心授权，2：中心，本地都存在
            doorStratyge:开门策略 0：单卡，1：单卡+确认，2：双卡，3：双卡+确认，4：三卡，5：三卡+确认
            beginTime：策略开始时间
            endTime：策略结束时间
            cardOfCenter：需要中心确认的卡，validateType！=0时必填，否则为空，以；分割
            cardOfLocal：本地卡，validateType！=1时必填，否则为空，以；分割
            centerUser：中心确认授权人员，validateType！=0时必填，否则为空，以；分割
     */
    @RequestMapping("/queryGroupStrategy")
    public void queryGroupStrategy(String groupId,
            String controlId,HttpServletResponse response) throws IOException {
        List<Strategy> list = service.queryGroupStrategy(groupId, controlId);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.3.2.7 保存组策略
    /*
     * <Message>
        <Strategy doorChanel=”” doorDir=”” validateType=”” doorStratyge=”” beginTime=”” endTime=”” cardOfCenter=”” cardOfLocal=”” centerUser=”” />
        </Message>

    <message code=“0000”descript=””>
    </ message >
     */
    @RequestMapping("/saveGroupStrategy")
    public void saveGroupStrategy(String groupId,String controlId,
            String xml,HttpServletResponse response) throws IOException {
        Strategy entity = (Strategy) XmlUtil.stringToObject(xml, Strategy.class);
        service.saveGroupStrategy(entity);
        Message message = new Message(Constants.RESULT_SUCCESS);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //锁定与解锁事件
    /*
     * eventId:刷卡事件ID
        lock 0:锁定，1：解锁 
        
        <Message code=“0000”descript=””>
         <Status result=””   />
        </Message >

     */
    @RequestMapping("/LockOrUnLockDoorEvent")
    public void LockOrUnLockDoorEvent(String eventId,
            String lock,HttpServletResponse response) throws IOException {
        service.LockOrUnLockDoorEvent(eventId, lock);
        String result = "<Message code='0000' descript=''><Status result=''/></Message >";
        response.getWriter().write(result);
    }
    //2.6.5.2.1 查询指定机构下所有门禁关联的摄像头
    /*
     * curOrganId:当前的要查询的机构id
        hasChild:是否包含子查询,0： 不包含，1：包含
        searchName:指定的控制器名称，模糊查询条件，为空时忽略此字段

        <Message code=“0000”descript=””>
        <Device id=”” name=”” >
          <Door doorName=”” channel=”” >    
            <Cameral cameralId=”” cameralName=”” dir=””/>
        …
        …
        </Door>
        </Device>
           ….
        ….
         
        </Message >
        
        id:控制器id
            name:控制器名称
            doorName:门名称
            channel：门通道id
            cameralId:摄像头id
            cameralName:摄像头名称
            dir：关联方向，0：进门，1出门


     */
    @RequestMapping("/queryAssociateCameral")
    public void queryAssociateCameral(String curOrganId,String hasChild,
            String searchName,HttpServletResponse response) throws IOException {
        List<Device> list = service.queryAssociateCameral(curOrganId, hasChild, searchName);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.5.2.2 保存门禁关联的摄像头
    /*
     * <Message code=“0000”descript=””>
          <Door id=”” >    
            <Cameral cameralId=”” dir=””/>
        …
        …
        </Door>
           ….
        ….
         
        </ message >
        id:控制器id
        channel：门通道id
        cameralId:摄像头id
        dir：关联方向，0：进门，1出门


    <message code=“0000”descript=””>
    </ message >

     */
    @RequestMapping("/saveAssociateCameral")
    public void saveAssociateCameral(String xml,HttpServletResponse response) throws IOException {
        List<Object> list = XmlUtil.stringToList(xml, Door.class);
        service.saveAssociateCameral(list);
        Message message = new Message(Constants.RESULT_SUCCESS);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
}
