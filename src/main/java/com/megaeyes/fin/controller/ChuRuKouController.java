/**
 * Project Name:fin_center
 * File Name:ChuRuKouController.java
 * Package Name:com.megaeyes.fin.controller
 * Date:2014��3��5������5:25:09
 * Copyright (c) 2014, �Ĵ�����   All Rights Reserved.
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
 * Date:     2014��3��5�� ����5:25:09 <br/>
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
    //2.6.2.3.1 ��ѯָ�������µ����п���������
    /*
     * curOrganId:��ǰ��Ҫ��ѯ�Ļ���id
        hasChild:�Ƿ�����Ӳ�ѯ,0�� ��������1������
        isAssigned:�Ƿ��Ѿ����䵽�飬0ȫ����1δ���䣬2�ѷ���
        searchName:ָ���Ŀ��������ƣ�ģ����ѯ������Ϊ��ʱ���Դ��ֶ�
        
        
        <Message code=��0000��descript=����>
<Device id=���� organId=����  organName=���� name="" deviceNo="" manufacture=���� >
<Door id=���� chanel=��1�� name=����1�� status=��0��/>
��.
 </Device >
����.. 
 </ message>
        
        code�����β����ķ�����
        descript������������
        organId:����������id
        organName:��������������
        name:����������
        deviceNo:������id
        manufacture:��������
        status:0���ߣ�1�����ſ���2�����Ź�
        chanel:��ͨ��id

     */
    @RequestMapping("/querySpecialOrganDoors")
    public void querySpecialOrganDoors(String curOrganId,
            String hasChild,String isAssigned,String searchName,HttpServletResponse response) throws IOException {
        
        Message message = new Message(Constants.RESULT_SUCCESS);
        List<Device> list = service.querySpecialOrganDoors(curOrganId, hasChild, isAssigned, searchName);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.2.3.3 ��ѯָ���Ž�״̬�Լ������豸
    /*
     * doorId:��id
     * 
     * 
     * <Message code=��0000��descript=����>
<DetailInfo  ip="1.1.1.1" status=����>
<Device name=���� type=����/>
<Device name=���� type=����/>
����.
<DetailInfo> 
 </message>


     * code�����β����ķ�����
        descript������������
        ip����ǰ��������IP��ַ
        name�������豸������
        type �������豸�����ͣ�Ŀǰ��Ҫ��������ͷ�Լ�����ͷ�󶨵ĶԽ���
     */
    @RequestMapping("/queryDetailDoorStatus")
    public void queryDetailDoorStatus(String doorId,HttpServletResponse response) throws IOException {
        
        Message message = new Message(Constants.RESULT_SUCCESS);
        DetailInfo info = service.queryDetailDoorStatus(doorId);
        message.setObject(info);
        response.getWriter().write(XmlUtil.objectToString(message));
        
    }
    //2.6.3.2.1 �½�&�޸Ŀ�������
    /*
     * xml=
     * <Message>
         <Group groupId=���� groupName=���� organId=����>
          <Device id=���� >
           ��.
        ��.
          <Device id=����>
        </Group>
        </Message>
        
        groupId  ���ڿ�ʱ����ʾ�½���
                        �ǿ�ʱ����ʾ�޸���,�޸�ʱ����ִ����ղ���������ӽ�xml�ڵĿ�����
                        groupName ������
                        organId����������ID
                        id��������id
           <Message code=��0000��descript=����>
            <GroupId id=���� />
            </Message>
            
            code�����β����ķ�����
            descript������������
            id:������½����򷵻��½�����id
     */
    @RequestMapping("/createOrModifyDoorGroup")
    public void createOrModifyDoorGroup(String xml,
            HttpServletResponse response) throws IOException {
        Group group = (Group) XmlUtil.stringToObject(xml, Group.class);
        service.createOrModifyDoorGroup(group);
        String result = "<Message code='0000' descript='�����ɹ�'><GroupId id='' /></Message>";
        response.getWriter().write(result);
    }
    //2.6.3.2.2 ���������Ӧ��״̬
    /*
     * <Message>
     <Device id=���� isApplyGroupStrategy =����>
         ��.
    ��.
        <Device id=���� isApplyGroupStrategy =����>
    </Message>
    
    
    <message code=��0000��descript=����>
        </ message>

     */
    @RequestMapping("/UpdateDoorGroupStatus")
    public void UpdateDoorGroupStatus(String xml,HttpServletResponse response) throws IOException {
        List<Object> list = XmlUtil.stringToList(xml, Device.class);
        service.UpdateDoorGroupStatus(list);
        response.getWriter().write(XmlUtil.objectToString(new Message(Constants.RESULT_SUCCESS)));
    }
    //2.6.3.2.3 ɾ����������
    /*
     * <Message code=��0000��descript=����>
        </Message>
     */
    @RequestMapping("/deleteDoorGroup")
    public void deleteDoorGroup(String groupId,
            HttpServletResponse response) throws IOException {
        service.deleteDoorGroup(groupId);
        response.getWriter().write(
                XmlUtil.objectToString(new Message(Constants.RESULT_SUCCESS)));
    }
    //2.6.3.2.4 ��ѯָ�������µĿ�������
    /*
     * curOrganId:��ǰ��Ҫ��ѯ�Ļ���id
        hasChild:�Ƿ�����Ӳ�ѯ,0�� ��������1������
        searchName:ָ���Ŀ����������ƣ�ģ����ѯ������Ϊ��ʱ���Դ��ֶ�
        
        <Message code=��0000��descript=����>
            <Group id=��11�� name="��������1"/>
            ����.. 
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
    //2.6.3.2.5   ��ѯ�������������еĿ�����
    /*
     * groupId:Ҫ��ѯ����id
     * <Message code=��0000��descript=����>
            <Device id=���� deviceNo=���� name=���� isApplyGroupStrategy=���� doorAcessIp=����doorAcessPort=����>
               ��.
            ��.
             <Device id=���� deviceNo=���� name=���� isApplyGroupStrategy=���� doorAcessIp=���� doorAcessPort=����>
            </Message >
            
            code�����β����ķ�����
            descript������������
            id:������id
            deviceNo:���������
            name:����������
            isApplyGroupStrategy:�Ƿ���Ӧ��������ԣ�0��δӦ�ã�1����Ӧ��
            doorAcessIp:�ÿ������Ľ���IP
            doorAcessPort�ÿ������Ľ���˿�

     */
    @RequestMapping("/queryGroupForAssignedDevice")
    public void queryGroupForAssignedDevice(
            String groupId,HttpServletResponse response) throws IOException {
        List<Device> list = service.queryGroupForAssignedDevice(groupId);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.3.2.6 ��ѯ�����
    /*
     * groupId:Ҫ��ѯ����id
        controlId:������id
        groupId��Ϊ��ʱ��ʾ��ѯ��������ԣ������ֻ����1����ÿ�α���ִ�и��ǲ���
        controlId��Ϊ��ʱ��ʾ��ѯ����ָ���������Ĳ��ԣ����Կ��Դ��ڶ����ÿ�α���ִ����������

        Message code=��0000��descript=����>
         <Strategy doorChanel=���� doorDir=���� validateType=���� doorStratyge=���� beginTime=���� endTime=���� cardOfCenter=���� cardOfLocal=���� centerUser=���� />  
        ��
        ��
        </Message >
            doorChanel:��ͨ��id�����ſ�������ԶΪ1��˫��ͨ����ΧΪ1,2
            doorDir:Ӧ�ò��Ե��ŷ���0�����ţ�1�����ţ�2������+����
            validateType:������֤��ʽ��0����������Ȩ��1����������Ȩ��2�����ģ����ض�����
            doorStratyge:���Ų��� 0��������1������+ȷ�ϣ�2��˫����3��˫��+ȷ�ϣ�4��������5������+ȷ��
            beginTime�����Կ�ʼʱ��
            endTime�����Խ���ʱ��
            cardOfCenter����Ҫ����ȷ�ϵĿ���validateType��=0ʱ�������Ϊ�գ��ԣ��ָ�
            cardOfLocal�����ؿ���validateType��=1ʱ�������Ϊ�գ��ԣ��ָ�
            centerUser������ȷ����Ȩ��Ա��validateType��=0ʱ�������Ϊ�գ��ԣ��ָ�
     */
    @RequestMapping("/queryGroupStrategy")
    public void queryGroupStrategy(String groupId,
            String controlId,HttpServletResponse response) throws IOException {
        List<Strategy> list = service.queryGroupStrategy(groupId, controlId);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.3.2.7 ���������
    /*
     * <Message>
        <Strategy doorChanel=���� doorDir=���� validateType=���� doorStratyge=���� beginTime=���� endTime=���� cardOfCenter=���� cardOfLocal=���� centerUser=���� />
        </Message>

    <message code=��0000��descript=����>
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
    //����������¼�
    /*
     * eventId:ˢ���¼�ID
        lock 0:������1������ 
        
        <Message code=��0000��descript=����>
         <Status result=����   />
        </Message >

     */
    @RequestMapping("/LockOrUnLockDoorEvent")
    public void LockOrUnLockDoorEvent(String eventId,
            String lock,HttpServletResponse response) throws IOException {
        service.LockOrUnLockDoorEvent(eventId, lock);
        String result = "<Message code='0000' descript=''><Status result=''/></Message >";
        response.getWriter().write(result);
    }
    //2.6.5.2.1 ��ѯָ�������������Ž�����������ͷ
    /*
     * curOrganId:��ǰ��Ҫ��ѯ�Ļ���id
        hasChild:�Ƿ�����Ӳ�ѯ,0�� ��������1������
        searchName:ָ���Ŀ��������ƣ�ģ����ѯ������Ϊ��ʱ���Դ��ֶ�

        <Message code=��0000��descript=����>
        <Device id=���� name=���� >
          <Door doorName=���� channel=���� >    
            <Cameral cameralId=���� cameralName=���� dir=����/>
        ��
        ��
        </Door>
        </Device>
           ��.
        ��.
         
        </Message >
        
        id:������id
            name:����������
            doorName:������
            channel����ͨ��id
            cameralId:����ͷid
            cameralName:����ͷ����
            dir����������0�����ţ�1����


     */
    @RequestMapping("/queryAssociateCameral")
    public void queryAssociateCameral(String curOrganId,String hasChild,
            String searchName,HttpServletResponse response) throws IOException {
        List<Device> list = service.queryAssociateCameral(curOrganId, hasChild, searchName);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    //2.6.5.2.2 �����Ž�����������ͷ
    /*
     * <Message code=��0000��descript=����>
          <Door id=���� >    
            <Cameral cameralId=���� dir=����/>
        ��
        ��
        </Door>
           ��.
        ��.
         
        </ message >
        id:������id
        channel����ͨ��id
        cameralId:����ͷid
        dir����������0�����ţ�1����


    <message code=��0000��descript=����>
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
