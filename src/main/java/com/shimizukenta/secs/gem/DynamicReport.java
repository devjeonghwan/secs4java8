package com.shimizukenta.secs.gem;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.shimizukenta.secs.gem.impl.AbstractDynamicReport;
import com.shimizukenta.secs.secs2.Secs2;
import com.shimizukenta.secs.secs2.Secs2Exception;

/**
 * This interface is implementation of Define-Report in GEM (SEMI-E30).
 * 
 * <p>
 * To create new instance, {@link #newInstance(Secs2, CharSequence, List)}
 * To get alias, {@link #alias()}
 * To get RPTID, {@link #reportId()}
 * To get VIDs, {@link #vids()}
 * To S2F33 Single RPTID, {@link #toS2F33Report()}
 * </p>
 * <p>
 * Instances of this class are immutable.
 * </p>
 * 
 * @author kenta-shimizu
 *
 */
public interface DynamicReport {
	
	/**
	 * Returns new instance.
	 * 
	 * @param reportId the Report ID
	 * @param alias the alias name
	 * @param vids the VIDs
	 * @return newInstance
	 */
	public static DynamicReport newInstance(Secs2 reportId, CharSequence alias, List<? extends Secs2> vids) {
		
		return new AbstractDynamicReport(reportId, alias, vids) {
			private static final long serialVersionUID = 1L;
		};
	}

	
	/**
	 * to S2F33-Secs2-Single-Report.
	 * 
	 * <p>
	 * Single-Report-Format:
	 * &lt;L [2]
	 * &nbsp;&nbsp;&lt;U4 report-id&gt;
	 * &nbsp;&nbsp;&lt;L [n]
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;U4 vid-1&gt;
	 * &nbsp;&nbsp;&nbsp;&nbsp;...
	 * &nbsp;&nbsp;&lt;
	 * &gt;.
	 * </p>
	 * 
	 * @return S2F33-single-report
	 */
	public Secs2 toS2F33Report();
	
	/**
	 * Returns RPTID.
	 * 
	 * @return SECS-II RPTID
	 */
	public Secs2 reportId();
	
	/**
	 * Returns Alias.
	 * 
	 * @return has value if aliased.
	 */
	public Optional<String> alias();
	
	/**
	 * Returns VIDs.
	 * 
	 * @return List of SECS-II VID
	 */
	public List<Secs2> vids();
	
	
	/**
	 * newInstace from S2F33-Secs2-Single-Report.
	 * 
	 * <p>
	 * Single-Report-Format:
	 * &lt;L [2]
	 * &nbsp;&nbsp;&lt;U4 report-id&gt;
	 * &nbsp;&nbsp;&lt;L [n]
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;U4 vid-1&gt;
	 * &nbsp;&nbsp;&nbsp;&nbsp;...
	 * &nbsp;&nbsp;&lt;
	 * &gt;.
	 * </p>
	 * 
	 * @param secs2 S2F33-Single-Report
	 * @return DynamicReport
	 * @throws Secs2Exception if SECS-II parse failed
	 */
	public static DynamicReport fromS2F33Report(Secs2 secs2) throws Secs2Exception {
		Secs2 rptid = secs2.get(0);
		List<Secs2> vids = secs2.get(1).stream().collect(Collectors.toList());
		return newInstance(rptid, null, vids);
	}
	
}
