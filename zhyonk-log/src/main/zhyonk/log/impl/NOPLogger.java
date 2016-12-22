package zhyonk.log.impl;

import zhyonk.log.Logger;

public class NOPLogger implements Logger{
	private final String name;
	
	public NOPLogger(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	@Override
	public boolean isEnabled(Level level) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void log(Level level, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void debug(String message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void info(String message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void warn(String message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void warn(String message, Throwable throwable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void error(String message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void error(String message, Throwable throwable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void trace(String message) {
		// TODO Auto-generated method stub
		
	}
	
}
