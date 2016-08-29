package com.neolynks.common.model.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.neolynks.common.model.ErrorCode;
import com.neolynks.common.model.client.ItemInfo;
import com.neolynks.common.model.client.price.ItemPrice;

/**
 * Created by nitesh.garg on Nov 28, 2015
 *
 */

@Data
public class ItemRequest implements Serializable {

	private static final long serialVersionUID = 2596651645497262599L;

	private Long barcode;
	private String itemCode;
	
	private ItemPrice itemPrice;
	private Boolean isPricingChanged = false;
	
	private Integer countForDelivery = 0;
	private Integer countForInStorePickup = 1;
	
	/**
	 * MRP is arbitrary number with no real implications other than sometimes being considered for discounts
	 * 
	 * fn(basePrice, tax%) = taxAmount
	 * 
	 * selling-price = basePrice + taxAmount - individualItemDiscountAmount
	 * netPrice = fn ( (count * price), cummulative-discount-if-applicable)
	 * 
	 */	
	
	private Double netPrice = 0.0D;
	private Double netTaxAmount = 0.0D;
	private Double netTaxableAmount = 0.0D;
	private Double netDiscountAmount = 0.0D;

	public List<ErrorCode> selfValidate() {
		List<ErrorCode> response = new ArrayList<ErrorCode>();

		if (this.getItemCode() == null) {
			response.add(ErrorCode.INVALID_OR_MISSING_ITEM_CODE);
		}

		if (this.getBarcode() == null) {
			response.add(ErrorCode.INVALID_OR_MISSING_BARCODE);
		}
		return response;
	}

	public ItemRequest() {
	}

	public ItemRequest(ItemInfo itemInfo) {
		this.setBarcode(itemInfo.getBarcode());
		this.setItemCode(itemInfo.getItemCode());
		//this.setItemPrice(itemInfo.getItemPrice());
	}

}
