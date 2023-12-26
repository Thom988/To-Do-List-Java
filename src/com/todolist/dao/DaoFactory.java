package com.todolist.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DaoFactory {
	
	private String url;
    private String username;
    private String password;
    private char fileMode;
    public BufferedReader bufferedR;
    public BufferedWriter bufferedW;
    public String folderPath = "MesNotes\\";
	

	public static DaoFactory getFileInstance() {
		DaoFactory instance = new DaoFactory();
		return instance;
	}
	
	public void getFileConnection(String fileName, String mode) throws IOException {
		fileMode = (mode.toUpperCase()).charAt(0);
		File myFile = new File(fileName);
		if (fileMode == 'R' || fileMode == 'L')
			bufferedR = new BufferedReader(new FileReader(folderPath+myFile+".txt"));
		else if (fileMode == 'W' || fileMode == 'E')
			bufferedW = new BufferedWriter(new FileWriter(folderPath+myFile+".txt"));
	}
	
	public void closeBuffered() throws IOException {
		if (fileMode == 'R' || fileMode == 'L') bufferedR.close();
		else if (fileMode == 'W' || fileMode == 'E') bufferedW.close();
	}
	
	public NoteDao getNoteDao() {
		return new NoteDaoImpl(this);
	}
}
