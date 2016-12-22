package zhyonk.log.impl;

import zhyonk.log.Logger;

public class SimpleLogger implements Logger{
	private final String name;
	private final SimpleLoggerFactory slf;
	
	public SimpleLogger(SimpleLoggerFactory simpleLoggerFactory, String name2) {
		this.name = name2;
		this.slf = simpleLoggerFactory;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isEnabled(Level level) {
		// TODO Auto-generated method stub
		return level.isEnabledFor(slf.getLevel());
	}

	@Override
	public void log(Level level, String message) {
		print(level, message, null);
	}

	public boolean isTraceEnabled() {
		return Level.TRACE.isEnabledFor(slf.getLevel());
	}

	public void trace(String message) {
		print(Level.TRACE, message, null);
	}

	public boolean isDebugEnabled() {
		return Level.DEBUG.isEnabledFor(slf.getLevel());
	}

	public void debug(String message) {
		print(Level.DEBUG, message, null);
	}

	public boolean isInfoEnabled() {
		return Level.INFO.isEnabledFor(slf.getLevel());
	}

	public void info(String message) {
		print(Level.INFO, message, null);
	}

	public boolean isWarnEnabled() {
		return Level.WARN.isEnabledFor(slf.getLevel());
	}

	public void warn(String message) {
		print(Level.WARN, message, null);
	}

	public void warn(String message, Throwable throwable) {
		print(Level.WARN, message, throwable);
	}

	public boolean isErrorEnabled() {
		return Level.ERROR.isEnabledFor(slf.getLevel());
	}

	public void error(String message) {
		print(Level.ERROR, message, null);
	}

	public void error(String message, Throwable throwable) {
		print(Level.ERROR, message, throwable);
	}
	/**
	 * 打印错误信息
	 */
	protected void print(Level level, String message, Throwable throwable) {
		if (!isEnabled(level)) {
			return;
		}

		StringBuilder msg = new StringBuilder()
			.append(slf.getElapsedTime()).append(' ').append('[')
			.append(level).append(']').append(' ')
			.append(slf.getCallerClass()).append(' ').append('-')
			.append(' ').append(message);

		System.out.println(msg.toString());

		if (throwable != null) {
			throwable.printStackTrace(System.out);
		}
	}
}
