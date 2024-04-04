package frc.robot.subsystems.shooterSystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooterRollersSubsystem extends SubsystemBase {
    private final CANSparkMax upwardMotorRight = new CANSparkMax(36, MotorType.kBrushless); 
    private final CANSparkMax upwardMotorRightAbove = new CANSparkMax(10, MotorType.kBrushless);
    private final CANSparkMax upwardMotorLeft = new CANSparkMax(45, MotorType.kBrushless);
    private final CANSparkMax shooterMotorLeft = new CANSparkMax(25, MotorType.kBrushless);
    private final CANSparkMax shooterMotorRight = new CANSparkMax(16, MotorType.kBrushless);
    public void shooterMotors(boolean turnOn){
        if (turnOn){
            shooterMotorLeft.set(1);
            shooterMotorRight.set(-1);
        }else{
            shooterMotorLeft.stopMotor();
            shooterMotorRight.stopMotor();
        }
    }
    public void indexMotors(boolean turnOn){
        if (turnOn){
            upwardMotorRight.set(1);
            upwardMotorRightAbove.set(1);
            upwardMotorLeft.set(-1);
        }else{
            upwardMotorRight.stopMotor();
            upwardMotorRightAbove.stopMotor();
            upwardMotorLeft.stopMotor();
        }
    }
    public boolean checkAmperage(){
        return ((upwardMotorLeft.getOutputCurrent() + upwardMotorRight.getOutputCurrent()) >= 5);
    }
}
