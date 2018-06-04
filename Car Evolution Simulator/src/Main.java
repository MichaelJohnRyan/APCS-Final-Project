import org.dyn4j.*;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
	//
	World world;
	//
	public Main() {
		super("Test");
		setVisible(true);
		setSize(1000, 1500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//
		//
		Dimension size = new Dimension(800, 600);
		//
		//
		Canvas canvas = new Canvas();
		canvas.setPreferredSize(size);
		canvas.setMinimumSize(size);
		canvas.setMinimumSize(size);
		canvas.setMaximumSize(size);
		//
		add(canvas);
		pack();
		
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
//https://www.youtube.com/watch?v=ptK9-CNms98