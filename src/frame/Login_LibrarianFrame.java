package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login_LibrarianFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Login_LibrarianFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 996, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton reader_Registerbutton = new JButton("Reader Registration");
		reader_Registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reader_RegisterFrame reader_RegisterFrame = new Reader_RegisterFrame();
				reader_RegisterFrame.setVisible(true);
				CloseFrame();
			}
		});
		reader_Registerbutton.setBounds(50, 197, 155, 29);
		contentPane.add(reader_Registerbutton);

		JButton book_Registerbutton = new JButton("Book Registration");
		book_Registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book_RegisterFrame book_RegisterFrame = new Book_RegisterFrame();
				book_RegisterFrame.setVisible(true);
				CloseFrame();
			}
		});
		book_Registerbutton.setBounds(50, 292, 155, 29);
		contentPane.add(book_Registerbutton);

		JButton all_Readerbutton = new JButton("Reader Database");
		all_Readerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_ReaderFrame all_ReaderFrame = new All_ReaderFrame();
				all_ReaderFrame.setVisible(true);
				CloseFrame();
			}
		});
		all_Readerbutton.setBounds(50, 375, 155, 29);
		contentPane.add(all_Readerbutton);

		JButton all_Bookbutton = new JButton("Book Database");
		all_Bookbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_BookFrame all_BookFrame = new All_BookFrame();
				all_BookFrame.setVisible(true);
				CloseFrame();
			}
		});
		all_Bookbutton.setBounds(50, 459, 155, 29);
		contentPane.add(all_Bookbutton);

		JButton checkReader_button = new JButton("Library Database");
		checkReader_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckReaderFrame checkReaderFrame = new CheckReaderFrame();
				checkReaderFrame.setVisible(true);
				CloseFrame();
			}
		});
		checkReader_button.setBounds(50, 545, 155, 29);
		contentPane.add(checkReader_button);

		JButton log_out_Button = new JButton("Logout");
		log_out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				CloseFrame();
			}
		});
		log_out_Button.setBounds(817, 102, 90, 29);
		contentPane.add(log_out_Button);

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);
	}


	private void CloseFrame() {
		super.dispose();
	}
}
