package org.usfirst.frc.team888.robot;                //kidnap all the robot code

import javax.lang.model.util.ElementScanner6;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Spark;

public class BunnyManip {  
    protected OI oi;

    protected Spark m_wm;

   protected boolean gangsta;

    public BunnyManip(OI oi) {
        this.oi = oi;

        gangsta = false;

        m_wm = new Spark(RobotMap.BUNNY_IDK);
    }
    public void bmTeleopPeriodic() {
        if (oi.getGamepadButton(RobotMap.A_BUTTON)) {
            m_wm.set(1);
        }
        else {
            m_wm.set(0);
        }
    }
}


