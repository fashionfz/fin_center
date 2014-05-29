/**  
 * Project Name:fin_center  
 * File Name:MboxUser.java  
 * Package Name:com.megaeyes.fin.po  
 * Date:2014年2月7日上午11:01:35  
 * Copyright (c) 2014, 四川天翼   All Rights Reserved.  
 *  
*/ 

package com.megaeyes.fin.cache;

import java.util.Collection;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;
import com.danga.MemCached.MemCachedClient;

/**
 * 
 * ClassName: MemcacheCacheManager <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2014年2月7日 下午2:05:56 <br/>  
 *  
 * @author dengbin ibcm@qq.com  
 * @version   
 * @since JDK 1.6
 */
public class MemcacheCacheManager extends AbstractCacheManager {

	private Collection<Cache> caches;
	private MemCachedClient client = null;

	public MemcacheCacheManager() {

	}

	public MemcacheCacheManager(MemCachedClient client) {
		setClient(client);
	}

	@Override
	protected Collection<? extends Cache> loadCaches() {
		return this.caches;
	}

	public void setCaches(Collection<Cache> caches) {
		this.caches = caches;
	}

	public void setClient(MemCachedClient client) {
		this.client = client;
		updateCaches();
	}

	public Cache getCache(String name) {
		checkState();

		Cache cache = super.getCache(name);
		if (cache == null) {
			cache = new TyMemcaheCache(name, client);
			addCache(cache);
		}
		return cache;
	}

	private void checkState() {
		if (client == null) {
			throw new IllegalStateException("MemcacheClient must not be null.");
		}

	}

	private void updateCaches() {
		if (caches != null) {
			for (Cache cache : caches) {
				if (cache instanceof TyMemcaheCache) {
					TyMemcaheCache memcacheCache = (TyMemcaheCache) cache;
					memcacheCache.setClient(client);
				}
			}
		}

	}

}
