package org.lijuny.springcloud.domain;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
	private int id;
	private String user_id;
	private String commodity_code;

	private int count;
	private int money;

}
