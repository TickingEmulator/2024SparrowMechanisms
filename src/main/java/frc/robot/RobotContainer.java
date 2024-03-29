// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.intakeCommands.intakeOut;
import frc.robot.commands.shooterCommands.angleShooter;
import frc.robot.commands.shooterCommands.shoot;
import frc.robot.subsystems.intakeSystems.intakeArmSubsystem;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;
import frc.robot.subsystems.shooterSystems.shooterArmSubsystem;
import frc.robot.subsystems.shooterSystems.shooterRollersSubsystem;

public class RobotContainer {
  private final Joystick operatorJoystick = new Joystick(1);
  private final intakeArmSubsystem m_IntakeArmSubsystem = new intakeArmSubsystem();
  private final intakeRollerSubsystem m_IntakeRollerSubsystem = new intakeRollerSubsystem();
  private final shooterArmSubsystem m_ShooterArmSubsystem = new shooterArmSubsystem();
  private final shooterRollersSubsystem m_ShooterRollersSubsystem = new shooterRollersSubsystem();
  private final Conditions m_Conditions = new Conditions();
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(operatorJoystick, 1).whileTrue(new intakeOut(m_IntakeArmSubsystem, m_IntakeRollerSubsystem, m_ShooterArmSubsystem, m_ShooterRollersSubsystem, m_Conditions, true));
    new JoystickButton(operatorJoystick, 1).whileFalse(new intakeOut(m_IntakeArmSubsystem, m_IntakeRollerSubsystem, m_ShooterArmSubsystem, m_ShooterRollersSubsystem, m_Conditions, false));
    new JoystickButton(operatorJoystick, 2).onTrue(new angleShooter(m_ShooterArmSubsystem, m_ShooterRollersSubsystem));
    new JoystickButton(operatorJoystick, 3).onTrue(new shoot(m_ShooterRollersSubsystem, m_Conditions, m_IntakeRollerSubsystem));

  }
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
