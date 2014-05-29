/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 *  
*/  

package com.megaeyes.fin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.megaeyes.fin.common.Constants;
import com.megaeyes.fin.common.Message;
import com.megaeyes.fin.dto.LockTabletDTO;
import com.megaeyes.fin.dto.MboxTabletCamara;
import com.megaeyes.fin.exception.MegaException;
import com.megaeyes.fin.po.Tablet;
import com.megaeyes.fin.po.VideoInputChannel;
import com.megaeyes.fin.service.TabletService;
import com.megaeyes.fin.utill.XmlUtil;

/**
 *
 * ClassName: TabletController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *
 * @author ICBM
 * @version
 * @since JDK 1.6
 */
@Controller
public class TabletController {

    /***/
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /***/
    @Autowired
    private TabletService tabletService;

	/**  
     * tabletService.  
     *  
     * @return  the tabletService  
     * @since   JDK 1.6  
     */
    public final TabletService getTabletService() {
        return tabletService;
    }


    /**
	 * tabletService.
	 *
	 * @param   tabletService1    the tabletService to set
	 * @since   JDK 1.6
	 */
	public final void setTabletService(final TabletService tabletService1) {
		this.tabletService = tabletService1;
	}



	/**
	 * 
	 *  
	 * @param userId
	 * @param xml
	 * @param response
	 * @throws IOException  
	 * @since JDK 1.6
	 */
	@RequestMapping("/registTablet")
    public void addTablet(
			@RequestParam(value = "xml", required = false)
            final String xml,
			final HttpServletResponse response) throws IOException {
		Tablet tablet = (Tablet) XmlUtil.
		        stringToObject(xml, Tablet.class);
		System.out.println(xml);
		tabletService.addTablet(tablet);
		String result = "<Message code=\"0000\" script=\"操作成功\"><PadWorkID>"+tablet.getId()+"</PadWorkID></Message>";
		response.getWriter().write(result);
	}
	

	/**
	 * 
		Xml: 
		<Message>
		  <TabletName></TabletName>
		  <Number></Number>
		  <TabletIp></TabletIp>
		  <Address></Address>
		  <Status></Status>
		   <LineStatus></LineStatus>
		  <DealStatus></DealStatus>
		</Message>
		<Message code="0000" script="">
		<Tablet id="" name="" status="" lineStatus="" address=""deviceNumber=""deviceIp="" devicePort="" 
		dealStatus="" lockStatus="" lockUser="" lockUserName="" linkman="" phone="" createTime="" clientMac=""lockTime="" sessionId=""/>
		</Message>
 
	 *  
	 * @author ICBM  
	 * @param userId
	 * @param response
	 * @throws IOException  
	 * @since JDK 1.6
	 */
	@RequestMapping("/getTablet")
    public void getTablet(
			@RequestParam(value = "userId", required = true)
			final String userId,
			@RequestParam(value = "xml")final String xml,
			final HttpServletResponse response) throws IOException {
	    Tablet queryParam = (Tablet) XmlUtil.
		        stringToObject(xml, Tablet.class);
		List<Tablet> list = tabletService.
		        getTablet(userId, queryParam);
		Message message = new Message(Constants.RESULT_SUCCESS);
		message.setObject(list);
		response.getWriter().write(XmlUtil.objectToString(message));
	}
	
