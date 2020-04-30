/*** In The Name of Allah ***/
package game.template.doublebuffering;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Program start.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		// Initialize the global thread-pool
		ThreadPool.init();
		
		// Show the game menu ...
		
		// After the player clicks 'PLAY' ...
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Game Title");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setResizable(false);
				// Create game canvas
				GameCanvas canvas = new GameCanvas();
				frame.setContentPane(canvas);
				frame.pack();
				frame.setLocationRelativeTo(null); // put frame at center of screen
				frame.setVisible(true);
				// Create and execute the game-loop
				GameLoop game = new GameLoop(canvas);
				game.init();
				ThreadPool.execute(game);
				// and the game starts ...
			}
		});
    }

}
