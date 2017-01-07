import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFile;
	private JTextField txtAns;
	private JTextField txtKey;
	private Model model = new Model();
	private ArrayList<String> arr;
	private JButton btnFileKey;
	private JButton btnSearch;
	private ArrayList<String> keys;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblSearchAlgorithm = new JLabel("Search Algorithm");
		contentPane.add(lblSearchAlgorithm, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][][grow][][][grow]", "[][][][][][][][][]"));

		JLabel lblTypes = new JLabel("Types: ");
		panel.add(lblTypes, "cell 0 0");

		JComboBox comboBoxTypes = new JComboBox();
		comboBoxTypes.setModel(new DefaultComboBoxModel(
				new String[] { "Sequential Search", "Non-recursive Binary Search", "Interpolation Search" }));
		panel.add(comboBoxTypes, "cell 2 0,growx");

		Label label = new Label("Num Search");
		panel.add(label, "cell 0 1");

		JComboBox comboBoxNumSearch = new JComboBox();
		comboBoxNumSearch.setModel(new DefaultComboBoxModel(new String[] { "100", "150", "200", "500" }));
		panel.add(comboBoxNumSearch, "cell 2 1,growx");

		Label label_1 = new Label("Num Skipped");
		panel.add(label_1, "cell 0 2");

		JComboBox comboBoxNumSkipped = new JComboBox();
		comboBoxNumSkipped.setModel(new DefaultComboBoxModel(new String[] { "0", "100", "50", "0" }));
		panel.add(comboBoxNumSkipped, "cell 2 2,growx");

		Label label_2 = new Label("File Data: ");
		panel.add(label_2, "cell 0 3");

		txtFile = new JTextField();
		txtFile.setEnabled(false);
		panel.add(txtFile, "cell 1 3 5 1,growx");
		txtFile.setColumns(10);

		JLabel lblFileKey = new JLabel("File Key");
		panel.add(lblFileKey, "cell 0 4");

		txtKey = new JTextField();
		txtKey.setEnabled(false);
		panel.add(txtKey, "cell 1 4 5 1,growx");
		txtKey.setColumns(10);

		JLabel lblRun = new JLabel("Run:");
		panel.add(lblRun, "cell 0 5");

		txtAns = new JTextField();
		txtAns.setEnabled(false);
		panel.add(txtAns, "cell 1 5 5 1,growx");
		txtAns.setColumns(10);

		JButton btnFile = new JButton("File Data");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(GUI.this) == JFileChooser.APPROVE_OPTION) {
					txtFile.setText(chooser.getSelectedFile().getPath());
					arr = model.loadFile(chooser.getSelectedFile());
					btnFileKey.setEnabled(true);
				}
			}
		});
		panel.add(btnFile, "cell 0 8");

		btnFileKey = new JButton("File Key");
		btnFileKey.setEnabled(false);
		btnFileKey.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(GUI.this) == JFileChooser.APPROVE_OPTION) {
					txtKey.setText(chooser.getSelectedFile().getPath());
					keys = model.loadKeys(chooser.getSelectedFile());
					btnSearch.setEnabled(true);
				}

			}
		});
		panel.add(btnFileKey, "flowx,cell 2 8");

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ans = "";
				int numSearch = Integer.parseInt(comboBoxNumSearch.getSelectedItem().toString());
				int numSkipped = Integer.parseInt(comboBoxNumSkipped.getSelectedItem().toString());

				if (comboBoxTypes.getSelectedIndex() == 0) {
					model.SequentialSearch(numSearch, numSkipped);
				} else if (comboBoxTypes.getSelectedIndex() == 1) {
					model.binarySearch(numSearch, numSkipped);
				} else {
					model.interpolationSearch(numSearch, numSkipped);
				}

				ans = model.result.toString();
				txtAns.setText(ans);

			}
		});
		btnSearch.setEnabled(false);
		panel.add(btnSearch, "cell 2 8");
	}

}
