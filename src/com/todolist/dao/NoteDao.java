package com.todolist.dao;

import java.io.IOException;
import java.util.List;

import com.todolist.model.MyNote;

public interface NoteDao {
	
	public List<String> recupererListeNotes() throws IOException ;
	
	public String RecupererNote(String noteName) throws IOException;
	
	public void sauvegarderNotes(String noteName, String text) throws IOException;

}
