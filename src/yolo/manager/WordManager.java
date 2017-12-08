package yolo.manager;

import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class WordManager extends JFrame {
	Map<String, Word> words;
	// 단어Spell을 키로, Word 객체를 일단 관리
	Map<String, List<Word>> groups;
	// 단어그룹을 키로, Word들을 List로 관리

	// =================================================================
	JTextField tfWord;
	JMenuItem miOen;
	JMenuItem miSave;
	JComboBox cbCate;
	JTextArea taInfo;
	JButton btUpAdd;
	JButton btDel;
	JList liWord;
	// 하나의 컴포넌트에 밸류를 여러개 설정할수 있는 컴포넌트들은 Model를 사용해서 항목관리를 편하게 할 수 있음.
	// ==================================================================
	DefaultComboBoxModel comboModel;
	DefaultListModel listModel;

	public WordManager() {
		words = new LinkedHashMap<>();
		groups = new LinkedHashMap<>();

		UIManager.put("Button.font", new Font("맑은 고딕", Font.PLAIN, 12));
		UIManager.put("TextArea.font", new Font("맑은 고딕", Font.PLAIN, 12));
		UIManager.put("TextField.font", new Font("맑은 고딕", Font.PLAIN, 11));
		UIManager.put("Label.font", new Font("맑은 고딕", Font.PLAIN, 11));
		UIManager.put("List.font", new Font("맑은 고딕", Font.PLAIN, 11));
		UIManager.put("ComboBox.font", new Font("맑은 고딕", Font.PLAIN, 12));
		UIManager.put("Menu.font", new Font("맑은 고딕", Font.PLAIN, 12));
		UIManager.put("MenuItem.font", new Font("맑은 고딕", Font.PLAIN, 12));
		UIManager.put("MenuItem.font", new Font("맑은 고딕", Font.PLAIN, 12));
		setTitle("\uAD00\uB9AC- \uC81C\uBAA9\uC5C6\uC74C (*)");
		setSize(522, 420);

		buildFrame();
		addEventListener();
		init(); //
	}

	private void addEventListener() {
		btUpAdd.setActionCommand("add");
		// JList 는 ActionEvent로 처리하는게 아님 . MouseClick Event 처리해야 함.
		btUpAdd.addActionListener(new BtUpAddHandler(this));
		liWord.addMouseListener(new LiWordHandler(this));
		miSave.addActionListener(new FileHandler(this));
		miOen.addActionListener(new FileHandler(this));
		btDel.addActionListener(new BtDelHandler(this));
	}

	// ====================================================================
	private void init() {
		String n1 = "WARCRAFT"; //
		String n2 = "게임";
		String n3 = "블리자드에서 만들어낸 전략시뮬레이션 게임";

		if (words.containsKey(n1)) {
			JOptionPane.showMessageDialog(this, "이미 등록되어 있는 단어입니다.");
		} else {
			Word w = new Word(n1, n2, n3);
			words.put(n1, w);
			listModel.addElement(n1); // SPELL
			if (groups.containsKey(n2)) {
				groups.get(n2).add(w);
			} else {
				groups.put(n2, new ArrayList<>());
				groups.get(n2).add(w);
				comboModel.addElement(n2);
			}
		}
	}

	private void buildFrame() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("FILE");
		menuBar.add(mnFile);

		miOen = new JMenuItem("OPEN");
		mnFile.add(miOen);

		miSave = new JMenuItem("SAVE");
		mnFile.add(miSave);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 57, 147, 210);
		getContentPane().add(scrollPane);

		listModel = new DefaultListModel<>();
		liWord = new JList(listModel);
		scrollPane.setViewportView(liWord);

		tfWord = new JTextField();
		tfWord.setBounds(87, 52, 131, 29);
		getContentPane().add(tfWord);
		tfWord.setColumns(10);
		comboModel = new DefaultComboBoxModel<>();
		cbCate = new JComboBox(comboModel);
		cbCate.setEditable(true);
		cbCate.setBounds(87, 104, 131, 29);
		getContentPane().add(cbCate);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(87, 158, 196, 111);
		getContentPane().add(scrollPane_1);

		taInfo = new JTextArea();
		taInfo.setLineWrap(true);
		scrollPane_1.setViewportView(taInfo);

		btUpAdd = new JButton("\uB4F1\uB85D / \uC218\uC815");
		btUpAdd.setBounds(87, 289, 196, 29);
		getContentPane().add(btUpAdd);

		btDel = new JButton("\uC0AD\uC81C");
		btDel.setBounds(325, 289, 147, 29);
		getContentPane().add(btDel);

		JLabel lblNewLabel = new JLabel("\uB2E8\uC5B4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(22, 52, 57, 29);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\uBD84\uB958");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(22, 104, 57, 29);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\uC124\uBA85");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(22, 158, 57, 29);
		getContentPane().add(label_1);
	}

	public static void main(String[] args) {
		new WordManager().setVisible(true);
	}
}
