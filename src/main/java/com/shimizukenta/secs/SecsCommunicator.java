package com.shimizukenta.secs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.shimizukenta.secs.hsmsss.HsmsSsCommunicator;
import com.shimizukenta.secs.hsmsss.HsmsSsCommunicatorConfig;
import com.shimizukenta.secs.secs1ontcpip.Secs1OnTcpIpCommunicator;
import com.shimizukenta.secs.secs1ontcpip.Secs1OnTcpIpCommunicatorConfig;

/**
 * This interface is implementation of SECS-Communicating, open/close communicating, receive/send SECS-Message.
 * 
 * <ul>
 * <li>To create HSMS-SS-Communicator instance,
 * {@link HsmsSsCommunicator#newInstance(HsmsSsCommunicatorConfig)}</li>
 * <li>To create SECS-I-on-TCP/IP-Communicator instance,
 * {@link Secs1OnTcpIpCommunicator#newInstance(Secs1OnTcpIpCommunicatorConfig)}</li>
 * </ul>
 * <ul>
 * <li>To open communicating,
 * {@link #open()}</li>
 * <li>To close communicating,
 * {@link #close()}</li>
 * </ul>
 * <ul>
 * <li>To receive Primary-Message,
 * {@link #addSecsMessageReceiveListener(SecsMessageReceiveListener)}
 * or {@link #addSecsMessageReceiveBiListener(SecsMessageReceiveBiListener)}</li>
 * </ul>
 * <ul>
 * <li>To get communicate-state-changed,
 * {@link #addSecsCommunicatableStateChangeListener(SecsCommunicatableStateChangeListener)}
 * or {@link #addSecsCommunicatableStateChangeBiListener(SecsCommunicatableStateChangeBiListener)}</li>
 * <li>To wait until communicatable, {@link #waitUntilCommunicatable()}</li>
 * <li>To wait until not communicatable, {@link #waitUntilNotCommunicatable()}</li>
 * </ul>
 * <ul>
 * <li>To access GEM-interface, {@link #gem()}</li>
 * </ul>
 * <ul>
 * <li>To log communicating,
 * {@link #addSecsLogListener(SecsLogListener)}</li>
 * </ul>
 * 
 * @author kenta-shimizu
 *
 */
public interface SecsCommunicator extends OpenAndCloseable, SecsGemAccessor, SecsMessageReceiveObservable, SecsMessagePassThroughObservable, SecsCommunicateStateDetectable, SecsLogObservable {
	
	/**
	 * Open and wait until communicatable.
	 * 
	 * <p>
	 * Blocking-method.
	 * If Already opened, do not open.
	 * If Already communicatable, do nothing.
	 * </p>
	 * 
	 * @throws IOException if open failed
	 * @throws InterruptedException if interrupted
	 */
	public void openAndWaitUntilCommunicatable() throws IOException, InterruptedException;
	
	/**
	 * Open and wait until communicatable.
	 * 
	 * <p>
	 * Blocking-method.
	 * If Already opened, do not open.
	 * If Already communicatable, do nothing.
	 * </p>
	 * 
	 * @param timeout the timeout value
	 * @param unit the timeout unit
	 * @throws IOException if open failed
	 * @throws InterruptedException if interrupted
	 * @throws TimeoutException if timeout
	 */
	public void openAndWaitUntilCommunicatable(long timeout, TimeUnit unit) throws IOException, InterruptedException, TimeoutException;
	
	
}
