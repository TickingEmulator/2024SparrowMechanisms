package frc.robot.subsystems.intakeSystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intakeRollerSubsystem extends SubsystemBase {
    private final CANSparkMax rightRollerMotor = new CANSparkMax(15, MotorType.kBrushless);
    private final CANSparkMax leftRollerMotor = new CANSparkMax(14, MotorType.kBrushless);
    public void intakeRollers(double speed, boolean turnOn){
        if (turnOn){
            rightRollerMotor.set(speed);
            leftRollerMotor.set(speed);
        }else{
            rightRollerMotor.stopMotor();
            leftRollerMotor.stopMotor();
        }
    }
    public boolean checkAmperage(){ 
        // idea if this doesnt work so i dont forget: read amp on time:
        // as time.get() is small is more you take off the outputcurrent when checking but the greater the timer the less you take off until its stable
        return ((rightRollerMotor.getOutputCurrent() + leftRollerMotor.getOutputCurrent()) >= 20); //really low 20
    }
}
