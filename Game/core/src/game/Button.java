package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Button {

	int x;
	int y;
	Batch batch;
	final Texture buttonImage = new Texture("continuearrow.png");
	boolean value = false;
	
	Button(int x, int y, Batch batch){
		this.x = x;
		this.y = y;
		this.batch = batch;
	}
	
	public void draw(Batch batch) {
		batch.draw(buttonImage, x, y);
		if(Gdx.input.getX() > this.x && Gdx.input.getX() <= this.x + 175 &&
		   Gdx.graphics.getHeight() - Gdx.input.getY() > this.y && Gdx.graphics.getHeight() - Gdx.input.getY() <= this.y + 98  &&
		   Gdx.input.isTouched()) {
			System.out.println("bob");
			this.value = true;
		}
	}
	
	public void scrollButton(int scrollSpeed, int Limit, String direction) {
		if(direction.equals("down") && this.y > Limit) {
			y = y - scrollSpeed;
		}
		
		if(direction.equals("right") && this.x < Limit) {
			x = x + scrollSpeed;
		}
	}
	
}
