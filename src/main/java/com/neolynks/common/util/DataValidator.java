package com.neolynks.common.util;

import org.apache.commons.collections4.CollectionUtils;

import com.neolynks.common.model.BaseResponse;
import com.neolynks.common.model.ErrorCode;
import com.neolynks.common.model.order.CartRequest;

/**
 * Created by nitesh.garg on Oct 25, 2015
 *
 */
public class DataValidator {

	public static BaseResponse validateFreshCart(CartRequest cart) {

		BaseResponse response = new BaseResponse();

		if (LongUtilsCustom.isEmpty(cart.getVendorId())) {
			response.getErrorDetail().add(ErrorCode.INVALID_VENDOR_ID);
		}

		if (LongUtilsCustom.isEmpty(cart.getDeviceDataVersionId())) {
			response.getErrorDetail().add(ErrorCode.UNKNOWN_INVENTORY_VERSION_ON_DEVICE);
		} else if (cart.getDeviceDataVersionId() < 0L) {
			response.getErrorDetail().add(ErrorCode.EXPIRED_DATA_VERSION);
		}

		if (cart.getDeliveryMode().getValue() == Constant.DELIVERY_MODE_DELIVERY
				|| cart.getDeliveryMode().getValue() == Constant.DELIVERY_MODE_PARTIAL_DELIVERY) {

			if (cart.getUserDetail() == null || cart.getUserDetail().getAddressId() == null || cart.getUserDetail().getUserId() == null) {
				response.getErrorDetail().add(ErrorCode.MISSING_USER_DETAILS_FOR_DELIVERY);
			}

		}

		if (cart.getDeliveryMode() == null) {
			response.getErrorDetail().add(ErrorCode.MISSING_USER_DETAILS_FOR_DELIVERY);
		}

		if (cart.getInStorePickUpItemBarcodeCountMap().size() == 0 && cart.getToBeDeliveredItemBarcodeCountMap().size() == 0) {
			response.getErrorDetail().add(ErrorCode.MISSING_ITEMS_IN_CART);
		} else {

			// TODO Validate delivery mode being correct



		}

		if (CollectionUtils.isNotEmpty(response.getErrorDetail())) {
			response.setIsError(Boolean.TRUE);
		}

		return response;

	}

	public static BaseResponse validateUpdatedCart(CartRequest cart) {

		BaseResponse response = new BaseResponse();

		if (cart.getUpdateCart() == null) {
			response.getErrorDetail().add(ErrorCode.MISSING_UPDATE_CART_DETAILS);
		}

		if (cart.getCartId() == null) {
			response.getErrorDetail().add(ErrorCode.MISSING_ORDER_ID);
		}

		if (cart.getUpdateCart().getIsItemListUpdated() == Boolean.FALSE
				&& cart.getUpdateCart().getIsUserDetailUpdated() == Boolean.FALSE) {
			response.getErrorDetail().add(ErrorCode.MISSING_UPDATE_OPERATION_REASON);
		}

		if (cart.getUpdateCart().getLastKnownServerDataVersionId() == null) {
			response.getErrorDetail().add(ErrorCode.MISSING_OR_INVALID_LAST_SEEN_SERVER_DATA_VERSION_ID);
		}

		if (LongUtilsCustom.isEmpty(cart.getVendorId())) {
			response.getErrorDetail().add(ErrorCode.INVALID_VENDOR_ID);
		}

		if (LongUtilsCustom.isEmpty(cart.getDeviceDataVersionId())) {
			response.getErrorDetail().add(ErrorCode.UNKNOWN_INVENTORY_VERSION_ON_DEVICE);
		} else if (cart.getDeviceDataVersionId() < 0L) {
			response.getErrorDetail().add(ErrorCode.EXPIRED_DATA_VERSION);
		}

		if (cart.getDeliveryMode().getValue() == Constant.DELIVERY_MODE_DELIVERY
				|| cart.getDeliveryMode().getValue() == Constant.DELIVERY_MODE_PARTIAL_DELIVERY) {

			if (cart.getUserDetail() == null || cart.getUserDetail().getAddressId() == null || cart.getUserDetail().getUserId() == null) {
				response.getErrorDetail().add(ErrorCode.MISSING_USER_DETAILS_FOR_DELIVERY);
			}

		}

		if (cart.getDeliveryMode() == null) {
			response.getErrorDetail().add(ErrorCode.MISSING_USER_DETAILS_FOR_DELIVERY);
		}

		if (cart.getInStorePickUpItemBarcodeCountMap().size() == 0 && cart.getToBeDeliveredItemBarcodeCountMap().size() == 0) {
			response.getErrorDetail().add(ErrorCode.MISSING_ITEMS_IN_CART);
		} else {

			// TODO Validate delivery mode being correct

		}

		if (CollectionUtils.isNotEmpty(response.getErrorDetail())) {
			response.setIsError(Boolean.TRUE);
		}

		return response;

	}
}
