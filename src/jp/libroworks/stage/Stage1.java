package jp.libroworks.stage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.libroworks.PlayerChara;
import jp.libroworks.supers.GameChara;
import jp.libroworks.supers.Stage;

public class Stage1 extends Stage {
	private PlayerChara player = new PlayerChara();
	private BufferedImage img_chara;
	private Ringo enemy =new Ringo();

	@Override
	public GameChara getPlayer() {
		return this.player;
	}

	@Override
	public void loadMedia() throws IOException {
		this.img_chara = ImageIO.read(new File("gazou/minige1-1.png"));
		this.player.setImage(this.img_chara.getSubimage(0,  0, 85, 105));
		this.enemy = ImageIO.read(new File("apple2.png"));
		this.enemy.setImage(this.img_chara.getSubimage(0,  0, 85, 105));
	}

	@Override
	public GameChara getEnemy() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void loadMedia1() throws IOException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
