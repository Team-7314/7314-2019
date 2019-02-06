/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCMD;

public class drivetrain extends Subsystem {

  //private TalonSRX left1 = new TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
  //private VictorSPX left2 = new VictorSPX(RobotMap.LEFT_BACK_MOTOR);
  //private TalonSRX right1 = new TalonSRX(RobotMap.RIGHT_FRONT_MOTOR);
  //private VictorSPX right2 = new VictorSPX(RobotMap.RIGHT_BACK_MOTOR);


public drivetrain(){
  //right1.setInverted(true);
  //right2.setInverted(true);
}


public static void drive(double leftPow, double rightPow){

  RobotMap.portTalon.set(ControlMode.PercentOutput, leftPow);
  RobotMap.starboardTalon.set(ControlMode.PercentOutput, rightPow);
} 


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCMD());
  }
}
