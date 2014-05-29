/**
 * Project Name:fin_center
 * File Name:MboxUserController.java
 * Package Name:com.megaeyes.fin.controller
 *
*/
package com.megaeyes.fin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.megaeyes.fin.common.Constants;
import com.megaeyes.fin.common.Message;
import com.megaeyes.fin.dto.TabletClientGetUserDTO;
import com.megaeyes.fin.po.TabletUser;
import com.megaeyes.fin.service.MboxUserService;
import com.megaeyes.fin.utill.XmlUtil;
/**
 * ClassName:MboxUserController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * @version
 * @since    JDK 1.6
 * @see
 */
@Controller
public class MboxUserController {
    /***/
    @Autowired
    private MboxUserService userService;
    /**
     * userService.
     *
     * @return  the userService
     * @since   JDK 1.6
     */
    public final MboxUserService getUserService() {
        return userService;
    }
    /**
     * userService.
     *
     * @param   userService    the userService to set
     * @since   JDK 1.6
     */
    public final void setUserService(MboxUserService userService) {
        this.userService = userService;
    }
    /**
     *
        <Message>
        <TabletUser name="zhansan" userNumber="12222" codeType="0" code="51398728282"
        compy="tianyi" photo="101010101" photoType="jpg" fingerPrint="" fingerPrint2=""
        fingerPrintType="" phone="010-110" note="test"/>
        </Message>
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param xml
     * @throws IOException
     * @since JDK 1.6
     */
    @RequestMapping("/addTabletUser")
    public void addMboxUser(
            @RequestParam(value = "userId" , required = true)
            final String userId ,
            @RequestParam(value = "xml" , required = true)
            final String xml ,
            final HttpServletResponse response) throws IOException {
        List<Object> list = XmlUtil.stringToList(xml, TabletUser.class);
        userService.addUserList(list);
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
    @RequestMapping("/getTabletUser")
    public void getMboxUser(
            @RequestParam(value = "userId" , required = true)
            final String userId ,
            @RequestParam(value = "identityNumber" , required = false)
            final String identityNumber ,
            @RequestParam(value = "userName" , required = false)
            final String userName ,
            final HttpServletResponse response) throws IOException {
        List<TabletUser> list = userService.getMboxUser(userId,userName,identityNumber);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(list);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param userId
     * @param tabletUserId
     * @param response
     * @throws IOException
     * @since JDK 1.6
     */
    @RequestMapping("/removeTabletUser")
    public void removeTabletUser(
            @RequestParam(value = "userId" , required = true)
            final String userId ,
            @RequestParam(value = "tabletUserId" , required = true)
            final String tabletUserId ,
            final HttpServletResponse response) throws IOException {
        userService.remvoeUser(Long.parseLong(tabletUserId));
        response.getWriter().write(
                XmlUtil.objectToString(
                        new Message(Constants.RESULT_SUCCESS)));
    }
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @throws IOException 
     * @throws ParseException 
     * @since JDK 1.6
     */
    @RequestMapping("/loadCustomer")
    public void getUpdateMobxUser(
            @RequestParam(value = "PadWorkID" , required = true)
            final String PadWorkID ,
            @RequestParam(value = "LastUpdateTime" , required = false)
            final String LastUpdateTime ,
            final HttpServletResponse response)
                    throws IOException, ParseException {
        TabletClientGetUserDTO dto = userService.
                getUpdateTabletUser(LastUpdateTime);
        Message message = new Message(Constants.RESULT_SUCCESS);
        message.setObject(dto);
        response.getWriter().write(XmlUtil.objectToString(message));
    }
}
