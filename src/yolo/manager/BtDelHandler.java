package yolo.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BtDelHandler implements ActionListener {
	WordManager owner;
	public BtDelHandler(WordManager wordManager) {
		owner = wordManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String key = (String)owner.liWord.getSelectedValue();
		owner.listModel.removeElement(key);

		Word target = owner.words.get(key);
		owner.groups.get(target.cate).remove(target);
		owner.words.remove(key);
		JOptionPane.showMessageDialog(owner, "삭제되었습니다");
	}
	
}
