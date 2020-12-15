package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainMenu {
	
	int y;
	Color color = Color.WHITE;

	MainMenu(int y){
		this.y = y;
	}
	
	public void draw(ShapeRenderer shape) {
    	shape.setColor(color);
        shape.rect(0, y, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
	
	public void scrollScreen(int scrollSpeed) {
		if(this.y > 0) {
			y = y - scrollSpeed;
		}
	}
}
