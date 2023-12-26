package com.todolist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.todolist.dao.DaoFactory;
import com.todolist.dao.NoteDao;
import com.todolist.model.MyNote;
import com.todolist.view.ToDoListViewable;

public class MyController {
	
	ToDoListViewable view;
	List<MyNote> notes;
	List<String> fileList;
	DaoFactory daoFactoryFile;
	NoteDao noteDao;
	
	public MyController(ToDoListViewable view) {
		this.view = view;
		this.daoFactoryFile = DaoFactory.getFileInstance();
		this.noteDao = daoFactoryFile.getNoteDao();	
		this.notes = new ArrayList<MyNote>();
		view.setController(this);
	}

	public void loadAndShowNotesList() throws IOException {
			fileList = noteDao.recupererListeNotes();
			for (String noteName : fileList) {
				notes.add(new MyNote(noteName, ""));
			}
			view.showNotesList(fileList);
	}
	
	public void addNewNote(String noteName, String note) throws IOException {
		notes.add(new MyNote(noteName, note));
		noteDao.sauvegarderNotes(noteName, note);
		loadAndShowNotesList();
		
	}
	
	public String getNoteContent(String noteName) throws IOException {
		String note = noteDao.RecupererNote(noteName);
		return note;
	}
	
}
