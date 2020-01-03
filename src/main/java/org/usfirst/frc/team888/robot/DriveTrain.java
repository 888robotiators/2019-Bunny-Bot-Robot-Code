package org.usfirst.frc.team888.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

/*
 * Simplest program to drive a robot with mecanum drive using a single Logitech
 * Extreme 3D Pro joystick and 4 drive motors connected as follows:
 *     - PWM 0 - Connected to front left drive motor
 *     - PWM 1 - Connected to rear left drive motor
 *     - PWM 2 - Connected to front right drive motor
 *     - PWM 3 - Connected to rear right drive motor
 */

public class DriveTrain {
     //Create a robot drive object using PWMs 0, 1, 2 and 3
     protected WPI_TalonSRX m_frontLeft;	
	protected WPI_TalonSRX m_rearLeft;
	protected WPI_TalonSRX m_frontRight;	
     protected WPI_TalonSRX m_rearRight;
     protected WPI_TalonSRX m_frontLeftFollower;	
	protected WPI_TalonSRX m_rearLeftFollower;
	protected WPI_TalonSRX m_frontRightFollower;	
     protected WPI_TalonSRX m_rearRightFollower;
     protected double xThrust;
     protected double yThrust;
     protected double zThrust;
     protected double joystickX;
     protected double joystickY;
     protected double joystickZ;
     
     protected OI oi;

     protected MecanumDrive m_robotDrive;

     public DriveTrain(OI oi) {
          m_frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MASTER_DT);
          m_frontLeftFollower = new WPI_TalonSRX(RobotMap.FRONT_LEFT_SLAVE_DT);	
          
          m_rearLeft = new WPI_TalonSRX(RobotMap.REAR_LEFT_MASTER_DT);
          m_rearLeftFollower = new WPI_TalonSRX(RobotMap.REAR_LEFT_SLAVE_DT);
         
          m_frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MASTER_DT);	
          m_frontRightFollower = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_SLAVE_DT);
          
          m_rearRight = new WPI_TalonSRX(RobotMap.REAR_RIGHT_MASTER_DT);	
          m_rearRightFollower = new WPI_TalonSRX(RobotMap.REAR_RIGHT_SLAVE_DT);
          
          m_frontLeftFollower.follow(m_frontLeft);
          m_rearLeftFollower.follow(m_rearLeft);
          m_frontRightFollower.follow(m_frontRight);
          m_rearRightFollower.follow(m_rearRight);

          m_robotDrive = new MecanumDrive(m_frontLeft, m_rearLeft, m_frontRight, m_rearRight);

          this.oi = oi;

     }

     /**
     
      */
     public void dtTeleopPeriodic() {
          joystickX = oi.getDriveStickXAxis();
          joystickY = oi.getDriveStickYAxis();
          joystickZ = oi.getDriveStickZAxis();

          xThrust = Math.abs(joystickX) <= RobotMap.JOYSTICK_DEADZONE ? 
               0.0 : joystickX * (1/RobotMap.JOYSTICK_DEADZONE);
          yThrust = Math.abs(joystickY) <= RobotMap.JOYSTICK_DEADZONE ? 
               0.0 : joystickY * (1/RobotMap.JOYSTICK_DEADZONE);
          zThrust = Math.abs(joystickZ) <= RobotMap.JOYSTICK_DEADZONE ? 
               0.0 : joystickZ * (1/RobotMap.JOYSTICK_DEADZONE);
          
          drive(xThrust, -yThrust, zThrust);
     }


     public void drive(double speedX, double speedY, double rotationSpeed) {
          m_robotDrive.driveCartesian(speedX, speedY, rotationSpeed);
     }

     public void drivePolar(double magnitude, double angle, double rotationSpeed) {
          m_robotDrive.drivePolar(magnitude, angle, rotationSpeed);
     }
     

}
