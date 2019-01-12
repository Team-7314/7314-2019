/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class drivetrain extends Subsystem {

  private VictorSP left1 = new VictorSP(RobotMap.LEFT_FRONT_MOTOR);
  private VictorSP left2 = new VictorSP(RobotMap.LEFT_BACK_MOTOR);
  private VictorSP right1 = new VictorSP(RobotMap.RIGHT_FRONT_MOTOR);
  private VictorSP right2 = new VictorSP(RobotMap.RIGHT_BACK_MOTOR);


public drivetrain(){
  right1.setInverted(true);
  right2.setInverted(true);
}


public void drive(double leftPow, double rightPow){
  left1.set(leftPow);
  left2.set(leftPow);
  right1.set(rightPow);
  right2.set(rightPow);
}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TankDriveCMD());
  }
}
