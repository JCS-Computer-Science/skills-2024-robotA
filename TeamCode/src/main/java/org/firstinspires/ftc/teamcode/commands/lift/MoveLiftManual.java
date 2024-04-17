package org.firstinspires.ftc.teamcode.commands.lift;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class MoveLiftManual extends CommandBase {
	private final LiftSubsystem liftSubsystem;
	private final GamepadEx gamepad;
	public MoveLiftManual(LiftSubsystem liftSubsystem, GamepadEx gamepad){
		this.liftSubsystem = liftSubsystem;
		this.gamepad = gamepad;
		addRequirements(liftSubsystem);
	}

	@Override
	public void execute() {
		int targetTicks = (int)Math.round(liftSubsystem.liftMotor.getTargetPosition() + (gamepad.getLeftY() * 10));
		liftSubsystem.setPosition(targetTicks);
	}

}
