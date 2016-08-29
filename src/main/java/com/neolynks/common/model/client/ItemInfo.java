package com.neolynks.common.model.client;

import java.io.Serializable;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neolynks.common.model.client.price.ItemPrice;
import com.neolynks.common.model.order.ItemProcessor;

/**
 * Created by nitesh.garg on Oct 28, 2015
 *
 */

@Data
public class ItemInfo implements Serializable {

	static Logger LOGGER = LoggerFactory.getLogger(ItemInfo.class);
	private static final long serialVersionUID = 594832882355959992L;

	private Long barcode;
	private String itemCode;

	private ItemPrice itemPrice;
	private ProductInfo productInfo;

	/**
	 * TODO Throw error if the item code or barcode doesn't match
	 */

	public void updateThisWithLatestItemData(ItemInfo latestItemData) {

		this.getItemPrice().setMrp(latestItemData.getItemPrice().getMrp());
		this.getItemPrice().setPrice(latestItemData.getItemPrice().getSellingPrice());
		this.getItemPrice().setBasePrice(latestItemData.getItemPrice().getBasePrice());

		this.getItemPrice().setTaxDetail(latestItemData.getItemPrice().getTaxDetail());
		this.getItemPrice().setDiscountDetail(latestItemData.getItemPrice().getDiscountDetail());

		this.getProductInfo().reset();
		this.getProductInfo().setName(latestItemData.getProductInfo().getName());
		this.getProductInfo().setTagLine(latestItemData.getProductInfo().getTagLine());
		this.getProductInfo().setImageJSON(latestItemData.getProductInfo().getImageJSON());
		this.getProductInfo().setDescription(latestItemData.getProductInfo().getDescription());
	}

	public ItemInfo generateDifferentialFrom(ItemInfo latestItemData) {

		ItemInfo deltaItemInfo = new ItemInfo();

		deltaItemInfo.setBarcode(this.getBarcode());
		deltaItemInfo.setItemCode(this.getItemCode());

		if (this.getItemPrice() == null || latestItemData.getItemPrice() == null) {
			deltaItemInfo.setItemPrice(latestItemData.getItemPrice());
		} else {
			deltaItemInfo.setItemPrice(this.getItemPrice().generateDifferentialFrom(latestItemData.getItemPrice()));
		}

		if (this.getProductInfo() == null) {
			deltaItemInfo.setProductInfo(latestItemData.getProductInfo());
		} else if (latestItemData.getProductInfo() == null) {
			deltaItemInfo.setProductInfo(this.getProductInfo());
		} else {
			deltaItemInfo.setProductInfo(this.getProductInfo()
					.generateDifferentialFrom(latestItemData.getProductInfo()));
		}

		return deltaItemInfo;

	}

	public void mergeOnlyNewUpdatesFrom(ItemInfo updateFromLatestItemData) {

		if (updateFromLatestItemData.getProductInfo().getIsName()) {
			this.getProductInfo().setName(updateFromLatestItemData.getProductInfo().getName());
		}

		if (updateFromLatestItemData.getProductInfo().getIsDescription()) {
			this.getProductInfo().setDescription(updateFromLatestItemData.getProductInfo().getDescription());
		}

		if (updateFromLatestItemData.getProductInfo().getIsImageJSON()) {
			this.getProductInfo().setImageJSON(updateFromLatestItemData.getProductInfo().getImageJSON());
		}

		if (updateFromLatestItemData.getProductInfo().getIsTagLine()) {
			this.getProductInfo().setTagLine(updateFromLatestItemData.getProductInfo().getTagLine());
		}
	}

	public ItemInfo() {
		super();
	}

	public ItemProcessor generateItemProcessor() {
		ItemProcessor itemProcessor = new ItemProcessor();

		itemProcessor.setBarcode(this.getBarcode());
		itemProcessor.setItemCode(this.getItemCode());
		itemProcessor.setItemPrice(this.getItemPrice());
		itemProcessor.setProductInfo(this.getProductInfo());

		return itemProcessor;
	}

}
