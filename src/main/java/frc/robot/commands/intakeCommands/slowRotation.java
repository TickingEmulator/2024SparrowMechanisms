package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intakeSystems.intakeArmSubsystem;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;

public class slowRotation extends Command {
    private final intakeArmSubsystem m_IntakeArmSubsystem;
    private final intakeRollerSubsystem m_IntakeRollerSubsystem;
    private boolean finished = false;
    private final Timer slowRotationTimer = new Timer();
    public slowRotation(intakeArmSubsystem m_IntakeArmSubsystem, intakeRollerSubsystem m_IntakeRollerSubsystem){
        this.m_IntakeArmSubsystem = m_IntakeArmSubsystem;
        this.m_IntakeRollerSubsystem = m_IntakeRollerSubsystem;
        finished = false;
        addRequirements(m_IntakeArmSubsystem, m_IntakeRollerSubsystem);
    }
    public void initialize(){
        slowRotationTimer.start();
        m_IntakeArmSubsystem.setIntakeArmPosition(-1);
        m_IntakeRollerSubsystem.intakeRollers(.13,true); // .10

    }
    public boolean isFinished(){
        if (slowRotationTimer.get() > .5){
            m_IntakeRollerSubsystem.intakeRollers(0,false);
            slowRotationTimer.stop();
            slowRotationTimer.reset();
            finished = true;
        }
        return (finished);
    }
    
}
