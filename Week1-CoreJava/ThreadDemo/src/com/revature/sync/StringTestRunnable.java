package com.revature.sync;

public class StringTestRunnable implements Runnable {
	
	StringBuilder sbuild = new StringBuilder();
	StringBuffer sbuff = new StringBuffer();
	char c;
	
	public StringTestRunnable() {
		super();
	}
	
	public StringTestRunnable(StringBuilder sbuild, StringBuffer sbuff, char c) {
		super();
		this.sbuff = sbuff;
		this.sbuild = sbuild;
		this.c = c;
	}

	@Override
	public void run() {
		for(int i=0; i<50; i++) {
			sbuild = sbuild.append(c);
			sbuff = sbuff.append(c);
		}
		
	}

}
