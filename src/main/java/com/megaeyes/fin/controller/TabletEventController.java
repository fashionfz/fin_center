/**
 * Project Name:fin_center
 * File Name:MboxUser.java
 * Package Name:com.megaeyes.fin.po
 *
*/

package com.megaeyes.fin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.megaeyes.fin.common.Constants;
import com.megaeyes.fin.common.Message;
import com.megaeyes.fin.dto.MboxTabletSchema;
import com.megaeyes.fin.po.TabletEvent;
import com.megaeyes.fin.service.MboxEventService;
import com.megaeyes.fin.utill.XmlUtil;

/**
 *
 * ClassName: AuthenticateController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *
 * @author dengbin ibcm@qq.com
 * @version
 * @since JDK 1.6
 */
@Controller
public class TabletEventController {
    /***/
    private final SimpleDateFormat df =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /***/
    @Autowired
	private MboxEventService eventService;
	/**
     * eventService.
     *
     * @return  the eventService
     * @since   JDK 1.6
     */
    public MboxEventService getEventService() {
        return eventService;
    }
    /**
     * eventService.
     *
     * @param   eventService    the eventService to set
     * @since   JDK 1.6
     */
    public void setEventService(MboxEventService eventService) {
        this.eventService = eventService;
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param tabletEventId
     * @param tabletId
     * @param beginTime
     * @param response
     * @throws IOException
     * @throws ParseException 
     * @since JDK 1.6
     */
	@RequestMapping("/beginTabletCheck")
	public void beginTabletCheck(
			@RequestParam(value = "tabletEventId" , required = false)
			final String tabletEventId ,
			@RequestParam( value = "PadWorkID" , required = false)
			final String PadWorkID ,
			@RequestParam(value = "beginTime" , required = false)
			final String beginTime ,
			final HttpServletResponse response)
			        throws IOException, ParseException{
	    Message message = new Message(Constants.RESULT_SUCCESS);
		MboxTabletSchema schema = eventService.
		        beginAuthenticate(tabletEventId,
		                Long.parseLong(PadWorkID), df.parse(beginTime));
		message.setObject(schema);
		response.getWriter().write(XmlUtil.objectToString(message));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param tabletUserId
	 * @param tabletEventId
	 * @param brushTime
	 * @param tabletId
	 * @param response
	 * @throws IOException
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 * @since JDK 1.6
	 */
	@RequestMapping("/doTabletCheck")
	public void doTabletCheck(
			@RequestParam(value = "tabletUserId" , required = false)
			final String tabletUserId ,
			@RequestParam(value = "tabletEventId" , required = true)
			final String tabletEventId ,
			@RequestParam(value = "brushTime" , required = false)
			final String brushTime,
			@RequestParam(value = "PadWorkID" , required = false)
			final String PadWorkID ,
			final HttpServletResponse response)
			        throws IOException ,
			        NumberFormatException ,
			        ParseException {
	       Message message = new Message(Constants.RESULT_SUCCESS);
		MboxTabletSchema schema = eventService.
		        brushFingerprint(
		                tabletEventId,
		                Long.parseLong(PadWorkID),
		                tabletUserId,
		                brushTime);
		message.setObject(schema);
		response.getWriter().write(XmlUtil.objectToString(message));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param tabletEventId
	 * @param tabletId
	 * @param endTime
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 * @throws NumberFormatException
	 * @since JDK 1.6
	 */
	@RequestMapping("/endTabletCheck")
	public void endTabletCheck(
			@RequestParam(value = "tabletEventId" , required = false)
			final String tabletEventId ,
			@RequestParam(value = "tabletId" , required = false)
			final String tabletId ,
			@RequestParam(value = "endTime" , required = false)
			final String endTime ,
			final HttpServletResponse response)
			        throws IOException, NumberFormatException, ParseException{
	    Message message = new Message(Constants.RESULT_SUCCESS);
		MboxTabletSchema schema = eventService.
		        endAuthenticate(tabletEventId, Long.parseLong(tabletId), endTime);
		message.setObject(schema);
		response.getWriter().write(XmlUtil.objectToString(message));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @throws IOException
	 * @since JDK 1.6
	 */
	@RequestMapping("/addTabletEvent")
	public void offLineUpdateLog(
	        @RequestParam(value = "xml" , required = false)
	        final String xml ,
	        final HttpServletResponse response) throws IOException {
	    List<Object> list = XmlUtil.stringToList(xml, TabletEvent.class);
	    eventService.offLineUpdateLog(list);
	    response.getWriter().write(
	            XmlUtil.objectToString(
	                    new Message(Constants.RESULT_SUCCESS)));
	}
	/**
	 *
	 *
	 * @author dengbin ibcm@qq.com
	 * @param response
	 * @throws IOException
	 * @since JDK 1.6
	 */
	@RequestMapping("/getTabletEvent")
	public void getTabletEvent(
	        @RequestParam(value = "intransfer")final String intransfer ,
	        final HttpServletResponse response) throws IOException {
	    List<TabletEvent> list = eventService.getTabletEvent(intransfer);
	    Message message = new Message(Constants.RESULT_SUCCESS);
	    message.setObject(list);
	    response.getWriter().write(XmlUtil.objectToString(message));
	}
	
	@RequestMapping("/dealTabletEvent")
	public void dealTabletEvent(String eventId,String context,String userId,
	        HttpServletResponse response) throws IOException {
	    eventService.dealTabletEvent(eventId, context, userId);
        String result = "<Message code='0000' script='²Ù×÷³É¹¦'><LockTabletDTO eventId=\""+eventId+"\"/></Message>";
        response.getWriter().write(result);
	}
}
