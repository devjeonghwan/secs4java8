package com.shimizukenta.secs;

/**
 * This interface is extend with Pass-Through SecsMessage.
 * 
 * <p>
 * To get Pass-Through SecsMessage, {@link #getSecsMessage()}.
 * </p>
 * 
 * @author kenta-shimizu
 *
 */
public interface SecsMessagePassThroughLog extends SecsLog {
	
	/**
	 * Returns Pass-through SecsMessage.
	 * 
	 * @return Pass-through SecsMessage.
	 */
	public SecsMessage getSecsMessage();
}
