package com.kingston.net.task;

/**
 * provides a skeletal implementation of the <tt>IDistributeTask</tt>
 * interface, and provides an api to measure cost time
 * @author kingston
 */
public abstract class AbstractDistributeTask implements IDistributeTask{

	/** thread distribute key  */
	protected int distributeKey;
	/** startTime when task begin */
	private long startMillis;
	/** end time when task finish */
	private long endMillis;

	public String getName() {
		return this.getClass().getSimpleName();
	}

	public int distributeKey() {
		return distributeKey;
	}

	public long getStartMillis() {
		return startMillis;
	}

	public void markStartMillis() {
		this.startMillis = System.currentTimeMillis();
	}

	public long getEndMillis() {
		return endMillis;
	}

	public void markEndMillis() {
		this.endMillis = System.currentTimeMillis();
	}

}
