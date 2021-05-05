package com.jbgames.sandsim.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.jbgames.sandsim.gameworld.GameRenderer;
import com.jbgames.sandsim.gameworld.GameWorld;
import com.jbgames.sandsim.helpers.InputHandler;

public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private InputHandler inputHandler;

    private float runTime;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth(), screenHeight = Gdx.graphics.getHeight();
        world = new GameWorld(screenWidth, screenHeight);
        Gdx.input.setInputProcessor(new InputHandler(world));
        renderer = new GameRenderer(world);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
