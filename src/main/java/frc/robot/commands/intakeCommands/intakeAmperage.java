package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Conditions;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;

public class intakeAmperage extends Command {
    private final intakeRollerSubsystem m_IntakeRollerSubsystem;
    private final Conditions m_Conditions;
    private final Timer intakeTimer = new Timer();
    private boolean commandFinsihed = false;
    public intakeAmperage(intakeRollerSubsystem m_IntakeRollerSubsystem, Conditions m_Conditions){
        this.m_IntakeRollerSubsystem = m_IntakeRollerSubsystem;
        this.m_Conditions = m_Conditions;
        commandFinsihed = false;
        addRequirements(m_IntakeRollerSubsystem);
    }
    public void initialize(){
        intakeTimer.start();
    }
    public boolean isFinished(){
        if (m_IntakeRollerSubsystem.checkAmperage() && intakeTimer.get() > .5){
            intakeTimer.stop();
            intakeTimer.reset();
            m_Conditions.isCycle = true;
            commandFinsihed = true;
        }
        return commandFinsihed;
    }
}
