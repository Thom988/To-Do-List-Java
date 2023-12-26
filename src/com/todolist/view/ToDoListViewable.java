package com.todolist.view;
import java.util.List;

import com.todolist.controller.MyController;

public interface ToDoListViewable {
	
	public void showNotesList(List<String> notes);
	public void setController(MyController controller);

}
