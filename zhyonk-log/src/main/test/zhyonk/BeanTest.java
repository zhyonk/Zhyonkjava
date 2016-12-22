package zhyonk;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mvc.zhyonk.action.BaseAction;
import mvc.zhyonk.action.BeanHelper;

public class BeanTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		BaseAction object = (BaseAction) BeanHelper.getBean(BaseAction.class);
		object.print();
	}

}
