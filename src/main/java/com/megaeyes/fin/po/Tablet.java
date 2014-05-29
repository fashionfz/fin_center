/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 * Date:2014年2月7日上午11:01:35  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/  

package com.megaeyes.fin.po;

import java.util.Date;

/**
 * 
 * ClassName: MboxTablet <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2014年2月7日 上午11:02:05 <br/>  
 *  
 * @author ICBM  
 * @version   
 * @since JDK 1.6
 */
public class Tablet implements java.io.Serializable {

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private long id;
	private String deviceNumber;
	private String name;
	private String address;
	private String ip;
	private String port;
	private String linkMan;
	private String phone;
	private int status;
	private Date createTime;
	private int lineStatus;
	private int dealStatus;
	private int lockStatus;
	private String lockUser;
	private String lockUserName;
	private Date lockTime;
	private String clientMac;
	private String sessionId;
	/**  
	 * id.  
	 *  
	 * @return  the id  
	 * @since   JDK 1.6  
	 */
	public long getId() {
		return id;
	}
	/**  
	 * id.  
	 *  
	 * @param   id    the id to set  
	 * @since   JDK 1.6  
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**  
	 * deviceNumber.  
	 *  
	 * @return  the deviceNumber  
	 * @since   JDK 1.6  
	 */
	public String getDeviceNumber() {
		return deviceNumber;
	}
	/**  
	 * deviceNumber.  
	 *  
	 * @param   deviceNumber    the deviceNumber to set  
	 * @since   JDK 1.6  
	 */
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	/**  
	 * name.  
	 *  
	 * @return  the name  
	 * @since   JDK 1.6  
	 */
	public String getName() {
		return name;
	}
	/**  
	 * name.  
	 *  
	 * @param   name    the name to set  
	 * @since   JDK 1.6  
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**  
	 * address.  
	 *  
	 * @return  the address  
	 * @since   JDK 1.6  
	 */
	public String getAddress() {
		return address;
	}
	/**  
	 * address.  
	 *  
	 * @param   address    the address to set  
	 * @since   JDK 1.6  
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**  
	 * ip.  
	 *  
	 * @return  the ip  
	 * @since   JDK 1.6  
	 */
	public String getIp() {
		return ip;
	}
	/**  
	 * ip.  
	 *  
	 * @param   ip    the ip to set  
	 * @since   JDK 1.6  
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**  
	 * port.  
	 *  
	 * @return  the port  
	 * @since   JDK 1.6  
	 */
	public String getPort() {
		return port;
	}
	/**  
	 * port.  
	 *  
	 * @param   port    the port to set  
	 * @since   JDK 1.6  
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/**  
	 * linkMan.  
	 *  
	 * @return  the linkMan  
	 * @since   JDK 1.6  
	 */
	public String getLinkMan() {
		return linkMan;
	}
	/**  
	 * linkMan.  
	 *  
	 * @param   linkMan    the linkMan to set  
	 * @since   JDK 1.6  
	 */
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	/**  
	 * phone.  
	 *  
	 * @return  the phone  
	 * @since   JDK 1.6  
	 */
	public String getPhone() {
		return phone;
	}
	/**  
	 * phone.  
	 *  
	 * @param   phone    the phone to set  
	 * @since   JDK 1.6  
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**  
	 * status.  
	 *  
	 * @return  the status  
	 * @since   JDK 1.6  
	 */
	public int getStatus() {
		return status;
	}
	/**  
	 * status.  
	 *  
	 * @param   status    the status to set  
	 * @since   JDK 1.6  
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**  
	 * createTime.  
	 *  
	 * @return  the createTime  
	 * @since   JDK 1.6  
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**  
	 * createTime.  
	 *  
	 * @param   createTime    the createTime to set  
	 * @since   JDK 1.6  
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**  
	 * lineStatus.  
	 *  
	 * @return  the lineStatus  
	 * @since   JDK 1.6  
	 */
	public int getLineStatus() {
		return lineStatus;
	}
	/**  
	 * lineStatus.  
	 *  
	 * @param   lineStatus    the lineStatus to set  
	 * @since   JDK 1.6  
	 */
	public void setLineStatus(int lineStatus) {
		this.lineStatus = lineStatus;
	}
	/**  
	 * dealStatus.  
	 *  
	 * @return  the dealStatus  
	 * @since   JDK 1.6  
	 */
	public int getDealStatus() {
		return dealStatus;
	}
	/**  
	 * dealStatus.  
	 *  
	 * @param   dealStatus    the dealStatus to set  
	 * @since   JDK 1.6  
	 */
	public void setDealStatus(int dealStatus) {
		this.dealStatus = dealStatus;
	}
	/**  
	 * lockStatus.  
	 *  
	 * @return  the lockStatus  
	 * @since   JDK 1.6  
	 */
	public int getLockStatus() {
		return lockStatus;
	}
	/**  
	 * lockStatus.  
	 *  
	 * @param   lockStatus    the lockStatus to set  
	 * @since   JDK 1.6  
	 */
	public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
	}
	/**  
	 * lockUser.  
	 *  
	 * @return  the lockUser  
	 * @since   JDK 1.6  
	 */
	public String getLockUser() {
		return lockUser;
	}
	/**  
	 * lockUser.  
	 *  
	 * @param   lockUser    the lockUser to set  
	 * @since   JDK 1.6  
	 */
	public void setLockUser(String lockUser) {
		this.lockUser = lockUser;
	}
	/**  
	 * lockUserName.  
	 *  
	 * @return  the lockUserName  
	 * @since   JDK 1.6  
	 */
	public String getLockUserName() {
		return lockUserName;
	}
	/**  
	 * lockUserName.  
	 *  
	 * @param   lockUserName    the lockUserName to set  
	 * @since   JDK 1.6  
	 */
	public void setLockUserName(String lockUserName) {
		this.lockUserName = lockUserName;
	}
	/**  
	 * lockTime.  
	 *  
	 * @return  the lockTime  
	 * @since   JDK 1.6  
	 */
	public Date getLockTime() {
		return lockTime;
	}
	/**  
	 * lockTime.  
	 *  
	 * @param   lockTime    the lockTime to set  
	 * @since   JDK 1.6  
	 */
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	/**  
	 * clientMac.  
	 *  
	 * @return  the clientMac  
	 * @since   JDK 1.6  
	 */
	public String getClientMac() {
		return clientMac;
	}
	/**  
	 * clientMac.  
	 *  
	 * @param   clientMac    the clientMac to set  
	 * @since   JDK 1.6  
	 */
	public void setClientMac(String clientMac) {
		this.clientMac = clientMac;
	}
	/**  
	 * sessionId.  
	 *  
	 * @return  the sessionId  
	 * @since   JDK 1.6  
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**  
	 * sessionId.  
	 *  
	 * @param   sessionId    the sessionId to set  
	 * @since   JDK 1.6  
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name+deviceNumber+address;
    }
	
	
}
