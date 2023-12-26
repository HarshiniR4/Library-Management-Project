package frame;
import javax.swing.JFrame;

public class Gif_LibrarianFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;


	public void run() {
		Gif_LibrarianFrame frame = new Gif_LibrarianFrame();
		frame.setVisible(false);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		} 
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
		Login_LibrarianFrame login_LibrarianFrame = new Login_LibrarianFrame();
		login_LibrarianFrame.setVisible(true);

	}

}