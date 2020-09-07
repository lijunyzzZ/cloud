package org.lijuny.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

/**
 * @author lijunyi
 */
@Component
public class PaymentService {
	public String paymentInfo_ok(Integer integer) {
		return "线程池" + Thread.currentThread().getName() + "paymentInfo_ok.id"  + integer;
	}

	/**
	 * 模拟出错的情况
	 * @param integer
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "paymentInfo_fallback",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") //三秒的限制
	})
	public String paymentInfo_TimeOut(Integer integer) {
		try {
//			int a = 10 /0;
			TimeUnit.SECONDS.sleep(5); //耗时超过限制

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池" + Thread.currentThread().getName() + "paymentInfo_timeout.id"  + integer + "cost time 5 s";
	}

	public String paymentInfo_fallback(Integer integer) {
		return "线程池" + Thread.currentThread().getName() + "paymentInfo_fallback.id"  + integer + " fallback";
	}


	//++++++++熔断


	@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败次数
	}) //十秒钟之类十次访问超过60%的失败就会熔断，断路器状态变回open会拦截所有的请求，下一个时间窗口变为（half open）会让一个请求通过，如果这个请求成功了那么就close，否者open
	public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
		if (id < 0 ) {
			throw new RuntimeException("**** id 不能为负数");
		}
		return Thread.currentThread().getName() + "invoke success, the uuid : " + IdUtil.simpleUUID();
	}

	public String paymentCircuitBreaker_fallback(Integer id) {
		return "id < 0" + id;
	}

}
