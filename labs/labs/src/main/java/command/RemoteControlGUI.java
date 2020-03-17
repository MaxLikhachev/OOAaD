package command;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoteControlGUI extends JFrame {

	private static final long serialVersionUID = -898242245822955215L;

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

	   	Container container = this.getContentPane();
		container.setLayout(new GridLayout(0, 2, 5, 5) );

		JPanel gridLight = new JPanel();
		gridLight.setLayout(new BoxLayout(gridLight, BoxLayout.X_AXIS));

		radioLightOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LightOnCommand(light).execute();
				statusBar.setText(light.toString());
			}
		});

		radioLightOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LightOffCommand(light).execute();
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
				new StereoOnWithCDCommand(stereo).execute();
				statusBar.setText(stereo.toString());
			}
		});
		radioStereoOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StereoOffCommand(stereo).execute();
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
				new GarageDoorOpenCommand(garageDoor).execute();
				statusBar.setText(garageDoor.toString());
			}
		});

		radioGarageDoorClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GarageDoorCloseCommand(garageDoor).execute();
				statusBar.setText(garageDoor.toString());
			}
		});

		container.add(labelGarageDoor);
	    ButtonGroup groupGarageDoor = new ButtonGroup();
	    groupGarageDoor.add(radioGarageDoorOpen);
	    groupGarageDoor.add(radioGarageDoorClose);
	    gridGarageDoor.add(radioGarageDoorOpen);
	    radioGarageDoorClose.setSelected(true);
		gridGarageDoor.add(radioGarageDoorClose);
		
		container.add(gridGarageDoor);



		JPanel gridCeilingFan = new JPanel();
		gridCeilingFan.setLayout(new BoxLayout(gridCeilingFan, BoxLayout.X_AXIS));


		radioCeilingFanHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CeilingFanHighCommand(ceilingFan).execute();
				statusBar.setText(ceilingFan.toString());
			}
		});

		radioCeilingFanMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CeilingFanMediumCommand(ceilingFan).execute();
				statusBar.setText(ceilingFan.toString());
			}
		});

		radioCeilingFanLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CeilingFanLowCommand(ceilingFan).execute();
				statusBar.setText(ceilingFan.toString());
			}
		});

		radioCeilingFanOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CeilingFanOffCommand(ceilingFan).execute();
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
		gridCeilingFan.add(radioCeilingFanMedium);
		gridCeilingFan.add(radioCeilingFanLow);
		gridCeilingFan.add(radioCeilingFanOff);

		container.add(gridCeilingFan);

		JPanel gridStatusBar = new JPanel();
		gridStatusBar.setLayout(new BoxLayout(gridStatusBar, BoxLayout.X_AXIS));
		gridStatusBar.add(statusTitle);
		gridStatusBar.add(statusBar);

		container.add(gridStatusBar);
	}
}