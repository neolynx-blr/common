package com.neolynks.common.model.client.price;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.apache.commons.collections4.CollectionUtils;

/**
 * Created by nitesh.garg on Oct 28, 2015
 *
 */

@Data
public class DiscountInfo implements Serializable {

	private static final long serialVersionUID = 1810204767291078266L;

	private Date startDate;
	private Date endDate;

	DiscountBase discountOn;
	List<DiscountBase> discountFor;

	public Boolean isDifferent(DiscountInfo discountInfo) {

		if (discountInfo == null) {
			return Boolean.TRUE;
		}

		if ((this.getStartDate() == null && discountInfo.getStartDate() != null)
				|| (this.getStartDate() != null && discountInfo.getStartDate() == null)
				|| (this.getStartDate().compareTo(discountInfo.getStartDate()) != 0)) {
			return Boolean.TRUE;
		}

		if ((this.getEndDate() == null && discountInfo.getEndDate() != null)
				|| (this.getEndDate() != null && discountInfo.getEndDate() == null)
				|| (this.getEndDate().compareTo(discountInfo.getEndDate()) != 0)) {
			return Boolean.TRUE;
		}

		if (this.getDiscountOn().isDifferent(discountInfo.getDiscountOn())) {
			return Boolean.TRUE;
		}

		if ((CollectionUtils.isNotEmpty(this.getDiscountFor()) && CollectionUtils
				.isEmpty(discountInfo.getDiscountFor()))
				|| (CollectionUtils.isEmpty(this.getDiscountFor()) && CollectionUtils.isNotEmpty(discountInfo
						.getDiscountFor())) || (this.getDiscountFor().size() != discountInfo.getDiscountFor().size())) {
			return Boolean.TRUE;
		}

		// TODO Later check for all
		if (this.getDiscountFor().get(0).isDifferent(discountInfo.getDiscountFor().get(0))) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

}
