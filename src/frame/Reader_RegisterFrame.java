package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Reader;
import sqlTools.ReaderTools;

public class Reader_RegisterFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField idReadertextField;
	private JTextField nameReadertextField;
	private JTextField typetextField;
	private JTextField sextextField;
	private JTextField passwordtextField;

	private JLabel idReaderLabel;
	private JLabel nameReaderLabel;
	private JLabel typeLabel;
	private JLabel sexLabel;
	private JLabel passwordLabel;

	private JButton insertButton;

	public Reader_RegisterFrame() {
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
		book_Registerbutton.setBounds(50, 292, 150, 29);
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
		checkReader_button.setBounds(50, 545, 158, 29);
		contentPane.add(checkReader_button);

		JButton log_out_Button = new JButton("Logout");
		log_out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				CloseFrame();
			}
		});
		log_out_Button.setBounds(817, 102, 85, 29);
		contentPane.add(log_out_Button);


		idReaderLabel = new JLabel("Reader ID");
		idReaderLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		idReaderLabel.setBounds(470, 180, 149, 55);
		contentPane.add(idReaderLabel);

		nameReaderLabel = new JLabel("Reader Name");
		nameReaderLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		nameReaderLabel.setBounds(470, 264, 113, 34);
		contentPane.add(nameReaderLabel);

		typeLabel = new JLabel("ְCategory");
		typeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		typeLabel.setBounds(470, 328, 90, 34);
		contentPane.add(typeLabel);

		sexLabel = new JLabel("Gender");
		sexLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		sexLabel.setBounds(470, 386, 106, 47);
		contentPane.add(sexLabel);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		passwordLabel.setBounds(470, 459, 120, 55);
		contentPane.add(passwordLabel);

		idReadertextField = new JTextField();
		idReadertextField.setFont(new Font("Serif", Font.PLAIN, 20));
		idReadertextField.setBounds(640, 184, 139, 47);
		contentPane.add(idReadertextField);
		idReadertextField.setColumns(10);

		nameReadertextField = new JTextField();
		nameReadertextField.setFont(new Font("Serif", Font.PLAIN, 20));
		nameReadertextField.setBounds(640, 258, 137, 47);
		contentPane.add(nameReadertextField);
		nameReadertextField.setColumns(10);

		typetextField = new JTextField();
		typetextField.setFont(new Font("Serif", Font.PLAIN, 20));
		typetextField.setBounds(640, 322, 139, 47);
		contentPane.add(typetextField);
		typetextField.setColumns(10);

		sextextField = new JTextField();
		sextextField.setFont(new Font("Serif", Font.PLAIN, 20));
		sextextField.setBounds(640, 386, 139, 47);
		contentPane.add(sextextField);
		sextextField.setColumns(10);

		passwordtextField = new JTextField();
		passwordtextField.setFont(new Font("Serif", Font.PLAIN, 30));
		passwordtextField.setBounds(640, 463, 139, 47);
		contentPane.add(passwordtextField);
		passwordtextField.setColumns(10);

		insertButton = new JButton(new ImageIcon("image/register.jpg"));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_insertButton_AddReader();
			}
		});
		insertButton.setBounds(555, 545, 104, 47);
		contentPane.add(insertButton);

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);
	}

	protected void do_insertButton_AddReader() {

		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();

		if (idReadertextField.getText() != null && !"".equals(idReadertextField.getText())
				&& nameReadertextField.getText() != null && !"".equals(nameReadertextField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& sextextField.getText() != null && !"".equals(sextextField.getText())
				&& passwordtextField.getText() != null && !"".equals(passwordtextField.getText())) {
			reader.setIdReader(idReadertextField.getText());
			reader.setNameReader(nameReadertextField.getText());
			reader.setType(typetextField.getText());
			reader.setSex(sextextField.getText());
			reader.setPassword(passwordtextField.getText());
			int i = readerTools.AddReader(reader);
			if (i == 1) {
				JOptionPane.showMessageDialog(getContentPane(), "Reader information added successfully!", "", JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(getContentPane(), "Failed to add reader information!", "", JOptionPane.WARNING_MESSAGE);
				return;
			}
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "Please enter complete information", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	public void CloseFrame() {
		super.dispose();
	}
}
