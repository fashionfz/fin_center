/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 * Date:2014年2月7日上午11:01:35  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/ 

package com.megaeyes.fin.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.support.SimpleValueWrapper;
import com.danga.MemCached.MemCachedClient;

/**
 * 
 * ClassName: TyMemcaheCache <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2014年2月7日 下午2:01:44 <br/>  
 *  
 * @author dengbin ibcm@qq.com  
 * @version   
 * @since JDK 1.6
 */
public class TyMemcaheCache implements Cache {

	private MemCachedClient client;
	private String name;

	public TyMemcaheCache() {

	}

	public TyMemcaheCache(String name, MemCachedClient client) {
		this.client = client;
		this.name = name;
	}

	@Override
	@Cacheable(value = "memcache")
	public String getName() {
		return this.name;
	}

	@Override
	public Object getNativeCache() {
		return this.client;
	}

	@Override
	public ValueWrapper get(Object key) {
		Object value = this.client.get(objectToString(key));
		return (value != null ? new SimpleValueWrapper(value) : null);
	}

	@Override
	public void put(Object key, Object value) {
		this.client.set(objectToString(key), value);

	}

	@Override
	public void evict(Object key) {
		this.client.delete(objectToString(key));

	}

	@Override
	public void clear() {
		// TODO delete all data
	}

	private static String objectToString(Object object) {
		if (object == null) {
			return null;
		} else if (object instanceof String) {
			return (String) object;
		} else {
			return object.toString();
		}
	}

	public void setClient(MemCachedClient client) {
		this.client = client;
	}

	public MemCachedClient getClient() {
		return client;
	}

	public void setName(String name) {
		this.name = name;
	}

}
