package ui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import carolineFunctions.CarolineExecution;
import dijkstraFunctions.DijkstraExecution;
import dijkstraFunctions.Philosopher;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ArrayList<JLabel> labelPhilosopher = new ArrayList<JLabel>();
	enum Status { STOPPED, STARTED };
	private static Status status = Status.STOPPED;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
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
	public MainApp() {
		setResizable(false);
		setTitle("Jantar dos Filósofos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/spaghetti.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnDijkstra = new JRadioButton("Dijkstra");
		buttonGroup.add(rdbtnDijkstra);
		rdbtnDijkstra.setSelected(true);
		rdbtnDijkstra.setBounds(445, 32, 111, 23);
		contentPane.add(rdbtnDijkstra);
		
		JRadioButton rdbtnCaroline = new JRadioButton("Caroline");
		buttonGroup.add(rdbtnCaroline);
		rdbtnCaroline.setBounds(445, 58, 111, 23);
		contentPane.add(rdbtnCaroline);
		
		JLabel lblAlgoritmo = new JLabel("Algoritmo");
		lblAlgoritmo.setBounds(445, 11, 62, 14);
		contentPane.add(lblAlgoritmo);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (status == Status.STOPPED) {
					if (rdbtnDijkstra.isSelected()) {
						DijkstraExecution.dijkstraStart();
					}
					if (rdbtnCaroline.isSelected()) {
						CarolineExecution.carolineStart();
					}
					status = Status.STARTED;
				}
			}
		});
		btnIniciar.setBounds(445, 195, 89, 23);
		contentPane.add(btnIniciar);
		
		JButton btnParar = new JButton("Parar");
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (status == Status.STARTED) {
					if (rdbtnDijkstra.isSelected()) {
						DijkstraExecution.dijkstraStop();
					}
					if (rdbtnCaroline.isSelected()) {
						CarolineExecution.carolineStop();
					}
					status = Status.STOPPED;
				}
			}
		});
		btnParar.setBounds(445, 229, 89, 23);
		contentPane.add(btnParar);
		
		JLabel lblPhilosopher0 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher0);
		lblPhilosopher0.setBounds(202, 32, 40, 40);
		lblPhilosopher0.setIcon(new ImageIcon(MainApp.class.getResource("/pacman.png")));
		contentPane.add(lblPhilosopher0);
		
		JLabel lblPhilosopher1 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher1);
		lblPhilosopher1.setBounds(292, 102, 40, 40);
		lblPhilosopher1.setIcon(new ImageIcon(MainApp.class.getResource("/red-ghost.png")));
		contentPane.add(lblPhilosopher1);
		
		JLabel lblPhilosopher2 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher2);
		lblPhilosopher2.setBounds(256, 195, 40, 40);
		lblPhilosopher2.setIcon(new ImageIcon(MainApp.class.getResource("/cyan-ghost.png")));
		contentPane.add(lblPhilosopher2);
		
		JLabel lblPhilosopher3 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher3);
		lblPhilosopher3.setBounds(151, 195, 40, 40);
		lblPhilosopher3.setIcon(new ImageIcon(MainApp.class.getResource("/orange-ghost.png")));
		contentPane.add(lblPhilosopher3);
		
		JLabel lblPhilosopher4 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher4);
		lblPhilosopher4.setBounds(111, 102, 40, 40);
		lblPhilosopher4.setIcon(new ImageIcon(MainApp.class.getResource("/pink-ghost.png")));
		contentPane.add(lblPhilosopher4);
		
		JLabel background = new JLabel("");
		background.setBounds(10, 11, 425, 241);
		background.setIcon(new ImageIcon(MainApp.class.getResource("/map-clear-2.png")));
		contentPane.add(background);
	}
	
	public void PhilosopherThink(int index) {
		labelPhilosopher.get(index).setIcon(new ImageIcon(MainApp.class.getResource("/ghost.png")));
	}
	
	public void PhilosopherEat(int index) {
		labelPhilosopher.get(index).setIcon(new ImageIcon(MainApp.class.getResource("/pacman.txt")));
	}
}
