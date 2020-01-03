package org.usfirst.frc.team888.robot;

public class Autonomous {

    protected int state = 0;

    protected double cycles;
    protected DriveTrain driveTrain;
    protected Shooter shooter;

    protected IMU imu;
   
    public Autonomous(DriveTrain driveTrain, Shooter shooter, IMU imu) {

        cycles = 0.0;

        this.driveTrain = driveTrain;
        this.shooter = shooter;

        this.imu = imu;
    }

    public void autoPeriodic() {  
        switch (state) {
            case 0:
                imu.resetHeading();
            case 1:
                if(moveDistance(25.0)) state++;
                break;
            case 2:
                stop(); state++;
            case 3:
                if(shoot()) state++;
                break;
            case 4:
                if(turn(RobotMap.PI_TURN)) state++;
                break;
            default:
        }
    }

    public void stop()
    {
        driveTrain.drive(0,0,0);
    }

    public boolean shoot()
    {
        boolean complete = false;
        if (cycles <= 2)
        {
            shooter.shoot(1);
        }
        else {
            cycles = 0;
            shooter.shoot(0);
            complete = true;
        }

        return complete;
    }

    public boolean moveDistance(double distance) {
        boolean complete = false;
        if (cycles <= ((int) (distance / RobotMap.MAX_SPEED))) {
            driveTrain.drive(0, -0.2, 0);
            cycles += 0.02;
        }
        else {
            driveTrain.drive(0, 0, 0);
            complete = true;
            cycles = 0.0;
        }

        return complete;
    }

    /**
     * Have to robot turn to a point.
     * 
     * @param angle The angle at which the robot should travel.
     * @param speed The speed at which the robot should travel.
     * @return The speed for the left and right sides of the robot.
     */
    public boolean turn(double desiredAngle) {
        double heading = imu.getHeading();
        boolean arrived = false;

        if (Math.abs(RobotMath.modAngleDegrees(desiredAngle - heading)) > RobotMap.ANGLE_TOLERENCE) {

            if (desiredAngle > 180) {
                // ...go the other way around the circle.
                desiredAngle -= 360;
            }

            driveTrain.drive(0, 0 , Math.max(0.1525, Math.min(1.0, (Math.abs(desiredAngle) / 360))));

        }

        else {
            driveTrain.drive(0, 0, 0);
            arrived = true;
        }

        return arrived;
    }

}