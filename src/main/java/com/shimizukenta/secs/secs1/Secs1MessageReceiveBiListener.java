package com.shimizukenta.secs.secs1;

import java.util.EventListener;

/**
 * Secs1Message receive Listener.
 * 
 * <p>
 * This interface is used in {@link Secs1Communicator#addSecs1MessageReceiveBiListener(Secs1MessageReceiveBiListener)}
 * Receive-Message is only Primary-Secs1Message.
 * </p>
 * 
 * @author kenta-shimizu
 */
public interface Secs1MessageReceiveBiListener extends EventListener {
	
	/**
	 * Putter Received Primary-Secs1Message and Secs1Communicator.
	 * 
	 * @param message only Primary-SecsMessage
	 * @param accessor the Secs1GemAccessor
	 */
	public void received(Secs1Message message, Secs1GemAccessor accessor);
	
}
