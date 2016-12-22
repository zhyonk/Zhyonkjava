package zhyonk.log;

import zhyonk.log.impl.NOPLoggerFactory;

public final class LoggerFactory {
	private static LoggerFactoryInterface loggerFactor = new NOPLoggerFactory();
	
	public static void setLoggerFactory(LoggerFactoryInterface loggerFactoryInterface){
		loggerFactor = loggerFactoryInterface;
	}
	
	public static Logger getLogger(Class clazz){
		return getLogger(clazz.getName());
		
	}

	private static Logger getLogger(String name) {

		return getLogger(name);
	}
}
