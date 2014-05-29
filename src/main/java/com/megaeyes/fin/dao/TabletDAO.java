/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 *  
*/  

package com.megaeyes.fin.dao;

import java.util.List;
import java.util.Map;

import com.megaeyes.fin.dao.core.MyBatisRepository;
import com.megaeyes.fin.po.InterPhone;
import com.megaeyes.fin.po.Tablet;
import com.megaeyes.fin.po.VideoInputChannel;


/**
 *
 * ClassName: TabletDAO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *
 * @author dengbin ibcm@qq.com
 * @version
 * @since JDK 1.6
 */
@MyBatisRepository
public interface TabletDAO {



	/**
	 * 
	 * queryTablet:. <br/>  
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param queryParam
	 * @return  tag
	 * @since JDK 1.6
	 */
	public List<Tablet> queryTablet(Tablet queryParam);
	
	/**
	 * 
	 * modifyTablet:. <br/>  
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param map  
	 * @since JDK 1.6
	 */
	public void modifyTablet(Map<String, Object> map);
	
	/**
	 * 
	 * deleteCamara:. <br/>  
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param tabletId  
	 * @since JDK 1.6
	 */
	public void deleteCamara(long tabletId);
	
	/**
	 * 
	 * insertCamara:. <br/>  
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param map  
	 * @since JDK 1.6
	 */
	public void insertCamara(Map<String,Object> map);
	
	/**
	 * 
	 * insertTablet:. <br/>  
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param tablet  
	 * @since JDK 1.6
	 */
	public void insertTablet(Tablet tablet);
	
	
	public void insertTabletStatus(Tablet tablet);
	
	/**
	 * 
	 * modifyTabletStatus:. <br/>  
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param userId
	 * @param tabletId
	 * @param status  
	 * @since JDK 1.6
	 */
	public void modifyTabletStatus(Map map);
	
	/**
	 * 
	 * modifyTabletOnline:. <br/>  
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param tabletId
	 * @param lineStatus  
	 * @since JDK 1.6
	 */
	public void modifyTabletOnline(Map map);
	
	public void modifyTabletDealStatus(Map map);
	
	/**
	 * 
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param tabletId
	 * @return  tag
	 * @since JDK 1.6
	 */
	public List<VideoInputChannel> getCamaraByTabletId(long tabletId);
	/**
	 * 
	 *
	 * @author dengbin ibcm@qq.com
	 * @param tabletId
	 * @return
	 * @since JDK 1.6
	 */
	public int checkLock(long tabletId);
	
	public int lockTablet(Map map);
	
	public int unLockTablet(Map map);
	
	public Tablet getTabletById(long id);
	
	public InterPhone getInterPhone(String vicId);
	
	public Long getIdByNumber(String deviceNumber);
}
