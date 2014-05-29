/**  
 * Project Name:fin_center  
 * File Name:MboxTabletCamara.java  
 * Package Name:com.megaeyes.fin.dto  
 *  
*/  
  
package com.megaeyes.fin.dto;   

import java.util.List;
import com.megaeyes.fin.po.VideoInputChannel;

/**  
 * ClassName:MboxTabletCamara <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * @author   dengbin ibcm@qq.com  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class MboxTabletCamara implements java.io.Serializable{

	/**  
	 * @since JDK 1.6  
	 */  
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String address;
	private List<VideoInputChannel> list;
	
	/**  
	 * id.  
	 *  
	 * @return  the id  
	 * @since   JDK 1.6  
	 */

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
    public final void setId(long id) {
        this.id = id;
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
	 * address.  
	 *  
	 * @return  the address  
	 * @since   JDK 1.6  
	 */
	public String getAddress() {
		return address;
	}
	/**  
	 * address.  
	 *  
	 * @param   address    the address to set  
	 * @since   JDK 1.6  
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**  
	 * list.  
	 *  
	 * @return  the list  
	 * @since   JDK 1.6  
	 */
	public List<VideoInputChannel> getList() {
		return list;
	}
	/**  
	 * list.  
	 *  
	 * @param   list    the list to set  
	 * @since   JDK 1.6  
	 */
	public void setList(List<VideoInputChannel> list) {
		this.list = list;
	}
	
}
