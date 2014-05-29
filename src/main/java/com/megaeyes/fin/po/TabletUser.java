/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 * Date:2014年2月7日上午11:01:35  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/  
  
package com.megaeyes.fin.po;   

import java.util.Date;


/**  
 * ClassName:MboxUser <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2014年2月7日 上午11:01:35 <br/>  
 * @author   ICBM  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class TabletUser implements java.io.Serializable{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    private long id;
	private String name;
	private String userNumber;
	private int codeType;
	private String code;
	private String compy;
	private String photo;
	private String photoType;
	private String fingerPrint;
	private String fingerPrint2;
	private String fingerPrintType;
	private String phone;
	private String note;
	private boolean status;
	private Date createTime;
	private Date modifyTime;
	
	private Date brushTime;
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
     * userNumber.
     *
     * @return  the userNumber
     * @since   JDK 1.6
     */
    public final String getUserNumber() {
        return userNumber;
    }
    /**
     * userNumber.
     *
     * @param   userNumber    the userNumber to set
     * @since   JDK 1.6
     */
    public final void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
    /**
     * codeType.
     *
     * @return  the codeType
     * @since   JDK 1.6
     */
    public final int getCodeType() {
        return codeType;
    }
    /**
     * codeType.
     *
     * @param   codeType    the codeType to set
     * @since   JDK 1.6
     */
    public final void setCodeType(int codeType) {
        this.codeType = codeType;
    }
    /**
     * code.
     *
     * @return  the code
     * @since   JDK 1.6
     */
    public final String getCode() {
        return code;
    }
    /**
     * code.
     *
     * @param   code    the code to set
     * @since   JDK 1.6
     */
    public final void setCode(String code) {
        this.code = code;
    }
    /**
     * compy.
     *
     * @return  the compy
     * @since   JDK 1.6
     */
    public final String getCompy() {
        return compy;
    }
    /**
     * compy.
     *
     * @param   compy    the compy to set
     * @since   JDK 1.6
     */
    public final void setCompy(String compy) {
        this.compy = compy;
    }
    /**
     * photo.
     *
     * @return  the photo
     * @since   JDK 1.6
     */
    public final String getPhoto() {
        return photo;
    }
    /**
     * photo.
     *
     * @param   photo    the photo to set
     * @since   JDK 1.6
     */
    public final void setPhoto(String photo) {
        this.photo = photo;
    }
    /**
     * photoType.
     *
     * @return  the photoType
     * @since   JDK 1.6
     */
    public final String getPhotoType() {
        return photoType;
    }
    /**
     * photoType.
     *
     * @param   photoType    the photoType to set
     * @since   JDK 1.6
     */
    public final void setPhotoType(String photoType) {
        this.photoType = photoType;
    }
    /**
     * fingerPrint.
     *
     * @return  the fingerPrint
     * @since   JDK 1.6
     */
    public final String getFingerPrint() {
        return fingerPrint;
    }
    /**
     * fingerPrint.
     *
     * @param   fingerPrint    the fingerPrint to set
     * @since   JDK 1.6
     */
    public final void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }
    /**
     * fingerPrint2.
     *
     * @return  the fingerPrint2
     * @since   JDK 1.6
     */
    public final String getFingerPrint2() {
        return fingerPrint2;
    }
    /**
     * fingerPrint2.
     *
     * @param   fingerPrint2    the fingerPrint2 to set
     * @since   JDK 1.6
     */
    public final void setFingerPrint2(String fingerPrint2) {
        this.fingerPrint2 = fingerPrint2;
    }
    /**
     * fingerPrintType.
     *
     * @return  the fingerPrintType
     * @since   JDK 1.6
     */
    public final String getFingerPrintType() {
        return fingerPrintType;
    }
    /**
     * fingerPrintType.
     *
     * @param   fingerPrintType    the fingerPrintType to set
     * @since   JDK 1.6
     */
    public final void setFingerPrintType(String fingerPrintType) {
        this.fingerPrintType = fingerPrintType;
    }
    /**
     * phone.
     *
     * @return  the phone
     * @since   JDK 1.6
     */
    public final String getPhone() {
        return phone;
    }
    /**
     * phone.
     *
     * @param   phone    the phone to set
     * @since   JDK 1.6
     */
    public final void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * note.
     *
     * @return  the note
     * @since   JDK 1.6
     */
    public final String getNote() {
        return note;
    }
    /**
     * note.
     *
     * @param   note    the note to set
     * @since   JDK 1.6
     */
    public final void setNote(String note) {
        this.note = note;
    }
    /**
     * status.
     *
     * @return  the status
     * @since   JDK 1.6
     */
    public final boolean isStatus() {
        return status;
    }
    /**
     * status.
     *
     * @param   status    the status to set
     * @since   JDK 1.6
     */
    public final void setStatus(boolean status) {
        this.status = status;
    }
    /**
     * createTime.
     *
     * @return  the createTime
     * @since   JDK 1.6
     */
    public final Date getCreateTime() {
        return createTime;
    }
    /**
     * createTime.
     *
     * @param   createTime    the createTime to set
     * @since   JDK 1.6
     */
    public final void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * modifyTime.
     *
     * @return  the modifyTime
     * @since   JDK 1.6
     */
    public final Date getModifyTime() {
        return modifyTime;
    }
    /**
     * modifyTime.
     *
     * @param   modifyTime    the modifyTime to set
     * @since   JDK 1.6
     */
    public final void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    /**
     * brushTime.
     *
     * @return  the brushTime
     * @since   JDK 1.6
     */
    public final Date getBrushTime() {
        return brushTime;
    }
    /**
     * brushTime.
     *
     * @param   brushTime    the brushTime to set
     * @since   JDK 1.6
     */
    public final void setBrushTime(Date brushTime) {
        this.brushTime = brushTime;
    }

    
	
	
}
