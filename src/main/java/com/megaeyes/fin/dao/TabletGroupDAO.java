/**  
 * Project Name:fin_center  
 * File Name:TabletGroupDAO.java  
 * Package Name:com.megaeyes.fin.dao  
 * Date:2014年2月17日下午4:10:51  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/  
  
package com.megaeyes.fin.dao;   

import java.util.List;
import java.util.Map;

import com.megaeyes.fin.dao.core.MyBatisRepository;
import com.megaeyes.fin.po.Tablet;
import com.megaeyes.fin.po.TabletGroup;
import com.megaeyes.fin.po.User;

/**  
 * ClassName:TabletGroupDAO <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2014年2月17日 下午4:10:51 <br/>  
 * @author   dengbin ibcm@qq.com  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@MyBatisRepository
public interface TabletGroupDAO {

    /**
     *
     * queryTabletGroup:(这里用一句话描述这个方法的作用). <br/>
     *
     * @author dengbin ibcm@qq.com
     * @return  tag
     * @since JDK 1.6
     */
    public List<TabletGroup> queryTabletGroup();
    /**
     *
     * saveTabletGroup:(这里用一句话描述这个方法的作用). <br/>
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param group
     * @since JDK 1.6
     */
    public void insertTabletGroup(
            TabletGroup group);
    /**
     *
     * updateTabletGroup:(这里用一句话描述这个方法的作用). <br/>
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param group
     * @since JDK 1.6
     */
    public void updateTabletGroup(
            final TabletGroup group);
    /**
     *
     * removeTabletGroup:(这里用一句话描述这个方法的作用). <br/>
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param tabletGroupId
     * @since JDK 1.6
     */
    public void removeTabletGroup(long groupId);
    /**
     *
     * clearGroupUser:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author dengbin ibcm@qq.com
     * @param groupId
     * @since JDK 1.6
     */
    public void clearGroupUser(long groupId);
    /**
     *
     * clearGroupTablet:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author dengbin ibcm@qq.com
     * @param groupId
     * @since JDK 1.6
     */
    public void clearGroupTablet(long groupId);
    /**
     * 
     * insetGroupUser:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author dengbin ibcm@qq.com
     * @param groupId
     * @param userId
     * @since JDK 1.6
     */
    public void insertGroupUser(Map<String , Object> map);
    /**
     * 
     * insetGroupTablet:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author dengbin ibcm@qq.com
     * @param groupId
     * @param tabletId
     * @since JDK 1.6
     */
    public void insertGroupTablet(Map<String , Object> map);
    /**
     * 
     * queryGroupUser:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author dengbin ibcm@qq.com
     * @param groupId
     * @return
     * @since JDK 1.6
     */
    public List<User> queryGroupUser(long groupId);
    /**
     * 
     * queryGroupUserByTabletId:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author dengbin ibcm@qq.com
     * @param tabletId
     * @return
     * @since JDK 1.6
     */
    public List<User> queryGroupUserByTabletId(long tabletId);
    /**
     * 
     * queryGroupTablet:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author dengbin ibcm@qq.com
     * @param groupId
     * @return
     * @since JDK 1.6
     */
    public List<Tablet> queryGroupTablet(long groupId);
    /**
     * 
     * getSystemUser:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author dengbin ibcm@qq.com
     * @return
     * @since JDK 1.6
     */
    public List<User> getSystemUser();
}
