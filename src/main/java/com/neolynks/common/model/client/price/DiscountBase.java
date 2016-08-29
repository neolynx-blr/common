package com.neolynks.common.model.client.price;

import java.io.Serializable;

import lombok.Data;

import com.neolynks.common.util.DiscountPlayer;
import com.neolynks.common.util.DiscountUnit;

/**
 * Created by nitesh.garg on Dec 13, 2015
 *
 */

@Data
public class DiscountBase implements Serializable {

	private static final long serialVersionUID = -556123350699505821L;

	private Double value = 1.0D;
	private DiscountUnit unit = DiscountUnit.COUNT;
	private DiscountPlayer player = DiscountPlayer.SELF;

	public Boolean isDifferent(DiscountBase discountBase) {

		if (discountBase == null) {
			return Boolean.TRUE;
		}

		if ((this.getValue() == null && discountBase.getValue() != null)
				|| (this.getValue() != null && discountBase.getValue() == null)
				|| (this.getValue().compareTo(discountBase.getValue()) != 0)) {
			return Boolean.TRUE;
		}

		if ((this.getUnit() == null && discountBase.getUnit() != null)
				|| (this.getUnit() != null && discountBase.getUnit() == null)
				|| (this.getUnit().getValue() != discountBase.getUnit().getValue())) {
			return Boolean.TRUE;
		}

		if ((this.getPlayer() == null && discountBase.getPlayer() != null)
				|| (this.getPlayer() != null && discountBase.getPlayer() == null)
				|| (this.getPlayer().getValue() != discountBase.getPlayer().getValue())) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

}
