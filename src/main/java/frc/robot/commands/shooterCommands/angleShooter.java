package frc.robot.commands.shooterCommands;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.shooterSystems.shooterArmSubsystem;
import frc.robot.subsystems.shooterSystems.shooterRollersSubsystem;

public class angleShooter extends Command {
    private final shooterArmSubsystem m_ShooterArmSubsystem;
    private final shooterRollersSubsystem m_ShooterRollersSubsystem;
    public angleShooter(shooterArmSubsystem m_ShooterArmSubsystem, shooterRollersSubsystem m_ShooterRollersSubsystem){
        this.m_ShooterArmSubsystem = m_ShooterArmSubsystem;
        this.m_ShooterRollersSubsystem = m_ShooterRollersSubsystem;
        addRequirements(m_ShooterArmSubsystem,m_ShooterRollersSubsystem);
    }
    public void initialize(){
        m_ShooterArmSubsystem.positionArmShooter(2); // abs: 0.662719615161288
        m_ShooterRollersSubsystem.shooterMotors(false); // supposed be on
    }
    public boolean isFinished(){
        return true;
    }
}
