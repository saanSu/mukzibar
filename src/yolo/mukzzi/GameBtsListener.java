package yolo.mukzzi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBtsListener implements ActionListener {
	MukZziGameMain gameMain;

	public GameBtsListener(MukZziGameMain gameMain) {
		this.gameMain = gameMain;
	}

	public void actionPerformed(ActionEvent e) {
		String[] arg = "묵,찌,빠".split(",");
		int r = (int) (Math.random() * 3);
		gameMain.lbEnemy.setText(arg[r]);
		gameMain.battleLog.append("[SYSTEM] 당신은 " + e.getActionCommand() + " vs 상대방은 " + arg[r] + "! \n");
		if (e.getActionCommand().equals(arg[r])) {
			if (gameMain.attack) {
				gameMain.battleLog.append("[SYSTEM] 당신의 승리로 게임이 종료됩니다.\n\n");
				gameMain.lbLog.setText("승리 !!");
			}
			else {
				gameMain.battleLog.append("[SYSTEM] 당신의 패배로 게임이 종료됩니다.\n\n");
				gameMain.lbLog.setText("패배 ..");
			}
			gameMain.ing =false;
			gameMain.btStart.setEnabled(!false);
			gameMain.btMook.setEnabled(!true);
			gameMain.btZzi.setEnabled(!true);
			gameMain.btBbar.setEnabled(!true);
			gameMain.btDrop.setEnabled(!true);
			
		} else {
			if (e.getActionCommand().equals("묵") && arg[r].equals("찌")
					|| e.getActionCommand().equals("찌") && arg[r].equals("빠")
					|| e.getActionCommand().equals("빠") && arg[r].equals("묵")) {
				gameMain.battleLog.append("[SYSTEM] 다음턴은 당신의 공격입니다.\n");
				gameMain.lbLog.setText("공격중");
				gameMain.attack=true;
			} else {	
				
				gameMain.battleLog.append("[SYSTEM] 다음턴은 당신의 수비입니다.\n");
				gameMain.lbLog.setText("수비중");
				gameMain.attack=false;
			}

		}

	}

}
