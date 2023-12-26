package com.todolist.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.todolist.controller.MyController;

public class MyFrameNote extends JFrame {
	
	private final int width = 350;
	private final int heigh = 600;
	MyController controller;
	JTextArea champDeTexte;
	
	
	public MyFrameNote(MyController controller, String note) {
		this.setTitle("Ma liste à faire");
		this.setSize(this.width, this.heigh);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.controller = controller;
		JPanel buttonPanel = new JPanel();
		JPanel textAreaPanel = new JPanel();
		JButton saveButton = new JButton("Sauvegarder"); 
		JButton cancelButton = new JButton("Annuler"); 
		this.champDeTexte = new JTextArea();
		champDeTexte.setText(note);
		
		textAreaPanel.setLayout(new BorderLayout());
		textAreaPanel.setBackground(Color.WHITE);
		buttonPanel.setBackground(Color.CYAN);
		
		textAreaPanel.add(champDeTexte, BorderLayout.WEST);
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Méthode du bouton de sauvegarde à faire !");
				try {
					promptForNewNote();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("méthode du bouton d'annulation à faire !");
				askExitConfirmation();
			}
		});
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(textAreaPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private void askExitConfirmation() {
		int answer = JOptionPane.showConfirmDialog(null, "Votre liste ne sera pas sauvegarder, êtes vous sûr de vouloir quitter ?", "annulation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (answer == 0) {
			dispose();
		}
	}
	
	private void promptForNewNote() throws IOException {
		String noteName = JOptionPane.showInputDialog("Entrer le nom de votre nouvelle note : ");
		controller.addNewNote(noteName, champDeTexte.getText());
		dispose();
	}
	
}
