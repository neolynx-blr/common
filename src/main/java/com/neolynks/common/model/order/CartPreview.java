package com.neolynks.common.model.order;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * Created by nitesh.garg on Dec 27, 2015
 *
 */

@Data
public class CartPreview implements Serializable {
	
	private static final long serialVersionUID = 3055115630699748328L;
	
	private Long userId;
	private Long vendorId;

	private DeliveryMode deliveryMode = DeliveryMode.IN_STORE_PICKUP;
	private Map<Long, Integer> itemBarcodeCountMap = new HashMap<Long, Integer>();
	
}
