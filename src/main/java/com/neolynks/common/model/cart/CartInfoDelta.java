package com.neolynks.common.model.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.neolynks.common.model.order.DeliveryMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by nitesh.garg on Dec 27, 2015
 *
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class CartInfoDelta implements Serializable {

	private static final long serialVersionUID = -7937068926138372616L;

	private String id;
	private Long vendorId;

	private DeliveryMode deliveryMode = DeliveryMode.IN_STORE_PICKUP;
	private Map<Long, Integer> deltaBarcodeCount = new HashMap<Long, Integer>();

}
