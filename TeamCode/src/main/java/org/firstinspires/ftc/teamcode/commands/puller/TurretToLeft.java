package org.firstinspires.ftc.teamcode.commands.puller;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.BranchPullerSubsystem;

public class TurretToLeft extends CommandBase {
	private final BranchPullerSubsystem pullerSubsystem;

	/**
	 * Command to move the turret to the left
	 * @param pullerSubsystem The puller subsystem
	 */
	public TurretToLeft(BranchPullerSubsystem pullerSubsystem) {
		this.pullerSubsystem = pullerSubsystem;
		addRequirements(pullerSubsystem);
	}

	@Override
	public void execute() {
		pullerSubsystem.turnTurret(-1);
	}

	@Override
	public boolean isFinished() {
		return pullerSubsystem.isAtRightLimit();
	}

	@Override
	public void end(boolean interrupted) {
		pullerSubsystem.turnTurret(0);
	}
}
