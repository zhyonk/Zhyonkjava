package zhyonk.log.impl;

import zhyonk.log.Logger;
import zhyonk.log.LoggerFactoryInterface;

public class SimpleLoggerFactory implements LoggerFactoryInterface{

	private final Logger.Level globalLevel;
	private final long startTime;
	
	
	public SimpleLoggerFactory(Logger.Level globalLevel) {
		this.globalLevel = globalLevel;
		this.startTime = System.currentTimeMillis();
	}
	/**
	 * 返回全局level
	 * @return 全局level
	 */
	public Logger.Level getLevel(){
		return globalLevel;
		
	}
	/**
	 * 返回创建所需要的时间
	 * @return
	 */
	public long getElapsedTime(){
		return System.currentTimeMillis()-startTime;
	}
	@Override
	public Logger getLogger(String name) {
		// TODO Auto-generated method stub
		return new SimpleLogger(this,name);
	}
	
	protected String getCallerClass(){
		Exception exception = new Exception();
		
		StackTraceElement[] stackTrace = exception.getStackTrace();
		
		for (StackTraceElement stackTraceElement : stackTrace) {
			String className = stackTraceElement.getClassName();
			
			if(className.equals(SimpleLoggerFactory.class.getName())){
				continue;
			}
			if(className.equals(SimpleLogger.class.getName())){
				continue;
			}
			return shortenClassName(className)
					+"."+stackTraceElement.getMethodName()
					+"."+stackTraceElement.getLineNumber();
		}
		return "N/A";
	}
	/**
	 * 缩写类名
	 * @param className
	 * @return
	 */
	protected String shortenClassName(String className) {
		int lastDotIndex = className.lastIndexOf(".");
		if(lastDotIndex==-1){
			return className;
		}
		
		StringBuilder shortClassName = new StringBuilder(className.length());
		
		int start = 0;
		//按照.来迭代类名，一个一个迭代知道最后一个.之后的className
		while(true){
			shortClassName.append(className.charAt(start));
			int next = className.indexOf(".",start);
			if(next==lastDotIndex){
				break;
			}
			start = next+1;
			shortClassName.append(".");
		}
		shortClassName.append(className.substring(lastDotIndex));
		return shortClassName.toString();
	}

}
