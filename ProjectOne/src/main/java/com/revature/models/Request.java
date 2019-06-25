package com.revature.models;

public class Request
{
	private int reqID;
	private int ammount;
	private String reason;
	private String status;
	private int createdBy;
	private int resolvedBy;
	private String outcome;
	
	public Request()
	{
		super();
	}
	
	

	public Request(int reqID, int ammount, String reason, String status, int createdBy, int resolvedBy, String outcome)
	{
		super();
		this.reqID = reqID;
		this.ammount = ammount;
		this.reason = reason;
		this.status = status;
		this.createdBy = createdBy;
		this.resolvedBy = resolvedBy;
		this.outcome = outcome;
	}



	@Override
	public String toString()
	{
		return "Request [reqID=" + reqID + ", ammount=" + ammount + ", reason=" + reason + ", status=" + status
				+ ", createdBy=" + createdBy + ", resolvedBy=" + resolvedBy + ", outcome=" + outcome + "]";
	}



	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ammount;
		result = prime * result + createdBy;
		result = prime * result + ((outcome == null) ? 0 : outcome.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reqID;
		result = prime * result + resolvedBy;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (ammount != other.ammount)
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (outcome == null)
		{
			if (other.outcome != null)
				return false;
		} else if (!outcome.equals(other.outcome))
			return false;
		if (reason == null)
		{
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reqID != other.reqID)
			return false;
		if (resolvedBy != other.resolvedBy)
			return false;
		if (status == null)
		{
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}



	public int getReqID()
	{
		return reqID;
	}

	public void setReqID(int reqID)
	{
		this.reqID = reqID;
	}

	public int getAmmount()
	{
		return ammount;
	}

	public void setAmmount(int ammount)
	{
		this.ammount = ammount;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(int createdBy)
	{
		this.createdBy = createdBy;
	}

	public int getResolvedBy()
	{
		return resolvedBy;
	}

	public void setResolvedBy(int resolvedBy)
	{
		this.resolvedBy = resolvedBy;
	}

	public String getOutcome()
	{
		return outcome;
	}

	public void setOutcome(String outcome)
	{
		this.outcome = outcome;
	}



	
}
