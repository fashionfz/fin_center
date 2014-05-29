/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 *  
*/  

package com.megaeyes.fin.po;

/**
 * 
 * ClassName: User <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 *  
 * @author dengbin ibcm@qq.com  
 * @version   
 * @since JDK 1.6
 */
public class User implements java.io.Serializable{

	/**
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String id;
	private String userName;
	private String name;
	private String naming;
	private String info="";
	private String level="";
	/**  
	 * id.  
	 *  
	 * @return  the id  
	 * @since   JDK 1.6  
	 */
	public String getId() {
		return id;
	}
	/**  
	 * id.  
	 *  
	 * @param   id    the id to set  
	 * @since   JDK 1.6  
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**  
	 * userName.  
	 *  
	 * @return  the userName  
	 * @since   JDK 1.6  
	 */

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
    public final void setName(String name) {
        this.name = name;
    }

	/**
     * userName.
     *
     * @return  the userName
     * @since   JDK 1.6
     */
    public final String getUserName() {
        return userName;
    }
    /**
     * userName.
     *
     * @param   userName    the userName to set
     * @since   JDK 1.6
     */
    public final void setUserName(String userName) {
        this.userName = userName;
    }
    /**  
	 * naming.  
	 *  
	 * @return  the naming  
	 * @since   JDK 1.6  
	 */
	public String getNaming() {
		return naming;
	}
	/**  
	 * naming.  
	 *  
	 * @param   naming    the naming to set  
	 * @since   JDK 1.6  
	 */
	public void setNaming(String naming) {
		this.naming = naming;
	}
    /**
     * info.
     *
     * @return  the info
     * @since   JDK 1.6
     */
    public final String getInfo() {
        return info;
    }
    /**
     * info.
     *
     * @param   info    the info to set
     * @since   JDK 1.6
     */
    public final void setInfo(String info) {
        this.info = info;
    }
    /**
     * level.
     *
     * @return  the level
     * @since   JDK 1.6
     */
    public final String getLevel() {
        return level;
    }
    /**
     * level.
     *
     * @param   level    the level to set
     * @since   JDK 1.6
     */
    public final void setLevel(String level) {
        this.level = level;
    }
	

	
	
}
