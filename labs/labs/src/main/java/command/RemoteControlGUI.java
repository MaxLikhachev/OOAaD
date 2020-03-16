package command;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoteControlGUI extends JFrame {

	private static final long serialVersionUID = -898242245822955215L;

	private Light light = new Light("");
	private Stereo stereo = new Stereo("");

	private JLabel labelLight = new JLabel("Light");
	private JRadioButton radioLightOn = new JRadioButton("On");
	private JRadioButton radioLightOff = new JRadioButton("Off");

	private JLabel labelStereo = new JLabel("Stereo");
	private JRadioButton radioStereoOn = new JRadioButton("On");
	private JRadioButton radioStereoOff = new JRadioButton("Off");

	private JLabel labelGarageDoor = new JLabel("Garage door");
	private JRadioButton radioGarageDoorOpen = new JRadioButton("Open");
	private JRadioButton radioGarageDoorClose = new JRadioButton("Close");

	private JLabel labelCeilingFan = new JLabel("Ceiling fan");
	private JRadioButton radioCeilingFanHigh = new JRadioButton("High");
	private JRadioButton radioCeilingFanMedium = new JRadioButton("Medium");
	private JRadioButton radioCeilingFanLow = new JRadioButton("Low");
	private JRadioButton radioCeilingFanOff = new JRadioButton("Off");
	
	public RemoteControlGUI() {
	    super("Remote control");
	    this.setBounds(100,100,320,320);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	   	Container container = this.getContentPane();
		container.setLayout(new GridLayout(0, 2, 5, 0) );
		
		JPanel gridLight = new JPanel();
		gridLight.setLayout(new BoxLayout(gridLight, BoxLayout.X_AXIS));

		radioLightOn.addActionListener(new RadioButtonEventListener());
		radioLightOff.addActionListener(new RadioButtonEventListener());
;
		
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

		container.add(labelStereo);
	    ButtonGroup groupStereo = new ButtonGroup();
		groupStereo.add(radioStereoOn);
	
	    groupStereo.add(radioStereoOff);
	    gridStereo.add(radioStereoOn);
	    radioStereoOff.setSelected(true);
		gridStereo.add(radioStereoOff);

		container.add(gridStereo);
		

		JPanel gridGarageDoor = new JPanel();
		gridGarageDoor.setLayout(new BoxLayout(gridGarageDoor, BoxLayout.X_AXIS));

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
	}

	class RadioButtonEventListener implements ActionListener {
		private String message = "Unknown action";
		public void actionPerformed(ActionEvent e) {
			if (radioLightOff.isSelected()) {
				new LightOffCommand(light).execute();
				this.message = light.toString();
			}
			if (radioLightOn.isSelected()) {
				new LightOnCommand(light).execute();
				this.message = light.toString();
			}
			if (radioStereoOff.isSelected()) {
				new StereoOffCommand(stereo).execute();
				this.message = stereo.toString();
			}
			if (radioStereoOn.isSelected()) {
				new StereoOnWithCDCommand(stereo).execute();
				this.message = stereo.toString();
			}
			
			JOptionPane.showMessageDialog(null, this.message, "Output", JOptionPane.PLAIN_MESSAGE);	
		}
	}
}