package org.usfirst.frc.team888.robot;                //kidnap all the robot code

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.GearTooth;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter {
    protected Spark m_intakeSpark;
    protected PIDController pid;
    protected GearTooth gt;
    protected double prevClicks;
    protected double changeInClicks;
    protected double strength;
    protected double n;
    protected double total;

    protected OI oi;

    public Shooter(OI oi) {
        m_intakeSpark = new Spark(1);

        gt = new GearTooth(RobotMap.SHOOTER_ENCODER);

        this.oi = oi;

        prevClicks = 0;
        n = 0;
        strength = 0;
        total = 0;

        //pid = new PIDController(Kp, 0, 0, source, output, 0.02);
    }
    

    public void shooterTeleopPeriodic() {
        changeInClicks = 1 / gt.getPeriod()/1000;
        total += changeInClicks;

        if (oi.getGamepadButton(RobotMap.GP_R_BUTTON)) {
            shoot(budgetBangBang());
        }
        else {
            shoot(oi.getGamepadAxis(RobotMap.GP_R_TRIGGER) * 0.5);
        }
        
        if (!(n%5 == 0)) {n++;}
        else{n=0; total = 0;}
        SmartDashboard.putNumber("Shooter Speed", changeInClicks);
        SmartDashboard.putNumber("Average Shooter Speed", changeInClicks / n);
    }

    public void shoot(double strength)  {
        m_intakeSpark.set(strength);
    }

    public double budgetBangBang() {
        if (changeInClicks > RobotMap.DESIRED_STRENGTH_UPPER) {
            strength = RobotMap.GAIN * (RobotMap.DESIRED_STRENGTH_UPPER - (changeInClicks ));
        }
        else if (changeInClicks < RobotMap.DESIRED_STRENGTH_UPPER) {
            strength = RobotMap.GAIN * (RobotMap.DESIRED_STRENGTH_UPPER - (changeInClicks));
        }
        SmartDashboard.putNumber("Strength", strength);
        if (strength <= 0){return 0.05;}

        return strength;
    }
}