/**
 * Project Name:fin_center
 * File Name:ChuRuKouService.java
 * Package Name:com.megaeyes.fin.service
 * Date:2014年3月5日下午7:34:47
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.
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
 * Date:     2014年3月5日 下午7:34:47 <br/>
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
     * curOrganId:当前的要查询的机构id
        hasChild:是否包含子查询,0： 不包含，1：包含
        isAssigned:是否已经分配到组，0全部，1未分配，2已分配
        searchName:指定的控制器名称，模糊查询条件，为空时忽略此字段

     * <Device id=”” organId=””  organName=”” name="" deviceNo="" manufacture=”” >
            <Door id=”” chanel=”1” name=”门1” status=“0”/>
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
    
    /*doorId:门id
     * 
        <DetailInfo  ip="1.1.1.1" status=””>
        <Device name=”” type=””/>
        <Device name=”” type=””/>
        …….
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
    //2.6.3.2.5   查询控制器组下所有的控制器
    /*
     * groupId:要查询的组id
     * 
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
    @Transactional
    public List<Device> queryGroupForAssignedDevice(
            String groupId) {
        List<Device> list = dao.queryGroupForAssignedDevice(groupId);
        return list;
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
    //锁定与解锁事件
    /*
     * eventId:刷卡事件ID
        lock 0:锁定，1：解锁 
        
        <Message code=“0000”descript=””>
         <Status result=””   />
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
    @Transactional
    public void saveAssociateCameral(List<Object> list) throws IOException {
        for(Object obj : list){
            Door door = (Door) obj;
            dao.saveAssociateCameral(door);
        }
    }
}
