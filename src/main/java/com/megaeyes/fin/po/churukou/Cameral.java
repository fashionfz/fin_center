/**
 * Project Name:fin_center
 * File Name:Cameral.java
 * Package Name:com.megaeyes.fin.po.response
 * Date:2014��3��5������7:25:52
 * Copyright (c) 2014, �Ĵ�����   All Rights Reserved.
 *
*/
  
package com.megaeyes.fin.po.churukou;   
/**
 * ClassName:Cameral <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014��3��5�� ����7:25:52 <br/>
 * @author   dengbin ibcm@qq.com
 * @version
 * @since    JDK 1.6
 * @see
 */
public class Cameral implements java.io.Serializable{

    /**
     * serialVersionUID:TODO(��һ�仰�������������ʾʲô).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private String cameralId;
    private String cameralName;
    private String dir;
    /**
     * cameralId.
     *
     * @return  the cameralId
     * @since   JDK 1.6
     */
    public final String getCameralId() {
        return cameralId;
    }
    /**
     * cameralId.
     *
     * @param   cameralId    the cameralId to set
     * @since   JDK 1.6
     */
    public final void setCameralId(String cameralId) {
        this.cameralId = cameralId;
    }
    /**
     * cameralName.
     *
     * @return  the cameralName
     * @since   JDK 1.6
     */
    public final String getCameralName() {
        return cameralName;
    }
    /**
     * cameralName.
     *
     * @param   cameralName    the cameralName to set
     * @since   JDK 1.6
     */
    public final void setCameralName(String cameralName) {
        this.cameralName = cameralName;
    }
    /**
     * dir.
     *
     * @return  the dir
     * @since   JDK 1.6
     */
    public final String getDir() {
        return dir;
    }
    /**
     * dir.
     *
     * @param   dir    the dir to set
     * @since   JDK 1.6
     */
    public final void setDir(String dir) {
        this.dir = dir;
    }
    
}
