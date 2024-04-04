package frc.robot.subsystems.shooterSystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class shooterArmSubsystem extends SubsystemBase {
    private final CANSparkMax armMotor = new CANSparkMax(12, MotorType.kBrushless);
    private final RelativeEncoder m_RelativeEncoder = armMotor.getEncoder();
    private final SparkPIDController m_pidController = armMotor.getPIDController();
    // private final DutyCycle absoluteShooterEncoder = new DutyCycle(new DigitalInput(19));
    // private final PIDController m_ControllerArm = new PIDController(0.3000,0.00005,0.0008);
    private double desiredPosition  = 0; // 0.342916
    public shooterArmSubsystem(){
        //-4.499995231628418
        m_RelativeEncoder.setPosition(0);
        m_pidController.setP(0.1000);
        m_pidController.setI(0);
        m_pidController.setD(0);

    }
    public void positionArmShooter(double desiredPosition){
        m_pidController.setReference(desiredPosition, ControlType.kPosition);
        //  this.desiredPosition = desiredPosition;
    }
    // @Override
    // public void periodic() {
        // SmartDashboard.putNumber("armPosition", m_RelativeEncoder.getPosition());
        // double voltage = m_ControllerArm.calculate(absoluteShooterEncoder.getOutput()*(2*Math.PI), desiredPosition);
        // armMotor.set(voltage);
        // SmartDashboard.putNumber("shooterArmPosition", m_RelativeEncoder.getPosition());
    // }
}
