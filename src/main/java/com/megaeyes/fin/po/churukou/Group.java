/**
 * Project Name:fin_center
 * File Name:Group.java
 * Package Name:com.megaeyes.fin.po.churukou
 * Date:2014年3月5日下午7:01:26
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.po.churukou;   

import java.util.List;

/**
 * ClassName:Group <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年3月5日 下午7:01:26 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class Group implements java.io.Serializable{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String groupId;
    private String groupName;
    private String  organId;
    List<Device> deviceList;
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
     * groupId.
     *
     * @return  the groupId
     * @since   JDK 1.6
     */
    public final String getGroupId() {
        return groupId;
    }
    /**
     * groupId.
     *
     * @param   groupId    the groupId to set
     * @since   JDK 1.6
     */
    public final void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    /**
     * groupName.
     *
     * @return  the groupName
     * @since   JDK 1.6
     */
    public final String getGroupName() {
        return groupName;
    }
    /**
     * groupName.
     *
     * @param   groupName    the groupName to set
     * @since   JDK 1.6
     */
    public final void setGroupName(String groupName) {
        this.groupName = groupName;
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
     * deviceList.
     *
     * @return  the deviceList
     * @since   JDK 1.6
     */
    public final List<Device> getDeviceList() {
        return deviceList;
    }
    /**
     * deviceList.
     *
     * @param   deviceList    the deviceList to set
     * @since   JDK 1.6
     */
    public final void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
    
}
