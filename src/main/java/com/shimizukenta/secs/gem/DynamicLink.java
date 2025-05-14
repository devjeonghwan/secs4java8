package com.shimizukenta.secs.gem;

import java.util.List;
import java.util.stream.Collectors;

import com.shimizukenta.secs.gem.impl.AbstractDynamicLink;
import com.shimizukenta.secs.secs2.Secs2;
import com.shimizukenta.secs.secs2.Secs2Exception;

/**
 * This interface is implementation of Event-Report-Link in GEM (SEMI-E30).
 * 
 * <p>
 * To create new instance, {@link #newInstance(DynamicCollectionEvent, List)}
 * To get CEID, {@link #collectionEventId()}
 * To get RPTIDs, {@link #reportIds()}
 * To S2F35 Single Link, {@link #toS2F35Link()}
 * </p>
 * <p>
 * Instances of this class are immutable.
 * </p>
 * 
 * @author kenta-shimizu
 *
 */
public interface DynamicLink {
	
	/**
	 * Returns new instance
	 * 
	 * @param collectionEvent the DynamicCollectionEvent
	 * @param reportIds the Report IDs
	 * @return newInstance
	 */
	public static DynamicLink newInstance(DynamicCollectionEvent collectionEvent, List<? extends Secs2> reportIds) {
		
		return new AbstractDynamicLink(collectionEvent, reportIds) {
			private static final long serialVersionUID = -6582421299432050134L;
			
		};
	}
	
	/**
	 * to S2F35-Secs2-Single-Link.
	 * 
	 * <p>
	 * Single-Link-Format:
	 * &lt;L [2]
	 * &nbsp;&nbsp;&lt;U4 collection-event-id&gt;
	 * &nbsp;&nbsp;&lt;L [n]
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;U4 report-id-1&gt;
	 * &nbsp;&nbsp;&nbsp;&nbsp;...
	 * &nbsp;&nbsp;&lt;
	 * &gt;.
	 * </p>
	 * 
	 * @return S2F35-single-link
	 */
	public Secs2 toS2F35Link();
	
	/**
	 * Returns Collection-Event
	 * 
	 * @return DynamicCollectionEvent
	 */
	public DynamicCollectionEvent collectionEvent();
	
	/**
	 * Returns CEID SECS-II
	 * 
	 * @return CEID SECS-II
	 */
	public Secs2 collectionEventId();
	
	/**
	 * Returns RPTIDs
	 * 
	 * @return list of RPTIDs
	 */
	public List<Secs2> reportIds();
	
	
	/**
	 * newInstance from S2F35-Secs2-Single-Link.
	 * 
	 * <p>
	 * Single-Link-Format:
	 * &lt;L [2]
	 * &nbsp;&nbsp;&lt;U4 collection-event-id&gt;
	 * &nbsp;&nbsp;&lt;L [n]
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;U4 report-id-1&gt;
	 * &nbsp;&nbsp;&nbsp;&nbsp;...
	 * &nbsp;&nbsp;&lt;
	 * &gt;.
	 * </p>
	 * 
	 * @param secs2 S2F35 Secs2 Single-Link
	 * @return DynamicLink
	 * @throws Secs2Exception if SECS-II parse failed
	 */
	public static DynamicLink fromS2F35Link(Secs2 secs2) throws Secs2Exception {
		DynamicCollectionEvent ce = DynamicCollectionEvent.newInstance(null, secs2.get(0));
		List<Secs2> rptids = secs2.get(1).stream().collect(Collectors.toList());
		return newInstance(ce, rptids);
	}
	

}
