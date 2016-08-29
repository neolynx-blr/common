package com.neolynks.common.model.client.price;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Created by nitesh.garg on Oct 28, 2015
 *
 */

@Data
public class DiscountDetail implements Serializable {

	private static final long serialVersionUID = 3994392467743733771L;

	private List<DiscountInfo> discountInfo = new ArrayList<DiscountInfo>();

	public Boolean isDifferent(DiscountDetail newDiscountDetail) {

		if ((this.getDiscountInfo().isEmpty() && !newDiscountDetail.getDiscountInfo().isEmpty())
				|| (!this.getDiscountInfo().isEmpty() && newDiscountDetail.getDiscountInfo().isEmpty())
				|| (this.getDiscountInfo().size() != newDiscountDetail.getDiscountInfo().size())) {
			return Boolean.TRUE;
		}

		// TODO Later check for all
		if (this.getDiscountInfo().get(0).isDifferent(newDiscountDetail.getDiscountInfo().get(0))) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;

	}
}
