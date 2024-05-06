package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DoorSubsystem extends SubsystemBase {
	HardwareMap hMap;
	ServoEx door;

	public DoorSubsystem(HardwareMap hMap) {
		this.hMap = hMap;
		door = new SimpleServo(hMap, "door", 0, 180);
		door.turnToAngle(90);
	}

	public void openDoor() {
		door.turnToAngle(180);
	}

	public void closeDoor() {
		door.turnToAngle(90);
	}

}
