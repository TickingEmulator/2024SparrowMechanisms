package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;

public class intakeAmperage extends Command {
    private final intakeRollerSubsystem m_IntakeRollerSubsystem;
    private final Timer intakeTimer = new Timer();
    public intakeAmperage(intakeRollerSubsystem m_IntakeRollerSubsystem){
        this.m_IntakeRollerSubsystem = m_IntakeRollerSubsystem;
        addRequirements(m_IntakeRollerSubsystem);
    }
    public void initialize(){
        intakeTimer.start();
    }
    public boolean isFinished(){
        if (m_IntakeRollerSubsystem.checkAmperage() && intakeTimer.get() > .5){
            intakeTimer.stop();
            intakeTimer.reset();
        }
        return m_IntakeRollerSubsystem.checkAmperage() && intakeTimer.get() > .5;
    }
}
