package com.todolist.main;

import java.io.IOException;

import com.todolist.controller.MyController;
import com.todolist.view.MyFrame;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
		MyController controller = new MyController(frame);
		try {
			controller.loadAndShowNotesList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
