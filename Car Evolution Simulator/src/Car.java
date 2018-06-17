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
	private double bodyheight;
	private double wheel1Radius;
	private double wheel2Radius;
	private double motor1Torque;
	private double motor2Torque;
	private double motor1Speed;
	private double motor2Speed;
	
	public Car(double bodyWidth, double bodyHeight, double wheel1Radius, double wheel2Radius, double motor1Torque, double motor2Torque, double motor1Speed, double motor2Speed){
		this.bodyWidth = bodyWidth;
		this.bodyheight = bodyHeight;
		this.wheel1Radius = wheel1Radius;
		this.wheel2Radius = wheel2Radius;
		this.motor1Torque = motor1Torque;
		this.motor2Torque = motor2Torque;
		this.motor1Speed = motor1Speed;
		this.motor2Speed = motor2Speed;
	}
}
