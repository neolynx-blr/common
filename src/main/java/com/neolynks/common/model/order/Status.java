package com.neolynks.common.model.order;

/**
 * Created by nitesh.garg on Oct 23, 2015
 *
 */
public enum Status {

	CREATED(1), UPDATED(2), PENDING_PICKUP(3), PENDING_DELIVERY(4), PICKED_PENDING_DELIVERY(5), COMPLETED(6);
	
	private final int value;

	private Status(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	
}
