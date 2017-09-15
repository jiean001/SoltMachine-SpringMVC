package org.luxb.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.fastjson.JSON;

import Aogu.Genes.Domain.TBusinessinfoEntity;
import Aogu.Genes.Service.TBusinessinfoService;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestService {
	private static final Logger LOGGER = Logger.getLogger(TestService.class);
	@Autowired
	private TBusinessinfoService tBusinessinfoServices;

	@Test
	public void testMain() {
		for(int i = 72; i < 80; i ++) {
			TBusinessinfoEntity business = tBusinessinfoServices.findBusinessByUserID(i);
			LOGGER.info("luxiongbo" + i + JSON.toJSONString(business));
		}
	}

}
