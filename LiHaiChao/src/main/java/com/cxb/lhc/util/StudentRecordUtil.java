package com.cxb.lhc.util;

import javax.persistence.Column;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder  
public class StudentRecordUtil {
	private Integer scholeStudentingId;
	private Integer studentId;
	private Integer unitCourseId;
	private Long videoStudentingTime;
	private Double videoExitTime;
	private int studentState;
	@Transient 
	private String  exel1;
	@Transient 
	private String  exel2;

}
