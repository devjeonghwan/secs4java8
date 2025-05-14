package com.shimizukenta.secs.gem;

import java.util.List;
import java.util.Optional;

import com.shimizukenta.secs.SecsException;
import com.shimizukenta.secs.SecsMessage;
import com.shimizukenta.secs.SecsSendMessageException;
import com.shimizukenta.secs.SecsWaitReplyMessageException;
import com.shimizukenta.secs.secs2.Secs2;
import com.shimizukenta.secs.secs2.Secs2Exception;

/**
 * This interface is implementation of Dynamic-Event-Report-Configuration in GEM (SEMI-E30).
 * 
 * <p>
 * To create new instance, {@link Gem#newDynamicEventReportConfig()}
 * </p>
 * <p>
 * To add Define-Report, {@link #addDefineReport(CharSequence, List)}
 * To add Enable-CEID, {@link #addEnableCollectionEvent(CharSequence, long)}
 * To add Link, {@link #addLinkByReport(DynamicCollectionEvent, List)}
 * </p>
 * <p>
 * To S2F37 Disable-All-CEIDs, {@link #s2f37DisableAll()}
 * To S2F33 Delete-All-Reports, {@link #s2f33DeleteAll()}
 * To S2F33 Define-Reports, {@link #s2f33Define()}
 * To S2F35 Link, {@link #s2f35()}
 * To S2F37 Enable-CEIDs, {@link #s2f37Enable()}
 * </p>
 * <p>
 * Relates: S2F33, S2F35, S2F37, S6F11, S6F13, S6F15, S6F17, S6F19, S6F21
 * </p>
 * 
 * @author kenta-shimizu
 *
 */
public interface DynamicEventReportConfig {
	
	/**
	 * Add Define-Report.
	 * 
	 * <p>
	 * Use for S2F33
	 * </p>
	 * 
	 * @param reportId the Report ID
	 * @param alias of use in {@link #getReport(CharSequence)}, {@link #s6f19(CharSequence)}, {@link #s6f21(CharSequence)}
	 * @param vids the VIDs
	 * @return DynamicReport
	 */
	public DynamicReport addDefineReport(long reportId, CharSequence alias, List<? extends Number> vids);
	
	/**
	 * Add Define-Report.
	 * 
	 * <p>
	 * Use for S2F33
	 * </p>
	 * 
	 * @param reportId the Report ID
	 * @param vids the VIDs
	 * @return DynamicReport
	 */
	public DynamicReport addDefineReport(long reportId, List<? extends Number> vids);
	
	/**
	 * Add Define-Report.
	 * 
	 * <p>
	 * Use for S2F33
	 * Report-ID is AutoNumber
	 * </p>
	 * 
	 * @param alias of use in {@link #getReport(CharSequence)}, {@link #s6f19(CharSequence)}, {@link #s6f21(CharSequence)}
	 * @param vids the VIDs
	 * @return DynamicReport
	 */
	public DynamicReport addDefineReport(CharSequence alias, List<? extends Number> vids);
	
	/**
	 * Add Define-Report.
	 * 
	 * <p>
	 * Use for S2F33
	 * Report-ID is AutoNumber.
	 * </p>
	 * 
	 * @param vids the VIDs
	 * @return DynamicReport
	 */
	public DynamicReport addDefineReport(List<? extends Number> vids);
	
	/**
	 * Remove Report
	 * 
	 * @param report the Dynamic Reports
	 * @return {@code true} if remove success
	 */
	public boolean removeReport(DynamicReport report);
	
	/**
	 * Seek in Define-Reports by alias.
	 * 
	 * @param alias the alias name
	 * @return DynamicReport if exist
	 */
	public Optional<DynamicReport> getReport(CharSequence alias);
	
	/**
	 * Seek in Define-Reports by report-id.
	 * 
	 * <p>
	 * Used for S6F11, S6F13, ...
	 * </p>
	 * 
	 * @param reportId the Report ID
	 * @return DynamicReport if exist
	 */
	public Optional<DynamicReport> getReport(Secs2 reportId);
	
	/**
	 * Add Event-Report-Link.
	 * Use for S2F35
	 * 
	 * @param ceid the Collection Event ID
	 * @param reportIds the Report IDs
	 * @return DynamicLink
	 */
	public DynamicLink addLinkById(long ceid, List<? extends Number> reportIds);
	
