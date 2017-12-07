package yolo.mukzzi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBtsListener implements ActionListener {
	MukZziGameMain gameMain;

	public GameBtsListener(MukZziGameMain gameMain) {
		this.gameMain = gameMain;
	}

	public void actionPerformed(ActionEvent e) {
		String[] arg = "��,��,��".split(",");
		int r = (int) (Math.random() * 3);
		gameMain.lbEnemy.setText(arg[r]);
		gameMain.battleLog.append("[SYSTEM] ����� " + e.getActionCommand() + " vs ������ " + arg[r] + "! \n");
		if (e.getActionCommand().equals(arg[r])) {
			if (gameMain.attack) {
				gameMain.battleLog.append("[SYSTEM] ����� �¸��� ������ ����˴ϴ�.\n\n");
				gameMain.lbLog.setText("�¸� !!");
			}
			else {
				gameMain.battleLog.append("[SYSTEM] ����� �й�� ������ ����˴ϴ�.\n\n");
				gameMain.lbLog.setText("�й� ..");
			}
			gameMain.ing =false;
			gameMain.btStart.setEnabled(!false);
			gameMain.btMook.setEnabled(!true);
			gameMain.btZzi.setEnabled(!true);
			gameMain.btBbar.setEnabled(!true);
			gameMain.btDrop.setEnabled(!true);
			
		} else {
			if (e.getActionCommand().equals("��") && arg[r].equals("��")
					|| e.getActionCommand().equals("��") && arg[r].equals("��")
					|| e.getActionCommand().equals("��") && arg[r].equals("��")) {
				gameMain.battleLog.append("[SYSTEM] �������� ����� �����Դϴ�.\n");
				gameMain.lbLog.setText("������");
				gameMain.attack=true;
			} else {	
				
				gameMain.battleLog.append("[SYSTEM] �������� ����� �����Դϴ�.\n");
				gameMain.lbLog.setText("������");
				gameMain.attack=false;
			}

		}

	}

}
