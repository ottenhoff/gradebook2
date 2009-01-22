/**********************************************************************************
*
* $Id:$
*
***********************************************************************************
*
* Copyright (c) 2008, 2009 The Regents of the University of California
*
* Licensed under the
* Educational Community License, Version 2.0 (the "License"); you may
* not use this file except in compliance with the License. You may
* obtain a copy of the License at
* 
* http://www.osedu.org/licenses/ECL-2.0
* 
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an "AS IS"
* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
* or implied. See the License for the specific language governing
* permissions and limitations under the License.
*
**********************************************************************************/
package org.sakaiproject.gradebook.gwt.client.model;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GradebookModel extends EntityModel implements IsSerializable {

	public enum GradeType { POINTS, PERCENTAGES, LETTERS, TEXT };
	public enum CategoryType { NO_CATEGORIES, SIMPLE_CATEGORIES, WEIGHTED_CATEGORIES }
	public enum Key { NAME("Name"), CATEGORYTYPE("Category Type"), GRADETYPE("Grade Type"), RELEASEGRADES("Release Grades");
	
		private String displayName;
	
		Key(String displayName) {
			this.displayName = displayName;
		}
		
		public String getDisplayName() {
			return displayName;
		}
	
	}
	
	private static final long serialVersionUID = 1L;
	
	private String gradebookUid;
	private Long gradebookId;
	private String name;
	private Boolean isReleaseGrades;
	private CategoryType categoryType;
	private GradeType gradeType;
	private Boolean isUserAbleToViewOwnGrades;
	private Boolean isUserHasGraderPermissions;
	private Boolean isUserAbleToGrade;
	private Boolean isUserAbleToEditAssessments;
	private StudentModel userAsStudent;
	private List<ColumnModel> columns;
	private String userName;


	public GradebookModel() {
		
	}

	public String getGradebookUid() {
		return gradebookUid;
	}


	public void setGradebookUid(String gradebookUid) {
		this.gradebookUid = gradebookUid;
	}


	public Long getGradebookId() {
		return gradebookId;
	}


	public void setGradebookId(Long gradebookId) {
		this.gradebookId = gradebookId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}	
	
	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	public GradeType getGradeType() {
		return gradeType;
	}

	public void setGradeType(GradeType gradeType) {
		this.gradeType = gradeType;
	}
	
	public Boolean isReleaseGrades() {
		return isReleaseGrades;
	}

	public void setReleaseGrades(Boolean isReleaseGrades) {
		this.isReleaseGrades = isReleaseGrades;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public Boolean isUserAbleToViewOwnGrades() {
		return isUserAbleToViewOwnGrades;
	}

	public void setUserAbleToViewOwnGrades(Boolean isUserAbleToViewOwnGrades) {
		this.isUserAbleToViewOwnGrades = isUserAbleToViewOwnGrades;
	}

	public Boolean isUserHasGraderPermissions() {
		return isUserHasGraderPermissions;
	}

	public void setUserHasGraderPermissions(Boolean isUserHasGraderPermissions) {
		this.isUserHasGraderPermissions = isUserHasGraderPermissions;
	}

	public Boolean isUserAbleToGrade() {
		return isUserAbleToGrade;
	}

	public void setUserAbleToGrade(Boolean isUserAbleToGrade) {
		this.isUserAbleToGrade = isUserAbleToGrade;
	}

	public Boolean isUserAbleToEditAssessments() {
		return isUserAbleToEditAssessments;
	}

	public void setUserAbleToEditAssessments(Boolean isUserAbleToEditAssessments) {
		this.isUserAbleToEditAssessments = isUserAbleToEditAssessments;
	}

	public StudentModel getUserAsStudent() {
		return userAsStudent;
	}

	public void setUserAsStudent(StudentModel userAsStudent) {
		this.userAsStudent = userAsStudent;
	}

	@Override
	public String getDisplayName() {
		return getName();
	}

	@Override
	public String getIdentifier() {
		return gradebookUid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
