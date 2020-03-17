package command;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoteControlGUI extends JFrame {

	private static final long serialVersionUID = -898242245822955215L;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Edit");
	private JMenuItem undoMenuItem = new JMenuItem("Undo");
	private JMenuItem redoMenuItem = new JMenuItem("Redo");

	private RemoteControl remoteControl = new RemoteControl();

	private Light light = new Light("");
	private Stereo stereo = new Stereo("");
	private GarageDoor garageDoor = new GarageDoor();
	private CeilingFan ceilingFan = new CeilingFan("");

	private JLabel labelLight = new JLabel("Light");
	private JRadioButton radioLightOn = new JRadioButton("On");
	private JRadioButton radioLightOff = new JRadioButton("Off");

	private JLabel labelStereo = new JLabel("Stereo");
	private JRadioButton radioStereoOnWithCD = new JRadioButton("On with CD");
	private JRadioButton radioStereoOff = new JRadioButton("Off");

	private JLabel labelGarageDoor = new JLabel("Garage door");
	private JRadioButton radioGarageDoorOpen = new JRadioButton("Open");
	private JRadioButton radioGarageDoorClose = new JRadioButton("Close");

	private JLabel labelCeilingFan = new JLabel("Ceiling fan");
	private JRadioButton radioCeilingFanHigh = new JRadioButton("High");
	private JRadioButton radioCeilingFanMedium = new JRadioButton("Medium");
	private JRadioButton radioCeilingFanLow = new JRadioButton("Low");
	private JRadioButton radioCeilingFanOff = new JRadioButton("Off");

	private JLabel statusTitle = new JLabel("Status: ");
	private JLabel statusBar = new JLabel("");
	
	public RemoteControlGUI() {
	    super("Remote control");
	    this.setBounds(100,100,320,320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		renderMenuBar();
		setJMenuBar(menuBar);

	   	Container container = this.getContentPane();
		container.setLayout(new GridLayout(0, 2, 5, 5) );

		JPanel gridLight = new JPanel();
		gridLight.setLayout(new BoxLayout(gridLight, BoxLayout.X_AXIS));

		radioLightOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new LightOnCommand(light));
				updateState();
				statusBar.setText(light.toString());
			}
		});

		radioLightOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new LightOffCommand(light));
				updateState();
				statusBar.setText(light.toString());
			}
		});
		
		container.add(labelLight);
	    ButtonGroup groupLight = new ButtonGroup();
		groupLight.add(radioLightOn);
	    groupLight.add(radioLightOff);
	    gridLight.add(radioLightOn);
		radioLightOff.setSelected(true);
		gridLight.add(radioLightOff);

		container.add(gridLight);


		
		JPanel gridStereo = new JPanel();
		gridStereo.setLayout(new BoxLayout(gridStereo, BoxLayout.X_AXIS));

		radioStereoOnWithCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new StereoOnWithCDCommand(stereo));
				updateState();
				statusBar.setText(stereo.toString());
			}
		});
		radioStereoOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new StereoOffCommand(stereo));
				updateState();
				statusBar.setText(stereo.toString());
			}
		});

		container.add(labelStereo);
	    ButtonGroup groupStereo = new ButtonGroup();
		groupStereo.add(radioStereoOnWithCD);
	
	    groupStereo.add(radioStereoOff);
	    gridStereo.add(radioStereoOnWithCD);
		radioStereoOff.setSelected(true);
		gridStereo.add(radioStereoOff);

		container.add(gridStereo);
		


		JPanel gridGarageDoor = new JPanel();
		gridGarageDoor.setLayout(new BoxLayout(gridGarageDoor, BoxLayout.X_AXIS));

		radioGarageDoorOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new GarageDoorOpenCommand(garageDoor));
				updateState();
				statusBar.setText(garageDoor.toString());
			}
		});

		radioGarageDoorClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new GarageDoorCloseCommand(garageDoor));
				updateState();
				statusBar.setText(garageDoor.toString());
			}
		});

		container.add(labelGarageDoor);
	    ButtonGroup groupGarageDoor = new ButtonGroup();
	    groupGarageDoor.add(radioGarageDoorOpen);
	    groupGarageDoor.add(radioGarageDoorClose);
	    gridGarageDoor.add(radioGarageDoorOpen);
		radioGarageDoorClose.setSelected(true);
		radioGarageDoorClose.setEnabled(false);
		gridGarageDoor.add(radioGarageDoorClose);
		
		container.add(gridGarageDoor);



		JPanel gridCeilingFan = new JPanel();
		gridCeilingFan.setLayout(new BoxLayout(gridCeilingFan, BoxLayout.X_AXIS));


		radioCeilingFanHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new CeilingFanHighCommand(ceilingFan));
				updateState();
				statusBar.setText(ceilingFan.toString());
			}
		});

		radioCeilingFanMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new CeilingFanMediumCommand(ceilingFan));
				updateState();
				statusBar.setText(ceilingFan.toString());
			}
		});

		radioCeilingFanLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new CeilingFanLowCommand(ceilingFan));
				updateState();
				statusBar.setText(ceilingFan.toString());
			}
		});

		radioCeilingFanOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.execute(new CeilingFanOffCommand(ceilingFan));
				updateState();
				statusBar.setText(ceilingFan.toString());
			}
		});
		
		container.add(labelCeilingFan);
	    ButtonGroup groupCeilingFan = new ButtonGroup();
		groupCeilingFan.add(radioCeilingFanHigh);
		groupCeilingFan.add(radioCeilingFanMedium);
		groupCeilingFan.add(radioCeilingFanLow);
		groupCeilingFan.add(radioCeilingFanOff);
	    gridCeilingFan.add(radioCeilingFanHigh);
		radioCeilingFanOff.setSelected(true);
		radioCeilingFanOff.setSelected(false);
		gridCeilingFan.add(radioCeilingFanMedium);
		gridCeilingFan.add(radioCeilingFanLow);
		gridCeilingFan.add(radioCeilingFanOff);

		container.add(gridCeilingFan);

		JPanel gridStatusBar = new JPanel();
		gridStatusBar.setLayout(new BoxLayout(gridStatusBar, BoxLayout.X_AXIS));
		gridStatusBar.add(statusTitle);
		gridStatusBar.add(statusBar);

		container.add(gridStatusBar);
		updateState();
	}

	private void renderMenuBar(){
		menuBar.add(initFileMenu());
		menuBar.add(initEditMenu());
	}

	private JMenu initFileMenu(){
		JMenu menu = new JMenu("File");
		JMenuItem menuItem = new JMenuItem("A text-only menu item");
		menu.add(menuItem);
		return menu;
	}

	private JMenu initEditMenu(){
		//undoMenuItem.setEnabled(remoteControl.isPossibleUndo());
		undoMenuItem.setAccelerator(KeyStroke.getKeyStroke("meta Z"));
		undoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remoteControl.undo();
				updateState();
				statusBar.setText("Undo");
			}
		});
		//redoMenuItem.setEnabled(false);
		redoMenuItem.setAccelerator(KeyStroke.getKeyStroke("meta shift Z"));
		redoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redoMenuItem.setEnabled(remoteControl.isPossibleRedo());
				remoteControl.redo();
				updateState();
				statusBar.setText("Redo");
			}
		});

		menu.add(undoMenuItem);
		menu.add(redoMenuItem);
		return menu;
	}

	private void updateState() {

		undoMenuItem.setEnabled(remoteControl.isPossibleUndo());
		redoMenuItem.setEnabled(remoteControl.isPossibleRedo());
		switch(light.state) {
			case Light.ON: {
				radioLightOn.setSelected(true);
				radioLightOn.setEnabled(false);
				radioLightOff.setEnabled(true);
			} break;
            case Light.OFF: {
				radioLightOff.setSelected(true);
				radioLightOff.setEnabled(false);
				radioLightOn.setEnabled(true);
			} break;
		}
		switch(stereo.state) {
			case Stereo.ON: {
				radioStereoOnWithCD.setSelected(true);
				radioStereoOnWithCD.setEnabled(false);
				radioStereoOff.setEnabled(true);
			} break;
            case Stereo.OFF: {
				radioStereoOff.setSelected(true);
				radioStereoOff.setEnabled(false);
				radioStereoOnWithCD.setEnabled(true);
			} break;
		}
		switch(garageDoor.state) {
			case GarageDoor.UP: {
				radioGarageDoorOpen.setSelected(true);
				radioGarageDoorOpen.setEnabled(false);
				radioGarageDoorClose.setEnabled(true);
			} break;
            case GarageDoor.DOWN: {
				radioGarageDoorClose.setSelected(true);
				radioGarageDoorClose.setEnabled(false);
				radioGarageDoorOpen.setEnabled(true);
			} break;
		}
		switch(ceilingFan.getSpeed()) {
			case CeilingFan.HIGH: {
				radioCeilingFanHigh.setSelected(true); 
				radioCeilingFanHigh.setEnabled(false);
				
				radioCeilingFanMedium.setEnabled(true);
				radioCeilingFanLow.setEnabled(true);
				radioCeilingFanOff.setEnabled(true);
			}break;
			case CeilingFan.MEDIUM: {
				radioCeilingFanMedium.setSelected(true); 
				radioCeilingFanMedium.setEnabled(false);

				radioCeilingFanHigh.setEnabled(true);
				radioCeilingFanLow.setEnabled(true);
				radioCeilingFanOff.setEnabled(true);
			}break;
			case CeilingFan.LOW: {
				radioCeilingFanLow.setSelected(true);
				radioCeilingFanLow.setEnabled(false);
				
				radioCeilingFanHigh.setEnabled(true);
				radioCeilingFanMedium.setEnabled(true);
				radioCeilingFanOff.setEnabled(true);
			}break;
			case CeilingFan.OFF: {
				radioCeilingFanOff.setSelected(true);
				radioCeilingFanOff.setEnabled(false);
				
				radioCeilingFanHigh.setEnabled(true);
				radioCeilingFanMedium.setEnabled(true);
				radioCeilingFanLow.setEnabled(true);
			}break;
		}
	}
	
}