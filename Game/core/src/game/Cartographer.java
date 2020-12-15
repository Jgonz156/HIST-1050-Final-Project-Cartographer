package game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Cartographer extends ApplicationAdapter {
	Music backgroundMusic;
	SpriteBatch batch;
	
	Texture background;
	
	Texture mainMenuImage;
	Texture mainMenuBlock;
	
	Texture debateTextPage, mazeGrass, mazeTarget;
	Texture navigateTextPage, compass, hourglass, mapOfBritain, mapOfItaly, mapOfPortugal, mapOfGreece, mapOfSouthAmerica, greenArrow, redX, choiceTitleBlock;
	Texture verifyTextPage, verifyGamePage;
	Texture summaryTextPage, notesTrunk, importantNotes;
	Texture creditsTextPage;
	TextureRegion gameWindow;
	
	Button mainMenuButton;
	Button debateTPButton, debateGButton;
	Button navigateTPButton, navigateGButton;
	Button verifyTPButton, verifyGButton;
	Button summaryTPButton, summaryGButton;
	Button creditsTPButton, creditsGButton;
	
	@Override
	public void create () {
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Tristan Lohengrin - Happy 8bit Loop 01.mp3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.play();
		backgroundMusic.setVolume((float) 0.1);
		
		batch = new SpriteBatch();
		background = new Texture("cartographerbackground.png");
		
		mainMenuImage = new Texture("8bitworld Map.png");
		mainMenuBlock = new Texture("mainmenublock.png");
		
		debateTextPage = new Texture("debateTextPage.png");
		mazeGrass = new Texture("mazeGrass.png");
		mazeTarget = new Texture("mazeTarget.png");
		
		navigateTextPage = new Texture("navigateTextPage.png");
		compass = new Texture("compass.png");
		hourglass = new Texture("hourglass.png");
		mapOfBritain = new Texture("mapOfBritain.png");
		mapOfItaly = new Texture("mapOfItaly.png");
		mapOfPortugal = new Texture("mapOfPortugal.png");
		mapOfGreece = new Texture("mapOfGreece.png");
		mapOfSouthAmerica = new Texture("mapOfSouthAmerica.png");
		greenArrow = new Texture("greenArrow.png");
		redX = new Texture("redX.png");
		choiceTitleBlock = new Texture("choiceTitleBlock.png");
		
		verifyTextPage = new Texture("verifyTextPage.png");
		verifyGamePage = new Texture("verifyGamePage.png");
		
		summaryTextPage = new Texture("summaryTextPage.png");
		importantNotes = new Texture("importantNotes.png");
		notesTrunk = new Texture("notesTrunk.png");
		
		creditsTextPage = new Texture("creditsTextPage.png");
		
		gameWindow = new TextureRegion(mainMenuImage, 580, 655);
		
		mainMenuButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		
		debateTPButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		debateGButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		
		navigateTPButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		navigateGButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		
		verifyTPButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		verifyGButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		
		summaryTPButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		summaryGButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		
		creditsTPButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
		creditsGButton = new Button(-175, Gdx.graphics.getHeight()/10, batch);
	}
	
	boolean passedMazeGame = false;
	
	int clicksForButtons = 0;
	boolean passedNavGame = false;
	
	int xCord = 295;
	int yCord = 57;
	boolean passedSummaryGame = false;
	
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		
		//Main Menu
		if(!mainMenuButton.value) {
			batch.draw(gameWindow, 295, 57, 590, 687);
			batch.draw(mainMenuBlock, 297, Gdx.graphics.getHeight()/2);
			mainMenuButton.draw(batch);
			mainMenuButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
		}
		
		//Debate Text Page
		if(mainMenuButton.value &&
		   !debateTPButton.value) {
			batch.draw(debateTextPage, 295, 57, 590, 687);
			debateTPButton.draw(batch);
			debateTPButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
		}
		
		//Debate Game Page
		if(mainMenuButton.value &&
		   debateTPButton.value && !debateGButton.value) {
			
			for(int x = 0; x < 590; x = x + 10) {
				for(int y = 0; y < 686; y = y + 7) {
					if(Math.random()*100 % 10 > 9) {
						batch.draw(mazeGrass, 295 + x, 57 + y, 10, 7);
					} 
					
					if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
						if(Gdx.input.getX() == x && Gdx.graphics.getHeight() - Gdx.input.getY() == y) {
							Gdx.input.setCursorPosition(1000, 1000);
						}
					}
				}
			}
			
			batch.draw(mazeTarget, Gdx.graphics.getWidth()/2-50, Gdx.graphics.getHeight()/2-50, 100, 100);
			
			if(Gdx.input.getX() > Gdx.graphics.getWidth()/2-50 && Gdx.input.getX() <= Gdx.graphics.getWidth()/2-50 + 100 &&
			   Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/2-50 &&
			   Gdx.graphics.getHeight() - Gdx.input.getY() <= Gdx.graphics.getHeight()/2-50 + 100 &&
			   Gdx.input.isTouched() && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
				passedMazeGame = true;
			}
			
			if(passedMazeGame) {
				debateGButton.draw(batch);
				debateGButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
			}
		}
		
		//Navigate Text Page
		if(mainMenuButton.value &&
		   debateTPButton.value && debateGButton.value &&
		   !navigateTPButton.value) {
			batch.draw(navigateTextPage, 295, 57, 590, 687);
			navigateTPButton.draw(batch);
			navigateTPButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
		}
		
		//Navigate Game Page
		if(mainMenuButton.value &&
		   debateTPButton.value && debateGButton.value &&
		   navigateTPButton.value && !navigateGButton.value) {
			
			if(clicksForButtons > 0 && clicksForButtons < 10) {
				batch.draw(compass, 295, 57+150);
			} else if(clicksForButtons > 10 && clicksForButtons < 20) {
				batch.draw(hourglass, 295, 57+150);
			} else if(clicksForButtons > 20 && clicksForButtons < 30) {
				batch.draw(mapOfBritain, 295, 57+150);
			} else if(clicksForButtons > 30 && clicksForButtons < 40) {
				batch.draw(mapOfPortugal, 295, 57+150);
			} else if(clicksForButtons > 40 && clicksForButtons < 50) {
				batch.draw(mapOfGreece, 295, 57+150);
			} else if(clicksForButtons > 50 && clicksForButtons < 60) {
				batch.draw(mapOfSouthAmerica, 295, 57+150);
			}

			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				clicksForButtons++;
			}
			
			if(clicksForButtons >= 60) {
				passedNavGame = true;
			}
			
			batch.draw(greenArrow, 590-100, 57);
			batch.draw(redX, 295, 57);
			batch.draw(choiceTitleBlock, 295, 687-57);
			if(passedNavGame) {
				navigateGButton.draw(batch);
				navigateGButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
			}
		}
		
		//Verify Text Page
		if(mainMenuButton.value &&
		   debateTPButton.value && debateGButton.value &&
		   navigateTPButton.value && navigateGButton.value &&
		   !verifyTPButton.value) {
			batch.draw(verifyTextPage, 295, 57, 590, 687);
			verifyTPButton.draw(batch);
			verifyTPButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
		}
		
		//Verify Game Page
		if(mainMenuButton.value &&
		   debateTPButton.value && debateGButton.value &&
		   navigateTPButton.value && navigateGButton.value &&
		   verifyTPButton.value && !verifyGButton.value) {
			batch.draw(verifyGamePage, 295, 57, 590, 687);
			verifyGButton.draw(batch);
			verifyGButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
		}
		
		//Summary Text Page
		if(mainMenuButton.value &&
		   debateTPButton.value && debateGButton.value &&
		   navigateTPButton.value && navigateGButton.value &&
		   verifyTPButton.value && verifyGButton.value &&
		   !summaryTPButton.value) {
			batch.draw(summaryTextPage, 295, 57, 590, 687);
			summaryTPButton.draw(batch);
			summaryTPButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
		}
		
		//Summary Game Page
		if(mainMenuButton.value &&
		   debateTPButton.value && debateGButton.value &&
		   navigateTPButton.value && navigateGButton.value &&
		   verifyTPButton.value && verifyGButton.value &&
		   summaryTPButton.value && !summaryGButton.value) {
			
			batch.draw(notesTrunk, 295*2, 57, 590/2, 687);
			batch.draw(importantNotes, xCord, yCord);
			
			if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
				xCord = Gdx.input.getX();
				yCord = Gdx.graphics.getHeight() - Gdx.input.getY();
			}
			
			if(xCord > 295*2 && yCord > 57) {
				passedSummaryGame = true;
			}
			
			if(passedSummaryGame) {
				summaryGButton.draw(batch);
				summaryGButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
			}
		}
		
		//Credits Text Page
		if(mainMenuButton.value &&
		   debateTPButton.value && debateGButton.value &&
		   navigateTPButton.value && navigateGButton.value &&
		   verifyTPButton.value && verifyGButton.value &&
		   summaryTPButton.value && summaryGButton.value &&
		   !creditsTPButton.value) {
			batch.draw(creditsTextPage, 295, 57, 590, 687);
			creditsTPButton.draw(batch);
			creditsTPButton.scrollButton(3, Gdx.graphics.getWidth()*2/3 - 98/2 - 98/2, "right");
		}
		
		if(creditsTPButton.value) {
			Gdx.app.exit();
		}
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backgroundMusic.dispose();
	}
}
