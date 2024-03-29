package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;
import frc.robot.subsystems.shooterSystems.shooterRollersSubsystem;

public class indexAmperage extends Command {

    private final shooterRollersSubsystem m_ShooterRollersSubsystem;
    private final intakeRollerSubsystem m_IntakeRollerSubsystem;
    private final Timer indexTimer = new Timer();
    public indexAmperage(shooterRollersSubsystem m_ShooterRollersSubsystem, intakeRollerSubsystem m_IntakeRollerSubsystem){
        this.m_ShooterRollersSubsystem = m_ShooterRollersSubsystem;
        this.m_IntakeRollerSubsystem = m_IntakeRollerSubsystem;
        addRequirements(m_ShooterRollersSubsystem,m_IntakeRollerSubsystem);
    }
    public void initialize(){
        indexTimer.start();
        m_ShooterRollersSubsystem.indexMotors(true);
        m_IntakeRollerSubsystem.intakeRollers(-1, true);
    }
    public boolean isFinished(){
        if (m_ShooterRollersSubsystem.checkAmperage() && indexTimer.get() > .50){
            m_ShooterRollersSubsystem.indexMotors(false);
            m_IntakeRollerSubsystem.intakeRollers(0, false);
            indexTimer.stop();
            indexTimer.reset();
        }
        return (m_ShooterRollersSubsystem.checkAmperage() && indexTimer.get() > .50);
    }
    
}
