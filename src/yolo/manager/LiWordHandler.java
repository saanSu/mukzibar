package yolo.manager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class LiWordHandler implements MouseListener {
	WordManager owner;

	public LiWordHandler(WordManager wordManager) {
		owner = wordManager;
	}

	public void mouseClicked(MouseEvent e) {
		int cnt = e.getClickCount();
		if (cnt == 2) {
			String w = (String) owner.liWord.getSelectedValue();
			Word word = owner.words.get(w);
			String ment = "SPELL:" + word.spell + ", cate:" + word.cate;
			if (JOptionPane.showConfirmDialog(owner, "[" + w + "] 을/를 수정하시겠습니까?") == 0) {
				owner.btUpAdd.setActionCommand("update");
				owner.tfWord.setText(word.spell);
				owner.taInfo.setText(word.info);
				owner.cbCate.setSelectedItem(word.cate);
				owner.tfWord.setEnabled(false);
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		// int x = e.getX(); int y = e.getY();
		// System.out.println("mousePressed");
	}

	public void mouseReleased(MouseEvent e) {
		// System.out.println("mouseReleased");
	}

	public void mouseEntered(MouseEvent e) {
		// System.out.println("mouseEntered");
	}

	public void mouseExited(MouseEvent e) {
		// System.out.println("mouseExited");

	}

}
