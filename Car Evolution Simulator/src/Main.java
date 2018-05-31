import org.dyn4j.*;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
	public Main() {
		super("Main");
		setVisible(true);
		//setSize(1000, 1500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
//https://www.youtube.com/watch?v=ptK9-CNms98