import org.dyn4j.*;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.World;
import org.dyn4j.dynamics.joint.RevoluteJoint;
import org.dyn4j.dynamics.joint.WheelJoint;
import org.dyn4j.geometry.Convex;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.samples.framework.SimulationBody;
import org.dyn4j.samples.framework.SimulationFrame;

public class Car {
	
	private double bodyWidth;
	private double bodyHeight;
	private double wheel1Radius;
	private double wheel2Radius;
	private double motor1Torque;
	private double motor2Torque;
	private double motor1Speed;
	private double motor2Speed;
	private double wheel1Grip;
	private double wheel2Grip;
	
	public Car(double bodyWidth, double bodyHeight, double wheel1Radius, double wheel2Radius, double wheel1Grip, double wheel2Grip, double motor1Torque, double motor2Torque, double motor1Speed, double motor2Speed){
		this.bodyWidth = bodyWidth;
		this.bodyHeight = bodyHeight;
		this.wheel1Radius = wheel1Radius;
		this.wheel2Radius = wheel2Radius;
		this.wheel1Grip = wheel1Grip;
		this.wheel2Grip = wheel2Grip;
		this.motor1Torque = motor1Torque;
		this.motor2Torque = motor2Torque;
		this.motor1Speed = motor1Speed;
		this.motor2Speed = motor2Speed;
	}
	//getters
	public double getBodyWidth(){
		return bodyWidth;
	}
	public double getBodyHeight(){
		return bodyHeight;
	}
	public double getWheel1Radius(){
		return wheel1Radius;
	}
	public double getWheel2Radius(){
		return wheel2Radius;
	}
	public double getWheel1Grip(){
		return wheel1Grip;
	}
	public double getWheel2Grip(){
		return wheel2Grip;
	}
	public double getMotor1Torque(){
		return motor1Torque;
	}
	public double getMotor2Torque(){
		return motor2Torque;
	}
	public double getMotor1Speed(){
		return motor1Speed;
	}
	public double getMotor2Speed(){
		return motor2Speed;
	}
}