	/**
	 * Add Event-Report-Link.
	 * 
	 * <p>
	 * Use for S2F35.
	 * </p>
	 * 
	 * @param ce the DynamicCollectionEvent
	 * @param reportIds the Report IDs
	 * @return DynamicLink
	 */
	public DynamicLink addLinkById(DynamicCollectionEvent ce, List<? extends Number> reportIds);
	
	/**
	 * Add Event-Report-Link.
	 * 
	 * <p>
	 * Use for S2F35.
	 * </p>
	 * 
	 * @param ceid Collection-Event-ID
	 * @param reports DynamicReports
	 * @return DynamicLink
	 */
	public DynamicLink addLinkByReport(long ceid, List<? extends DynamicReport> reports);
	
	/**
	 * Add Event-Report-Link.
	 * 
	 * <p>
	 * Use for S2F35.
	 * </p>
	 * 
	 * @param ce DynamicCollectionEvent
	 * @param reports the DynamicReports
	 * @return DynamicLink
	 */
	public DynamicLink addLinkByReport(DynamicCollectionEvent ce, List<? extends DynamicReport> reports);
	
	/**
	 * Remove Link.
	 * 
	 * @param link the the DynamicLink
	 * @return {@code true} if remove success
	 */
	public boolean removeLink(DynamicLink link);
	
	/**
	 * Add Enable-Collection-Event.
	 * 
	 * <p>
	 * Use for S2F37.
	 * </p>
	 * 
	 * @param ceid the Collection Event ID
	 * @return DynamicCollectionEvent
	 */
	public DynamicCollectionEvent addEnableCollectionEvent(long ceid);
	
	/**
	 * Add Enable-Collection-Event.
	 * 
	 * <p>
	 * Use for S2F37.
	 * </p>
	 * 
	 * @param alias of {@link #getCollectionEvent(CharSequence)}, {@link #s6f15(CharSequence)}, {@link #s6f17(CharSequence)}
	 * @param ceid the Collection Event ID
	 * @return DynamicCollectionEvent
	 */
	public DynamicCollectionEvent addEnableCollectionEvent(CharSequence alias, long ceid);
	
	/**
	 * Remove Enable-Collection-Event.
	 * 
	 * @param ce the DynamicCollectionEvent
	 * @return {@code true} if remove success
	 */
	public boolean removeEnableCollectionEvent(DynamicCollectionEvent ce);
	
	/**
	 * Seek in Enable-Collection-Events by alias.
	 * 
	 * @param alias the alias name
	 * @return DynamicCollectionEvent if exist
	 */
	public Optional<DynamicCollectionEvent> getCollectionEvent(CharSequence alias);
	
	/**
	 * Seek in Enable-Collection-Events by Collection-Event-ID.
	 * 
	 * <p>
	 * Used for S6F11, S6F13,...
	 * </p>
	 * 
	 * @param ceid the Collection Event ID
	 * @return DynamicCollectionEvent if exist
	 */
	public Optional<DynamicCollectionEvent> getCollectionEvent(Secs2 ceid);
	
	/**
	 * S2F33, Delete All Define-Report.
	 * 
	 * <p>
	 * DATA-ID is AutoNumber.
	 * blocking-method.
	 * </p>
	 * 
	 * @return DRACK
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if Interrupted
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
	 * blocking-method
	 * </p>
	 * 
	 * @return DRACK
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if Interrupted
	 */
	public DRACK s2f33Define()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F35, Link Collection Event Report.
	 * 
	 * <p>
	 * DATA-ID is AutoNumber.
	 * blocking-method
	 * </p>
	 * 
	 * @return LRACK
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if Interrupted
	 */
	public LRACK s2f35()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S2F37, Disable All Collection-Event-Report.
	 * 
	 * <p>
	 * blocking-method.
	 * </p>
	 * 
	 * @return ERACK
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if Interrupted
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
	 * blocking-method
	 * </p>
	 * 
	 * @return ERACK
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if Interrupted
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
	 * blocking-method
	 * </p>
	 * 
	 * @return ERACK
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws Secs2Exception if SECS-II parse failed
	 * @throws InterruptedException if Interrupted
	 */
	public ERACK s2f37Enable()
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			Secs2Exception,
			InterruptedException;
	
