package yolo.test;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class TestGUI extends JFrame {
	String guest;
	
	private JButton btMook;
	private JButton btZzi;
	private JButton btBbar;
	private JButton btDrop;
	private JButton btStop;
	private JLabel lbEnemy;
	private JMenuItem mnNew;
	private JMenuItem mnOpen;
	private JTextArea battleLog;

	public TestGUI() {
		configure();
		buildMenu();
		buildPane();
	}

	
	private void configure() {
		UIManager.put("Button.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		UIManager.put("TextArea.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		UIManager.put("TextField.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		UIManager.put("Label.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		UIManager.put("Menu.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		UIManager.put("MenuItem.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));

		setTitle("´ë°á! ¹¬Âîºü - °Ô½ºÆ®");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(400, 615);
		setLocation(700, 100);

	}

	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("MENU");
		mnMenu.setMnemonic('m');
		menuBar.add(mnMenu);

		mnNew = new JMenuItem("\uC0C8\uAC8C\uC784");
		mnMenu.add(mnNew);

		mnOpen = new JMenuItem("\uBD88\uB7EC\uC624\uAE30");
		mnMenu.add(mnOpen);
	}

	private void buildPane() {
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 348, 370, 204);
		getContentPane().add(scrollPane);

		battleLog = new JTextArea();
		battleLog.setEditable(false);
		battleLog.setLineWrap(true);
		scrollPane.setViewportView(battleLog);

		JPanel panel = new JPanel();
		panel.setBounds(12, 252, 370, 81);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 3, 20, 0));

		btMook = new JButton("\uBB35(1)");
		btMook.setEnabled(false);
		btMook.setMnemonic('1');
		panel.add(btMook);

		btZzi = new JButton("\uCC0C(2)");
		btZzi.setEnabled(false);
		btZzi.setMnemonic('2');
		panel.add(btZzi);

		btBbar = new JButton("\uBE60(3)");
		btBbar.setEnabled(false);
		btBbar.setMnemonic('3');
		panel.add(btBbar);

		lbEnemy = new JLabel("??");
		lbEnemy.setFont(new Font("ºù±×·¹Ã¼", Font.PLAIN, 42));
		lbEnemy.setHorizontalAlignment(SwingConstants.CENTER);
		lbEnemy.setBounds(119, 88, 155, 110);
		getContentPane().add(lbEnemy);

		JLabel lb = new JLabel("VS");
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setBounds(119, 208, 155, 32);
		getContentPane().add(lb);

		btDrop = new JButton("\uAE30\uAD8C(D)");
		btDrop.setMnemonic('d');
		btDrop.setEnabled(false);
		btDrop.setBounds(307, 188, 75, 23);
		getContentPane().add(btDrop);

		btStop = new JButton("\uC2DC\uC791(S)");
		btStop.setMnemonic('s');
		btStop.setBounds(307, 155, 75, 23);
		getContentPane().add(btStop);

	}

	public static void main(String[] args) {
		new TestGUI().setVisible(true);
	}
}
