/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 * Date:2014年2月7日上午11:01:35  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/  

package com.megaeyes.fin.po;

/**
 * 
 * ClassName: VideoInputChannel <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2014年2月7日 上午11:13:54 <br/>  
 *  
 * @author ICBM
 * @version   
 * @since JDK 1.6
 */
public class VideoInputChannel implements java.io.Serializable{

	/**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String id;
	private String name;
	private String naming;
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
	 * name.  
	 *  
	 * @return  the name  
	 * @since   JDK 1.6  
	 */
	public String getName() {
		return name;
	}
	/**  
	 * name.  
	 *  
	 * @param   name    the name to set  
	 * @since   JDK 1.6  
	 */
	public void setName(String name) {
		this.name = name;
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

	
}
