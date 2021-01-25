/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shivishbrahma.tilottama.main.util.bankapp.api;

/**
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Bank {
	String BANK, IFSC, BRANCH, ADDRESS, CONTACT, CITY, RTGS, DISTRICT, STATE;

	public Bank(String BANK, String IFSC, String BRANCH, String ADDRESS, String CONTACT, String CITY, String RTGS,
			String DISTRICT, String STATE) {
		this.BANK = BANK;
		this.IFSC = IFSC;
		this.BRANCH = BRANCH;
		this.ADDRESS = ADDRESS;
		this.CONTACT = CONTACT;
		this.CITY = CITY;
		this.RTGS = RTGS;
		this.DISTRICT = DISTRICT;
		this.STATE = STATE;
	}

	/**
	 * @return the bANK
	 */
	public String getBANK() {
		return BANK;
	}

	/**
	 * @param bANK the bANK to set
	 */
	public void setBANK(String bANK) {
		BANK = bANK;
	}

	/**
	 * @return the iFSC
	 */
	public String getIFSC() {
		return IFSC;
	}

	/**
	 * @param iFSC the iFSC to set
	 */
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	/**
	 * @return the bRANCH
	 */
	public String getBRANCH() {
		return BRANCH;
	}

	/**
	 * @param bRANCH the bRANCH to set
	 */
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}

	/**
	 * @return the aDDRESS
	 */
	public String getADDRESS() {
		return ADDRESS;
	}

	/**
	 * @param aDDRESS the aDDRESS to set
	 */
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	/**
	 * @return the cONTACT
	 */
	public String getCONTACT() {
		return CONTACT;
	}

	/**
	 * @param cONTACT the cONTACT to set
	 */
	public void setCONTACT(String cONTACT) {
		CONTACT = cONTACT;
	}

	/**
	 * @return the cITY
	 */
	public String getCITY() {
		return CITY;
	}

	/**
	 * @param cITY the cITY to set
	 */
	public void setCITY(String cITY) {
		CITY = cITY;
	}

	/**
	 * @return the rTGS
	 */
	public String getRTGS() {
		return RTGS;
	}

	/**
	 * @param rTGS the rTGS to set
	 */
	public void setRTGS(String rTGS) {
		RTGS = rTGS;
	}

	/**
	 * @return the dISTRICT
	 */
	public String getDISTRICT() {
		return DISTRICT;
	}

	/**
	 * @param dISTRICT the dISTRICT to set
	 */
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}

	/**
	 * @return the sTATE
	 */
	public String getSTATE() {
		return STATE;
	}

	/**
	 * @param sTATE the sTATE to set
	 */
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	/**
	 * @return
	 */
	public String stringify() {
		String s = "";
		s += "BANK = " + BANK + "\n";
		s += "IFSC = " + IFSC + "\n";
		s += "BRANCH = " + BRANCH + "\n";
		s += "ADDRESS = " + ADDRESS + "\n";
		s += "CONTACT = " + CONTACT + "\n";
		s += "CITY = " + CITY + "\n";
		s += "RTGS = " + RTGS + "\n";
		s += "DISTRICT = " + DISTRICT + "\n";
		s += "STATE = " + STATE;
		return s;
	}

}
