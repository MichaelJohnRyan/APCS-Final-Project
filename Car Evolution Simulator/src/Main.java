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
	//
	World world;
	//
	public Main() {
		super("Test", 5);
		
	}
	
	public static void main(String[] args) {
		Main simulation = new Main();
		simulation.run();
	}

	@Override
	protected void initializeWorld() {
		world.setGravity(World.EARTH_GRAVITY);
		
		 SimulationBody body1 = new SimulationBody(Color.CYAN);
		    {
				Convex c = Geometry.createSquare(1.0);
				BodyFixture bf = new BodyFixture(c);
				body1.addFixture(bf);
		    }
		    body1.setLinearVelocity(new Vector2(0.0, 0.0));
		    body1.setAngularVelocity(0.0);
		    body1.setMass(MassType.NORMAL);
		    body1.setAutoSleepingEnabled(false);
		    world.addBody(body1);
		
	}
}
//https://www.youtube.com/watch?v=ptK9-CNms98