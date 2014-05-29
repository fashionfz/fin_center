/**
 * Project Name:fin_center
 * File Name:TabletClientGetUserDTO.java
 * Package Name:com.megaeyes.fin.dto
 * Date:2014年2月20日上午9:34:09
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.dto;   

import java.util.Date;
import java.util.List;

import com.megaeyes.fin.po.TabletUser;

/**
 * ClassName:TabletClientGetUserDTO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年2月20日 上午9:34:09 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class TabletClientGetUserDTO {

    private Date lastModifyTime;
    private List<TabletUser> userList;
    /**
     * lastModifyTime.
     *
     * @return  the lastModifyTime
     * @since   JDK 1.6
     */
    public final Date getLastModifyTime() {
        return lastModifyTime;
    }
    /**
     * lastModifyTime.
     *
     * @param   lastModifyTime    the lastModifyTime to set
     * @since   JDK 1.6
     */
    public final void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
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
    
    
}
