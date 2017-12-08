package yolo.manager;

import java.io.Serializable;

public class Word implements Serializable {
	String spell;
	String cate;
	String info;

	public Word(String spell, String cate, String info) {
		this.spell = spell;
		this.cate = cate;
		this.info = info;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Word) {
			Word other = (Word) obj;
			return spell.equals(other.spell) && cate.equals(other.cate) && info.equals(other.info);
		}
		return false;
	}

}
