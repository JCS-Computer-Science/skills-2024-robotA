package org.firstinspires.ftc.teamcode.commands.puller;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.BranchPullerSubsystem;

public class TogglePuller extends CommandBase {
	BranchPullerSubsystem pullerSubsystem;


	public TogglePuller(BranchPullerSubsystem pullerSubsystem) {
		this.pullerSubsystem = pullerSubsystem;
	}

	@Override
	public void execute() {
		pullerSubsystem.togglePuller();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
