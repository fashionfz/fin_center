/**
 * Project Name:fin_center
 * File Name:TabletEventDAO.java
 * Package Name:com.megaeyes.fin.dao
 *
*/

package com.megaeyes.fin.dao;

import java.util.List;
import java.util.Map;

import com.megaeyes.fin.dao.core.MyBatisRepository;
import com.megaeyes.fin.po.TabletEvent;
import com.megaeyes.fin.po.TabletUser;

/**
 * ClassName:TabletEventDAO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
@MyBatisRepository
public interface TabletEventDAO {
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param event
     * @since JDK 1.6
     */
    public void insetEventLog(TabletEvent event);
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param map
     * @since JDK 1.6
     */
    public void addEventNotifyUser(Map map);
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param map
     * @since JDK 1.6
     */
    public void addEventCamara(Map map);
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param map
     * @since JDK 1.6
     */
    public void addEventMboxUser(Map map);
    /**
     * 
     *
     * @author dengbin ibcm@qq.com
     * @param event
     * @since JDK 1.6
     */
    public void beginEventLog(TabletEvent event);
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param map
     * @since JDK 1.6
     */
    public void endEventLog(Map map);
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param eventId
     * @since JDK 1.6
     */
    public void updateStatus(String eventId);
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @return
     * @since JDK 1.6
     */
    public List<TabletEvent> getTabletEvent();
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @return
     * @since JDK 1.6
     */
    public List<TabletEvent> getIntransferEvent();
    /**
     * 
     *
     * @author dengbin ibcm@qq.com
     * @param eventId
     * @return
     * @since JDK 1.6
     */
    public List<TabletUser> getMboxUser(String eventId);
    
    public void dealTabletEvent(Map map);
}
