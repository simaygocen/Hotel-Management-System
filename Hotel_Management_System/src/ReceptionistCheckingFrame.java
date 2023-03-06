import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import javax.swing.JComboBox;

public class ReceptionistCheckingFrame extends JFrame {

	private JPanel contentPane;
	private JTable roomtable;
	private DefaultTableModel model;
	private List<Room> rooms;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistCheckingFrame frame = new ReceptionistCheckingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public ReceptionistCheckingFrame() throws FileNotFoundException {
		Room.addRoomToList();
		rooms = Room.getRooms();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1180, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 20, 1151, 662);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Room Availability", null, panel, null);
		panel.setLayout(null);
		
		String[] STATU = {"Available","Non-Available","All"};
		final JComboBox availability = new JComboBox(STATU);		
		availability.setBounds(132, 102, 156, 28);
		panel.add(availability);
		
		JLabel lblNewLabel_3 = new JLabel("Availability");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(36, 98, 75, 32);
		panel.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_4 = new JLabel("Receptionist Management");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 35, 309, 32);
		panel.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(480, 10, 637, 615);
		panel.add(scrollPane);
		
		roomtable = new JTable();
		model = new DefaultTableModel();
		Object[] column3 = {"RoomNum","Type","Availability"};
		final Object[] row3 = new Object[5];
		model.setColumnIdentifiers(column3);
		roomtable.setModel(model);
		scrollPane.setViewportView(roomtable);
		
		JButton LIST = new JButton("LIST");
		LIST.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				for(int i=model.getRowCount()-1; i>=0; i--) {
					model.removeRow(i);}
				if(availability.getSelectedItem().equals("Available")) {
					 
					for (int i = 0; i < rooms.size(); i++) {
						if(rooms.get(i).getAvailability().equals("available")) {
							row3[0] = rooms.get(i).getRoomNumber();
							row3[1] = rooms.get(i).getType();
							row3[2] = rooms.get(i).getAvailability();
							model.addRow(row3);
						}						
					}					
				}
				else if(availability.getSelectedItem().equals("Non-Available")) {
					
					for (int i = 0; i < rooms.size(); i++) {
						if(rooms.get(i).getAvailability().equals("non-available")) {
							row3[0] = rooms.get(i).getRoomNumber();
							row3[1] = rooms.get(i).getType();
							row3[2] = rooms.get(i).getAvailability();
							model.addRow(row3);
						}						
					}				
				}
				else {				 
					for (int i = 0; i < rooms.size(); i++) {
						row3[0] = rooms.get(i).getRoomNumber();
						row3[1] = rooms.get(i).getType();
						row3[2] = rooms.get(i).getAvailability();
						model.addRow(row3);
					}				
				}
			
			}
			
		});

		LIST.setFont(new Font("Tahoma", Font.BOLD, 14));
		LIST.setBounds(132, 160, 91, 32);
		panel.add(LIST);
		
		
	}


}
