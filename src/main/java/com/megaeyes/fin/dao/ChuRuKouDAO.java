/**
 * Project Name:fin_center
 * File Name:ChuRuKouDAO.java
 * Package Name:com.megaeyes.fin.dao
 * Date:2014年3月5日下午7:53:54
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.dao;   

import java.util.List;
import java.util.Map;

import com.megaeyes.fin.dao.core.MyBatisRepository;
import com.megaeyes.fin.po.churukou.DetailInfo;
import com.megaeyes.fin.po.churukou.Device;
import com.megaeyes.fin.po.churukou.DeviceAndDoor;
import com.megaeyes.fin.po.churukou.Door;
import com.megaeyes.fin.po.churukou.Group;
import com.megaeyes.fin.po.churukou.Strategy;

/**
 * ClassName:ChuRuKouDAO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年3月5日 下午7:53:54 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
@MyBatisRepository
public interface ChuRuKouDAO {

    public List<DeviceAndDoor> querySpecialOrganDoors(Map map);
    
    public DetailInfo queryDetailDoorStatus(String doorId);

    public void createOrModifyDoorGroup(Group group);

    public void UpdateDoorGroupStatus(Object device);

    public void deleteDoorGroup(String groupId);
    
    public List<Group> querySpecialDoorGroup(Map map);

    public List<Device> queryGroupForAssignedDevice(String groupId);

    public List<Strategy> queryGroupStrategy(Map map);

    public void saveGroupStrategy(Strategy entity);

    public void LockOrUnLockDoorEvent(Map map);
    
    public void saveAssociateCameral(Door door);
    
    public List<Device> queryAssociateCameral(Map map);
}
