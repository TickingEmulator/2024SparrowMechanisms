// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Timer;



public class Robot extends TimedRobot{
    /**
     * Main robot functions
     */
    //private RobotContainer m_RobotContainer;
    private Command m_autonomousCommand;
    //private Autonomous autonomous = new Autonomous();
    private Command m_autoBuilder;
    private RobotContainer m_RobotContainer = new RobotContainer();
    
    private Timer m_autoDriveTimer = new Timer();
    
    Thread m_visionThread;
    //Drivetrain drivetrain = new Drivetrain();
   // DriveAndOperate driveAndOperate = new DriveAndOperate();
    private double autoV = 2.5; //auto constraints
    private double autoA = 1.25;
    private boolean start = false;
    
    

    

    /**
     * Robot variables
     */
    public String autoSelected;

    @Override
    public void robotInit() {
    
     //m_RobotContainer.setDefaultCommands();
     m_RobotContainer.configureButtonBindings();
     m_RobotContainer.configureBindings();

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic(){
        
    }

    @Override
    public void robotPeriodic() {
        // m_RobotContainer.configureButtonBindings();
        CommandScheduler.getInstance().run();
    // m_RobotContainer.setDefaultCommands();
        
        

    }

    @Override
    public void autonomousInit() {
        m_RobotContainer.driveAutoPath(); 
        
    }

    @Override
    public void autonomousPeriodic() {
        
        //m_RobotContainer.flatStanley();
        
    }

    @Override
    public void teleopInit() {
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
     //m_RobotContainer.setDefaultCommands();
        
        // m_RobotContainer.configureButtonBindings();

         
        //m_RobotContainer.m_ShooterArmSubsystem.resetEncoderPosition();
        
    }

    @Override
    public void teleopPeriodic() {
        
        // driveAndOperate.readDriverController();
        // driveAndOperate.readOperatorController();
        // // driveAndOperate.testJoystickRead();
        // driveAndOperate.driveAndOperate();
        //SmartDashboard.putNumber("xVisions", m_RobotContainer.visionSubsystem.getVisionTags(2)[1]);
        
     m_RobotContainer.configureButtonBindings();
       
        
    }
    

}









//with love, blueGate3