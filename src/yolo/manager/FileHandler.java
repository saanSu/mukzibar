package yolo.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class FileHandler implements ActionListener {
	
	WordManager owner;

	public FileHandler(WordManager wordManager) {
		owner = wordManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == owner.miSave) {
			JFileChooser fc = new JFileChooser();
			fc.showSaveDialog(owner);
			File target = fc.getSelectedFile();
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target));
				oos.writeObject(owner.words);
				oos.writeObject(owner.groups);
				oos.close();
				owner.setTitle("관리-" + target.getName());
				JOptionPane.showMessageDialog(owner, "저장하기 성공.");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(owner, "저장하기에 문제가 생겼습니다.");
				System.out.println(ex.toString());
			}
		} else {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(owner);
			File target = fc.getSelectedFile();
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target));
				owner.words = (Map) ois.readObject();
				owner.groups = (Map) ois.readObject();
				ois.close();
				owner.setTitle("관리-" + target.getName());
				owner.listModel.clear();
				Set<String> ks = owner.words.keySet();
				for (String k : ks)
					owner.listModel.addElement(k);
				owner.comboModel.removeAllElements();
				Set<String> cs = owner.groups.keySet();
				for (String c : cs)
					owner.comboModel.addElement(c);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(owner, "불러오기에 문제가 생겼습니다.");
				System.out.println(ex.toString());
			}
		}
	}
}
