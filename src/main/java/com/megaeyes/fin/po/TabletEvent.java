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
import java.util.List;

/**
 * 
 * ClassName: MboxEvent <br/>  
 * Function: 钞箱事件pojo. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2014年2月7日 上午10:30:05 <br/>  
 *  
 * @author ICBM  
 * @version   
 * @since JDK 1.6
 */
public class TabletEvent implements java.io.Serializable{

	/**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String id;
	private long tabletId;
	private String tabletName;
	private String deviceNumber;
	private String tabletAddress;
	private String code;
	private Date beginTime;
	private Date endTime;
	private String tabletUsers;
	private int type;
	private int status;
	private String dealContent;
	private String dealUserId;
	private String dealUserName;
	private Date dealTime;
	
	private List<VideoInputChannel> vicList;
	private List<TabletUser> userList;

	/**
     * id.
     *
     * @return  the id
     * @since   JDK 1.6
     */
    public String getId() {
        return id;
    }
    /**
     * id.
     *
     * @param   id    the id to set
     * @since   JDK 1.6
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * tabletId.
     *
     * @return  the tabletId
     * @since   JDK 1.6
     */
    public long getTabletId() {
        return tabletId;
    }
    /**
     * tabletId.
     *
     * @param   tabletId    the tabletId to set
     * @since   JDK 1.6
     */
    public void setTabletId(long tabletId) {
        this.tabletId = tabletId;
    }
    /**  
	 * tabletName.  
	 *  
	 * @return  the tabletName  
	 * @since   JDK 1.6  
	 */
	public String getTabletName() {
		return tabletName;
	}
	/**  
	 * tabletName.  
	 *  
	 * @param   tabletName    the tabletName to set  
	 * @since   JDK 1.6  
	 */
	public void setTabletName(String tabletName) {
		this.tabletName = tabletName;
	}
	/**  
	 * code.  
	 *  
	 * @return  the code  
	 * @since   JDK 1.6  
	 */
	public String getCode() {
		return code;
	}
	/**  
	 * code.  
	 *  
	 * @param   code    the code to set  
	 * @since   JDK 1.6  
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**  
	 * beginTime.  
	 *  
	 * @return  the beginTime  
	 * @since   JDK 1.6  
	 */
	public Date getBeginTime() {
		return beginTime;
	}
	/**  
	 * beginTime.  
	 *  
	 * @param   beginTime    the beginTime to set  
	 * @since   JDK 1.6  
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/**  
	 * endTime.  
	 *  
	 * @return  the endTime  
	 * @since   JDK 1.6  
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**  
	 * endTime.  
	 *  
	 * @param   endTime    the endTime to set  
	 * @since   JDK 1.6  
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**  
	 * dealContent.  
	 *  
	 * @return  the dealContent  
	 * @since   JDK 1.6  
	 */
	public String getDealContent() {
		return dealContent;
	}
	/**  
	 * dealContent.  
	 *  
	 * @param   dealContent    the dealContent to set  
	 * @since   JDK 1.6  
	 */
	public void setDealContent(String dealContent) {
		this.dealContent = dealContent;
	}
	/**  
	 * dealUserId.  
	 *  
	 * @return  the dealUserId  
	 * @since   JDK 1.6  
	 */
	public String getDealUserId() {
		return dealUserId;
	}
	/**  
	 * dealUserId.  
	 *  
	 * @param   dealUserId    the dealUserId to set  
	 * @since   JDK 1.6  
	 */
	public void setDealUserId(String dealUserId) {
		this.dealUserId = dealUserId;
	}
	/**  
	 * dealUserName.  
	 *  
	 * @return  the dealUserName  
	 * @since   JDK 1.6  
	 */
	public String getDealUserName() {
		return dealUserName;
	}
	/**  
	 * dealUserName.  
	 *  
	 * @param   dealUserName    the dealUserName to set  
	 * @since   JDK 1.6  
	 */
	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}
	/**  
	 * dealTime.  
	 *  
	 * @return  the dealTime  
	 * @since   JDK 1.6  
	 */
	public Date getDealTime() {
		return dealTime;
	}
	/**  
	 * dealTime.  
	 *  
	 * @param   dealTime    the dealTime to set  
	 * @since   JDK 1.6  
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
    /**
     * deviceNumber.
     *
     * @return  the deviceNumber
     * @since   JDK 1.6
     */
    public final String getDeviceNumber() {
        return deviceNumber;
    }
    /**
     * deviceNumber.
     *
     * @param   deviceNumber    the deviceNumber to set
     * @since   JDK 1.6
     */
    public final void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }
    /**
     * tabletAddress.
     *
     * @return  the tabletAddress
     * @since   JDK 1.6
     */
    public final String getTabletAddress() {
        return tabletAddress;
    }
    /**
     * tabletAddress.
     *
     * @param   tabletAddress    the tabletAddress to set
     * @since   JDK 1.6
     */
    public final void setTabletAddress(String tabletAddress) {
        this.tabletAddress = tabletAddress;
    }
    /**
     * tabletUsers.
     *
     * @return  the tabletUsers
     * @since   JDK 1.6
     */
    public final String getTabletUsers() {
        return tabletUsers;
    }
    /**
     * tabletUsers.
     *
     * @param   tabletUsers    the tabletUsers to set
     * @since   JDK 1.6
     */
    public final void setTabletUsers(String tabletUsers) {
        this.tabletUsers = tabletUsers;
    }
    /**
     * type.
     *
     * @return  the type
     * @since   JDK 1.6
     */
    public final int getType() {
        return type;
    }
    /**
     * type.
     *
     * @param   type    the type to set
     * @since   JDK 1.6
     */
    public final void setType(int type) {
        this.type = type;
    }
    /**
     * status.
     *
     * @return  the status
     * @since   JDK 1.6
     */
    public final int getStatus() {
        return status;
    }
    /**
     * status.
     *
     * @param   status    the status to set
     * @since   JDK 1.6
     */
    public final void setStatus(int status) {
        this.status = status;
    }
    /**
     * userList.
     *
     * @return  the userList
     * @since   JDK 1.6
     */
    public final List<TabletUser> getUserList() {
        return userList;
    }
    /**
     * userList.
     *
     * @param   userList    the userList to set
     * @since   JDK 1.6
     */
    public final void setUserList(List<TabletUser> userList) {
        this.userList = userList;
    }
    /**
     * vicList.
     *
     * @return  the vicList
     * @since   JDK 1.6
     */
    public final List<VideoInputChannel> getVicList() {
        return vicList;
    }
    /**
     * vicList.
     *
     * @param   vicList    the vicList to set
     * @since   JDK 1.6
     */
    public final void setVicList(List<VideoInputChannel> vicList) {
        this.vicList = vicList;
    }
}
