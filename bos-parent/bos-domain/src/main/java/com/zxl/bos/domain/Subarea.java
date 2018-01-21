package com.zxl.bos.domain;

/**
 * 分区
 */

public class Subarea implements java.io.Serializable {

	// Fields

	private String id;
	private Decidedzone decidedzone;
	private Region region;
	private String addresskey;
	private String startnum;
	private String endnum;
	private String single;
	private String position;

	public String getSubareaid(){
		return id;
	}
	
	// Constructors

	/** default constructor */
	public Subarea() {
	}

	/** minimal constructor */
	public Subarea(String id) {
		this.id = id;
	}

	/** full constructor */
	public Subarea(String id, Decidedzone decidedzone, Region region,
			String addresskey, String startnum, String endnum, String single,
			String position) {
		this.id = id;
		this.decidedzone = decidedzone;
		this.region = region;
		this.addresskey = addresskey;
		this.startnum = startnum;
		this.endnum = endnum;
		this.single = single;
		this.position = position;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Decidedzone getDecidedzone() {
		return this.decidedzone;
	}

	public void setDecidedzone(Decidedzone decidedzone) {
		this.decidedzone = decidedzone;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getAddresskey() {
		return this.addresskey;
	}

	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}

	public String getStartnum() {
		return this.startnum;
	}

	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}

	public String getEndnum() {
		return this.endnum;
	}

	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}

	public String getSingle() {
		return this.single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}