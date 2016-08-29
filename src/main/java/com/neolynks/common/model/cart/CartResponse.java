package com.neolynks.common.model.cart;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.neolynks.common.model.BaseResponse;

/**
 * Created by nitesh.garg on Dec 27, 2015
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class CartResponse extends BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 5112133396527776299L;
	
	CartInfo cartBase;

}
