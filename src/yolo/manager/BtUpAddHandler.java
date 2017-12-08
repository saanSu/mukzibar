package yolo.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BtUpAddHandler implements ActionListener {
	WordManager owner;

	public BtUpAddHandler(WordManager wordManager) {
		owner = wordManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String w = owner.tfWord.getText();
		String c = (String) owner.cbCate.getSelectedItem();
		String i = owner.taInfo.getText();
		Word word = new Word(w, c, i);
		if (e.getActionCommand().equals("add")) {
			if (owner.words.containsKey(w)) {
				JOptionPane.showMessageDialog(owner, "이미 등록되어 있는 단어입니다.");
			} else {
				owner.words.put(w, word);
				owner.listModel.addElement(w); // SPELL
				if (owner.groups.containsKey(c)) {
					owner.groups.get(c).add(word);
				} else {
					owner.groups.put(c, new ArrayList<>());
					owner.groups.get(c).add(word);
					owner.comboModel.addElement(c);
				}
				JOptionPane.showMessageDialog(owner, "등록처리 되었습니다.");
			}
		} else {
			Word old = owner.words.get(w);
			owner.groups.get(old.cate).remove(old);
			owner.words.put(w, word);
			
			if (owner.groups.containsKey(c)) {
				owner.groups.get(c).add(word);
			} else {
				owner.groups.put(c, new ArrayList<>());
				owner.groups.get(c).add(word);
				owner.comboModel.addElement(c);
			}
			JOptionPane.showMessageDialog(owner, "변경처리 되었습니다.");
			owner.tfWord.setEnabled(true);
			owner.btUpAdd.setActionCommand("add");
		}
		owner.tfWord.setText("");
		owner.cbCate.setSelectedIndex(0);
		owner.taInfo.setText("");
	}
}
