package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import carolineFunctions.CarolineExecution;
import dijkstraFunctions.DijkstraExecution;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static ArrayList<JLabel> labelPhilosopher = new ArrayList<JLabel>();
	private static ArrayList<JLabel> labelPhilosopherCountEaten = new ArrayList<JLabel>();
	private static ArrayList<JLabel> labelPhilosopherTimeWithoutEating = new ArrayList<JLabel>();
	private static ArrayList<JLabel> labelPhilosopherAverageWaitingTime = new ArrayList<JLabel>();
	private static ArrayList<JLabel> labelPhilosopherMaxWaitingTime = new ArrayList<JLabel>();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/images/spaghetti.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhilosopher0EatenCount = new JLabel("");
		labelPhilosopherCountEaten.add(lblPhilosopher0EatenCount);
		lblPhilosopher0EatenCount.setForeground(Color.white);
		lblPhilosopher0EatenCount.setBounds(247, 21, 95, 14);
		contentPane.add(lblPhilosopher0EatenCount);
		
		JLabel lblPhilosopher0TimeWithoutEating = new JLabel("");
		labelPhilosopherTimeWithoutEating.add(lblPhilosopher0TimeWithoutEating);
		lblPhilosopher0TimeWithoutEating.setForeground(Color.white);
		lblPhilosopher0TimeWithoutEating.setBounds(247, 36, 119, 14);
		contentPane.add(lblPhilosopher0TimeWithoutEating);
		
		JLabel lblPhilosopher0AverageWaitingTime = new JLabel("");
		labelPhilosopherAverageWaitingTime.add(lblPhilosopher0AverageWaitingTime);
		lblPhilosopher0AverageWaitingTime.setForeground(Color.white);
		lblPhilosopher0AverageWaitingTime.setBounds(247, 52, 108, 14);
		contentPane.add(lblPhilosopher0AverageWaitingTime);
		
		JLabel lblPhilosopher0MaxWaitingTime = new JLabel("");
		labelPhilosopherMaxWaitingTime.add(lblPhilosopher0MaxWaitingTime);
		lblPhilosopher0MaxWaitingTime.setForeground(Color.white);
		lblPhilosopher0MaxWaitingTime.setBounds(247, 67, 108, 14);
		contentPane.add(lblPhilosopher0MaxWaitingTime);
		
		JLabel lblPhilosopher1EatenCount = new JLabel("");
		labelPhilosopherCountEaten.add(lblPhilosopher1EatenCount);
		lblPhilosopher1EatenCount.setForeground(Color.white);
		lblPhilosopher1EatenCount.setBounds(338, 92, 89, 14);
		contentPane.add(lblPhilosopher1EatenCount);
		
		JLabel lblPhilosopher1TimeWithoutEating = new JLabel("");
		labelPhilosopherTimeWithoutEating.add(lblPhilosopher1TimeWithoutEating);
		lblPhilosopher1TimeWithoutEating.setForeground(Color.white);
		lblPhilosopher1TimeWithoutEating.setBounds(338, 107, 97, 14);
		contentPane.add(lblPhilosopher1TimeWithoutEating);
		
		JLabel lblPhilosopher1AverageWaitingTime = new JLabel("");
		labelPhilosopherAverageWaitingTime.add(lblPhilosopher1AverageWaitingTime);
		lblPhilosopher1AverageWaitingTime.setForeground(Color.white);
		lblPhilosopher1AverageWaitingTime.setBounds(338, 122, 97, 14);
		contentPane.add(lblPhilosopher1AverageWaitingTime);
		
		JLabel lblPhilosopher1MaxWaitingTime = new JLabel("");
		labelPhilosopherMaxWaitingTime.add(lblPhilosopher1MaxWaitingTime);
		lblPhilosopher1MaxWaitingTime.setForeground(Color.white);
		lblPhilosopher1MaxWaitingTime.setBounds(338, 137, 97, 14);
		contentPane.add(lblPhilosopher1MaxWaitingTime);
		
		JLabel lblPhilosopher2EatenCount = new JLabel("");
		labelPhilosopherCountEaten.add(lblPhilosopher2EatenCount);
		lblPhilosopher2EatenCount.setForeground(Color.white);
		lblPhilosopher2EatenCount.setBounds(306, 184, 108, 14);
		contentPane.add(lblPhilosopher2EatenCount);
		
		JLabel lblPhilosopher2TimeWithoutEating = new JLabel("");
		labelPhilosopherTimeWithoutEating.add(lblPhilosopher2TimeWithoutEating);
		lblPhilosopher2TimeWithoutEating.setForeground(Color.white);
		lblPhilosopher2TimeWithoutEating.setBounds(306, 199, 108, 14);
		contentPane.add(lblPhilosopher2TimeWithoutEating);
		
		JLabel lblPhilosopher2AverageWaitingTime = new JLabel("");
		labelPhilosopherAverageWaitingTime.add(lblPhilosopher2AverageWaitingTime);
		lblPhilosopher2AverageWaitingTime.setForeground(Color.white);
		lblPhilosopher2AverageWaitingTime.setBounds(306, 214, 108, 14);
		contentPane.add(lblPhilosopher2AverageWaitingTime);
		
		JLabel lblPhilosopher2MaxWaitingTime = new JLabel("");
		labelPhilosopherMaxWaitingTime.add(lblPhilosopher2MaxWaitingTime);
		lblPhilosopher2MaxWaitingTime.setForeground(Color.white);
		lblPhilosopher2MaxWaitingTime.setBounds(306, 229, 108, 14);
		contentPane.add(lblPhilosopher2MaxWaitingTime);
		
		JLabel lblPhilosopher3EatenCount = new JLabel("");
		labelPhilosopherCountEaten.add(lblPhilosopher3EatenCount);
		lblPhilosopher3EatenCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhilosopher3EatenCount.setForeground(Color.white);
		lblPhilosopher3EatenCount.setBounds(40, 184, 103, 14);
		contentPane.add(lblPhilosopher3EatenCount);
		
		JLabel lblPhilosopher3TimeWithoutEating = new JLabel("");
		labelPhilosopherTimeWithoutEating.add(lblPhilosopher3TimeWithoutEating);
		lblPhilosopher3TimeWithoutEating.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhilosopher3TimeWithoutEating.setForeground(Color.white);
		lblPhilosopher3TimeWithoutEating.setBounds(20, 199, 123, 14);
		contentPane.add(lblPhilosopher3TimeWithoutEating);
		
		JLabel lblPhilosopher3AverageWaitingTime = new JLabel("");
		labelPhilosopherAverageWaitingTime.add(lblPhilosopher3AverageWaitingTime);
		lblPhilosopher3AverageWaitingTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhilosopher3AverageWaitingTime.setForeground(Color.white);
		lblPhilosopher3AverageWaitingTime.setBounds(20, 214, 123, 14);
		contentPane.add(lblPhilosopher3AverageWaitingTime);
		
		JLabel lblPhilosopher3MaxWaitingTime = new JLabel("");
		labelPhilosopherMaxWaitingTime.add(lblPhilosopher3MaxWaitingTime);
		lblPhilosopher3MaxWaitingTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhilosopher3MaxWaitingTime.setForeground(Color.white);
		lblPhilosopher3MaxWaitingTime.setBounds(20, 229, 123, 14);
		contentPane.add(lblPhilosopher3MaxWaitingTime);
		
		JLabel lblPhilosopher4EatenCount = new JLabel("");
		labelPhilosopherCountEaten.add(lblPhilosopher4EatenCount);
		lblPhilosopher4EatenCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhilosopher4EatenCount.setForeground(Color.white);
		lblPhilosopher4EatenCount.setBounds(20, 92, 95, 14);
		contentPane.add(lblPhilosopher4EatenCount);
		
		JLabel lblPhilosopher4TimeWithoutEating = new JLabel("");
		labelPhilosopherTimeWithoutEating.add(lblPhilosopher4TimeWithoutEating);
		lblPhilosopher4TimeWithoutEating.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhilosopher4TimeWithoutEating.setForeground(Color.white);
		lblPhilosopher4TimeWithoutEating.setBounds(10, 107, 105, 14);
		contentPane.add(lblPhilosopher4TimeWithoutEating);
		
		JLabel lblPhilosopher4AverageWaitingTime = new JLabel("");
		labelPhilosopherAverageWaitingTime.add(lblPhilosopher4AverageWaitingTime);
		lblPhilosopher4AverageWaitingTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhilosopher4AverageWaitingTime.setForeground(Color.white);
		lblPhilosopher4AverageWaitingTime.setBounds(10, 122, 105, 14);
		contentPane.add(lblPhilosopher4AverageWaitingTime);
		
		JLabel lblPhilosopher4MaxWaitingTime = new JLabel("");
		labelPhilosopherMaxWaitingTime.add(lblPhilosopher4MaxWaitingTime);
		lblPhilosopher4MaxWaitingTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhilosopher4MaxWaitingTime.setForeground(Color.white);
		lblPhilosopher4MaxWaitingTime.setBounds(10, 137, 105, 14);
		contentPane.add(lblPhilosopher4MaxWaitingTime);
		
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
					for (JLabel jlabel : labelPhilosopherCountEaten) {
						jlabel.setText("");
					}
					for (JLabel jlabel : labelPhilosopherTimeWithoutEating) {
						jlabel.setText("");
					}
					for (JLabel jlabel : labelPhilosopherAverageWaitingTime) {
						jlabel.setText("");
					}
					for (JLabel jlabel : labelPhilosopherMaxWaitingTime) {
						jlabel.setText("");
					}
					if (rdbtnDijkstra.isSelected()) {
						DijkstraExecution.dijkstraStart();
					}
					if (rdbtnCaroline.isSelected()) {
						CarolineExecution.carolineStart();
					}
					MainApp.StatusStart();
				}
			}
		});
		btnIniciar.setBounds(445, 195, 89, 23);
		contentPane.add(btnIniciar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnFechar.setBounds(445, 229, 89, 23);
		contentPane.add(btnFechar);
		
		JLabel lblPhilosopher0 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher0);
		lblPhilosopher0.setBounds(202, 32, 40, 40);
		lblPhilosopher0.setIcon(new ImageIcon(MainApp.class.getResource("/images/purple-ghost.png")));
		contentPane.add(lblPhilosopher0);
		
		JLabel lblPhilosopher1 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher1);
		lblPhilosopher1.setBounds(292, 102, 40, 40);
		lblPhilosopher1.setIcon(new ImageIcon(MainApp.class.getResource("/images/red-ghost.png")));
		contentPane.add(lblPhilosopher1);
		
		JLabel lblPhilosopher2 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher2);
		lblPhilosopher2.setBounds(256, 195, 40, 40);
		lblPhilosopher2.setIcon(new ImageIcon(MainApp.class.getResource("/images/cyan-ghost.png")));
		contentPane.add(lblPhilosopher2);
		
		JLabel lblPhilosopher3 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher3);
		lblPhilosopher3.setBounds(151, 195, 40, 40);
		lblPhilosopher3.setIcon(new ImageIcon(MainApp.class.getResource("/images/orange-ghost.png")));
		contentPane.add(lblPhilosopher3);
		
		JLabel lblPhilosopher4 = new JLabel("");
		labelPhilosopher.add(lblPhilosopher4);
		lblPhilosopher4.setBounds(118, 107, 40, 40);
		lblPhilosopher4.setIcon(new ImageIcon(MainApp.class.getResource("/images/pink-ghost.png")));
		contentPane.add(lblPhilosopher4);
		
		JLabel background = new JLabel("");
		background.setBounds(10, 11, 425, 241);
		background.setIcon(new ImageIcon(MainApp.class.getResource("/images/map-clear-2.png")));
		contentPane.add(background);
	}
	
	public static void PhilosopherThink(int index) {
		labelPhilosopher.get(index).setIcon(new ImageIcon(MainApp.class.getResource("/images/ghost.png")));
	}
	
	public static void PhilosopherEat(int index) {
		labelPhilosopher.get(index).setIcon(new ImageIcon(MainApp.class.getResource("/images/pacman.png")));
	}
	
	public static void PhilosopherIdle(int index) {
		switch (index) {
		case 0:
			labelPhilosopher.get(0).setIcon(new ImageIcon(MainApp.class.getResource("/images/purple-ghost.png")));
			break;
		case 1:
			labelPhilosopher.get(1).setIcon(new ImageIcon(MainApp.class.getResource("/images/red-ghost.png")));
			break;
		case 2:
			labelPhilosopher.get(2).setIcon(new ImageIcon(MainApp.class.getResource("/images/cyan-ghost.png")));
			break;
		case 3:
			labelPhilosopher.get(3).setIcon(new ImageIcon(MainApp.class.getResource("/images/orange-ghost.png")));
			break;
		case 4:
			labelPhilosopher.get(4).setIcon(new ImageIcon(MainApp.class.getResource("/images/pink-ghost.png")));
			break;
		}
	}
	
	public static void StatusStart() {
		status = Status.STARTED;
	}
	
	public static void StatusStop() {
		status = Status.STOPPED;
	}
	
	public static void PhilosopherEatenCountUpdate(int index, int countEat) {
		labelPhilosopherCountEaten.get(index).setText("Comeu: "  + countEat);
	}
	
	public static void PhilosopherTimeWithoutEatingUpdate(int index, long timeWithoutEating) {
		labelPhilosopherTimeWithoutEating.get(index).setText("Sem comer: "  + timeWithoutEating);
	}
	
	public static void PhilosopherAverageWaitingTimeUpdate(int index, long avg) {
		labelPhilosopherAverageWaitingTime.get(index).setText("Media: "  + avg);
	}
	
	public static void PhilosopherMaxWaitingTimeUpdate(int index, long max) {
		labelPhilosopherMaxWaitingTime.get(index).setText("Maxima: "  + max);
	}
}
