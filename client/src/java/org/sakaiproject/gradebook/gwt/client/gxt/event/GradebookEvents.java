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
package org.sakaiproject.gradebook.gwt.client.gxt.event;

import java.util.HashMap;
import java.util.Map;

import org.sakaiproject.gradebook.gwt.client.gxt.event.GradebookEvent.EventKey;


public class GradebookEvents {

	private static Map<Integer, GradebookEvent> eventMap = new HashMap<Integer, GradebookEvent>();
	
	protected GradebookEvents() {

	}
	
	public static GradebookEvent registerEvent(EventKey eventKey) {
		GradebookEvent gradebookEvent = new GradebookEvent(eventKey);

		eventMap.put(Integer.valueOf(eventKey.getEventType()), gradebookEvent);
		return gradebookEvent;
	}
	
	public static GradebookEvent getEvent(int eventType) {
		GradebookEvent gradebookEvent = eventMap.get(Integer.valueOf(eventType));
	
		if (gradebookEvent == null)
			return None;
		
		return gradebookEvent;
	}
	
	
	public static final GradebookEvent BeginItemUpdates				= registerEvent(EventKey.BEGIN_ITEM_UPDATES);
	public static final GradebookEvent BrowseLearner 				= registerEvent(EventKey.BROWSE_LEARNER);
	public static final GradebookEvent Confirmation					= registerEvent(EventKey.CONFIRMATION);
	public static final GradebookEvent ConfirmDeleteItem			= registerEvent(EventKey.CONFIRM_DELETE_ITEM);
	public static final GradebookEvent ClearSearch 					= registerEvent(EventKey.CLEAR_SEARCH);
	public static final GradebookEvent CloseNotification			= registerEvent(EventKey.CLOSE_NOTIFICATION);
	public static final GradebookEvent CreateItem					= registerEvent(EventKey.CREATE_ITEM);
	public static final GradebookEvent DeleteItem					= registerEvent(EventKey.DELETE_ITEM);
	public static final GradebookEvent DoSearch 					= registerEvent(EventKey.DO_SEARCH);
	public static final GradebookEvent EndItemUpdates				= registerEvent(EventKey.END_ITEM_UPDATES);
	public static final GradebookEvent EqualWeight 					= registerEvent(EventKey.EQUL_WEIGHT);
	public static final GradebookEvent Exception 					= registerEvent(EventKey.EXCEPTION);
	public static final GradebookEvent ExpandEastPanel 				= registerEvent(EventKey.EXPAND_EAST_PANEL);
	public static final GradebookEvent GradebookChange 				= registerEvent(EventKey.GRADEBOOK_CHANGE);
	public static final GradebookEvent HideColumn					= registerEvent(EventKey.HIDE_COLUMN);
	public static final GradebookEvent HideEastPanel				= registerEvent(EventKey.HIDE_EAST_PANEL);
	public static final GradebookEvent HideFormPanel				= registerEvent(EventKey.HIDE_FORM_PANEL);
	public static final GradebookEvent ItemCreated					= registerEvent(EventKey.ITEM_CREATED);
	public static final GradebookEvent ItemDeleted					= registerEvent(EventKey.ITEM_DELETED);
	public static final GradebookEvent ItemUpdated					= registerEvent(EventKey.ITEM_UPDATED);
	public static final GradebookEvent LearnerGradeRecordUpdated	= registerEvent(EventKey.LEARNER_GRADE_RECORD_UPDATED); 
	public static final GradebookEvent Load				 			= registerEvent(EventKey.LOAD);
	public static final GradebookEvent LoadItemTreeModel 			= registerEvent(EventKey.LOAD_ITEM_TREE_MODEL);
	public static final GradebookEvent MaskItemTree					= registerEvent(EventKey.MASK_ITEM_TREE);
	public static final GradebookEvent NewCategory					= registerEvent(EventKey.NEW_CATEGORY);
	public static final GradebookEvent NewItem						= registerEvent(EventKey.NEW_ITEM);
	public static final GradebookEvent None							= registerEvent(EventKey.NONE);
	public static final GradebookEvent Notification					= registerEvent(EventKey.NOTIFICATION);
	public static final GradebookEvent Refresh 						= registerEvent(EventKey.REFESH);
	public static final GradebookEvent RefreshCourseGrades 			= registerEvent(EventKey.REFRESH_COURSE_GRADES);
	public static final GradebookEvent RevertItem					= registerEvent(EventKey.REVERT_ITEM);
	public static final GradebookEvent SelectDeleteItem				= registerEvent(EventKey.SELECT_DELETE_ITEM);
	public static final GradebookEvent SelectItem					= registerEvent(EventKey.SELECT_ITEM);
	public static final GradebookEvent SelectLearner				= registerEvent(EventKey.SELECT_LEARNER);
	public static final GradebookEvent ShowColumns					= registerEvent(EventKey.SHOW_COLUMNS);
	public static final GradebookEvent ShowGradeScale				= registerEvent(EventKey.SHOW_GRADE_SCALE);
	public static final GradebookEvent ShowGraderPermissionSettings = registerEvent(EventKey.SHOW_GRADER_PERMISSION_SETTINGS);
	public static final GradebookEvent ShowHistory					= registerEvent(EventKey.SHOW_HISTORY);
	public static final GradebookEvent ShowStatistics				= registerEvent(EventKey.SHOW_STATISTICS);
	public static final GradebookEvent SingleGrade					= registerEvent(EventKey.SINGLE_GRADE);
	public static final GradebookEvent SingleView 					= registerEvent(EventKey.SINGLE_VIEW);
	public static final GradebookEvent StartEditItem				= registerEvent(EventKey.START_EDIT_ITEM);
	public static final GradebookEvent StartExport					= registerEvent(EventKey.START_EXPORT);
	public static final GradebookEvent StartImport					= registerEvent(EventKey.START_IMPORT);
	public static final GradebookEvent Startup 						= registerEvent(EventKey.STARTUP);
	public static final GradebookEvent StopImport					= registerEvent(EventKey.STOP_IMPORT);
	public static final GradebookEvent StartFinalgrade				= registerEvent(EventKey.START_FINAL_GRADE);
	public static final GradebookEvent SwitchEditItem				= registerEvent(EventKey.SWITCH_EDIT_ITEM);
	public static final GradebookEvent SwitchGradebook 				= registerEvent(EventKey.SWITCH_GRADEBOOK);
	public static final GradebookEvent UnmaskItemTree				= registerEvent(EventKey.UNMASK_ITEM_TREE);
	public static final GradebookEvent UpdateLearnerGradeRecord		= registerEvent(EventKey.UPDATE_LEARNER_GRADE_RECORD);
	public static final GradebookEvent UpdateItem					= registerEvent(EventKey.UPDATE_ITEM);
	public static final GradebookEvent UserChange 					= registerEvent(EventKey.USER_CHANGE);
	
		
}
