/**
 * Project Name:fin_center
 * File Name:TabletGroupService.java
 * Package Name:com.megaeyes.fin.service
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

import com.megaeyes.fin.dao.TabletGroupDAO;
import com.megaeyes.fin.po.Tablet;
import com.megaeyes.fin.po.TabletGroup;
import com.megaeyes.fin.po.User;

/**
 *
 * ClassName: TabletGroupService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *
 * @author dengbin ibcm@qq.com
 * @since JDK 1.6
 */
@Service
public class TabletGroupService {

    /***/
    @Autowired
    private TabletGroupDAO groupDAO;
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
    public final void setGroupDAO(TabletGroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @return tag
     * @since JDK 1.6
     */
    @Transactional(readOnly = true)
    @Cacheable(value = "memcache" , key = "'allTabletGroup'")
    public List<TabletGroup> getTabletGroup(
            final String userId) {
        return groupDAO.queryTabletGroup();
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param tabletGroupId
     * @return tag
     * @since JDK 1.6
     */
    @Transactional(readOnly = true)
    @Cacheable(value = "memcache" , key = "'tabletGroupDetail:'+#tabletGroupId")
    public TabletGroup getTabletGroupDetail(
            final String userId ,
            final String tabletGroupId) {
        TabletGroup group = new TabletGroup();
        group.setId(Long.parseLong(tabletGroupId));
        List<User> userList = groupDAO.queryGroupUser(group.getId());
        List<Tablet> tabletList = groupDAO.queryGroupTablet(group.getId());
        group.setUserList(userList);
        group.setTabletList(tabletList);
        return group;
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param group
     * @since JDK 1.6
     */
    @Transactional(rollbackFor = com.megaeyes.fin.exception.MegaException.class)
    @Caching(evict = {
            @CacheEvict(value = "memcache" , key = "'allTabletGroup'") ,
            @CacheEvict(value = "memcache" ,
            key = "'tabletGroupDetail:'+#group.id",condition="#group.id>0") })
    public void saveTabletGroup(
            final String userId ,
            final TabletGroup group) {
        group.setCreateUser(userId);
        List<Tablet> tabletList = group.getTabletList();
        List<User> userList = group.getUserList();
        if (group.getId() > 0) {
            groupDAO.updateTabletGroup(group);
            groupDAO.clearGroupTablet(group.getId());
            groupDAO.clearGroupUser(group.getId());
        } else {
            groupDAO.insertTabletGroup(group);
        }
        updateGroupUserTablet(group.getId(), userList, tabletList);
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param tabletGroupId
     * @since JDK 1.6
     */
    @Transactional(
            rollbackFor = com.megaeyes.fin.exception.MegaException.class)
    @Caching(evict = {
            @CacheEvict(value = "memcache" , key = "'allTabletGroup'") ,
            @CacheEvict(value = "memcache" ,
            key = "'tabletGroupDetail:'+#tabletGroupId") })
    public void removeTabletGroup(
            final String userId ,
            final String tabletGroupId) {
        groupDAO.clearGroupTablet(Long.parseLong(tabletGroupId));
        groupDAO.clearGroupUser(Long.parseLong(tabletGroupId));
        groupDAO.removeTabletGroup(Long.parseLong(tabletGroupId));
    }
    /**
     * 
     *
     * @author dengbin ibcm@qq.com
     * @param groupId
     * @param userList
     * @param tabletList
     * @since JDK 1.6
     */
    public void updateGroupUserTablet(
            final long groupId ,
            final List<User> userList ,
            final List<Tablet> tabletList) {
        for (User user : userList) {
            Map<String , Object> map = new HashMap<String , Object>();
            map.put("groupId", groupId);
            map.put("userId", user.getId());
            groupDAO.insertGroupUser(map);
        }
        for (Tablet tablet : tabletList) {
            Map<String , Object> map = new HashMap<String , Object>();
            map.put("groupId", groupId);
            map.put("tabletId", tablet.getId());
            groupDAO.insertGroupTablet(map);
        }
    }
    @Transactional(readOnly = true)
    public List<User> getSystemUser() {
        return groupDAO.getSystemUser();
    }
}
