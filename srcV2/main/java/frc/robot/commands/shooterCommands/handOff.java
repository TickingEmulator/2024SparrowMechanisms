package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooterSystems.shooterArmSubsystem;

public class handOff extends Command{
    private final shooterArmSubsystem m_ShooterArmSubsystem;
    public handOff(shooterArmSubsystem m_ShooterArmSubsystem){
        this.m_ShooterArmSubsystem = m_ShooterArmSubsystem;
        addRequirements(m_ShooterArmSubsystem);
    }
    public void initialize(){
        m_ShooterArmSubsystem.positionArmShooter(4.499995231628418);
    }
    public boolean isFinished(){
        return true;
    }
    
}
