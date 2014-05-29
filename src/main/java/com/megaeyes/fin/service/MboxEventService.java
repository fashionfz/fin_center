/**
 * Project Name:fin_center
 * File Name:MboxEventService.java
 * Package Name:com.megaeyes.fin.service
 *
*/
package com.megaeyes.fin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megaeyes.fin.dao.TabletDAO;
import com.megaeyes.fin.dao.TabletEventDAO;
import com.megaeyes.fin.dao.TabletGroupDAO;
import com.megaeyes.fin.dto.MboxTabletSchema;
import com.megaeyes.fin.po.Tablet;
import com.megaeyes.fin.po.TabletEvent;
import com.megaeyes.fin.po.TabletUser;
import com.megaeyes.fin.po.User;
import com.megaeyes.fin.po.VideoInputChannel;

/**
 * ClassName:MboxEventService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
@Service
@Transactional
public class MboxEventService {
    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /***/
    @Autowired
    private TabletEventDAO eventDAO;
    /***/
    @Autowired
    private TabletDAO tabletDAO;
    /***/
    @Autowired
    private TabletGroupDAO groupDAO;
    /**
     * eventDAO.
     *
     * @return  the eventDAO
     * @since   JDK 1.6
     */
    public final TabletEventDAO getEventDAO() {
        return eventDAO;
    }
    /**
     * eventDAO.
     *
     * @param   eventDAO    the eventDAO to set
     * @since   JDK 1.6
     */
    public final void setEventDAO(final TabletEventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
    /**
     * tabletDAO.
     *
     * @return  the tabletDAO
     * @since   JDK 1.6
     */
    public final TabletDAO getTabletDAO() {
        return tabletDAO;
    }
    /**
     * tabletDAO.
     *
     * @param   tabletDAO    the tabletDAO to set
     * @since   JDK 1.6
     */
    public final void setTabletDAO(final TabletDAO tabletDAO) {
        this.tabletDAO = tabletDAO;
    }
    /**
     * groupDAO.
     *
     * @return  the groupDAO
     * @since   JDK 1.6
     */
    public final TabletGroupDAO getGroupDAO() {
        return groupDAO;
    }
    /**
     * groupDAO.
     *
     * @param   groupDAO    the groupDAO to set
     * @since   JDK 1.6
     */
    public final void setGroupDAO(final TabletGroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }
    /**
     * 
     *  
     * @author ICBM  
     * @since JDK 1.6
     */
    @Transactional(rollbackFor =
            com.megaeyes.fin.exception.MegaException.class)
    public MboxTabletSchema beginAuthenticate(
            final String eventId ,
            final long tabletId ,
            final Date beginTime) {
      Tablet tablet = tabletDAO.getTabletById(tabletId);
      TabletEvent event = new TabletEvent();
      event.setTabletName(tablet.getName());
      event.setTabletAddress(tablet.getAddress());
      event.setId(eventId);
      event.setTabletId(tabletId);
      event.setBeginTime(beginTime);
      eventDAO.beginEventLog(event);
      Map<String , Object> map = new HashMap<String , Object>();
      map.put("dealStatus", 1);
      map.put("tabletId", tabletId);
      tabletDAO.modifyTabletDealStatus(map);
      MboxTabletSchema schema = getSchemaUserByTabletId(eventId ,tabletId);
      saveEventInfo(schema , eventId);
      return schema;
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param schema
     * @param eventId
     * @since JDK 1.6
     */
    private void saveEventInfo(
            final MboxTabletSchema schema ,
            final String eventId) {
        for (VideoInputChannel vic : schema.getVicList()) {
            Map<String , Object> map = new HashMap<String , Object>();
            map.put("eventId", eventId);
            map.put("vicId", vic.getId());
            eventDAO.addEventCamara(map);
        }
        List<User> userList = groupDAO.
                queryGroupUserByTabletId(schema.getTabletId());
        for (User user : userList) {
            Map<String , Object> map = new HashMap<String , Object>();
            map.put("eventId", eventId);
            map.put("userId", user.getId());
            eventDAO.addEventNotifyUser(map);
        }
    }
    /**
     * 
     *  
     * @author ICBM  
     * @param eventId
     * @param tabletId
     * @param mboxUserId
     * @param brushTime
     * @return tag
     * @throws ParseException 
     * @since JDK 1.6
     */
    @Transactional(rollbackFor =
            com.megaeyes.fin.exception.MegaException.class)
    public MboxTabletSchema brushFingerprint(
            final String eventId ,
            final long tabletId ,
            final String mboxUserId ,
            final String brushTime) throws ParseException {
        if (null == mboxUserId || "".equals(mboxUserId)) {
            eventDAO.updateStatus(eventId);
        } else {
            Map<String , Object> map = new HashMap<String , Object>();
            map.put("eventId", eventId);
            map.put("mboxUserId", Long.parseLong(mboxUserId));
            map.put("brushTime", df.parseObject(brushTime));
            eventDAO.addEventMboxUser(map);
        }
        return getSchemaUserByTabletId(eventId ,tabletId);
    }
    /**
     * 
     *  
     * @author ICBM  
     * @param eventId
     * @param tabletId
     * @param endTime
     * @return tag
     * @throws ParseException 
     * @since JDK 1.6
     */
    @Transactional(rollbackFor =
            com.megaeyes.fin.exception.MegaException.class)
    public MboxTabletSchema endAuthenticate(
            final String eventId ,
            final long tabletId ,
            final String endTime) throws ParseException {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("eventId", eventId);
        map.put("endTime", df.parseObject(endTime));
        eventDAO.endEventLog(map);
        
        Map<String , Object> status = new HashMap<String , Object>();
        status.put("dealStatus", 0);
        status.put("tabletId", tabletId);
        tabletDAO.modifyTabletDealStatus(status);
      return getSchemaUserByTabletId(eventId ,tabletId);
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param list
     * @since JDK 1.6
     */
    @Transactional(rollbackFor =
            com.megaeyes.fin.exception.MegaException.class)
    public void offLineUpdateLog(final List<Object> list) {
      for (Object obj : list) {
          TabletEvent event = (TabletEvent) obj;
          eventDAO.insetEventLog(event);
          for (TabletUser user : event.getUserList()) {
              Map<String , Object> map = new HashMap<String , Object>();
              map.put("eventId", event.getId());
              map.put("mboxUserId", user.getId());
              map.put("brushTime", user.getBrushTime());
              eventDAO.addEventMboxUser(map);
          }
      }
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @return
     * @since JDK 1.6
     */
    @Transactional(readOnly = true)
    public List<TabletEvent> getTabletEvent(String intransfer) {
        if ("1".equals(intransfer)) {
            return eventDAO.getIntransferEvent();
        } else {
            return eventDAO.getTabletEvent();
        }
    }
     /**
     *
     *
     * @author ICBM
     * @since JDK 1.6
     */
    @Cacheable(value = "memcache", key = "'tabletSchema:'+#tabletId")
    private MboxTabletSchema getSchemaByTabletId(String eventId ,
            final long tabletId) {
        MboxTabletSchema schema = new MboxTabletSchema();
        schema.setEventId(eventId);
        schema.setTabletId(tabletId);
        Tablet tablet = tabletDAO.getTabletById(tabletId);
        schema.setTabletName(tablet.getName());
        List<VideoInputChannel> vicList = tabletDAO.
                getCamaraByTabletId(tabletId);
        schema.setVicList(vicList);
        return schema;
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param eventId
     * @param tabletId
     * @return
     * @since JDK 1.6
     */
    @Cacheable(value = "memcache", key = "'tabletSchemaUser:'+#tabletId")
    private MboxTabletSchema getSchemaUserByTabletId(String eventId ,
            final long tabletId) {
        MboxTabletSchema schema = new MboxTabletSchema();
        schema.setEventId(eventId);
        schema.setTabletId(tabletId);
        Tablet tablet = tabletDAO.getTabletById(tabletId);
        schema.setTabletName(tablet.getName());
        List<User> userList = groupDAO.queryGroupUserByTabletId(tablet.getId());
        List<VideoInputChannel> vicList = tabletDAO.
                getCamaraByTabletId(tabletId);
        schema.setVicList(vicList);
        schema.setUserList(userList);
        return schema;
    }
    @Transactional
    public void dealTabletEvent(String eventId,String context,String userId) {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("eventId", eventId);
        map.put("context", context);
        map.put("userId", userId);
        eventDAO.dealTabletEvent(map);
    }
}
