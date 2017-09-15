package org.luxb.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"/*, "classpath:persistence.xml" */})
public class TestService {
	private static final Logger LOGGER = Logger.getLogger(TestService.class);

	@Test
	public void testMain() {
		LOGGER.info("asfdsafsa");
	}

}
