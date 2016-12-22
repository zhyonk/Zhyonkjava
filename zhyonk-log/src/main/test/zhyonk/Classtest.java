package zhyonk;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mvc.zhyonk.action.ClassHelper;
import mvc.zhyonk.meta.Bean;

public class Classtest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetClassListByAnnotation() {
		ClassHelper.getClassListByAnnotation(Bean.class,"C:/dev/workspace/Eclipseworkspace/zhyonk/bin/mvc/zhyonk/action");
	}

}
