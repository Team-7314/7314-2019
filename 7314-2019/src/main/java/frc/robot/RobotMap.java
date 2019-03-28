

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

public class RobotMap {

  //instantiate joysticks
  public static Joystick driverStick;
  public static int driverStickPort = 0;

  public static Joystick subStick;
  public static int subsystemStickPort = 1;

  public static final int LEFT_FRONT_MOTOR = 0; //talon
  public static final int LEFT_BACK_MOTOR = 0; //victor
  public static final int RIGHT_FRONT_MOTOR = 1; //talon
  public static final int RIGHT_BACK_MOTOR = 1; //victor
  public static final int RAMP_MOTOR = 2;
  public static final int ARM_MOTOR = 3;

  // Motor controllers should be public for use in multiple files and classes
  public static TalonSRX portTalon; // Port drive TalonSRX
  public static TalonSRX starboardTalon; // Starboard drive TalonSRX
  public static VictorSPX portVictor; // Port drive VictorSPX
  public static VictorSPX starboardVictor; // Starboard drive VictorSPX
  public static VictorSPX rampVictor; // ramp VictorSPX
  public static VictorSPX armVictor; // arm VictorSPX
  
  //digital IO 
  public static DigitalInput dio0;
  public static DigitalInput dio1;
  
}