/**
 * Project Name:fin_center
 * File Name:MboxUserService.java
 * Package Name:com.megaeyes.fin.service
 *
*/
package com.megaeyes.fin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megaeyes.fin.dao.MboxUserDAO;
import com.megaeyes.fin.dto.TabletClientGetUserDTO;
import com.megaeyes.fin.po.TabletUser;

/**
 * ClassName:MboxUserService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
@Service
public class MboxUserService {
    private final SimpleDateFormat df =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /***/
    @Autowired
    private MboxUserDAO mboxUserDAO;
    /**
     * mboxUserDAO.
     *
     * @return  the mboxUserDAO
     * @since   JDK 1.6
     */
    public final MboxUserDAO getMboxUserDAO() {
        return mboxUserDAO;
    }

    /**
     * mboxUserDAO.
     *
     * @param   mboxUserDAO    the mboxUserDAO to set
     * @since   JDK 1.6
     */
    public final void setMboxUserDAO(MboxUserDAO mboxUserDAO) {
        this.mboxUserDAO = mboxUserDAO;
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param list
     * @since JDK 1.6
     */
    @Transactional(rollbackFor = com.megaeyes.fin.exception.MegaException.class)
    public void addUserList(final List<Object> list) {
        for (Object object : list) {
            if(mboxUserDAO.checkTabletUser((TabletUser)object)<1)
                mboxUserDAO.insertUser((TabletUser)object);
        }
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @since JDK 1.6
     */
    @Transactional(rollbackFor = com.megaeyes.fin.exception.MegaException.class)
    public void remvoeUser(final long userId) {
        mboxUserDAO.removeUser(userId);
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
    //@Cacheable(value = "memcache" , key = "'allMboxUser'")
    public List<TabletUser> getMboxUser(final String userId ,
            final String userName ,final String identityNumber) {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("userName", userName);
        map.put("identityNumber", identityNumber);
        return mboxUserDAO.getMboxUser(map);
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param updateTime
     * @return
     * @throws ParseException
     * @since JDK 1.6
     */
    @Transactional(readOnly = true)
    public TabletClientGetUserDTO getUpdateTabletUser(
            final String updateTime) throws ParseException {
        TabletClientGetUserDTO dto = new TabletClientGetUserDTO();
        dto.setLastModifyTime(mboxUserDAO.getLastUpdateTime());
        dto.setUserList(mboxUserDAO.getUpdateUser(df.parse(updateTime)));
        return dto;
    }
}
