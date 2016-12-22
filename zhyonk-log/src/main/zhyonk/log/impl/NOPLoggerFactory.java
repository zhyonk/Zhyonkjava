package zhyonk.log.impl;

import zhyonk.log.Logger;
import zhyonk.log.LoggerFactoryInterface;

public class NOPLoggerFactory implements LoggerFactoryInterface {
	
	private final NOPLogger logger = new NOPLogger("*");
	
	public Logger getLogger(String name) {
		return logger;
	}

}
