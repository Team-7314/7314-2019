

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class RobotMap {

  public static final int LEFT_FRONT_MOTOR = 0;
  public static final int LEFT_BACK_MOTOR = 0;
  public static final int RIGHT_FRONT_MOTOR = 1;
  public static final int RIGHT_BACK_MOTOR = 1;

  // Motor controllers should be public for use in multiple files and classes
  public static TalonSRX portTalon; // Port drive TalonSRX
  public static TalonSRX starboardTalon; // Starboard drive TalonSRX
  public static VictorSPX portVictor; // Port drive VictorSPX
  public static VictorSPX starboardVictor; // Starboard drive VictorSPX

}