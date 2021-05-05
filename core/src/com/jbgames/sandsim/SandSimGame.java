package com.jbgames.sandsim;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jbgames.sandsim.screens.GameScreen;

public class SandSimGame extends Game {

	@Override
	public void create () {
		setScreen(new GameScreen());
	}

	@Override
	public void render () {
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
