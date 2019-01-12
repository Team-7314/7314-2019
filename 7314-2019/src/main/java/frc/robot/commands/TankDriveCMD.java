
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDriveCMD extends Command {
  public TankDriveCMD() {
    requires(Robot.dt);

  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.dt.drive(Robot.oi.getDriverRightStickY(), Robot.oi.getDriverLeftStickY());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
