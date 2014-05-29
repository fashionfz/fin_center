/**
 * Project Name:fin_center
 * File Name:Device.java
 * Package Name:com.megaeyes.fin.po.churukou
 * Date:2014年3月5日下午5:31:28
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.po.churukou;   

import java.util.List;

/**
 * ClassName:Device <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年3月5日 下午5:31:28 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class Device implements java.io.Serializable{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String organId;
    private String organName;
    private String name;
    private String deviceNo;
    private String manufacture;
    private String isApplyGroupStrategy;
    private String doorAcessIp;
    private String doorAcessPort;
    private List<Door> doorList;
    private String type;
    
    /**
     * id.
     *
     * @return  the id
     * @since   JDK 1.6
     */
    public final String getId() {
        return id;
    }
    /**
     * id.
     *
     * @param   id    the id to set
     * @since   JDK 1.6
     */
    public final void setId(String id) {
        this.id = id;
    }
    /**
     * organId.
     *
     * @return  the organId
     * @since   JDK 1.6
     */
    public final String getOrganId() {
        return organId;
    }
    /**
     * organId.
     *
     * @param   organId    the organId to set
     * @since   JDK 1.6
     */
    public final void setOrganId(String organId) {
        this.organId = organId;
    }
    /**
     * organName.
     *
     * @return  the organName
     * @since   JDK 1.6
     */
    public final String getOrganName() {
        return organName;
    }
    /**
     * organName.
     *
     * @param   organName    the organName to set
     * @since   JDK 1.6
     */
    public final void setOrganName(String organName) {
        this.organName = organName;
    }
    /**
     * name.
     *
     * @return  the name
     * @since   JDK 1.6
     */
    public final String getName() {
        return name;
    }
    /**
     * name.
     *
     * @param   name    the name to set
     * @since   JDK 1.6
     */
    public final void setName(String name) {
        this.name = name;
    }
    /**
     * deviceNo.
     *
     * @return  the deviceNo
     * @since   JDK 1.6
     */
    public final String getDeviceNo() {
        return deviceNo;
    }
    /**
     * deviceNo.
     *
     * @param   deviceNo    the deviceNo to set
     * @since   JDK 1.6
     */
    public final void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }
    /**
     * manufacture.
     *
     * @return  the manufacture
     * @since   JDK 1.6
     */
    public final String getManufacture() {
        return manufacture;
    }
    /**
     * manufacture.
     *
     * @param   manufacture    the manufacture to set
     * @since   JDK 1.6
     */
    public final void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
    /**
     * doorList.
     *
     * @return  the doorList
     * @since   JDK 1.6
     */
    public final List<Door> getDoorList() {
        return doorList;
    }
    /**
     * doorList.
     *
     * @param   doorList    the doorList to set
     * @since   JDK 1.6
     */
    public final void setDoorList(List<Door> doorList) {
        this.doorList = doorList;
    }
    /**
     * type.
     *
     * @return  the type
     * @since   JDK 1.6
     */
    public final String getType() {
        return type;
    }
    /**
     * type.
     *
     * @param   type    the type to set
     * @since   JDK 1.6
     */
    public final void setType(String type) {
        this.type = type;
    }
    /**
     * isApplyGroupStrategy.
     *
     * @return  the isApplyGroupStrategy
     * @since   JDK 1.6
     */
    public final String getIsApplyGroupStrategy() {
        return isApplyGroupStrategy;
    }
    /**
     * isApplyGroupStrategy.
     *
     * @param   isApplyGroupStrategy    the isApplyGroupStrategy to set
     * @since   JDK 1.6
     */
    public final void setIsApplyGroupStrategy(String isApplyGroupStrategy) {
        this.isApplyGroupStrategy = isApplyGroupStrategy;
    }
    /**
     * doorAcessIp.
     *
     * @return  the doorAcessIp
     * @since   JDK 1.6
     */
    public final String getDoorAcessIp() {
        return doorAcessIp;
    }
    /**
     * doorAcessIp.
     *
     * @param   doorAcessIp    the doorAcessIp to set
     * @since   JDK 1.6
     */
    public final void setDoorAcessIp(String doorAcessIp) {
        this.doorAcessIp = doorAcessIp;
    }
    /**
     * doorAcessPort.
     *
     * @return  the doorAcessPort
     * @since   JDK 1.6
     */
    public final String getDoorAcessPort() {
        return doorAcessPort;
    }
    /**
     * doorAcessPort.
     *
     * @param   doorAcessPort    the doorAcessPort to set
     * @since   JDK 1.6
     */
    public final void setDoorAcessPort(String doorAcessPort) {
        this.doorAcessPort = doorAcessPort;
    }
    
}
