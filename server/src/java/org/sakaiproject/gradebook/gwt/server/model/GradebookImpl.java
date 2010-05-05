package org.sakaiproject.gradebook.gwt.server.model;

import java.util.List;

import org.sakaiproject.gradebook.gwt.client.gxt.model.ItemModel;
import org.sakaiproject.gradebook.gwt.client.model.Configuration;
import org.sakaiproject.gradebook.gwt.client.model.FixedColumn;
import org.sakaiproject.gradebook.gwt.client.model.Gradebook;
import org.sakaiproject.gradebook.gwt.client.model.Item;
import org.sakaiproject.gradebook.gwt.client.model.Learner;
import org.sakaiproject.gradebook.gwt.client.model.Statistics;
import org.sakaiproject.gradebook.gwt.client.model.key.GradebookKey;
import org.sakaiproject.gradebook.gwt.server.Util;

import com.extjs.gxt.ui.client.data.ModelData;

public class GradebookImpl extends BaseModel implements Gradebook {

	private static final long serialVersionUID = 1L;

	public GradebookImpl() {
		super();
		setNewGradebook(Boolean.FALSE);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getGradebookUid()
	 */
	public String getGradebookUid() {
		return get(GradebookKey.S_GB_UID.name());
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setGradebookUid(java.lang.String)
	 */
	public void setGradebookUid(String gradebookUid) {
		set(GradebookKey.S_GB_UID.name(), gradebookUid);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getGradebookId()
	 */
	public Long getGradebookId() {
		return Util.toLong(get(GradebookKey.L_GB_ID.name()));
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setGradebookId(java.lang.Long)
	 */
	public void setGradebookId(Long gradebookId) {
		set(GradebookKey.L_GB_ID.name(), gradebookId);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getConfigurationModel()
	 */
	public Configuration getConfigurationModel() {
		return get(GradebookKey.M_CONF.name());
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setConfigurationModel(org.sakaiproject.gradebook.gwt.client.model.Configuration)
	 */
	public void setConfigurationModel(Configuration configuration) {
		set(GradebookKey.M_CONF.name(), configuration);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getName()
	 */
	public String getName() {
		return get(GradebookKey.S_NM.name());
	}


	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setName(java.lang.String)
	 */
	public void setName(String name) {
		set(GradebookKey.S_NM.name(), name);
	}	
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getColumns()
	 */
	public List<FixedColumn> getColumns() {
		return get(GradebookKey.A_CLMNS.name());
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setColumns(java.util.List)
	 */
	public void setColumns(List<FixedColumn> columns) {
		set(GradebookKey.A_CLMNS.name(), columns);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getUserAsStudent()
	 */
	public Learner getUserAsStudent() {
		return get(GradebookKey.M_USER.name());
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setUserAsStudent(org.sakaiproject.gradebook.gwt.client.model.Learner)
	 */
	public void setUserAsStudent(Learner userAsStudent) {
		set(GradebookKey.M_USER.name(), userAsStudent);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getIdentifier()
	 */
	public String getIdentifier() {
		return getGradebookUid();
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getUserName()
	 */
	public String getUserName() {
		return get(GradebookKey.S_USR_NM.name());
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setUserName(java.lang.String)
	 */
	public void setUserName(String userName) {
		set(GradebookKey.S_USR_NM.name(), userName);
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getGradebookItemModel()
	 */
	public Item getGradebookItemModel() {	
		return get(GradebookKey.M_GB_ITM.name());
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setGradebookGradeItem(org.sakaiproject.gradebook.gwt.client.model.Item)
	 */
	public void setGradebookGradeItem(Item gradebookGradeItem) {
		set(GradebookKey.M_GB_ITM.name(), gradebookGradeItem);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#isNewGradebook()
	 */
	public Boolean isNewGradebook() {
		return Util.toBoolean(get(GradebookKey.B_NEW_GB.name()));
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setNewGradebook(java.lang.Boolean)
	 */
	public void setNewGradebook(Boolean isNewGradebook) {
		set(GradebookKey.B_NEW_GB.name(), isNewGradebook);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getStatsModel()
	 */
	public List<Statistics> getStatsModel() {
		return get(GradebookKey.A_STATS.name());
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#setStatsModel(java.util.List)
	 */
	public void setStatsModel(List<Statistics> statsModel) {
		set(GradebookKey.A_STATS.name(), statsModel);
	}

	
	/*
	 * (non-Javadoc)
	 * @see org.sakaiproject.gradebook.gwt.client.model.Gradebook#getCategoryItemModel(java.lang.Long)
	 */
	public Item getCategoryItemModel(Long categoryId) {
		
		// Returning null because it's not called on the server side
		return null;
	}

}
