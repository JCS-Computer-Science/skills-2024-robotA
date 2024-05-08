package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BranchPullerSubsystem extends SubsystemBase {
	TelemetrySubsystem t;
	HardwareMap hMap;
	ServoEx pullerLeft, pullerRight, turret;
	private DigitalChannel leftLimit, rightLimit, centerSwitch;

	public boolean clockwisePassingCenter =true;
	boolean isPulling = false;

	public BranchPullerSubsystem(HardwareMap hMap, TelemetrySubsystem telemetrySubsystem) {
		this.hMap = hMap;
		this.t = telemetrySubsystem;
		pullerLeft = new SimpleServo(hMap, "pullerLeft", 0, 180);
		pullerRight = new SimpleServo(hMap, "pullerRight", 0, 180);
		turret = new SimpleServo(hMap, "turret", 0, 180);

		pullerRight.setInverted(true);
		pullerLeft.setInverted(false);

		turret.setPosition(0.5);

		resetPullers();

		leftLimit = hMap.get(DigitalChannel.class, "leftLimit");
		leftLimit.setMode(DigitalChannel.Mode.INPUT);
		rightLimit = hMap.get(DigitalChannel.class, "rightLimit");
		rightLimit.setMode(DigitalChannel.Mode.INPUT);
		centerSwitch = hMap.get(DigitalChannel.class, "centerSwitch");
		centerSwitch.setMode(DigitalChannel.Mode.INPUT);
	}

	public void setBranch(double position){
		pullerLeft.setPosition(position);
		pullerRight.setPosition(position);
	}

	public void pullBranch(){
		pullerLeft.setPosition(1);
		pullerRight.setPosition(1);
		isPulling = true;
	}

	public void resetPullers(){
		pullerLeft.setPosition(0);
		pullerRight.setPosition(0);
		isPulling = false;
	}

	public void togglePuller(){
		if(!isPulling){
			pullBranch();
		}else{
			resetPullers();
		}
	}

	public void turnTurret(double speed){

		double position = (speed+1)/2;

		if(speed>0){
			if(!leftLimit.getState()){
				position = 0.5;
			}
		}
		else{
			if(!rightLimit.getState()){
				position = 0.5;
			}
		}
		turret.setPosition(position);
	}

	public boolean isCentered(){

		return !centerSwitch.getState();
	}

	public boolean isAtRightLimit(){

		return !rightLimit.getState();
	}

	public boolean isAtLeftLimit(){

		return !leftLimit.getState();
	}

	@Override
	public void periodic() {
		if(centerSwitch.getState()){
			clockwisePassingCenter = turret.getPosition()<0.5;
		}
		t.addLine("\nTurret");
		t.addData("Current Speed", turret.getPosition());
		t.addData("Left Limit", leftLimit.getState());
		t.addData("Center Switch", centerSwitch.getState());
		t.addData("Right Limit", rightLimit.getState());

		t.addData("CW passing C", clockwisePassingCenter);
	}



}
