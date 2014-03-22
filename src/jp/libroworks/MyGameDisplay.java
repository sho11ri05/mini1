package jp.libroworks;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.libroworks.stage.Stage1;
import jp.libroworks.supers.GameChara;
import jp.libroworks.supers.GameDisplay;
import jp.libroworks.supers.Stage;

public class MyGameDisplay extends GameDisplay {

	GameDisplay title, main, over, clear;
	private Font mfont = new Font("Sanserif", Font.BOLD, 50);
	Stage stage = new Stage1();

	public MyGameDisplay(){
		this.title = new MyGameTitle();
		this.main = new MyGameMain();
		this.over = new MyGameOver();
		this.clear = new MyStageClear();
		GameDisplay.current = this.title;
	}

	@Override
	public void show(GraphicsInfo ginfo) {
	}

	@Override
	public void loadMedia() throws IOException {
		this.title.loadMedia();
		this.main.loadMedia();
		this.over.loadMedia();
		this.clear.loadMedia();
	}

	//タイトル画面
	class MyGameTitle extends GameDisplay{
		private BufferedImage img_title;

		@Override
		public void show(GraphicsInfo ginfo) {
			ginfo.g.drawImage(this.img_title, 0, 0, null);

			ginfo.g.setColor(Color.CYAN);
			ginfo.g.setFont(MyGameDisplay.this.mfont);
			String str = "PUSH SPACE";
			FontMetrics fm = ginfo.g.getFontMetrics();
			int strw = fm.stringWidth(str) / 2;
			ginfo.g.drawString(str, 550 - strw, 450);

			if(ginfo.keystate[KEY_STATE.SPACE] == true){
				GameDisplay.current = MyGameDisplay.this.main;
			}
		}

		@Override
		public void loadMedia() throws IOException {
			this.img_title = ImageIO.read(new File("gazou/m1-0.jpg"));
		}
	}

	//ゲーム本編
	class  MyGameMain extends GameDisplay{
		@Override
		public void show(GraphicsInfo ginfo) {
			ginfo.g.setColor(Color.RED);
			ginfo.g.setFont(MyGameDisplay.this.mfont);
			String str = "本編：X＝OVER、C＝CLEAR";
			ginfo.g.drawString(str, 10, 240);
			if(ginfo.keystate[KEY_STATE.X] ==true){
				GameDisplay.current = MyGameDisplay.this.over;
				MyGameDisplay.this.over.setStartTime(ginfo.currenttime);
			}
			if(ginfo.keystate[KEY_STATE.C] ==true){
				GameDisplay.current = MyGameDisplay.this.clear;
				MyGameDisplay.this.clear.setStartTime(ginfo.currenttime);
			}

			GameChara player = MyGameDisplay.this.stage.getPlayer();
			player.draw(ginfo, MyGameDisplay.this.stage);
		}

		@Override
		public void loadMedia() throws IOException {
			MyGameDisplay.this.stage.loadMedia();
		}
	}

	//ゲームオーバー画面
	class MyGameOver extends GameDisplay{
		@Override
		public void show(GraphicsInfo ginfo) {
			ginfo.g.setColor(Color.RED);
			ginfo.g.setFont(MyGameDisplay.this.mfont);
			String str = "ゲームオーバー";
			FontMetrics fm = ginfo.g.getFontMetrics();
			int strw = fm.stringWidth(str) / 2;
			ginfo.g.drawString(str, 400 - strw, 200);

			if(ginfo.currenttime - this.starttime > 5000){
				GameDisplay.current = MyGameDisplay.this.title;
			}
		}

		@Override
		public void loadMedia() {}
	}

	//ステージクリア画面
	class MyStageClear extends GameDisplay{
		@Override
		public void show(GraphicsInfo ginfo) {
			ginfo.g.setColor(Color.CYAN);
			ginfo.g.setFont(MyGameDisplay.this.mfont);
			String str = "ステージクリア";
			FontMetrics fm = ginfo.g.getFontMetrics();
			int strw = fm.stringWidth(str) / 2;
			ginfo.g.drawString(str, 400 - strw, 200);

			if(ginfo.currenttime - this.starttime > 5000){
				GameDisplay.current = MyGameDisplay.this.title;
			}
		}

		@Override
		public void loadMedia() {}
	}
}