	/**
	 * S6F15, Event Report Request.
	 * 
	 * <p>
	 * blocking-method
	 * </p>
	 * 
	 * @param ce the DynamicCollectionEvent
	 * @return reply message
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if Interrupted
	 */
	public Optional<? extends SecsMessage> s6f15(DynamicCollectionEvent ce)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F15, Event Report Request.
	 * 
	 * <p>
	 * Parameter "alias" is setted in #addEnableCollectionEvent
	 * Seek in enable-collection-events by alias.
	 * blocking-method.
	 * If alias not found, throw AliasNotFoundDynamicEventReportException.
	 * </p>
	 * 
	 * @param alias the alias name
	 * @return reply message
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws DynamicEventReportException if find alias failed
	 * @throws InterruptedException if Interrupted
	 */
	public Optional<? extends SecsMessage> s6f15(CharSequence alias)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			DynamicEventReportException,
			InterruptedException;
	
	/**
	 * S6F17, Annotated Event Report Request.
	 * 
	 * <p>
	 * blocking-method
	 * </p>
	 * 
	 * @param ce the DynamicCollectionEvent
	 * @return reply message
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if Interrupted
	 */
	public Optional<? extends SecsMessage> s6f17(DynamicCollectionEvent ce)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F17, Annotated Event Report Request.
	 * 
	 * <p>
	 * Parameter "alias" is setted in #addEnableCollectionEvent
	 * Seek in enable-collection-events by alias.
	 * blocking-method.
	 * If alias not found, throw AliasNotFoundDynamicEventReportException.
	 * </p>
	 * 
	 * @param alias the alias name
	 * @return reply message
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws DynamicEventReportException if find alias failed
	 * @throws InterruptedException if Interrupted
	 */
	public Optional<? extends SecsMessage> s6f17(CharSequence alias)
			throws SecsSendMessageException
			, SecsWaitReplyMessageException
			, SecsException
			, DynamicEventReportException
			, InterruptedException;
	
	/**
	 * S6F19, Individual Report Request
	 * 
	 * <p>
	 * blocking-method
	 * </p>
	 * 
	 * @param report the DynamicReport
	 * @return reply message
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if Interrupted
	 */
	public Optional<? extends SecsMessage> s6f19(DynamicReport report)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F19, Individual Report Request.
	 * 
	 * <p>
	 * Parameter "alias" is setted in #addDefineReport
	 * Seek in define-reports by alias.
	 * blocking-method.
	 * If alias not found, throw AliasNotFoundDynamicEventReportException.
	 * </p>
	 * 
	 * @param alias the alias name
	 * @return reply message
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws DynamicEventReportException if find alias failed
	 * @throws InterruptedException if Interrupted
	 */
	public Optional<? extends SecsMessage> s6f19(CharSequence alias)
			throws SecsSendMessageException
			, SecsWaitReplyMessageException
			, SecsException
			, DynamicEventReportException
			, InterruptedException;
	
	/**
	 * S6F21, Annotated Individual Report Request.
	 * 
	 * <p>
	 * blocking-method
	 * </p>
	 * 
	 * @param report the DynamicReport
	 * @return reply message
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws InterruptedException if Interrupted
	 */
	public Optional<? extends SecsMessage> s6f21(DynamicReport report)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			InterruptedException;
	
	/**
	 * S6F21, Annotated Individual Report Request.
	 * 
	 * <p>
	 * Parameter "alias" is setted in #addDefineReport
	 * Seek in define-reports by alias.
	 * blocking-method.
	 * If alias not found, throw AliasNotFoundDynamicEventReportException.
	 * </p>
	 * 
	 * @param alias the alias name
	 * @return reply message
	 * @throws SecsSendMessageException if send message failed
	 * @throws SecsWaitReplyMessageException if repy timeout
	 * @throws SecsException if SECS communicate failed
	 * @throws DynamicEventReportException if find alias failed
	 * @throws InterruptedException if Interrupted
	 */
	public Optional<? extends SecsMessage> s6f21(CharSequence alias)
			throws SecsSendMessageException,
			SecsWaitReplyMessageException,
			SecsException,
			DynamicEventReportException,
			InterruptedException;

}
