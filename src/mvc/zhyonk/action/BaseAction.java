package mvc.zhyonk.action;

import mvc.zhyonk.meta.Bean;
import mvc.zhyonk.meta.Inject;
import mvc.zhyonk.meta.Request;

@Bean
public class BaseAction {
	@Inject
	private TestService testService;
	@Request
	public void print(){
		System.out.println("print method run...");
		testService.print();
	}
}
