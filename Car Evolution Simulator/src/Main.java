import org.dyn4j.*;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.World;
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
		initializeWorld();
	}
	
	public static void main(String[] args) {
		Main simulation = new Main();
		simulation.run();
	}

	@Override
	protected void initializeWorld() {
		
		SimulationBody body1 = new SimulationBody();
		body1.addFixture(Geometry.createSquare(10), 1, 20, .25);
		body1.setAngularVelocity(5);
		body1.translate(0, 0);
		body1.setMass(MassType.NORMAL);
		this.world.addBody(body1);
		//
		//
		SimulationBody floor = new SimulationBody();
		floor.addFixture(Geometry.createRectangle(100.0, 0.5));
		floor.setMass(MassType.INFINITE);
		floor.translate(0, -50);
		this.world.addBody(floor);
		
		this.world.setGravity(World.EARTH_GRAVITY);
	}
}
//www.youtube.com/watch?v=ptK9-CNms98