/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.drivetrain;

public class Robot extends TimedRobot {
  public static drivetrain dt;
  public static OI oi;

  @Override
  public void robotInit() {
   dt = new drivetrain();
   oi = new OI();

   // Initialize all motor controllers and joysticks here
   RobotMap.portTalon = new TalonSRX(0);
   RobotMap.starboardTalon = new TalonSRX(1);
   RobotMap.portVictor = new VictorSPX(0);
   RobotMap.starboardVictor = new VictorSPX(1);

   // Set Victors to follower mode, following corresponding Talons
   RobotMap.portVictor.follow(RobotMap.portTalon);
   RobotMap.starboardVictor.follow(RobotMap.starboardTalon);

  }

  
  @Override
  public void robotPeriodic() {
    double currx = oi.getDriverRightStickX();
    double curry = oi.getDriverRightStickY();

    RobotMap.portTalon.set(ControlMode.PercentOutput, 
      currx + curry);
    RobotMap.starboardTalon.set(ControlMode.PercentOutput,  
      currx - curry);
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
   
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    
    RobotMap.portTalon.set(ControlMode.PercentOutput, 0.5); // Set portside to half speed
    RobotMap.starboardTalon.set(ControlMode.PercentOutput, -0.5); // Set starboard side to negative half speed, to ensure both sides move in the same direction
    
  }

  @Override
  public void teleopInit() {
  
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
