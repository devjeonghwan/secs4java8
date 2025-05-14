package com.shimizukenta.secs.gem;

import java.util.Optional;

import com.shimizukenta.secs.SecsCommunicator;
import com.shimizukenta.secs.SecsException;
import com.shimizukenta.secs.SecsMessage;
import com.shimizukenta.secs.SecsSendMessageException;
import com.shimizukenta.secs.SecsWaitReplyMessageException;
import com.shimizukenta.secs.secs2.Secs2;
import com.shimizukenta.secs.secs2.Secs2Exception;

/**
 * This interface is implementation of GEM (SEMI-E30, partially).
 * 
 * <p>
 * To get this interface, call from {@link SecsCommunicator#gem()}
 * </p>
 * 
 * @author kenta-shimizu
 *
 */
public interface Gem {
	
	/**
	 * Returns auto number DATAID.
	 * 
	 * @return Auto-DATAID
	 */
	public Secs2 autoDataId();
	
	/**
	 * Returns DATAID.
	 * 
	 * @param id DATA-ID-Nubmer
	 * @return SECS-II DATAID
	 */
	public Secs2 dataId(long id);
	
	/**
	 * Returns DynamicEventReportConfig instance.
	 * 
	 * @return DynamicEventReportConfig new-Instance
	 */
	public DynamicEventReportConfig newDynamicEventReportConfig();
	
