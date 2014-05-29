/**
 * Project Name:fin_center
 * File Name:Door.java
 * Package Name:com.megaeyes.fin.po.churukou
 * Date:2014年3月5日下午5:32:59
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.po.churukou;   

import java.util.List;

/**
 * ClassName:Door <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年3月5日 下午5:32:59 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class Door implements java.io.Serializable{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String  chanel;
    private String name;
    private String status;
    private String doorName;
    private String channel;
    private List<Cameral> list;
    /**
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
     * chanel.
     *
     * @return  the chanel
     * @since   JDK 1.6
     */
    public final String getChanel() {
        return chanel;
    }
    /**
     * chanel.
     *
     * @param   chanel    the chanel to set
     * @since   JDK 1.6
     */
    public final void setChanel(String chanel) {
        this.chanel = chanel;
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
     * status.
     *
     * @return  the status
     * @since   JDK 1.6
     */
    public final String getStatus() {
        return status;
    }
    /**
     * status.
     *
     * @param   status    the status to set
     * @since   JDK 1.6
     */
    public final void setStatus(String status) {
        this.status = status;
    }
    /**
     * doorName.
     *
     * @return  the doorName
     * @since   JDK 1.6
     */
    public final String getDoorName() {
        return doorName;
    }
    /**
     * doorName.
     *
     * @param   doorName    the doorName to set
     * @since   JDK 1.6
     */
    public final void setDoorName(String doorName) {
        this.doorName = doorName;
    }
    /**
     * channel.
     *
     * @return  the channel
     * @since   JDK 1.6
     */
    public final String getChannel() {
        return channel;
    }
    /**
     * channel.
     *
     * @param   channel    the channel to set
     * @since   JDK 1.6
     */
    public final void setChannel(String channel) {
        this.channel = channel;
    }
    /**
     * list.
     *
     * @return  the list
     * @since   JDK 1.6
     */
    public final List<Cameral> getList() {
        return list;
    }
    /**
     * list.
     *
     * @param   list    the list to set
     * @since   JDK 1.6
     */
    public final void setList(List<Cameral> list) {
        this.list = list;
    }
    
    
}
