package com.cxb.zbq.entityquery;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumQuery {
	private String curriculumName;//课程名称
	private Integer curriculumCategoryId;//类别id
	private Integer whetherToIssue;//是否发布(0：未发布 1：已发布)
	private Integer teacherId;//老师id
	

}
