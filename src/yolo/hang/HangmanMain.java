package yolo.hang;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class HangmanMain extends JFrame {
	String word;
	StringBuilder sbWord;

	// =================================================
	private JMenu mnSetting;
	private JTextField tfWord;
	private JLabel lbWord;
	private JButton btStart;
	private JComboBox cbCate;

	public HangmanMain() {
		configure();
		buildFrame();
		addListener();
	}

	Thread t = null;

	private void addListener() {
		
		btStart.setMnemonic('S');
		tfWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfWord.getText().length() != 1) {
					JOptionPane.showMessageDialog(HangmanMain.this, "¾ËÆÄºª ÇÏ³ª¾¿ ÀÔ·Â¹Ù¶ø´Ï´Ù.");
				} else {
					char c = tfWord.getText().toUpperCase().charAt(0);
					int cnt = 0;
					for (int i = 0; i < word.length(); i++) {
						if (word.charAt(i) == c) {
							sbWord.setCharAt(i, c);
							cnt++;
						}
					}
					if (cnt == 0) {
						JOptionPane.showMessageDialog(HangmanMain.this, "[ "+c+" ] Àº/´Â Æ÷ÇÔµÇ¾îÀÖÁö ¾Ê½À´Ï´Ù." );
					} else { 
						lbWord.setText(sbWord.toString());
						if (sbWord.toString().equals(word)) {
							JOptionPane.showMessageDialog(HangmanMain.this, "´Ü¾î¸¦ ¿Ï¼ºÇÏ¼Ì½À´Ï´Ù.\n´Ù½Ã ½ÃÀÛÇØÁÖ½Ê½Ã¿ä.");
							lbWord.setEnabled(false);
							tfWord.setEnabled(false);
							btStart.setEnabled(true);
						}
					}
				}
				tfWord.setText("");
			}
		});

		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("START")) {
					t = new Thread() {
						public void run() {
							String[] gods = "gaia,gigantes,nike,demeter,dionysos,leto,medeia,moira,musa,seiren,selene,ares,artemis,athena,apollon,eros"
									.toUpperCase().split(",");
							while (!this.isInterrupted()) {
								word = gods[(int) (Math.random() * gods.length)];
								char[] c = new char[word.length()];
								Arrays.fill(c, '?');
								sbWord = new StringBuilder(new String(c));
								lbWord.setText(sbWord.toString());
							}
						}
					};
					t.start();
					btStart.setText("STOP");
				} else {
					t.interrupt();
					lbWord.setEnabled(true);
					tfWord.setEnabled(true);
					btStart.setText("START");
					btStart.setEnabled(false);
				}
			}
		});

	}

	private void buildFrame() {
		getContentPane().setLayout(null);

		lbWord = new JLabel("???????");
		lbWord.setEnabled(false);
		lbWord.setHorizontalAlignment(SwingConstants.CENTER);
		lbWord.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 26));
		lbWord.setBounds(60, 93, 269, 52);
		getContentPane().add(lbWord);

		tfWord = new JTextField();
		tfWord.setEnabled(false);
		tfWord.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		tfWord.setHorizontalAlignment(SwingConstants.CENTER);
		tfWord.setBounds(142, 237, 116, 44);
		getContentPane().add(tfWord);
		tfWord.setColumns(10);

		btStart = new JButton("START");
		btStart.setBounds(280, 10, 97, 23);
		getContentPane().add(btStart);

		JLabel lbInfo = new JLabel(
				"\u203B START\uBC84\uD2BC\uC744 \uB20C\uB7EC \uB2E8\uC5B4\uB97C \uC120\uD0DD\uBC1B\uC740 \uD6C4 \uD55C\uB2E8\uC5B4\uC529 \uC785\uB825\uD569\uB2C8\uB2E4.");
		lbInfo.setBounds(12, 327, 365, 15);
		getContentPane().add(lbInfo);
		
		cbCate = new JComboBox();
		cbCate.setModel(new DefaultComboBoxModel(new String[] {"\uADF8\uB9AC\uC2A4\uC2E0 ", "\uACFC\uC77C"}));
		cbCate.setBounds(158, 11, 110, 21);
		getContentPane().add(cbCate);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnSetting = new JMenu("SETTING");
		menuBar.add(mnSetting);

	}

	private void configure() {
		UIManager.put("Button.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		UIManager.put("TextArea.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		UIManager.put("TextField.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		UIManager.put("Label.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		UIManager.put("List.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		UIManager.put("ComboBox.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		UIManager.put("TableHeader.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		UIManager.put("Menu.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		UIManager.put("MenuItem.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		UIManager.put("MenuItem.font", new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		setTitle("\uB450\uB1CC\uD37C\uC990! \uD589\uB9E8");
		setResizable(false);
		setSize(395, 401);

	}

	public static void main(String[] args) {
		new HangmanMain().setVisible(true);
	}
}
