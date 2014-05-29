/**
 * Project Name:fin_center
 * File Name:MboxUser.java
 *
*/

package com.megaeyes.fin.controller;

import java.io.IOException;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.megaeyes.fin.common.Constants;
import com.megaeyes.fin.common.Message;
import com.megaeyes.fin.exception.MegaException;
import com.megaeyes.fin.utill.XmlUtil;

/**
 *
 * ClassName: ExceptionController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *
 * @author ICBM
 * @version
 * @since JDK 1.6
 */
@Controller
public class ExceptionController {
    /***/
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     *
     *
     * @author dengbin ibcm@qq.com
     * @param request
     * @param response
     * @throws IOException
     * @since JDK 1.6
     */
    @RequestMapping("/exception")
    public final void exception(
            final HttpServletRequest request ,
            final HttpServletResponse response) throws IOException {
         String flag = request.getParameter("flag");
         ResourceBundle bundle = ResourceBundle.getBundle("exception");
         Exception ex = (Exception) request.getAttribute("exception");
         Message message = new Message(Constants.RESULT_FAIL);
         if ("MyException".equals(flag)) {
             logger.error(
                     bundle.getString(((MegaException) ex).getErrorKey()));
             message.setScript(
                     bundle.getString(((MegaException) ex).getErrorKey()));
         } else if ("DbException".equals(flag)) {
             logger.error(ex.toString());
             message.setScript("sql异常" + ex.toString());
         } else {
             logger.error(ex.toString());
             message.setScript("系统异常" + ex.toString());
         }
         response.getWriter().write(XmlUtil.objectToString(message));
    }
}
