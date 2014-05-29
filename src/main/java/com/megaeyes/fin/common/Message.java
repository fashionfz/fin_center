/**  
 *  
*/ 

package com.megaeyes.fin.common;

public class Message {

	private String code;
	private String script;
	private Object object;
	
	/**
	 * 
	 * Creates a new instance of Message.  
	 *  
	 * @param type
	 */
	public Message(int type){
		if(Constants.RESULT_SUCCESS==type){
			code="0000";
			script="操作成功";
		}else{
			code="0001";
			script="操作失败";
		}
	}

	/**  
	 * code.  
	 *  
	 * @return  the code  
	 * @since   JDK 1.6  
	 */
	public String getCode() {
		return code;
	}

	/**  
	 * code.  
	 *  
	 * @param   code    the code to set  
	 * @since   JDK 1.6  
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**  
	 * script.  
	 *  
	 * @return  the script  
	 * @since   JDK 1.6  
	 */
	public String getScript() {
		return script;
	}

	/**  
	 * script.  
	 *  
	 * @param   script    the script to set  
	 * @since   JDK 1.6  
	 */
	public void setScript(String script) {
		this.script = script;
	}

	/**  
	 * object.  
	 *  
	 * @return  the object  
	 * @since   JDK 1.6  
	 */
	public Object getObject() {
		return object;
	}

	/**  
	 * object.  
	 *  
	 * @param   object    the object to set  
	 * @since   JDK 1.6  
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
