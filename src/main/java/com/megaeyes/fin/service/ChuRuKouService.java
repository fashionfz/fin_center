/**
 * Project Name:fin_center
 * File Name:ChuRuKouService.java
 * Package Name:com.megaeyes.fin.service
 * Date:2014��3��5������7:34:47
 * Copyright (c) 2014, �Ĵ�����   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.service;   

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megaeyes.fin.dao.ChuRuKouDAO;
import com.megaeyes.fin.po.churukou.DetailInfo;
import com.megaeyes.fin.po.churukou.Device;
import com.megaeyes.fin.po.churukou.DeviceAndDoor;
import com.megaeyes.fin.po.churukou.Door;
import com.megaeyes.fin.po.churukou.Group;
import com.megaeyes.fin.po.churukou.Strategy;

/**
 * ClassName:ChuRuKouService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014��3��5�� ����7:34:47 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
@Service
@Transactional
public class ChuRuKouService {
    @Autowired
    private ChuRuKouDAO dao;
    /**
     * dao.
     *
     * @return  the dao
     * @since   JDK 1.6
     */
    public final ChuRuKouDAO getDao() {
        return dao;
    }

    /**
     * dao.
     *
     * @param   dao    the dao to set
     * @since   JDK 1.6
     */
    public final void setDao(ChuRuKouDAO dao) {
        this.dao = dao;
    }

    

    /*
     * curOrganId:��ǰ��Ҫ��ѯ�Ļ���id
        hasChild:�Ƿ�����Ӳ�ѯ,0�� ��������1������
        isAssigned:�Ƿ��Ѿ����䵽�飬0ȫ����1δ���䣬2�ѷ���
        searchName:ָ���Ŀ��������ƣ�ģ����ѯ������Ϊ��ʱ���Դ��ֶ�

     * <Device id=���� organId=����  organName=���� name="" deviceNo="" manufacture=���� >
            <Door id=���� chanel=��1�� name=����1�� status=��0��/>
            ....
        </Device >
     */
    @Transactional
    public List<Device> querySpecialOrganDoors(String curOrganId,
            String hasChild,String isAssigned,String searchName){
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("curOrganId", curOrganId);
        map.put("hasChild", hasChild);
        map.put("isAssigned", isAssigned);
        map.put("searchName", searchName);
        List<DeviceAndDoor> list = dao.querySpecialOrganDoors(map);
        
        Map<String , Device> map2 = new HashMap<String , Device>();
        for(DeviceAndDoor entity : list) {
            if(map2.containsKey(entity.getDeviceId())) {
                //map2.get(entity.getDeviceId()).getDoorList().add(e)
            }
        }
        List<Device> result = null;
        return result;
    }
    
    /*doorId:��id
     * 
        <DetailInfo  ip="1.1.1.1" status=����>
        <Device name=���� type=����/>
        <Device name=���� type=����/>
        ����.
        <DetailInfo> 
     */
    @Transactional
    public DetailInfo queryDetailDoorStatus(String doorId) {
        DetailInfo info = dao.queryDetailDoorStatus(doorId);
        return info;
    }
    /*

     */
    @Transactional
    public void createOrModifyDoorGroup(Group group) throws IOException {
        dao.createOrModifyDoorGroup(group);
    }
    /*


     */
    @Transactional
    public void UpdateDoorGroupStatus(List<Object> list) {
        for(Object obj : list) {
            Device device = (Device) obj;
            dao.UpdateDoorGroupStatus(device);
        }
    }
    /*
     */
    @Transactional
    public void deleteDoorGroup(String groupId) {
        dao.deleteDoorGroup(groupId);
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
    @Transactional
    public List<Group> querySpecialDoorGroup(String curOrganId,String hasChild,
            String searchName) {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("curOrganId", curOrganId);
        map.put("hasChild", hasChild);
        map.put("searchName", searchName);
        List<Group> list = dao.querySpecialDoorGroup(map);
        return list;
    }
    //2.6.3.2.5   ��ѯ�������������еĿ�����
    /*
     * groupId:Ҫ��ѯ����id
     * 
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
    @Transactional
    public List<Device> queryGroupForAssignedDevice(
            String groupId) {
        List<Device> list = dao.queryGroupForAssignedDevice(groupId);
        return list;
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
    @Transactional
    public List<Strategy> queryGroupStrategy(String groupId,
            String controlId) {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("groupId", groupId);
        map.put("controlId", controlId);
        List<Strategy> list = dao.queryGroupStrategy(map);
        return list;
    }
    /*
     */
    @Transactional
    public void saveGroupStrategy(Strategy entity) throws IOException {
        dao.saveGroupStrategy(entity);
    }
    //����������¼�
    /*
     * eventId:ˢ���¼�ID
        lock 0:������1������ 
        
        <Message code=��0000��descript=����>
         <Status result=����   />
        </Message >

     */
    @Transactional
    public void LockOrUnLockDoorEvent(String eventId,
            String lock) throws IOException {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("eventId", eventId);
        map.put("lock", lock);
        dao.LockOrUnLockDoorEvent(map);
   
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
    @Transactional
    public List<Device> queryAssociateCameral(String curOrganId,String hasChild,
            String searchName) {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("curOrganId", curOrganId);
        map.put("hasChild", hasChild);
        map.put("searchName", searchName);
        List<Device> list = dao.queryAssociateCameral(map);
        return list;
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
    @Transactional
    public void saveAssociateCameral(List<Object> list) throws IOException {
        for(Object obj : list){
            Door door = (Door) obj;
            dao.saveAssociateCameral(door);
        }
    }
}
