package org.lijuny.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lijunyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
	private long id;
	private String serial;
}
