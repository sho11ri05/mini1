package jp.libroworks;

import jp.libroworks.supers.GameChara;
import jp.libroworks.supers.Stage;

public class PlayerChara extends GameChara {
	public static final double SPEED = 200;

	@Override
	public GameChara draw(GraphicsInfo ginfo, Stage stage) {
		//キー入力
		if(ginfo.keystate[KEY_STATE.LEFT]){
			this.position.x -= PlayerChara.SPEED * ginfo.frametime;
		}
		if(ginfo.keystate[KEY_STATE.RIGHT]){
			this.position.x += PlayerChara.SPEED * ginfo.frametime;
		}
		if(ginfo.keystate[KEY_STATE.UP]){
			this.position.y -= PlayerChara.SPEED * ginfo.frametime;
		}
		if(ginfo.keystate[KEY_STATE.DOWN]){
			this.position.y += PlayerChara.SPEED * ginfo.frametime;
		}
		if(ginfo.keystate[KEY_STATE.Z]){
			this.angle += 1;
		}
		return super.draw(ginfo, stage);
	}

}
