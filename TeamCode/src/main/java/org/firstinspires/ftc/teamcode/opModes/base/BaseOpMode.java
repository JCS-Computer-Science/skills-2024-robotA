package org.firstinspires.ftc.teamcode.opModes.base;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.BranchPullerSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DoorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.TelemetrySubsystem;

/**
 * Generic OpMode base that can be extended by {@link TeleOpMode} and {@link AutoOpMode}.
 *
 * @author Eric Singer
 *
 * @see DriveSubsystem

 * @see TelemetrySubsystem
 * @see LiftSubsystem
 */
public abstract class BaseOpMode extends CommandOpMode {
	protected DriveSubsystem driveSubsystem, d;

	protected TelemetrySubsystem telemetrySubsystem, t;
	protected LiftSubsystem liftSubsystem, lift;
	protected BranchPullerSubsystem branchPullerSubsystem;

	protected DoorSubsystem doorSubsystem;
	protected HardwareMap hMap;

	public abstract void setup();

	@Override
	public void initialize() {
		hMap = hardwareMap;

		//      Subsystems
		telemetrySubsystem = new TelemetrySubsystem(telemetry);
		driveSubsystem = new DriveSubsystem(hMap, telemetrySubsystem);

		liftSubsystem = new LiftSubsystem(hMap, telemetrySubsystem);
		branchPullerSubsystem = new BranchPullerSubsystem(hMap, telemetrySubsystem);

		doorSubsystem = new DoorSubsystem(hMap);


		// 	Aliases
		d = driveSubsystem;

		t = telemetrySubsystem;
		lift = liftSubsystem;
	}
}
