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
	
	public void createCar(){
		
		double width = (Math.random()*10)+10;
		double height = (Math.random()*5)+5;
		double wheel1Radius = (Math.random()*6) +1;
		double wheel2Radius = (Math.random()*6) +1;
		
		SimulationBody wheel1 = new SimulationBody();
		wheel1.addFixture(Geometry.createCircle(wheel1Radius), 1, 20, .125);
		wheel1.setMass(MassType.NORMAL);
		this.world.addBody(wheel1);
		
		SimulationBody wheel2 = new SimulationBody();
		wheel2.addFixture(Geometry.createCircle(wheel2Radius), 1, 20, .125);
		wheel2.setMass(MassType.NORMAL);
		wheel2.translate(new Vector2(width, 0));
		this.world.addBody(wheel2);
		
		SimulationBody body = new SimulationBody();
		body.addFixture(Geometry.createPolygon(new Vector2(0, 0), new Vector2(width, 0), new Vector2(width, height), new Vector2(0,height)));
		body.setMass(MassType.NORMAL);
		this.world.addBody(body);
		
		WheelJoint joint = new WheelJoint(body, wheel1, new Vector2(0,0), new Vector2(wheel1Radius,wheel1Radius));
		joint.setMotorEnabled(true);
		joint.setMotorSpeed(10);
		joint.setMaximumMotorTorque(500);
		joint.setCollisionAllowed(false);
		this.world.addJoint(joint);
		
		WheelJoint joint2 = new WheelJoint(body, wheel2, new Vector2(width, 0), new Vector2(wheel2Radius, wheel2Radius));
		joint2.setMotorEnabled(true);
		joint2.setMotorSpeed(10);
		joint2.setMaximumMotorTorque(500);
		joint2.setCollisionAllowed(false);
		this.world.addJoint(joint2);
		
	}

	@Override
	protected void initializeWorld() {
		/*
		SimulationBody body1 = new SimulationBody();
		body1.addFixture(Geometry.createSquare(10), 1, 20, .25);
		body1.setAngularVelocity(2.5);
		//body1.translate(0, 0);
		body1.setMass(MassType.NORMAL);
		this.world.addBody(body1);
		*/
		
		SimulationBody floor = new SimulationBody();
		floor.addFixture(Geometry.createRectangle(1000.0, 0.5));
		floor.setMass(MassType.INFINITE);
		floor.translate(0, -50);
		this.world.addBody(floor);

		createCar();
		
		this.world.setGravity(World.EARTH_GRAVITY);
	}
}
//www.youtube.com/watch?v=ptK9-CNms98