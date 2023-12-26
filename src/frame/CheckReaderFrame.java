package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Book;
import model.Reader;
import sqlTools.BorrowTools;
import sqlTools.ReaderTools;

public class CheckReaderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane;

	private JScrollPane bookScrollPane;
	private JTable bookJtable;
	private DefaultTableModel defaultModel;

	private JLabel idReaderLabel;
	private JLabel nameReaderLabel;
	private JLabel typeLabel;
	private JLabel sexLabel;
	private JLabel passwordLabel;
	private JTextField idReadertextField;

	private JLabel showNameReaderLabel;
	private JLabel showTypeLabel;
	private JLabel showSexLabel;
	private JLabel showPasswordLabel;

	public CheckReaderFrame() {
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

		JButton all_Bookbutton = new JButton("Library Database");
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
		checkReader_button.setBounds(50, 545, 150, 29);
		contentPane.add(checkReader_button);

		JButton log_out_Button = new JButton("Log Out");
		log_out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				CloseFrame();
			}
		});
		log_out_Button.setBounds(817, 102, 85, 29);
		contentPane.add(log_out_Button);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(128, 61, 862, 598);
		contentPane.add(layeredPane);

		idReaderLabel = new JLabel("Library Card Number");
		idReaderLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		idReaderLabel.setBounds(311, 102, 168, 43);
		layeredPane.add(idReaderLabel);

		nameReaderLabel = new JLabel("Name:");
		nameReaderLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		nameReaderLabel.setBounds(241, 218, 81, 32);
		layeredPane.add(nameReaderLabel);

		typeLabel = new JLabel("Position:");
		typeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		typeLabel.setBounds(507, 218, 93, 32);
		layeredPane.add(typeLabel);

		sexLabel = new JLabel("Gender:");
		sexLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		sexLabel.setBounds(241, 260, 81, 38);
		layeredPane.add(sexLabel);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		passwordLabel.setBounds(507, 260, 89, 32);
		layeredPane.add(passwordLabel);

		idReadertextField = new JTextField();
		idReadertextField.setFont(new Font("Serif", Font.PLAIN, 20));
		idReadertextField.setBounds(491, 102, 146, 43);
		idReadertextField.setColumns(10);
		layeredPane.add(idReadertextField);

		showNameReaderLabel = new JLabel("");
		showNameReaderLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		showNameReaderLabel.setBounds(318, 218, 155, 32);
		layeredPane.add(showNameReaderLabel);

		showTypeLabel = new JLabel("");
		showTypeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		showTypeLabel.setBounds(590, 218, 137, 33);
		layeredPane.add(showTypeLabel);

		showSexLabel = new JLabel("");
		showSexLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		showSexLabel.setBounds(330, 260, 137, 38);
		layeredPane.add(showSexLabel);

		showPasswordLabel = new JLabel("");
		showPasswordLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		showPasswordLabel.setBounds(593, 260, 137, 34);
		layeredPane.add(showPasswordLabel);

		JButton btnNewButton = new JButton(new ImageIcon("image/query.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_data();
			}
		});
		btnNewButton.setBounds(401, 171, 105, 43);
		layeredPane.add(btnNewButton);

		bookScrollPane = new JScrollPane(bookJtable);
		bookScrollPane.setBounds(197, 301, 576, 260);
		layeredPane.add(bookScrollPane);

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);

	}


	private void show_data() {

		bookJtable = new JTable();
		bookJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		bookJtable.setRowHeight(54);

		defaultModel = (DefaultTableModel) bookJtable.getModel();
		defaultModel.setRowCount(0);
		defaultModel.setColumnIdentifiers(new Object[] { "Number", "Title", "Price", "Category", "Author", "Publisher" });

		bookJtable.getTableHeader().setReorderingAllowed(false);
		bookJtable.setModel(defaultModel);

		bookJtable.getColumnModel().getColumn(0).setPreferredWidth(10);
		bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
		bookJtable.getColumnModel().getColumn(2).setPreferredWidth(20);
		bookJtable.getColumnModel().getColumn(3).setPreferredWidth(20);
		bookJtable.getColumnModel().getColumn(4).setPreferredWidth(10);
		bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);

		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();
		BorrowTools borrowtools = new BorrowTools();

		if (idReadertextField.getText() != null && !"".equals(idReadertextField.getText())) {
			reader.setIdReader(idReadertextField.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Please enter reader number", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		List<Reader> readerlist = readerTools.ReaderData(reader.getIdReader());
		List<Book> booklist = borrowtools.BookData(reader.getIdReader());

		// Check the idReader

		if (readerlist.size() == 0) {
			JOptionPane.showMessageDialog(this, "Enter the correct reader number", "", JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			for (Iterator<Reader> iterator = readerlist.iterator(); iterator.hasNext();) {
				Reader temp = (Reader) iterator.next();
				showNameReaderLabel.setText(temp.getNameReader());
				showTypeLabel.setText(temp.getType());
				showSexLabel.setText(temp.getSex());
				showPasswordLabel.setText(temp.getPassword());
			}
			for (Iterator<Book> iterator = booklist.iterator(); iterator.hasNext();) {
				Book temp = (Book) iterator.next();
				defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), "$" + temp.getPrice(),
						temp.getType(), temp.getAuthor(), temp.getPublisher() });
			}
		}
		bookScrollPane.setViewportView(bookJtable);
	}

	public void CloseFrame() {
		super.dispose();
	}
}
