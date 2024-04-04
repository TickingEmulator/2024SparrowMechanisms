package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Conditions;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;
import frc.robot.subsystems.shooterSystems.shooterRollersSubsystem;

public class shoot extends Command{
    private final shooterRollersSubsystem m_ShooterRollersSubsystem;
    private final intakeRollerSubsystem m_IntakeRollerSubsystem;
    private final Conditions m_Conditions;
    private final Timer shooterTimer = new Timer();
    public shoot(shooterRollersSubsystem m_ShooterRollersSubsystem, Conditions m_Conditions, intakeRollerSubsystem m_IntakeRollerSubsystem){
        this.m_ShooterRollersSubsystem = m_ShooterRollersSubsystem;
        this.m_IntakeRollerSubsystem = m_IntakeRollerSubsystem;
        this.m_Conditions = m_Conditions;
        addRequirements(m_ShooterRollersSubsystem);
    }
    public void initialize(){
        shooterTimer.start();
        m_ShooterRollersSubsystem.indexMotors(true);
        m_IntakeRollerSubsystem.intakeRollers(-1, true);
        
    }
    public boolean isFinished(){
        if (shooterTimer.get() > 1){
            shooterTimer.stop();
            shooterTimer.reset();
            m_ShooterRollersSubsystem.indexMotors(false);
            m_IntakeRollerSubsystem.intakeRollers(0, false);
            m_ShooterRollersSubsystem.shooterMotors(false);
            m_Conditions.isCycle = false;
        }
        return (shooterTimer.get() > 1);
    }
    
}
