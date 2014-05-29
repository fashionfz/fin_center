/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 * Date:2014年2月7日上午11:01:35  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/  

package com.megaeyes.fin.dto;

import java.util.Date;
import java.util.List;

import com.megaeyes.fin.po.User;
import com.megaeyes.fin.po.VideoInputChannel;

/**
 * 
 * ClassName: MboxTabletSchema <br/>  
 * Function: 平板设备预案dto. <br/>  
 * date: 2014年2月7日 下午1:42:30 <br/>  
 *  
 * @author dengbin ibcm@qq.com  
 * @version   
 * @since JDK 1.6
 */
public class MboxTabletSchema {
    private String eventId;
    private long tabletId;
    private Date beginTime;
    private String tabletName;
	private List<User> userList;
	private List<VideoInputChannel> vicList;
	/**  
	 * userList.  
	 *  
	 * @return  the userList  
	 * @since   JDK 1.6  
	 */
	public List<User> getUserList() {
		return userList;
	}
	/**  
	 * userList.  
	 *  
	 * @param   userList    the userList to set  
	 * @since   JDK 1.6  
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	/**  
	 * vicList.  
	 *  
	 * @return  the vicList  
	 * @since   JDK 1.6  
	 */
	public List<VideoInputChannel> getVicList() {
		return vicList;
	}
	/**  
	 * vicList.  
	 *  
	 * @param   vicList    the vicList to set  
	 * @since   JDK 1.6  
	 */
	public void setVicList(List<VideoInputChannel> vicList) {
		this.vicList = vicList;
	}
    /**
     * tabletId.
     *
     * @return  the tabletId
     * @since   JDK 1.6
     */
    public final long getTabletId() {
        return tabletId;
    }
    /**
     * tabletId.
     *
     * @param   tabletId    the tabletId to set
     * @since   JDK 1.6
     */
    public final void setTabletId(long tabletId) {
        this.tabletId = tabletId;
    }
    /**
     * tabletName.
     *
     * @return  the tabletName
     * @since   JDK 1.6
     */
    public final String getTabletName() {
        return tabletName;
    }
    /**
     * tabletName.
     *
     * @param   tabletName    the tabletName to set
     * @since   JDK 1.6
     */
    public final void setTabletName(String tabletName) {
        this.tabletName = tabletName;
    }
    /**
     * eventId.
     *
     * @return  the eventId
     * @since   JDK 1.6
     */
    public final String getEventId() {
        return eventId;
    }
    /**
     * eventId.
     *
     * @param   eventId    the eventId to set
     * @since   JDK 1.6
     */
    public final void setEventId(String eventId) {
        this.eventId = eventId;
    }
    /**
     * beginTime.
     *
     * @return  the beginTime
     * @since   JDK 1.6
     */
    public final Date getBeginTime() {
        return beginTime;
    }
    /**
     * beginTime.
     *
     * @param   beginTime    the beginTime to set
     * @since   JDK 1.6
     */
    public final void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    
	
}
