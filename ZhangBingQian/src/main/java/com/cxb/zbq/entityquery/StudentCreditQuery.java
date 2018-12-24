package com.cxb.zbq.entityquery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreditQuery {
	private Integer studentId;
	private Integer minCredit;
	private Integer maxCredit;
}
