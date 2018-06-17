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

import java.awt.*;
import javax.swing.*;

public class Main extends SimulationFrame {
	
	public Main() {
		super("Test", 5.0);
	}
	
	public static void main(String[] args) {
		Main simulation = new Main();
		simulation.run();
	}
	
	public Car createCar(){
		//car variable randomizers
		double bodyWidth = (Math.random()*10)+10;
		double bodyHeight = (Math.random()*5)+5;
		double wheel1Radius = (Math.random()*4)+1;
		double wheel2Radius = (Math.random()*4)+1;
		double motor1Torque = (Math.random()*500)+500;
		double motor2Torque = (Math.random()*500)+500;
		double motor1Speed = (Math.random()*40)+10;
		double motor2Speed = (Math.random()*40)+10;
		//creates the car object...
		Car car = new Car(bodyWidth, bodyHeight, wheel1Radius, wheel2Radius, motor1Torque, motor2Torque, motor1Speed, motor2Speed);
		//...then returns it
		return car;
		
	}
	public void createBody(Car car){
		//makes each of the components of the car based on the car object and adds them to the simulation
		SimulationBody wheel1 = new SimulationBody();
		wheel1.addFixture(Geometry.createCircle(car.getWheel1Radius()), 1, 20, .125);
		wheel1.setMass(MassType.NORMAL);
		this.world.addBody(wheel1);
		
		SimulationBody wheel2 = new SimulationBody();
		wheel2.addFixture(Geometry.createCircle(car.getWheel2Radius()), 1, 20, .125);
		wheel2.setMass(MassType.NORMAL);
		wheel2.translate(new Vector2(car.getBodyWidth(), 0));
		this.world.addBody(wheel2);
		
		SimulationBody body = new SimulationBody();
		body.addFixture(Geometry.createPolygon(new Vector2(0, 0), new Vector2(car.getBodyWidth(), 0), new Vector2(car.getBodyWidth(), car.getBodyHeight()), new Vector2(0,car.getBodyHeight())));
		body.setMass(MassType.NORMAL);
		this.world.addBody(body);
		
		WheelJoint joint = new WheelJoint(body, wheel1, new Vector2(0,0), new Vector2(car.getWheel1Radius(),car.getWheel1Radius()));
		joint.setMotorEnabled(true);
		joint.setMotorSpeed(100);
		joint.setMaximumMotorTorque(10);
		joint.setCollisionAllowed(false);
		this.world.addJoint(joint);
		
		WheelJoint joint2 = new WheelJoint(body, wheel2, new Vector2(car.getBodyWidth(), 0), new Vector2(car.getWheel2Radius(), car.getWheel2Radius()));
		joint2.setMotorEnabled(true);
		joint2.setMotorSpeed(10);
		joint2.setMaximumMotorTorque(500);
		joint2.setCollisionAllowed(false);
		this.world.addJoint(joint2);
	}

	@Override
	protected void initializeWorld() {
		//IGNORE... (its a square used for testing)
		/*
		SimulationBody body1 = new SimulationBody();
		body1.addFixture(Geometry.createSquare(10), 1, 20, .25);
		body1.setAngularVelocity(2.5);
		//body1.translate(0, 0);
		body1.setMass(MassType.NORMAL);
		this.world.addBody(body1);
		*/
		//adds the floor
		SimulationBody floor = new SimulationBody();
		floor.addFixture(Geometry.createRectangle(1000.0, 0.5));
		floor.setMass(MassType.INFINITE);
		floor.translate(0, -50);
		this.world.addBody(floor);

		createBody(createCar());
		//sets the worlds gravity to something that I think is closer to earth's gravity
		this.world.setGravity(new Vector2(0, -30));
	}
}
//www.youtube.com/watch?v=ptK9-CNms98