package jp.libroworks.supers;

import java.io.IOException;

import jp.libroworks.GraphicsInfo;

public abstract class GameDisplay {

	protected static GameDisplay current = null;
	protected long starttime;

	//開始時間設定
	public void setStartTime(long st){
		this.starttime = st;
	}

	//現在のディスプレイを返す
	public GameDisplay getCurrentDisplay(){
		return GameDisplay.current;
	}

	//このディスプレイを表示
	public abstract void show(GraphicsInfo ginfo);

	//画像などを読み込む
	public abstract void loadMedia() throws IOException;

}
