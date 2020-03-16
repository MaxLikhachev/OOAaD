package command;

	/*
	TODO 
    Классы для каждого обработчика событий
    Состояния для каждого прибора
	Механизм "возврат-отмена" - список состояний, подключенных к меню
    */
    

public final class App {
    public static void main(String[] args) {
        RemoteControlGUI app = new RemoteControlGUI();
		app.pack();
		app.setVisible(true);
        /*RemoteControl remoteControl = new RemoteControl();
        //CeilingFan ceilingFan = new CeilingFan("Living room");
        //CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        //CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
        //CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        //CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        //remoteControl.setCommand(0, ceilingFanLow, ceilingFanOff);
        //remoteControl.setCommand(1, ceilingFanMedium, ceilingFanOff);
        //remoteControl.setCommand(2, ceilingFanHigh, ceilingFanOff);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(2);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        */
    }
}
