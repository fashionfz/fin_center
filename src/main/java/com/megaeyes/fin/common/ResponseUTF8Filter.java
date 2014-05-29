/**  
 * Project Name:fin_center  
 * File Name:ResponseUTF8Filter.java  
 * Package Name:com.megaeyes.fin.common  
 * Date:2014年2月8日上午11:12:52  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/  
  
package com.megaeyes.fin.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ClassName:ResponseUTF8Filter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年2月8日 上午11:12:52 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class ResponseUTF8Filter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig)
            throws ServletException { }

    @Override
    public final void doFilter(final ServletRequest request ,
            final ServletResponse response ,
            final FilterChain chain)
                    throws IOException, ServletException {
        request.setCharacterEncoding("GB2312");
        response.setCharacterEncoding("GB2312");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { }
}

