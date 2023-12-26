package com.todolist.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.todolist.controller.MyController;

public class MyFrame extends JFrame implements ToDoListViewable {

	private static final long serialVersionUID = 1L;
	public String[] notesList = new String[15];
	JList<String> myJList;
	MyController controller;


	public MyFrame() {
		this.setTitle("Ma ToDo List");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(700, 800); 
		this.setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel();
		JPanel panelButton = new JPanel();
		JPanel panelList = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuHelp = new JMenu("Help");
		JButton addButton = new JButton("Ajouter Liste"); 
		JButton modifyButton = new JButton("Modifier Liste");
		JButton deleteButton = new JButton("Supprimer Liste");
		this.myJList = new JList<String>(notesList);
		
		
		//myJList.setVisibleRowCount(0);
		myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myJList.setFont(new Font("comic sans", 1, 16));
		mainPanel.setSize(700, 800);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.CYAN);
		panelButton.setBackground(Color.LIGHT_GRAY);
		panelList.setBackground(Color.WHITE);
		panelList.setLayout(new BorderLayout());
		panelButton.setLayout(new GridLayout(15, 2, 0, 15));
		
		
		//addButton.addActionListener((event) -> new MyFrameList());
		addButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addFrameNote();
			}
		});
		
		//modifyButton.addActionListener((event) -> ......);
		modifyButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modifyNote();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//deleteButton.addActionListener((event) -> ......);
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Méthode du bouton delete à faire !");
			}
			
		});
		
		panelButton.add(addButton);
		panelButton.add(modifyButton);
		panelButton.add(deleteButton);
		panelList.add(myJList, BorderLayout.WEST);
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		mainPanel.add(menuBar, BorderLayout.NORTH);
		mainPanel.add(panelButton, BorderLayout.WEST);
		mainPanel.add(panelList, BorderLayout.CENTER);
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	private void addFrameNote() {
		new MyFrameNote(this.controller, null);
	}
	
	private void modifyNote() throws IOException {
		String noteName = controller.getNoteContent(myJList.getSelectedValue());
		new MyFrameNote(this.controller, noteName);
	}
	
	@Override
	public void showNotesList(List<String> notesName) {
		int i = 0;
		for (String noteName : notesName) {
			notesList[i] = noteName.substring(0, noteName.indexOf("."));
			i++;
		}
		myJList.setListData(notesList);
	}

	@Override
	public void setController(MyController controller) {
		this.controller = controller;
		
	}
	
}