	/**
	 * S1F1, Are You Online?.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return Reply-Message
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s1f1()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S1F2, On Line Data.
	 * 
	 * <p>
	 * MDLN, SOFTREV is reference AbstractGemConfig value.
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s1f2(SecsMessage primaryMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S1F13, Establish Communications Request.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return COMMACK the COMMACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public COMMACK s1f13()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S1F14, Establish Communications Request Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param commack the COMMACK
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s1f14(SecsMessage primaryMsg, COMMACK commack)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S1F15, Request OFF-LINE.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return OFLACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public OFLACK s1f15()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S1F16, OFF-LINE Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s1f16(SecsMessage primaryMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S1F17, Request ON-LINE.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return ONLACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public ONLACK s1f17()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S1F18, ON-LINE Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param onlack the ONLACK
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s1f18(SecsMessage primaryMsg, ONLACK onlack)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F17, Date and Time Request.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return Clock
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public Clock s2f17()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F18, Date and Time Response.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param clock the CLOCK
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f18(SecsMessage primaryMsg, Clock clock)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F18, Now Date and Time Response.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f18Now(SecsMessage primaryMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F22, Remote Command Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param cmda the CMDA
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f22(SecsMessage primaryMsg, CMDA cmda)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F28, Initiate Processing Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param cmda the CMDA
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f28(SecsMessage primaryMsg, CMDA cmda)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F31, Date and Time Set Request.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param clock the Clock
	 * @return TIACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public TIACK s2f31(Clock clock)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F31, Now Date and Time Set Request.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return TIACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public TIACK s2f31Now()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F32, Date and Time Set Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param tiack the Clock
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f32(SecsMessage primaryMsg, TIACK tiack)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F33, Delete All Define-Report.
	 * 
	 * <p>
	 * DATA-ID is AutoNumber.
	 * blocking-method.
	 * </p>
	 * 
	 * @return DRACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public DRACK s2f33DeleteAll()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;

	/**
	 * S2F33, Define Report.
	 * 
	 * <p>
	 * DATA-ID is AutoNumber.
	 * blocking-method.
	 * </p>
	 * 
	 * @param config the DynamicEventReportConfig
	 * @return DRACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public DRACK s2f33Define(DynamicEventReportConfig config)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F34, Define Report Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param drack the DRACK
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f34(SecsMessage primaryMsg, DRACK drack)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F35, Link Collection Event Report.
	 * 
	 * <p>
	 * DATA-ID is AutoNumber.
	 * blocking-method.
	 * </p>
	 * 
	 * @param config the config DynamicEventReportConfig
	 * @return LRACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public LRACK s2f35(DynamicEventReportConfig config)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F36, Link Collection Event Report Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param lrack the LRACK
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f36(SecsMessage primaryMsg, LRACK lrack)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F37, Disable All Collection-Event-Report.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return ERACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public ERACK s2f37DisableAll()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F37, Enable All Collection-Event-Report.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return ERACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public ERACK s2f37EnableAll()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F37, Enable Collection-Event-Report.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param config the DynamicEventReportConfig
	 * @return ERACK
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if interrupted
	 */
	public ERACK s2f37Enable(DynamicEventReportConfig config)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F38, Enable/Disable CollectionEvent Report Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param erack the ERACK
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f38(SecsMessage primaryMsg, ERACK erack)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S2F40, Multi-block Grant.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param grant the GRANT
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s2f40(SecsMessage primaryMsg, GRANT grant)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S3F16, Matls Multi-block Grant.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param grant the GRANT
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s3f16(SecsMessage primaryMsg, GRANT grant)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S5F2, Alarm Report Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc5 the ACKC5
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s5f2(SecsMessage primaryMsg, ACKC5 ackc5)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S5F4, Enable/Disable Alarm Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc5 the ACKC5
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s5f4(SecsMessage primaryMsg, ACKC5 ackc5)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F2, Trace Data Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc6 the ACKC6
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f2(SecsMessage primaryMsg, ACKC6 ackc6)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F4, Discrete Variable Data Send Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc6 the ACKC6
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f4(SecsMessage primaryMsg, ACKC6 ackc6)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F6, Multi-block Grant.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param grant6 the GRANT6
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f6(SecsMessage primaryMsg, GRANT6 grant6)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F10, Formatted Variable Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc6 the ACKC6
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f10(SecsMessage primaryMsg, ACKC6 ackc6)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F12, CollectionEvent Report Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc6 the ACKC6
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f12(SecsMessage primaryMsg, ACKC6 ackc6)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F14, Annotated CollectionEvent Report Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc6 the ACKC6
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f14(SecsMessage primaryMsg, ACKC6 ackc6)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F15, Event Report Request.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param ce the DynamicCollectionEvent
	 * @return reply message
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f15(DynamicCollectionEvent ce)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F17, Annotated Event Report Request.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param ce the DynamicCollectionEvent
	 * @return reply message
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f17(DynamicCollectionEvent ce)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F19, Individual Report Request.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param report the DynamicReport
	 * @return reply message
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f19(DynamicReport report)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F21, Annotated Individual Report Request.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param report the DynamicReport
	 * @return reply message
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f21(DynamicReport report)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F26, Notification Report Send Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc6 the ACKC6
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s6f26(SecsMessage primaryMsg, ACKC6 ackc6)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F4, Process Program Send Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f4(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F12, Matl/Process Matrix Update Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f12(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F14, Delete Matl/Process Matrix Entry Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f14(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F16, Matrix Mode Select Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f16(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F18, Delete Process Program Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f18(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F24, Formatted Process Program Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f24(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F32, Verification Request Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f32(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F38, Large PP Send Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f38(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F40, Large Formatted PP Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f40(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F42, Large PP Req Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f42(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S7F44, Large Formatted PP Req Ack.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc7 the ACKC7
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s7f44(SecsMessage primaryMsg, ACKC7 ackc7)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S9F1, Unknown Device ID.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param refMsg the reference message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s9f1(SecsMessage refMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S9F3, Unknown Stream.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param refMsg the reference message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s9f3(SecsMessage refMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S9F5, Unknown Function.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param refMsg the reference message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s9f5(SecsMessage refMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S9F7, Illegal Data.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param refMsg the reference message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s9f7(SecsMessage refMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S9F9, Transaction Timeout.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param refMsg the reference message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s9f9(SecsMessage refMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S9F11, Data Too Long.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param refMsg the reference message
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s9f11(SecsMessage refMsg)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	
	/* HOOK s9f13 */
	
	
	/**
	 * S10F2, Terminal Request Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc10 the ACKC10
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s10f2(SecsMessage primaryMsg, ACKC10 ackc10)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;

	/**
	 * S10F4, Terminal Display, Single Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc10 the ACKC10
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s10f4(SecsMessage primaryMsg, ACKC10 ackc10)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;

	/**
	 * S10F6, Terminal Display, Multi-Block Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc10 the ACKC10
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s10f6(SecsMessage primaryMsg, ACKC10 ackc10)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S10F10, Broadcast Acknowledge.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param ackc10 the ACKC10
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s10f10(SecsMessage primaryMsg, ACKC10 ackc10)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S13F12, Data Set Obj Multi-Block Grant.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @param primaryMsg the primary message
	 * @param grant the GRANT
	 * @return {@code Optional.empty()}
	 * @throws SecsSendMessageException if send failed
	 * @throws SecsWaitReplyMessageException if receive message failed, e.g. Timeout-T3
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if interrupted
	 */
	public Optional<SecsMessage> s13f12(SecsMessage primaryMsg, GRANT grant)
			throws SecsSendMessageException
			, SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
}