	/**
	 * 
	 * Xml=
		<Message>
		   <Tablet id="" name="" address="">
		       <VideoInputChannel id="" />
		   </Tablet>
		</Message>
 
	 *  <Message code="0000" script=""/>
	 *  
	 *  
	 * @author dengbin ibcm@qq.com  
	 * @param userId
	 * @param tabletId
	 * @param xml
	 * @param response
	 * @throws IOException  
	 * @since JDK 1.6
	 */
	@RequestMapping("/modifyTablet")
    public void modifyTablet(
			@RequestParam(value = "userId", required = true)
			final String userId,
			@RequestParam(value = "xml", required = true)
			final String xml,	
			final HttpServletResponse response) throws IOException{
		MboxTabletCamara tc = (MboxTabletCamara) XmlUtil.
		        stringToObject(xml, MboxTabletCamara.class);
 		tabletService.modifyTablet(userId, tc);
		response.getWriter().write(
		        XmlUtil.objectToString(
		                new Message(Constants.RESULT_SUCCESS)));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param userId
	 * @param tabletId
	 * @param status
	 * @param response
	 * @throws IOException
	 * @since JDK 1.6
	 */
	@RequestMapping("/modifyTabletStatus")
    public void modifyTabletStatus(
			@RequestParam(value = "userId", required = true)
			final String userId ,
			@RequestParam(value = "tabletId", required = true)
			final String tabletId ,
			@RequestParam(value = "status", required = true)
			final String status ,
			final HttpServletResponse response) throws IOException{
		tabletService.modifyTabletStatus(userId, tabletId, status);
		response.getWriter().write(
		        XmlUtil.objectToString(
		                new Message(Constants.RESULT_SUCCESS)));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param tabletId
	 * @param lineStatus
	 * @param response
	 * @throws IOException
	 * @since JDK 1.6
	 */
	@RequestMapping("/modifyTabletOnline")
    public void modifyTabletOnline(
			@RequestParam(value = "tabletId", required = true)
			final String tabletId,
			@RequestParam(value = "lineStatus", required = true)
			final String lineStatus,
			final HttpServletResponse response) throws IOException{
		tabletService.modifyTabletOnline(tabletId, lineStatus);
		response.getWriter().write(
		        XmlUtil.objectToString(
		                new Message(Constants.RESULT_SUCCESS)));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param userId
	 * @param tabletId
	 * @param response
	 * @throws IOException
	 * @since JDK 1.6
	 */
	@RequestMapping("/getCamaraByTabletId")
    public void getCamaraByTabletId(
			@RequestParam(value = "userId", required = true)
			final String userId ,
			@RequestParam(value = "tabletId", required = true)
			final String tabletId ,
			final HttpServletResponse response) throws IOException{
		List<VideoInputChannel> list = tabletService.
		        getCamaraByTabletId(tabletId);
		Message message = new Message(Constants.RESULT_SUCCESS);
		message.setObject(list);
		response.getWriter().write(XmlUtil.objectToString(message));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param tabletId
	 * @param userId
	 * @param sessionId
	 * @param clientMac
	 * @throws MegaException 
	 * @throws IOException 
	 * @since JDK 1.6
	 */
	@RequestMapping("/lockTablet")
	public void lockTalet(
            @RequestParam(value = "eventId", required = true)
            final String eventId ,	        
            @RequestParam(value = "tabletId", required = true)
            final String tabletId ,
	        @RequestParam(value = "userId", required = true)
	        final String userId ,
	        @RequestParam(value = "sessionId", required = true)
	        final String sessionId ,
            final HttpServletResponse response)
                    throws MegaException, IOException {
	    LockTabletDTO dto = tabletService.lockTalet(userId, sessionId, tabletId,eventId);
	    dto.setTabletId(tabletId);
	    dto.setEventId(eventId);
	    Message message = new Message(Constants.RESULT_SUCCESS);
	    message.setObject(dto);
	    response.getWriter().write(
	            XmlUtil.objectToString(message));
	}
	
       @RequestMapping("/brushFinger")
        public void brushFinger(
                @RequestParam(value = "eventId", required = true)
                final String eventId ,          
                @RequestParam(value = "tabletId", required = true)
                final String tabletId ,
                @RequestParam(value = "userId", required = false)
                final String userId ,
                @RequestParam(value = "sessionId", required = false)
                final String sessionId ,
                final HttpServletResponse response)
                        throws MegaException, IOException {
            LockTabletDTO dto = tabletService.brushFinger(userId, sessionId, tabletId,eventId);
            dto.setTabletId(tabletId);
            dto.setEventId(eventId);
            Message message = new Message(Constants.RESULT_SUCCESS);
            message.setObject(dto);
            response.getWriter().write(
                    XmlUtil.objectToString(message));
        }
	/**
	 * 
	 *
	 * @author dengbin ibcm@qq.com
	 * @param tabletId
	 * @param userId
	 * @param sessionId
	 * @param response
	 * @throws IOException
	 * @since JDK 1.6
	 */
	@RequestMapping("/unLockTablet")
	public void unLockTablet(
	           @RequestParam(value = "tabletId", required = true)
	            final String tabletId ,
	              @RequestParam(value = "eventId", required = true)
                final String eventId ,
	            @RequestParam(value = "userId", required = true)
	            final String userId ,
	            @RequestParam(value = "sessionId", required = true)
	            final String sessionId ,
	            final HttpServletResponse response) throws IOException {
	       tabletService.unLockTablet(userId, sessionId, tabletId);
	       String result = "<Message code='0000' script='操作成功'><LockTabletDTO eventId=\""+eventId+"\"/></Message>";
	       response.getWriter().write(result);
	}
}
