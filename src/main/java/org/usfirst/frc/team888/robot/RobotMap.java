package org.usfirst.frc.team888.robot;

public class RobotMap {

    // USB IDs in the DS for the controller.
    public static final int JOYSTICK = 0;
    public static final int GAMEPAD_PORT = 1;

    // Axes values for Joysticks
    public static final int JOYSTICK_X_AXIS = 0;
    public static final int JOYSTICK_Y_AXIS = 1;
    public static final int JOYSTICK_Z_AXIS = 2;

    public static final double JOYSTICK_DEADZONE = 0.5;

    // Button values for gamepad
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    public static final int GP_L_BUTTON = 5;
    public static final int GP_R_BUTTON = 6;

    // Axes values for gamepad
    public static final int GP_L_X_AXIS = 0;
    public static final int GP_L_Y_AXIS = 1;

    public static final int GP_L_TRIGGER = 2;
    public static final int GP_R_TRIGGER = 3;

    public static final int GP_R_X_AXIS = 4;
    public static final int GP_R_Y_AXIS = 5;
    // ID for other motor controllers
    public static final int FRONT_LEFT_MASTER_DT = 22;
    public static final int FRONT_LEFT_SLAVE_DT = 23;
    public static final int FRONT_RIGHT_MASTER_DT = 24;
    public static final int FRONT_RIGHT_SLAVE_DT = 25;
    public static final int REAR_RIGHT_MASTER_DT = 26;
    public static final int REAR_RIGHT_SLAVE_DT = 27;
    public static final int REAR_LEFT_MASTER_DT = 28;
    public static final int REAR_LEFT_SLAVE_DT = 29;
    public static final int TURN_RIGHT = 90;
    public static final int TURN_LEFT = -90;
    public static final int PI_TURN = 180;
    public static final double DESIRED_STRENGTH_UPPER = 0.5;
    public static final double DESIRED_STRENGTH_LOWER = 0.25;
    public static final double GAIN = 2;

    public static final int BUNNY_IDK = 3;
    public static final int UNCLOGGER_SPARK = 2;

    public static final double MAX_SPEED = 7; // feet per second
    public static final double ANGLE_TOLERENCE = 4; //degrees
    //Port for sensors
    public static final int SHOOTER_ENCODER = 9;

    public static final int JETSON_SOCKET = 5555;

}
