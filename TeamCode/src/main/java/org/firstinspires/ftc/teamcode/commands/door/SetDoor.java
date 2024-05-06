package org.firstinspires.ftc.teamcode.commands.door;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.DoorSubsystem;

public class SetDoor extends CommandBase {
	private DoorSubsystem doorSubsystem;
	private boolean open;

	public SetDoor(DoorSubsystem doorSubsystem, boolean open){
		this.doorSubsystem = doorSubsystem;
		this.open = open;
		addRequirements(doorSubsystem);
	}

	@Override
	public void initialize() {
		if(open){
			doorSubsystem.openDoor();
		} else {
			doorSubsystem.closeDoor();
		}
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
