/**
 * Project Name:fin_center
 * File Name:MboxUserDAO.java
 * Package Name:com.megaeyes.fin.dao
 *
*/
package com.megaeyes.fin.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.megaeyes.fin.dao.core.MyBatisRepository;
import com.megaeyes.fin.po.TabletUser;

/**
 * ClassName:MboxUserDAO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
@MyBatisRepository
public interface MboxUserDAO {

    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param user
     * @since JDK 1.6
     */
    public void insertUser(TabletUser user);
    /**
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @since JDK 1.6
     */
    public void removeUser(long userId);
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @return
     * @since JDK 1.6
     */
    public List<TabletUser> getMboxUser(Map map);
    /**
     * 
     *
     * @author dengbin ibcm@qq.com
     * @param user
     * @return
     * @since JDK 1.6
     */
    public int checkTabletUser(TabletUser user);
    
    public Date getLastUpdateTime();
    
    public List<TabletUser> getUpdateUser(Date update);
}
