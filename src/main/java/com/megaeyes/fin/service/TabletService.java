/**
 * Project Name:fin_center
 * File Name:MboxUser.java
 * Package Name:com.megaeyes.fin.po
 *
*/

package com.megaeyes.fin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megaeyes.fin.dao.TabletDAO;
import com.megaeyes.fin.dao.TabletEventDAO;
import com.megaeyes.fin.dto.LockTabletDTO;
import com.megaeyes.fin.dto.MboxTabletCamara;
import com.megaeyes.fin.exception.MegaException;
import com.megaeyes.fin.po.InterPhone;
import com.megaeyes.fin.po.Tablet;
import com.megaeyes.fin.po.TabletUser;
import com.megaeyes.fin.po.VideoInputChannel;

/**
 *
 * ClassName: TabletService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *
 * @author dengbin ibcm@qq.com
 * @version
 * @since JDK 1.6
 */
@Service
@Transactional
public class TabletService {
    /**
     *
     */
    @Autowired
    private TabletDAO tabletDAO;
    
    @Autowired
    private TabletEventDAO eventDAO;

	/**
	 * tabletDAO.
	 *
	 * @return  the tabletDAO
	 * @since   JDK 1.6
	 */
	public TabletDAO getTabletDAO() {
		return tabletDAO;
	}


	/**
	 * tabletDAO.
	 *
	 * @param   tabletDAO    the tabletDAO to set
	 * @since   JDK 1.6
	 */
	public void setTabletDAO(TabletDAO tabletDAO) {
		this.tabletDAO = tabletDAO;
	}


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
    public final void setEventDAO(TabletEventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }


