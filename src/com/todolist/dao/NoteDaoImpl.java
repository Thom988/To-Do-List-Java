
package com.todolist.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.todolist.model.MyNote;


public class NoteDaoImpl implements NoteDao {
	
	private DaoFactory daoFactory;
	
	public NoteDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;	
	}
	
	public String RecupererNote(String noteName) throws IOException {
		// Fonction a corriger pour récupérer toutes les lignes, non seulement ma première
		daoFactory.getFileConnection(noteName, "Read");
		String chaine = "";
		while (daoFactory.bufferedR.readLine() != null)
		chaine = chaine + daoFactory.bufferedR.readLine();
		daoFactory.closeBuffered();
		return chaine;
		
	}
	
	public void sauvegarderNotes(String noteName, String text) throws IOException {
		daoFactory.getFileConnection(noteName, "Write");
		String chaine = "";
		chaine = String.valueOf(text);
		if (chaine != null) {
			daoFactory.bufferedW.write(chaine,0,chaine.length());
			daoFactory.bufferedW.newLine();
		}
		daoFactory.closeBuffered();
	}
	
	public List<String> recupererListeNotes() throws IOException {
		List<String> notesName = new ArrayList<String>();
		File folder = new File(daoFactory.folderPath);
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				notesName.add(file.getName());
			}
		}
		return notesName;
	}

}