/**
 * Project Name:fin_center
 * File Name:LockTabletDTO.java
 * Package Name:com.megaeyes.fin.dto
 *
*/
  
package com.megaeyes.fin.dto;   

import java.util.List;

import com.megaeyes.fin.po.InterPhone;
import com.megaeyes.fin.po.TabletUser;
import com.megaeyes.fin.po.VideoInputChannel;

/**
 * @version
 * @since    JDK 1.6
 * @see
 */
public class LockTabletDTO implements java.io.Serializable{

    /**
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;

    private String tabletId;
    
    private String eventId;
    
    private List<VideoInputChannel> vicList;
    
    private List<TabletUser> userList;
    
    private InterPhone interPhone;

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
     * interPhone.
     *
     * @return  the interPhone
     * @since   JDK 1.6
     */
    public final InterPhone getInterPhone() {
        return interPhone;
    }

    /**
     * interPhone.
     *
     * @param   interPhone    the interPhone to set
     * @since   JDK 1.6
     */
    public final void setInterPhone(InterPhone interPhone) {
        this.interPhone = interPhone;
    }

    /**
     * tabletId.
     *
     * @return  the tabletId
     * @since   JDK 1.6
     */
    public final String getTabletId() {
        return tabletId;
    }

    /**
     * tabletId.
     *
     * @param   tabletId    the tabletId to set
     * @since   JDK 1.6
     */
    public final void setTabletId(String tabletId) {
        this.tabletId = tabletId;
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
    
    
}
