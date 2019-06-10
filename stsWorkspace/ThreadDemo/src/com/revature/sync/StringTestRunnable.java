package com.revature.sync;

public class StringTestRunnable implements Runnable {
	
	StringBuilder sBuild = new StringBuilder();
	StringBuffer sBuff = new StringBuffer();
	char c;
	
	public StringTestRunnable() {
		
	}
	
	public StringTestRunnable(StringBuilder sBuild, StringBuffer sBuff, char c) {
		super();
		this.sBuff = sBuff;
		this.sBuild = sBuild;
		this.c = c;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			sBuild = sBuild.append(c);
			sBuff = sBuff.append(c);
		}
	}

}
