/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team888.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    protected Joystick driveStick;
    protected Joystick gamepad;


    public OI() {

        // Instantiates and declares the joystick objects
        driveStick = new Joystick(RobotMap.JOYSTICK);
        gamepad = new Joystick(RobotMap.GAMEPAD_PORT);

    }

    /**
     * @param Axis array value
     * @return Axis value between -1 and 1 for drive joystick
     */
    public double getDriveStickXAxis() {
        return driveStick.getX();
    }

        /**
     * @param Axis array value
     * @return Axis value between -1 and 1 for drive joystick
     */
    public double getDriveStickYAxis() {
        return driveStick.getY();
    }

    /**
     * @param Axis array value
     * @return Axis value between -1 and 1 for drive joystick
     */
    public double getDriveStickZAxis() {
        return driveStick.getZ();
    }

    /**
     * @param Button array value
     * @return Button value (true if pressed) from the gamepad joystick
     */
    public boolean getGamepadButton(int button) {
        return gamepad.getRawButton(button);
    }

    /**
     * @param Axis array value
     * @return Axis value between -1 and 1 for drive joystick
     */
    public double getGamepadAxis(int axis) {
        return gamepad.getRawAxis(axis);
    }

    /**
     * Get's the value of the gamepad D-Pad.
     * @return The D-Pad value as an angle with up being zero.
     */
    public int getGamepadDPad() {
        return gamepad.getPOV();
    }

}
