package application.view;

import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import application.controller.MenuController;

public class AboutPanel extends JPanel{
	private static final long serialVersionUID = 8667300202908812663L;
	
	private JLabel title;
	private JScrollPane scrollPane;
	private JTextArea gameStory;
	private JButton backToMenuButton;
	
	public AboutPanel() {
		title = new JLabel("A bit of story");
		title.setFont(GameFonts.GAME_TITLE_FONT);
		backToMenuButton = new JButton(ButtonText.BACK_TO_MENU_BUTTON_TEXT);
		backToMenuButton.setBackground(Colors.BUTTON_DEFAULT_COLOR);
		backToMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		try {
			gameStory = new JTextArea(readStory().toString());
		} catch (Exception e) {
			System.out.println("Error while reading game story");
		}
		gameStory.setEditable(false);
		gameStory.setBackground(Colors.MAP_COLOR);
		gameStory.setFont(GameFonts.GAME_STORY_FONT);
		scrollPane = new JScrollPane(gameStory);
		
		scrollPane.setMaximumSize(new Dimension(450, 520));
		backToMenuButton.setMaximumSize(new Dimension(180, 70));
		
		this.setBackground(Colors.WORLD_GROUND);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		this.add(title);
		this.add(Box.createRigidArea(new Dimension(0, 25)));
		this.add(scrollPane);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(backToMenuButton);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
	}
	
	public JButton getBackToMenuButton() {
		return backToMenuButton;
	}
	
	public void setController(MenuController controller) {
		backToMenuButton.addActionListener(controller);
	}
	
	public StringBuilder readStory() throws Exception{
		StringBuilder builder = new StringBuilder();
		
		String myPath = "/application/resources/story/story.txt";
		File file= new File(getClass().getResource(myPath).toURI());
		FileReader reader= new FileReader(file);
				
		BufferedReader in = null;
		try {
			in = new BufferedReader(reader);
			while(in.ready()) {
				String line = in.readLine();
				builder.append(line + System.lineSeparator());
			}
		}
		finally {
			if(in != null)
				in.close();
		}
		return builder;
	}
}