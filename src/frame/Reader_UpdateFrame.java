package frame;

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
import java.awt.Color;
import java.awt.Font;

public class Reader_UpdateFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField nameReadertextField;
	private JTextField typetextField;
	private JTextField sextextField;
	private JTextField passwordtextField;	

	private JLabel idReader_showLabel;
	private JLabel idReaderLabel;
	private JLabel nameReaderLabel;
	private JLabel typeLabel;
	private JLabel sexLabel;
	private JLabel passwordLabel;
	private JButton updateButton;
	

	public Reader_UpdateFrame(All_ReaderFrame all_readerFrame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 937, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idReaderLabel = new JLabel("Book ID");
		idReaderLabel.setForeground(Color.WHITE);
		idReaderLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		idReaderLabel.setBounds(258, 79, 148, 38);
		contentPane.add(idReaderLabel);
		
		nameReaderLabel = new JLabel("Reader Name");
		nameReaderLabel.setForeground(Color.WHITE);
		nameReaderLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		nameReaderLabel.setBounds(283, 162, 91, 29);
		contentPane.add(nameReaderLabel);
		
		typeLabel = new JLabel("ְCategory");
		typeLabel.setForeground(Color.WHITE);
		typeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		typeLabel.setBounds(283, 232, 81, 38);
		contentPane.add(typeLabel);
		
		sexLabel = new JLabel("Gender");
		sexLabel.setForeground(Color.WHITE);
		sexLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		sexLabel.setBounds(283, 319, 81, 38);
		contentPane.add(sexLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(258, 393, 130, 48);
		contentPane.add(passwordLabel);
		
		idReader_showLabel = new JLabel();
		idReader_showLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		idReader_showLabel.setForeground(Color.WHITE);
		idReader_showLabel.setBounds(467, 79, 156, 38);
		contentPane.add(idReader_showLabel);
		idReader_showLabel.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 0).toString());
		
		nameReadertextField = new JTextField();
		nameReadertextField.setFont(new Font("Serif", Font.PLAIN, 20));
		nameReadertextField.setBounds(467, 162, 156, 38);
		contentPane.add(nameReadertextField);
		nameReadertextField.setColumns(10);
		nameReadertextField.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 1).toString());
		
		typetextField = new JTextField();
		typetextField.setFont(new Font("Serif", Font.PLAIN, 20));
		typetextField.setBounds(467, 232, 156, 48);
		contentPane.add(typetextField);
		typetextField.setColumns(10);
		typetextField.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 2).toString());
		
		sextextField = new JTextField();
		sextextField.setFont(new Font("Serif", Font.PLAIN, 20));
		sextextField.setBounds(467, 315, 156, 48);
		contentPane.add(sextextField);
		sextextField.setColumns(10);
		sextextField.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 3).toString());
		
		passwordtextField = new JTextField();
		passwordtextField.setFont(new Font("Serif", Font.PLAIN, 20));
		passwordtextField.setBounds(467, 394, 161, 48);
		contentPane.add(passwordtextField);
		passwordtextField.setColumns(10);
		passwordtextField.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 4).toString());
		
		updateButton = new JButton(new ImageIcon("image/update.jpg"));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_UpdateReader();
			}
		});
		updateButton.setBounds(376, 498, 104, 37);
		contentPane.add(updateButton);
		
		JLabel background = new JLabel(new ImageIcon("image/updateReaderbackground.jpg"));
		background.setBounds(0, 0, 931, 623);
		contentPane.add(background);
		
	}


	protected void do_updateButton_UpdateReader() {

		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();
		
		if ( idReader_showLabel.getText() != null && !"".equals(idReader_showLabel.getText()) 
				&& nameReadertextField.getText() != null && !"".equals(nameReadertextField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& sextextField.getText() != null && !"".equals(sextextField.getText())
				&& passwordtextField.getText() != null && !"".equals(passwordtextField.getText()) ) {
			reader.setIdReader(idReader_showLabel.getText());
			reader.setNameReader(nameReadertextField.getText());
			reader.setType(typetextField.getText());
			reader.setSex(sextextField.getText());
			reader.setPassword(passwordtextField.getText());
			int i = readerTools.UpdateReader(reader);
			if ( i == 1 ) {
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
}
