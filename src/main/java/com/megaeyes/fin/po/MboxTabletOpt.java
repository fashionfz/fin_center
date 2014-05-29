/**
 * Project Name:fin_center
 * File Name:MboxTabletOpt.java
 * Package Name:com.megaeyes.fin.po
 *
*/

package com.megaeyes.fin.po;   

import java.sql.Timestamp;

/**
 * ClassName:MboxTabletOpt <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class MboxTabletOpt implements java.io.Serializable{

    /**
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private long tabletId;
    private boolean lineStatus;
    private boolean dealStatus;
    private boolean lockStatus;
    private String lockUser;
    private String lockUserName;
    private Timestamp lockTime;
    private String clientMac;
    private String sessionId;
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
     * lineStatus.
     *
     * @return  the lineStatus
     * @since   JDK 1.6
     */
    public final boolean isLineStatus() {
        return lineStatus;
    }
    /**
     * lineStatus.
     *
     * @param   lineStatus    the lineStatus to set
     * @since   JDK 1.6
     */
    public final void setLineStatus(boolean lineStatus) {
        this.lineStatus = lineStatus;
    }
    /**
     * dealStatus.
     *
     * @return  the dealStatus
     * @since   JDK 1.6
     */
    public final boolean isDealStatus() {
        return dealStatus;
    }
    /**
     * dealStatus.
     *
     * @param   dealStatus    the dealStatus to set
     * @since   JDK 1.6
     */
    public final void setDealStatus(boolean dealStatus) {
        this.dealStatus = dealStatus;
    }
    /**
     * lockStatus.
     *
     * @return  the lockStatus
     * @since   JDK 1.6
     */
    public final boolean isLockStatus() {
        return lockStatus;
    }
    /**
     * lockStatus.
     *
     * @param   lockStatus    the lockStatus to set
     * @since   JDK 1.6
     */
    public final void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }
    /**
     * lockUser.
     *
     * @return  the lockUser
     * @since   JDK 1.6
     */
    public final String getLockUser() {
        return lockUser;
    }
    /**
     * lockUser.
     *
     * @param   lockUser    the lockUser to set
     * @since   JDK 1.6
     */
    public final void setLockUser(String lockUser) {
        this.lockUser = lockUser;
    }
    /**
     * lockUserName.
     *
     * @return  the lockUserName
     * @since   JDK 1.6
     */
    public final String getLockUserName() {
        return lockUserName;
    }
    /**
     * lockUserName.
     *
     * @param   lockUserName    the lockUserName to set
     * @since   JDK 1.6
     */
    public final void setLockUserName(String lockUserName) {
        this.lockUserName = lockUserName;
    }
    /**
     * lockTime.
     *
     * @return  the lockTime
     * @since   JDK 1.6
     */
    public final Timestamp getLockTime() {
        return lockTime;
    }
    /**
     * lockTime.
     *
     * @param   lockTime    the lockTime to set
     * @since   JDK 1.6
     */
    public final void setLockTime(Timestamp lockTime) {
        this.lockTime = lockTime;
    }
    /**
     * clientMac.
     *
     * @return  the clientMac
     * @since   JDK 1.6
     */
    public final String getClientMac() {
        return clientMac;
    }
    /**
     * clientMac.
     *
     * @param   clientMac    the clientMac to set
     * @since   JDK 1.6
     */
    public final void setClientMac(String clientMac) {
        this.clientMac = clientMac;
    }
    /**
     * sessionId.
     *
     * @return  the sessionId
     * @since   JDK 1.6
     */
    public final String getSessionId() {
        return sessionId;
    }
    /**
     * sessionId.
     *
     * @param   sessionId    the sessionId to set
     * @since   JDK 1.6
     */
    public final void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    
}
