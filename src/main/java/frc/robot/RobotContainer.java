package frc.robot;
// done at 6:15

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.intakeCommands.intakeOut;
import frc.robot.commands.shooterCommands.angleShooter;
import frc.robot.commands.shooterCommands.shoot;
import frc.robot.subsystems.intakeSystems.intakeArmSubsystem;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;
import frc.robot.subsystems.shooterSystems.shooterArmSubsystem;
import frc.robot.subsystems.shooterSystems.shooterRollersSubsystem;

public class RobotContainer {
    //public final  AHRS navx = new AHRS();
    
    //public final Scheduler scheduler = new Scheduler();
    /**
     * ---------------------------------------------------------------------------------------
     * Subsystems
     * ---------------------------------------------------------------------------------------
     */
   // public final Drivetrain drivetrain = new Drivetrain();
    public final Drivetrain drivetrain = new Drivetrain();
    public DigitalInput m_condeDetector = new DigitalInput(9);
    public Joystick driveJoystick = new Joystick(0);
    private final Joystick operatorJoystick = new Joystick(1);
    private final intakeArmSubsystem m_IntakeArmSubsystem = new intakeArmSubsystem();
    private final intakeRollerSubsystem m_IntakeRollerSubsystem = new intakeRollerSubsystem();
    private final shooterArmSubsystem m_ShooterArmSubsystem = new shooterArmSubsystem();
    private final shooterRollersSubsystem m_ShooterRollersSubsystem = new shooterRollersSubsystem();
    private final Conditions m_Conditions = new Conditions();
    
   
    public RobotContainer () {
        configureButtonBindings();
        configureBindings();
       
        NamedCommands.registerCommand("ResetNavxFieldHeading", drivetrain.resetNavxMark(0));//if this offsets by 90, like forward is left or right, go into drivetrain and delete the part about initial angle, that may be the issue. 
        var alliance = DriverStation.getAlliance();
                    
                        
                    

        

    }
  public void configureBindings() {
    new JoystickButton(operatorJoystick, 1).onTrue(new intakeOut(m_IntakeArmSubsystem, m_IntakeRollerSubsystem, m_ShooterArmSubsystem, m_ShooterRollersSubsystem, m_Conditions, true)); 
    new JoystickButton(operatorJoystick, 4).onFalse(new intakeOut(m_IntakeArmSubsystem, m_IntakeRollerSubsystem, m_ShooterArmSubsystem, m_ShooterRollersSubsystem, m_Conditions, false));
    new JoystickButton(operatorJoystick, 2).onTrue(new angleShooter(m_ShooterArmSubsystem, m_ShooterRollersSubsystem));
    new JoystickButton(operatorJoystick, 3).onTrue(new shoot(m_ShooterRollersSubsystem, m_Conditions, m_IntakeRollerSubsystem));

  }
    public void configureButtonBindings () { 
        drivetrain.drive(driveJoystick.getRawAxis(1), -driveJoystick.getRawAxis(0), -driveJoystick.getRawAxis(4), true, false);
        if (driveJoystick.getRawButton(4) == false) {
            drivetrain.drive(-driveJoystick.getRawAxis(1), driveJoystick.getRawAxis(0), driveJoystick.getRawAxis(4), true, false);
        } else {           
        
        }



        
        var alliance = DriverStation.getAlliance();
        

        }


    // Set default/passive commands for each subsystem
    public void setDefaultCommands () {
        
        //drivetrain.setDefaultCommand(new Drive(drivetrain, driveJoystick));
        //ShooterSubsystem.setDefaultCommand(new Shoot(m_shooterSubsystem, 0));

    }

     public Command driveAutoPath() {
        
     return new PathPlannerAuto("autoOne");

     }
}