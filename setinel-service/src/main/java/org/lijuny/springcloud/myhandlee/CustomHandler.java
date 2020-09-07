package org.lijuny.springcloud.myhandlee;

import org.lijuny.springcloud.entities.CommonResult;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author lijunyi
 */
public class CustomHandler {

	public static CommonResult handler(BlockException e) {
		return new CommonResult(444, e.getClass().getCanonicalName());
	}
}
