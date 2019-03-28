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

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DiskGrabberArm;
import frc.robot.subsystems.Ramp;
import frc.robot.subsystems.drivetrain;

public class Robot extends TimedRobot {
  public static drivetrain dt;
  public static OI oi;
  public static DiskGrabberArm arm;
  public static Ramp ramp;
  public Boolean rampUp;

  @Override
  public void robotInit() {
    dt = new drivetrain();
    oi = new OI();
    arm = new DiskGrabberArm();
    ramp = new Ramp();
    rampUp = true;

    // Initialize all motor controllers and joysticks here
    RobotMap.driverStick = new Joystick(RobotMap.driverStickPort);
    RobotMap.subStick = new Joystick(RobotMap.subsystemStickPort);

    RobotMap.portTalon = new TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
    RobotMap.starboardTalon = new TalonSRX(RobotMap.RIGHT_FRONT_MOTOR);
    RobotMap.portVictor = new VictorSPX(RobotMap.LEFT_BACK_MOTOR);
    RobotMap.starboardVictor = new VictorSPX(RobotMap.RIGHT_BACK_MOTOR);
    RobotMap.armVictor = new VictorSPX(RobotMap.ARM_MOTOR);
    RobotMap.rampVictor = new VictorSPX(RobotMap.RAMP_MOTOR);

    // Set Victors to follower mode, following corresponding Talons
    RobotMap.portVictor.follow(RobotMap.portTalon);
    RobotMap.starboardVictor.follow(RobotMap.starboardTalon);

    // start cameraserver
    CameraServer.getInstance().startAutomaticCapture();

    //add positive pressure to keep ramp up
    RobotMap.rampVictor.set(ControlMode.PercentOutput, -0.1);

    //instantiate digital input
    RobotMap.dio0 = new DigitalInput(0);
    RobotMap.dio1 = new DigitalInput(1);

  

  }

  
  @Override
  public void robotPeriodic() {
    //drive
    double curry = RobotMap.driverStick.getRawAxis(1);
    double currx = RobotMap.driverStick.getRawAxis(2);

    currx = currx * .75;
    curry = curry * .75;

    //ramp
    double rampAng = RobotMap.driverStick.getPOV(0);
    
    //smartdash
    SmartDashboard.putBoolean("On the Line? ", !RobotMap.dio0.get());
    SmartDashboard.putBoolean("Ramp Up? ", !RobotMap.dio1.get());

    if (Math.abs(curry) < .1) {
      curry = 0;
    }

    if (Math.abs(currx) < .1) {
      currx = 0;
    }

    //if ((RobotMap.dio1.get() == false) && (rampUp == true)) {
      //Robot.ramp.moveRampUp();
    //}

    //button 7 - moves arm down
    //button 8 - moves arm up
    //small joystick - moves ramp
    if (RobotMap.driverStick.getRawButton(7)) {
      Robot.arm.flipArmDown();
    }
    else if (RobotMap.driverStick.getRawButton(8)) {
      Robot.arm.flipArmUp(); 
    }
    else if (rampAng == 0) {
      rampUp = true;
      Robot.ramp.moveRampUp();
    }
    else if (rampAng == 180) {
      rampUp = false;
      Robot.ramp.moveRampDown();
    }
    else {
      Robot.dt.drive(currx + curry, currx - curry);
    }
    
    //
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
    
    //RobotMap.portTalon.set(ControlMode.PercentOutput, 0.5); // Set portside to half speed
    //RobotMap.starboardTalon.set(ControlMode.PercentOutput, -0.5); // Set starboard side to negative half speed, to ensure both sides move in the same direction
    
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
