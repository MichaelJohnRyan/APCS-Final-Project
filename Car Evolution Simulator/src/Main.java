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
import java.util.ArrayList;

import javax.swing.*;

public class Main extends SimulationFrame {
	
	ArrayList<Car> generation = new ArrayList<Car>();
	
	public Main() {
		super("Test", 5.0);
		//fills the generation ArrayList with car objects
		for(int i = 0; i < 100; i++){
			generation.add(createCar());
		}
		/*
		for(int i = 0; i < 100; i++){
			createBody(generation.get(i));
		}*/
		
		createBody(generation.get(0));
	}
	
	public static void main(String[] args) {
		Main simulation = new Main();
		simulation.run();
	}
	
	public static Car createCar(){
		//car variable randomizers
		double bodyWidth = (Math.random()*10)+10;
		double bodyHeight = (Math.random()*5)+5;
		double wheel1Radius = (Math.random()*5)+2;
		double wheel2Radius = (Math.random()*5)+2;
		double motor1Torque = (Math.random()*1000)+500;
		double motor2Torque = (Math.random()*1000)+500;
		double motor1Speed = (Math.random()*50)+75;
		double motor2Speed = (Math.random()*50)+75;
		double wheel1Grip = (Math.random()*20)+10;
		double wheel2Grip = (Math.random()*20)+10;
		//creates the car object...
		Car car = new Car(bodyWidth, bodyHeight, wheel1Radius, wheel2Radius, wheel1Grip, wheel2Grip, motor1Torque, motor2Torque, motor1Speed, motor2Speed);
		//...then returns it
		return car;
		
	}
	public void createBody(Car car){
		//makes each of the components of the car based on the car object and adds them to the simulation
		SimulationBody wheel1 = new SimulationBody();
		wheel1.addFixture(Geometry.createCircle(car.getWheel1Radius()), 1, car.getWheel1Grip(), .125);
		wheel1.setMass(MassType.NORMAL);
		this.world.addBody(wheel1);
		
		SimulationBody wheel2 = new SimulationBody();
		wheel2.addFixture(Geometry.createCircle(car.getWheel2Radius()), 1, car.getWheel2Grip(), .125);
		wheel2.setMass(MassType.NORMAL);
		wheel2.translate(new Vector2(car.getBodyWidth(), 0));
		this.world.addBody(wheel2);
		
		SimulationBody body = new SimulationBody();
		body.addFixture(Geometry.createPolygon(new Vector2(0, 0), new Vector2(car.getBodyWidth(), 0), new Vector2(car.getBodyWidth(), car.getBodyHeight()), new Vector2(0,car.getBodyHeight())));
		body.setMass(MassType.NORMAL);
		this.world.addBody(body);
		
		WheelJoint joint = new WheelJoint(body, wheel1, new Vector2(0,0), new Vector2(car.getWheel1Radius(),car.getWheel1Radius()));
		joint.setMotorEnabled(true);
		joint.setMotorSpeed(car.getMotor1Speed());
		joint.setMaximumMotorTorque(car.getMotor1Torque());
		joint.setCollisionAllowed(false);
		this.world.addJoint(joint);
		
		WheelJoint joint2 = new WheelJoint(body, wheel2, new Vector2(car.getBodyWidth(), 0), new Vector2(car.getWheel2Radius(), car.getWheel2Radius()));
		joint2.setMotorEnabled(true);
		joint2.setMotorSpeed(car.getMotor2Speed());
		joint2.setMaximumMotorTorque(car.getMotor2Torque());
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
		
		//sets the worlds gravity to something that I think is closer to earth's gravity
		this.world.setGravity(new Vector2(0, -30));
	}
}
/*
RESOURCES: 
www.dyn4j.org/
www.youtube.com/watch?v=ptK9-CNms98
*/