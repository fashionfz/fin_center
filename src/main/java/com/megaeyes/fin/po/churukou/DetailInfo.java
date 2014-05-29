/**
 * Project Name:fin_center
 * File Name:DetailInfo.java
 * Package Name:com.megaeyes.fin.po.churukou
 * Date:2014年3月5日下午5:38:10
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.po.churukou;   

import java.util.List;

/**
 * ClassName:DetailInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年3月5日 下午5:38:10 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class DetailInfo implements java.io.Serializable{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String ip;
    private String status;
    private List<Device> deviceList;
    /**
     * ip.
     *
     * @return  the ip
     * @since   JDK 1.6
     */
    public final String getIp() {
        return ip;
    }
    /**
     * ip.
     *
     * @param   ip    the ip to set
     * @since   JDK 1.6
     */
    public final void setIp(String ip) {
        this.ip = ip;
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
