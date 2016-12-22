package zhyonk.log;

public interface Logger {
	/**
	 * 
	 * 日志等级
	 */
	
	public enum Level{
		TRACE(1),
		DEBUG(2),
		INFO(3),
		WARN(4),
		ERROR(5);
		
		private final int value;
		Level(int value) {
			this.value = value;
		}

		/**
		 * Returns <code>true</code> if this level
		 * is enabled for given required level.
		 */
		public boolean isEnabledFor(Level level) {
			return this.value >= level.value;
		}
	}
	/**
	 * 返回logger名称
	 * @return
	 */
	public String getName();
	/**
	 * 返回启用级别
	 * @param level
	 * @return
	 */
	public boolean isEnabled(Level level);
	
	/**
	 * 
	 * @param level
	 * @param message
	 */
	public void log(Level level,String message);
	
	public boolean isTraceEnabled();
	
	public void trace(String message);
	
	public boolean isDebugEnabled();
	
	public void debug(String message);
	
	public boolean isInfoEnabled();
	
	public void info(String message);

	public boolean isWarnEnabled();
	
	public void warn(String message);
	
	public void warn(String message, Throwable throwable);
	
	public boolean isErrorEnabled();
	
	public void error(String message);
	
	public void error(String message, Throwable throwable);
}
