package org.usfirst.frc.team888.robot;                //kidnap all the robot code

import edu.wpi.first.wpilibj.Spark;

public class Intake {
    protected Spark m_intakeSpark;
    
    protected OI oi;

    public Intake(OI oi) {
        m_intakeSpark = new Spark(0);

        this.oi = oi;
    }
    public void intakeTeleopPeriodic() {
        if (oi.getGamepadButton(RobotMap.GP_L_BUTTON)) {
            m_intakeSpark.set(1);
        }
        else {
        m_intakeSpark.set(-oi.getGamepadAxis(RobotMap.GP_L_TRIGGER));
        }
    }

    //public void intakeTeleopPeriodic() {
       // m_intakeSpark.set(1.0);
    }
