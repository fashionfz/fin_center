package com.megaeyes.fin.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author ICBM
 * @version 1.0
 */
public class TabletGroup implements java.io.Serializable{

	/**  
     *serialVersionUID:TODO(用一句话描述这个变量表示什么).  
     *@since JDK 1.6  
     */  
    private static final long serialVersionUID = 1L;
    /***/
    private Timestamp createTime;
    /***/
	private String createUser;
	/***/
	private long id;
	/***/
	private String name;
	/***/
	private int status;
	/***/
	private List<Tablet> tabletList;
	/***/
	private List<User> userList;
	
	
	
	
	

	/**  
     * createTime.  
     *  
     * @return  the createTime  
     * @since   JDK 1.6  
     */
    public final Timestamp getCreateTime() {
        return createTime;
    }

    /**  
     * createTime.  
     *  
     * @param   createTime    the createTime to set  
     * @since   JDK 1.6  
     */
    public final void setCreateTime(final Timestamp createTime) {
        this.createTime = createTime;
    }

    /**  
     * createUser.  
     *  
     * @return  the createUser  
     * @since   JDK 1.6  
     */
    public final String getCreateUser() {
        return createUser;
    }

    /**  
     * createUser.  
     *  
     * @param   createUser    the createUser to set  
     * @since   JDK 1.6  
     */
    public final void setCreateUser(final String createUser) {
        this.createUser = createUser;
    }

    /**  
     * id.  
     *  
     * @return  the id  
     * @since   JDK 1.6  
     */
    public final long getId() {
        return id;
    }

    /**  
     * id.  
     *  
     * @param   id    the id to set  
     * @since   JDK 1.6  
     */
    public final void setId(final long id) {
        this.id = id;
    }

    /**  
     * name.  
     *  
     * @return  the name  
     * @since   JDK 1.6  
     */
    public final String getName() {
        return name;
    }

    /**  
     * name.  
     *  
     * @param   name    the name to set  
     * @since   JDK 1.6  
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**  
     * status.  
     *  
     * @return  the status  
     * @since   JDK 1.6  
     */
    public final int getStatus() {
        return status;
    }

    /**  
     * status.  
     *  
     * @param   status    the status to set  
     * @since   JDK 1.6  
     */
    public final void setStatus(final int status) {
        this.status = status;
    }
    

    /**
     * tabletList.
     *
     * @return  the tabletList
     * @since   JDK 1.6
     */
    public final List<Tablet> getTabletList() {
        return tabletList;
    }

    /**
     * tabletList.
     *
     * @param   tabletList    the tabletList to set
     * @since   JDK 1.6
     */
    public final void setTabletList(List<Tablet> tabletList) {
        this.tabletList = tabletList;
    }

    /**  
     * userList.  
     *  
     * @return  the userList  
     * @since   JDK 1.6  
     */
    public List<User> getUserList() {
        return userList;
    }

    /**  
     * userList.  
     *  
     * @param   userList    the userList to set  
     * @since   JDK 1.6  
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    
}//end TabletGroup