    /**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param userId
	 * @param queryParam
	 * @return
	 * @since JDK 1.6
	 */
	@Transactional(rollbackFor =
	        com.megaeyes.fin.exception.MegaException.class)
	//@Cacheable(value = "memcache", key = "'allTablet'")
	public List<Tablet> getTablet(
	        final String userId ,
	        final Tablet queryParam) {
		return tabletDAO.queryTablet(queryParam);
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param userId
	 * @param tablet
	 * @since JDK 1.6
	 */
	@Transactional(readOnly = true,
	        rollbackFor = com.megaeyes.fin.exception.MegaException.class)
    //@CacheEvict(value = "memcache", key = "'allTablet2'")
    public void addTablet(
            final Tablet tablet){
	    Long id = tabletDAO.getIdByNumber(tablet.getDeviceNumber());
	    if(id!=null&&id>0) {
	        tablet.setId(id);
	        modifyTabletOnline(String.valueOf(id),"1");
	        return;
	    }
		tabletDAO.insertTablet(tablet);
		tabletDAO.insertTabletStatus(tablet);
	}
	
	/**
	 * 
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param userId
	 * @param tabletId
	 * @param tc
	 * @since JDK 1.6
	 */
	@Transactional(rollbackFor =
	        com.megaeyes.fin.exception.MegaException.class)
	@Caching(evict = {
            //@CacheEvict(value = "memcache" , key = "'allTablet2'") ,
            @CacheEvict(value = "memcache" , key = "'tabletCamara:'+#tc.id") })
    public void modifyTablet(
            final String userId,
            final MboxTabletCamara tc) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tabletId", tc.getId());
		map.put("name", tc.getName());
		map.put("address", tc.getAddress());
		tabletDAO.modifyTablet(map);
		tabletDAO.deleteCamara(tc.getId());
		for (VideoInputChannel vic : tc.getList()) {
			map.put("vicId", vic.getId());
			tabletDAO.insertCamara(map);
		}
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param userId
	 * @param tabletId
	 * @param status
	 * @since JDK 1.6
	 */
	@Transactional(rollbackFor =
	        com.megaeyes.fin.exception.MegaException.class)
	//@CacheEvict(value = "memcache", key = "'allTablet2'")
	public void modifyTabletStatus(
	        final String userId,
	        final String tabletId,
	        final String status) {
	    Map<String , Object> map = new HashMap<String , Object>();
	    map.put("status", Integer.parseInt(status));
	    map.put("tabletId", tabletId);
		tabletDAO.modifyTabletStatus(map);
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param tabletId
	 * @param lineStatus
	 * @since JDK 1.6
	 */
	@Transactional(rollbackFor =
	        com.megaeyes.fin.exception.MegaException.class)
	//@CacheEvict(value = "memcache", key = "'allTablet2'")
	public void modifyTabletOnline(
	        final String tabletId,
	        final String lineStatus) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tabletId", Long.parseLong(tabletId));
        map.put("lineStatus", Integer.parseInt(lineStatus));
		tabletDAO.modifyTabletOnline(map);
		
	      if ("0".equals(lineStatus)) {
	          Map<String , Object> status = new HashMap<String , Object>();
	          status.put("dealStatus", 0);
	          status.put("tabletId", tabletId);
	          tabletDAO.modifyTabletDealStatus(status);
	        }
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param tabletId
	 * @return tag
	 * @since JDK 1.6
	 */
	@Transactional(readOnly = true ,
	        rollbackFor = com.megaeyes.fin.exception.MegaException.class)
	@Cacheable(value = "memcache", key = "'tabletCamara:'+#tabletId")
	public List<VideoInputChannel> getCamaraByTabletId(
	        final String tabletId) {
		return tabletDAO.getCamaraByTabletId(Long.parseLong(tabletId));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param userId
	 * @param sessionId
	 * @param tabletId
	 * @param status
	 * @throws MegaException
	 * @since JDK 1.6
	 */
	@Transactional(rollbackFor =
	        com.megaeyes.fin.exception.MegaException.class)
	public LockTabletDTO lockTalet(String userId ,
	        String sessionId , String tabletId,String eventId) throws MegaException {
        int count = tabletDAO.checkLock(Long.parseLong(tabletId));
        if (count > 0) {
            LockTabletDTO dto = new LockTabletDTO();
            Map<String , Object> map = new HashMap<String , Object>();
            map.put("userId", userId);
            map.put("sessionId", sessionId);
            map.put("tabletId", Long.parseLong(tabletId));
            map.put("status", 1);
            tabletDAO.lockTablet(map);
            List<VideoInputChannel> vicList = tabletDAO.getCamaraByTabletId(Long.parseLong(tabletId));
            for(VideoInputChannel vic : vicList) {
                InterPhone ip = tabletDAO.getInterPhone(vic.getId());
                if(ip!=null) {
                    dto.setInterPhone(ip);
                    break;
                }
            }
            List<TabletUser> userList = eventDAO.getMboxUser(eventId);
            dto.setVicList(vicList);
            dto.setUserList(userList);
            return dto;
        } else {
            throw new MegaException("LOCK_ERROR");
        }

	}
	
    @Transactional(rollbackFor =
            com.megaeyes.fin.exception.MegaException.class)
    public LockTabletDTO brushFinger(String userId ,
            String sessionId , String tabletId,String eventId) throws MegaException {
        LockTabletDTO dto = new LockTabletDTO();
        List<VideoInputChannel> vicList = tabletDAO.getCamaraByTabletId(Long.parseLong(tabletId));
        for(VideoInputChannel vic : vicList) {
            InterPhone ip = tabletDAO.getInterPhone(vic.getId());
            if(ip!=null) {
                dto.setInterPhone(ip);
                break;
            }
        }
        List<TabletUser> userList = eventDAO.getMboxUser(eventId);
        dto.setVicList(vicList);
        dto.setUserList(userList);
        return dto;

    }	
	@Transactional(rollbackFor =
            com.megaeyes.fin.exception.MegaException.class)
	public void unLockTablet(String userId ,
            String sessionId , String tabletId) {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("tabletId", Long.parseLong(tabletId));
        map.put("status", 0);
        tabletDAO.unLockTablet(map);
	}
	
}
