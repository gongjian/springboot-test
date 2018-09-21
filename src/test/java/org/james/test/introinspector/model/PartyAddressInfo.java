package org.james.test.introinspector.model;

/**
 * <b>Description:<b><br/>
 * Output model for party address which belongs to party roles who have address
 * information defined.
 * 
 */
public class PartyAddressInfo extends AddressInfo {

	public PartyAddressInfo(){
		super();
	}
	
	private static final long serialVersionUID = 7616574942606442306L;

	private java.lang.Long partyAddrId;
	
	public java.lang.Long getPartyAddrId() {
		return partyAddrId;
	}

	public void setPartyAddrId(java.lang.Long partyAddrId) {
		this.partyAddrId = partyAddrId;
	}

	
}
