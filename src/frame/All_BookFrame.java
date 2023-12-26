package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Author;
import model.Book;
import model.Publisher;
import sqlTools.AuthorTools;
import sqlTools.BookTools;
import sqlTools.BorrowTools;
import sqlTools.PublisherTools;

public class All_BookFrame extends JFrame implements ItemListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JScrollPane bookScrollPane;
	public JTable bookJtable;
	private DefaultTableModel defaultModel;
	public int row;

	private JButton updateButton;
	private JButton deleteButton;
	private JButton searchButton;

	private String searchType = "idBook";
	private JRadioButton nameBookRadioButton;
	private JRadioButton idBookRadioButton;
	private ButtonGroup group;

	private JTextField searchtextField;

	public All_BookFrame() {
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

		JButton checkReader_button = new JButton("Library Status");
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
		log_out_Button.setBounds(817, 102, 85, 29);
		contentPane.add(log_out_Button);

		bookScrollPane = new JScrollPane();
		bookScrollPane.setBounds(293, 253, 658, 332);
		contentPane.add(bookScrollPane);

		deleteButton = new JButton(new ImageIcon("image/delete.jpg"));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_Book();
			}
		});
		deleteButton.setBounds(641, 600, 128, 44);
		contentPane.add(deleteButton);

		searchtextField = new JTextField();
		searchtextField.setFont(new Font("Serif", Font.PLAIN, 18));
		searchtextField.setBounds(300, 166, 492, 35);
		contentPane.add(searchtextField);
		searchtextField.setColumns(10);

		searchButton = new JButton(new ImageIcon("image/search.jpg"));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_search_book();
			}
		});
		searchButton.setBounds(838, 166, 97, 35);
		contentPane.add(searchButton);

		idBookRadioButton = new JRadioButton("Search by Book ID");
		idBookRadioButton.setFont(new Font("Serif", Font.PLAIN, 15));
		idBookRadioButton.setBounds(346, 213, 177, 29);
		contentPane.add(idBookRadioButton);
		idBookRadioButton.setSelected(true);
		idBookRadioButton.addItemListener(this);
		idBookRadioButton.setContentAreaFilled(false);

		nameBookRadioButton = new JRadioButton("Search by Book Title");
		nameBookRadioButton.setFont(new Font("Serif", Font.PLAIN, 15));
		nameBookRadioButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		nameBookRadioButton.setBounds(568, 213, 177, 29);
		contentPane.add(nameBookRadioButton);
		nameBookRadioButton.addItemListener(this);
		nameBookRadioButton.setContentAreaFilled(false);


		group = new ButtonGroup();
		group.add(this.idBookRadioButton);
		group.add(this.nameBookRadioButton);

		updateButton = new JButton(new ImageIcon("image/update.jpg"));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_book();
			}
		});
		updateButton.setBounds(437, 600, 128, 44);
		contentPane.add(updateButton);


		show_data();

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
		defaultModel
				.setColumnIdentifiers(new Object[] { "ID", "Title", "Price", "Category", "Author", "Publisher", "Author's Workplace", "Publisher's Address", "Availability" });
		bookJtable.getTableHeader().setReorderingAllowed(false);
		bookJtable.setModel(defaultModel);

		bookJtable.getColumnModel().getColumn(0).setPreferredWidth(20);
		bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
		bookJtable.getColumnModel().getColumn(2).setPreferredWidth(30);
		bookJtable.getColumnModel().getColumn(3).setPreferredWidth(40);
		bookJtable.getColumnModel().getColumn(4).setPreferredWidth(40);
		bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);
		bookJtable.getColumnModel().getColumn(6).setPreferredWidth(40);
		bookJtable.getColumnModel().getColumn(7).setPreferredWidth(80);
		bookJtable.getColumnModel().getColumn(8).setPreferredWidth(30);

		BookTools bookTools = new BookTools();
		AuthorTools authorTools = new AuthorTools();
		PublisherTools publisherTools = new PublisherTools();

		List<Book> booklist = bookTools.BookData();
		BorrowTools borrowtools = new BorrowTools();

		for (Iterator<Book> iterator = booklist.iterator(); iterator.hasNext();) {
			Book temp = (Book) iterator.next();
			// Check the idReader
			String whetherInStock = null;

			if (borrowtools.whetherInStock(temp.getIdBook()) == true) {
                whetherInStock = "Available";
            } else {
                whetherInStock = "Borrowed";
            }

			List<Author> authorlist = authorTools.AuthorData(temp.getAuthor());
			Publisher publisher = publisherTools.PublisherData((temp.getPublisher()));
			defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), temp.getPrice(), temp.getType(),
					temp.getAuthor(), temp.getPublisher(), authorlist.get(0).getWorkplace(), publisher.getAddress(),
					whetherInStock });
		}
		bookScrollPane.setViewportView(bookJtable);
	}

	public void itemStateChanged(ItemEvent e) {
	    if (idBookRadioButton.isSelected()) {
	        this.searchType = "idBook";
	    }
	    if (nameBookRadioButton.isSelected()) {
	        this.searchType = "nameBook";
	    }
	}

	private void do_search_book() {

		if ("nameBook".equals(searchType)) {

			bookJtable = new JTable();
			bookJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			bookJtable.setRowHeight(54);

			defaultModel = (DefaultTableModel) bookJtable.getModel();
			defaultModel.setRowCount(0);
			defaultModel.setColumnIdentifiers(
	                new Object[] { "ID", "Title", "Price", "Type", "Author", "Publisher", "Author's Workplace", "Publisher's Address", "Availability" });

	        bookJtable.getTableHeader().setReorderingAllowed(false);
	        bookJtable.setModel(defaultModel);

	        bookJtable.getColumnModel().getColumn(0).setPreferredWidth(20);
	        bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
	        bookJtable.getColumnModel().getColumn(2).setPreferredWidth(30);
	        bookJtable.getColumnModel().getColumn(3).setPreferredWidth(40);
	        bookJtable.getColumnModel().getColumn(4).setPreferredWidth(40);
	        bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);
	        bookJtable.getColumnModel().getColumn(6).setPreferredWidth(40);
	        bookJtable.getColumnModel().getColumn(7).setPreferredWidth(80);
	        bookJtable.getColumnModel().getColumn(8).setPreferredWidth(30);

	        BookTools bookTools = new BookTools();
	        AuthorTools authorTools = new AuthorTools();
	        PublisherTools publisherTools = new PublisherTools();

	        BorrowTools borrowTools = new BorrowTools();

	        String keyword = null;
	        if (searchtextField.getText() != null && !"".equals(searchtextField.getText())) {
	            keyword = searchtextField.getText();
	        } else {
	            show_data();
	            JOptionPane.showMessageDialog(this, "Please enter a book title.", "", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        List<Book> bookList = bookTools.BookData(keyword);

	        if (bookList.size() == 0) {
	            JOptionPane.showMessageDialog(this, "No related books found.", "", JOptionPane.WARNING_MESSAGE);
	            return;
	        } else {
	            for (Iterator<Book> iterator = bookList.iterator(); iterator.hasNext();) {
	                Book temp = iterator.next();
	                String whetherInStock = null;
	                if (borrowTools.whetherInStock(temp.getIdBook())) {
	                    whetherInStock = "Available";
	                } else {
	                    whetherInStock = "Borrowed";
	                }
	                List<Author> authorList = authorTools.AuthorData(temp.getAuthor());
	                Publisher publisher = publisherTools.PublisherData(temp.getPublisher());
	                defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), temp.getPrice(),
	                        temp.getType(), temp.getAuthor(), temp.getPublisher(), authorList.get(0).getWorkplace(),
	                        publisher.getAddress(), whetherInStock });
	            }
	            bookScrollPane.setViewportView(bookJtable);
	        }
	    }

	    // This mega if statement is used to search by "book ID"
	    if ("idBook".equals(searchType)) {

	        bookJtable = new JTable();
	        bookJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	        bookJtable.setRowHeight(54);

	        defaultModel = (DefaultTableModel) bookJtable.getModel();
	        defaultModel.setRowCount(0);
	        defaultModel.setColumnIdentifiers(
	                new Object[] { "ID", "Title", "Price", "Type", "Author", "Publisher", "Author's Workplace", "Publisher's Address", "Availability" });

	        bookJtable.getTableHeader().setReorderingAllowed(false);
	        bookJtable.setModel(defaultModel);

	        bookJtable.getColumnModel().getColumn(0).setPreferredWidth(20);
	        bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
	        bookJtable.getColumnModel().getColumn(2).setPreferredWidth(30);
	        bookJtable.getColumnModel().getColumn(3).setPreferredWidth(40);
	        bookJtable.getColumnModel().getColumn(4).setPreferredWidth(40);
	        bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);
	        bookJtable.getColumnModel().getColumn(6).setPreferredWidth(40);
	        bookJtable.getColumnModel().getColumn(7).setPreferredWidth(80);
	        bookJtable.getColumnModel().getColumn(8).setPreferredWidth(30);
	        BorrowTools borrowTools = new BorrowTools();
	        AuthorTools authorTools = new AuthorTools();
	        PublisherTools publisherTools = new PublisherTools();

	        String keyword = null;
	        if (searchtextField.getText() != null && !"".equals(searchtextField.getText())) {
	            keyword = searchtextField.getText();
	        } else {
	            show_data();
	            JOptionPane.showMessageDialog(this, "Please enter a book ID.", "", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        List<Book> bookList = borrowTools.BookData_Search_idBook(keyword);

	        if (bookList.size() == 0) {
	            JOptionPane.showMessageDialog(this, "No related books found.", "", JOptionPane.WARNING_MESSAGE);
	            return;
	        } else {
	            for (Iterator<Book> iterator = bookList.iterator(); iterator.hasNext();) {
	                Book temp = iterator.next();
	                String whetherInStock = null;
	                if (borrowTools.whetherInStock(temp.getIdBook())) {
	                    whetherInStock = "Available";
	                } else {
	                    whetherInStock = "Borrowed";
	                }
	                List<Author> authorList = authorTools.AuthorData(temp.getAuthor());
	                Publisher publisher = publisherTools.PublisherData(temp.getPublisher());
	                defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), temp.getPrice() + "元",
	                        temp.getType(), temp.getAuthor(), temp.getPublisher(), authorList.get(0).getWorkplace(),
	                        publisher.getName(), whetherInStock });
	            }
	            bookScrollPane.setViewportView(bookJtable);
	        }
	    }
	}



	private void update_book() {

		row = bookJtable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Please select a book!", "", JOptionPane.WARNING_MESSAGE);
            return;
		}
		Book_UpdateFrame book_UpdateFrame = new Book_UpdateFrame(All_BookFrame.this);
		book_UpdateFrame.setVisible(true);

	}


	private void delete_Book() {
		row = bookJtable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Please select a book", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		BookTools bookTools = new BookTools();
		int i = bookTools.DeleteBook(bookJtable.getValueAt(row, 0).toString());
		if (i == 1) {
            JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted book information!", "", JOptionPane.WARNING_MESSAGE);
            this.show_data();
            return;
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "Failed to delete book information!", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
	}

	public void CloseFrame() {
		super.dispose();
	}
}
