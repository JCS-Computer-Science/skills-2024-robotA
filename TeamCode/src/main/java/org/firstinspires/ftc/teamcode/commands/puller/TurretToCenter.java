package org.firstinspires.ftc.teamcode.commands.puller;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.BranchPullerSubsystem;

public class TurretToCenter extends CommandBase {
	private final BranchPullerSubsystem pullerSubsystem;

	/**
	 * Command to move the turret to the left
	 * @param pullerSubsystem The puller subsystem
	 */
	public TurretToCenter(BranchPullerSubsystem pullerSubsystem) {
		this.pullerSubsystem = pullerSubsystem;
		addRequirements(pullerSubsystem);
	}

	@Override
	public void execute() {
		if(pullerSubsystem.clockwisePassingCenter){
			pullerSubsystem.turnTurret(1);
		}else{
			pullerSubsystem.turnTurret(-1);
		}
	}

	@Override
	public boolean isFinished() {
		return !pullerSubsystem.isCentered();
	}

	@Override
	public void end(boolean interrupted) {
		pullerSubsystem.turnTurret(0);
	}
}
