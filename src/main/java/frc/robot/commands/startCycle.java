package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Conditions;
import frc.robot.commands.intakeCommands.intakeAmperage;
import frc.robot.commands.intakeCommands.slowRotation;
import frc.robot.commands.shooterCommands.handOff;
import frc.robot.commands.shooterCommands.indexAmperage;
import frc.robot.subsystems.intakeSystems.intakeArmSubsystem;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;
import frc.robot.subsystems.shooterSystems.shooterArmSubsystem;
import frc.robot.subsystems.shooterSystems.shooterRollersSubsystem;

public class startCycle extends SequentialCommandGroup {
    private final intakeArmSubsystem m_IntakeArmSubsystem;
    private final intakeRollerSubsystem m_IntakeRollerSubsystem;
    private final shooterArmSubsystem m_ShooterArmSubsystem;
    private final shooterRollersSubsystem m_ShooterRollersSubsystem;
    private final Conditions m_Conditions;
    public startCycle(intakeArmSubsystem m_IntakeArmSubsystem, intakeRollerSubsystem m_IntakeRollerSubsystem, shooterArmSubsystem m_ShooterArmSubsystem, shooterRollersSubsystem m_ShooterRollersSubsystem, Conditions m_Conditions){
        this.m_IntakeArmSubsystem = m_IntakeArmSubsystem;
        this.m_IntakeRollerSubsystem = m_IntakeRollerSubsystem;
        this.m_ShooterArmSubsystem = m_ShooterArmSubsystem;
        this.m_ShooterRollersSubsystem = m_ShooterRollersSubsystem;
        this.m_Conditions = m_Conditions;
        addCommands(
            new SequentialCommandGroup(
                new intakeAmperage(m_IntakeRollerSubsystem, m_Conditions),
                new handOff(m_ShooterArmSubsystem),
                new slowRotation(m_IntakeArmSubsystem,m_IntakeRollerSubsystem),
                new indexAmperage(m_ShooterRollersSubsystem, m_IntakeRollerSubsystem)
            )
        );
    }
}
