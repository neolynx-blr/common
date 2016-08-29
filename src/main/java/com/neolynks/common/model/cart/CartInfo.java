package com.neolynks.common.model.cart;

import java.io.Serializable;

import com.neolynks.common.model.order.DeliveryMode;

import lombok.Data;

/**
 * Created by nitesh.garg on Dec 27, 2015
 *
 */

@Data
public class CartInfo implements Serializable {

	private static final long serialVersionUID = 1255731123698943954L;

	private Long id;
	private CartStatus status = CartStatus.OPEN;

	private Long userId;
	private Long vendorId;

	private Integer totalItemCount = 0;
	private Integer uniqueItemCount = 0;

	private DeliveryMode deliveryMode = DeliveryMode.IN_STORE_PICKUP;

}
