package org.usfirst.frc.team888.robot;                //kidnap all the robot code

import javax.lang.model.util.ElementScanner6;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Spark;

public class GangstaGerty {  
    protected OI oi;

    protected Spark m_wm;

   protected boolean gangsta;

    public GangstaGerty(OI oi) {
        this.oi = oi;

        gangsta = false;

        m_wm = new Spark(RobotMap.UNCLOGGER_SPARK);
    }
    public void unclogTeleopPeriodic() {
        // if (oi.getGamepadButton(RobotMap.Y_BUTTON))
        // {
        //     gangsta = (gangsta) ? false : true;
        // }

        // if (gangsta)
        // {
        //     m_wm.set(-1);
        // }
        // else
        // {
        //     m_wm.set(0);
        // }

        //m_wm.set(-1);
        
        if (oi.getGamepadButton(RobotMap.B_BUTTON)) {
            m_wm.set(1);
            SmartDashboard.putString("GangstaGerty", "Clockwise (away from shooter)");
        }
        else if (oi.getGamepadButton(RobotMap.Y_BUTTON)) {
            m_wm.set(-1);
            SmartDashboard.putString("GangstaGerty", "Counter-clockwise (towards shooter)");
        }
        else {
            m_wm.set(0);
            SmartDashboard.putString("GangstaGerty", "Idle");
        }
    }
}


