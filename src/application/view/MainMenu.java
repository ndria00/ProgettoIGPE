package application.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import application.controller.MenuController;
import application.model.Game;

//pannello principale del gioco
public class MainMenu extends JPanel{
	private static final long serialVersionUID = -4538518220054972545L;
	private JLabel gameName;
	private JButton playButton;
	private JButton settingsButton;
	private JButton aboutButton;
	private JButton exitButton;
	private Dimension buttonDim;
	
	public MainMenu() {
		gameName = new JLabel(Game.getInstance().getGameName(), SwingConstants.CENTER);
		playButton = new JButton(ButtonText.PLAY_BUTTON_TEXT);
		settingsButton = new JButton(ButtonText.SETTINGS_BUTTON_TEXT);
		aboutButton = new JButton(ButtonText.ABOUT_BUTTON_TEXT);
		exitButton = new JButton (ButtonText.QUIT_BUTTON_TEXT);
		buttonDim = new Dimension(300, 120);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		playButton.setBackground(Colors.BUTTON_DEFAULT_COLOR);
		settingsButton.setBackground(Colors.BUTTON_DEFAULT_COLOR);
		aboutButton.setBackground(Colors.BUTTON_DEFAULT_COLOR);
		exitButton.setBackground(Colors.BUTTON_DEFAULT_COLOR);
		
		playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		gameName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		playButton.setMaximumSize(buttonDim);
		settingsButton.setMaximumSize(buttonDim);
		aboutButton.setMaximumSize(buttonDim);
		exitButton.setMaximumSize(buttonDim);
		gameName.setMaximumSize(new Dimension(500, 120));
		
		gameName.setFont(GameFonts.GAME_TITLE_FONT);
		playButton.setFont(GameFonts.MAIN_MENU_BUTTONS_FONT);
		settingsButton.setFont(GameFonts.MAIN_MENU_BUTTONS_FONT);
		aboutButton.setFont(GameFonts.MAIN_MENU_BUTTONS_FONT);
		exitButton.setFont(GameFonts.MAIN_MENU_BUTTONS_FONT);
		

		this.add(gameName);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(settingsButton);
		this.add(Box.createVerticalStrut(30));
		this.add(playButton);
		this.add(Box.createVerticalStrut(30));
		this.add(aboutButton);
		this.add(Box.createVerticalStrut(30));
		this.add(exitButton);
		
		this.setBackground(Colors.MAP_COLOR);
		this.setFocusable(true);
		setActionCommands();
	}
	
	public void setActionCommands() {
		playButton.setActionCommand("Play");
		settingsButton.setActionCommand("Options");
		aboutButton.setActionCommand("About");
		exitButton.setActionCommand("Quit");
	}
	
	
	public void setController(MenuController controller) {
		playButton.addActionListener(controller);
		settingsButton.addActionListener(controller);
		aboutButton.addActionListener(controller);
		exitButton.addActionListener(controller);
	}
	
	public JButton getPlayButton() {
		return playButton;
	}
	
	public JButton getSettingsButton() {
		return settingsButton;
	}
	
	public JButton getAboutButton() {
		return aboutButton;
	}
	
	public JButton getExitButton() {
		return exitButton;
	}
	
	
	public void startGame() {
		
	}
}