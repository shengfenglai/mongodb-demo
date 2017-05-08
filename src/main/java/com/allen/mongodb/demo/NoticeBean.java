package com.allen.mongodb.demo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Allen on 2017/5/8 0008.
 */
@Document
public class NoticeBean {

	public NoticeBean() {
	}

	@PersistenceConstructor
	public NoticeBean(String id, int siteId, String creator, String title, String content, Date createTime,
			Date updateTime) {
		this.id = id;
		this.siteId = siteId;
		this.creator = creator;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	@Id
	private String id;

	@Indexed
	private int siteId;

	private String creator;

	private String title;

	private String content;

	@Indexed(direction = IndexDirection.DESCENDING)
	private Date createTime;

	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
