package jp.libroworks.supers;

import java.io.IOException;

public abstract class Stage {

	public abstract GameChara getPlayer();
	public abstract void loadMedia() throws IOException;
	public abstract GameChara getEnemy();
	public abstract void loadMedia1() throws IOException;
}
