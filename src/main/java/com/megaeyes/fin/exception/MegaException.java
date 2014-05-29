/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 * Date:2014年2月7日上午11:01:35  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/  

package com.megaeyes.fin.exception;


/**
 * 
 * ClassName: MegaException <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2014年2月7日 上午11:17:56 <br/>  
 *  
 * @author ICBM  
 * @version   
 * @since JDK 1.6
 */
public class MegaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorKey;
	
	
	/**  
	 * errorKey.  
	 *  
	 * @return  the errorKey  
	 * @since   JDK 1.6  
	 */
	public String getErrorKey() {
		return errorKey;
	}
	
	/**
	 * 
	 * Creates a new instance of MegaException.  
	 *  
	 * @param errorKey
	 */
	public MegaException(String errorKey){
		this.errorKey=errorKey;
	}
}
