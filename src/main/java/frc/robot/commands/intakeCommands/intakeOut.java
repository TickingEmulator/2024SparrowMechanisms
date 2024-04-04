package frc.robot.commands.intakeCommands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Conditions;
import frc.robot.commands.startCycle;
import frc.robot.subsystems.intakeSystems.intakeArmSubsystem;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;
import frc.robot.subsystems.shooterSystems.shooterArmSubsystem;
import frc.robot.subsystems.shooterSystems.shooterRollersSubsystem;

public class intakeOut extends Command {
    private final intakeArmSubsystem m_IntakeArmSubsystem;
    private final intakeRollerSubsystem m_IntakeRollerSubsystem;
    private final shooterArmSubsystem m_ShooterArmSubsystem;
    private final shooterRollersSubsystem m_ShooterRollersSubsystem;
    private final Conditions m_Conditions;
    private boolean isHolding;
    public intakeOut(intakeArmSubsystem m_IntakeArmSubsystem, intakeRollerSubsystem m_IntakeRollerSubsystem, shooterArmSubsystem m_ShooterArmSubsystem, shooterRollersSubsystem m_ShooterRollersSubsystem, Conditions m_Conditions, boolean isHolding){
        this.m_IntakeArmSubsystem = m_IntakeArmSubsystem;
        this.m_IntakeRollerSubsystem = m_IntakeRollerSubsystem;
        this.m_ShooterArmSubsystem = m_ShooterArmSubsystem;
        this.m_ShooterRollersSubsystem = m_ShooterRollersSubsystem;
        this.m_Conditions = m_Conditions;
        this.isHolding = isHolding;
        addRequirements(m_IntakeArmSubsystem, m_IntakeRollerSubsystem, m_ShooterArmSubsystem, m_ShooterRollersSubsystem);
    }
    public void initialize(){
        if (isHolding && !m_Conditions.isCycle){
            m_IntakeArmSubsystem.setIntakeArmPosition(-9.8);
            m_IntakeRollerSubsystem.intakeRollers(1,true);
            SmartDashboard.putString("triggerOne", "fired");
            new startCycle(m_IntakeArmSubsystem, m_IntakeRollerSubsystem, m_ShooterArmSubsystem, m_ShooterRollersSubsystem, m_Conditions).schedule();
        }else if (!isHolding && !m_Conditions.isCycle){
            m_IntakeArmSubsystem.setIntakeArmPosition(-1);
            m_IntakeRollerSubsystem.intakeRollers(0,false);
        }
    }
    public boolean isFinished(){
        return true;
    }
    
}
