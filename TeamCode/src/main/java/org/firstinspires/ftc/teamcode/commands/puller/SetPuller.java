package org.firstinspires.ftc.teamcode.commands.puller;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.BranchPullerSubsystem;

public class SetPuller extends CommandBase{
	private final double position;
	BranchPullerSubsystem pullerSubsystem;

	public SetPuller(BranchPullerSubsystem pullerSubsystem, double position) {
		this.pullerSubsystem = pullerSubsystem;
		this.position = position;
	}

	@Override
	public void execute() {
		pullerSubsystem.setBranch(position);
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
