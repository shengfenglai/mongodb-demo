package com.allen.mongodb.demo.test;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allen.mongodb.demo.NoticeBean;
import com.mongodb.WriteResult;

/**
 * Created by Allen on 2017/5/8 0008.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MongoDBTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void testInsert() {

		Date now = new Date();

		NoticeBean noticeBean = new NoticeBean();
		noticeBean.setSiteId(1);
		noticeBean.setCreator("allen");
		noticeBean.setCreateTime(now);
		noticeBean.setUpdateTime(now);
		mongoTemplate.insert(noticeBean);
		System.out.println(noticeBean.getId());

	}

	@Test
	public void testDelete() {
		mongoTemplate.remove(Query.query(Criteria.where("id").is("596c64f944f07e6d8ddc0339").and("siteId").is(1)),
				NoticeBean.class);
	}

	@Test
	public void testModify() {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is("596c64f944f07e6d8ddc0339").and("siteId").is(1));
		Update update = new Update();
		System.out.println(new DateTime().toDate());
		update.set("updateTime", new DateTime().toDate());
		WriteResult result = mongoTemplate.updateFirst(query, update, NoticeBean.class);
		System.out.println(result);
	}

	@Test
	public void testFind() {
		NoticeBean noticeBean = mongoTemplate.findOne(
				Query.query(Criteria.where("id").is("596c64f944f07e6d8ddc0339").and("siteId").is(1)), NoticeBean.class);

		System.out.println(noticeBean.getCreator());

	}

}
