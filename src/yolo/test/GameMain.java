package yolo.test;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;

public class GameMain extends JFrame {
	String guest;
	
	boolean attack;
	boolean ing;
	JButton btMook;
	JButton btZzi;
	JButton btBbar;
	JButton btDrop;
	JButton btStart;
	JLabel lbEnemy;
	JMenuItem mnNew;
	JMenuItem mnOpen;
	JTextArea battleLog;
	JLabel lbLog;

	public GameMain() {
		configure();
		buildMenu();
		buildPane();
		addListener();
	}

	private void addListener() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(ing) {
					JOptionPane.showConfirmDialog(GameMain.this, "∞‘¿”¿Ã ¡¯«‡¡ﬂ¿‘¥œ¥Ÿ.\n¡æ∑·«œΩ√∞⁄Ω¿¥œ±Ó?");
				}else {
					System.exit(0);
				}
			}
		});
		// Ω√¿€ BUTTON √≥∏Æ
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack=true;
				ing = true;
				btStart.setEnabled(false);
				btMook.setEnabled(true);
				btZzi.setEnabled(true);
				btBbar.setEnabled(true);
				btDrop.setEnabled(true);
				battleLog.append("[SYSTEM] π¨¬Ó∫¸ Ω√¿€! ¥ÁΩ≈¿« º±∞¯¿‘¥œ¥Ÿ.\n");
				lbLog.setText("∞¯∞›¡ﬂ");
			}
		});
		btDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ing = false;
				btStart.setEnabled(!false);
				btMook.setEnabled(!true);
				btZzi.setEnabled(!true);
				btBbar.setEnabled(!true);
				btDrop.setEnabled(!true);
				battleLog.append("[SYSTEM] ¥ÁΩ≈¿« ±‚±«! ∆–πË √≥∏ÆµÀ¥œ¥Ÿ.\n\n");
				lbLog.setText("∆–πË..");
			}
		});
		btMook.addActionListener(new GameBtsListener(this));
		btBbar.addActionListener(new GameBtsListener(this));
		btZzi.addActionListener(new GameBtsListener(this));
	}
	


	private void configure() {
		UIManager.put("Button.font", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		UIManager.put("TextArea.font", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		UIManager.put("TextField.font", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 11));
		UIManager.put("Label.font", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 11));
		UIManager.put("Menu.font", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		UIManager.put("MenuItem.font", new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));

		setTitle("¥Î∞·! π¨¬Ó∫¸ - ∞‘Ω∫∆Æ");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		btMook.setActionCommand("π¨");
		panel.add(btMook);

		btZzi = new JButton("\uCC0C(2)");
		btZzi.setEnabled(false);
		btZzi.setMnemonic('2');
		btZzi.setActionCommand("¬Ó");
		panel.add(btZzi);

		btBbar = new JButton("\uBE60(3)");
		btBbar.setEnabled(false);
		btBbar.setMnemonic('3');
		btBbar.setActionCommand("∫¸");
		panel.add(btBbar);

		lbEnemy = new JLabel("??");
		lbEnemy.setForeground(SystemColor.textHighlight);
		lbEnemy.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 44));
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

		btStart = new JButton("\uC2DC\uC791(S)");
		btStart.setMnemonic('s');
		btStart.setBounds(307, 155, 75, 23);
		getContentPane().add(btStart);
		
		lbLog = new JLabel("");
		lbLog.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLog.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		lbLog.setForeground(Color.RED);
		lbLog.setBounds(297, 221, 85, 23);
		getContentPane().add(lbLog);

	}

	public static void main(String[] args) {
		new GameMain().setVisible(true);
	}
}
