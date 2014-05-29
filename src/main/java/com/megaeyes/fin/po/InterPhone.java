/**
 * Project Name:fin_center
 * File Name:InterPhone.java
 * Package Name:com.megaeyes.fin.po
 * Date:2014年2月28日下午3:35:10
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.po;   
/**
 * ClassName:InterPhone <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年2月28日 下午3:35:10 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class InterPhone implements java.io.Serializable{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String deviceNumber;
    private String account;
    private String password;
    private String sipServerId;
    /**
     * id.
     *
     * @return  the id
     * @since   JDK 1.6
     */
    public final String getId() {
        return id;
    }
    /**
     * id.
     *
     * @param   id    the id to set
     * @since   JDK 1.6
     */
    public final void setId(String id) {
        this.id = id;
    }
    /**
     * name.
     *
     * @return  the name
     * @since   JDK 1.6
     */
    public final String getName() {
        return name;
    }
    /**
     * name.
     *
     * @param   name    the name to set
     * @since   JDK 1.6
     */
    public final void setName(String name) {
        this.name = name;
    }
    /**
     * deviceNumber.
     *
     * @return  the deviceNumber
     * @since   JDK 1.6
     */
    public final String getDeviceNumber() {
        return deviceNumber;
    }
    /**
     * deviceNumber.
     *
     * @param   deviceNumber    the deviceNumber to set
     * @since   JDK 1.6
     */
    public final void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }
    /**
     * account.
     *
     * @return  the account
     * @since   JDK 1.6
     */
    public final String getAccount() {
        return account;
    }
    /**
     * account.
     *
     * @param   account    the account to set
     * @since   JDK 1.6
     */
    public final void setAccount(String account) {
        this.account = account;
    }
    /**
     * password.
     *
     * @return  the password
     * @since   JDK 1.6
     */
    public final String getPassword() {
        return password;
    }
    /**
     * password.
     *
     * @param   password    the password to set
     * @since   JDK 1.6
     */
    public final void setPassword(String password) {
        this.password = password;
    }
    /**
     * sipServerId.
     *
     * @return  the sipServerId
     * @since   JDK 1.6
     */
    public final String getSipServerId() {
        return sipServerId;
    }
    /**
     * sipServerId.
     *
     * @param   sipServerId    the sipServerId to set
     * @since   JDK 1.6
     */
    public final void setSipServerId(String sipServerId) {
        this.sipServerId = sipServerId;
    }
    
}
