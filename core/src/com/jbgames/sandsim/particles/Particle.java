package com.jbgames.sandsim.particles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public abstract class Particle {
    private String type;
    private Vector2 pos, oldPos, velocity;
    private float temperature, density;
    private boolean solid;

    public Particle(String type, Vector2 pos, float temperature, Vector2 velocity, float density, boolean solid) {
        this.type = type;
        this.pos = pos;
        this.temperature = temperature;
        this.velocity = velocity;
        this.density = density;
        this.solid = solid;
        oldPos = new Vector2();

    }

    public void update(float delta, Vector2 gravity, Particle[][] simGrid){
        velocity.add(gravity.cpy().scl(delta));
        //velocity.y = Math.min(200, velocity.y);
    }

    public void render(ShapeRenderer sr){}

    public Point posToGrid() {
        return new Point((int)pos.x, (int)pos.y);
    }



    public Vector2 getVelocity() {
        return velocity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public Vector2 getOldPos() {
        return oldPos;
    }

    public void setOldPos(Vector2 oldPos) {
        this.oldPos = oldPos;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public float getX() {
        return pos.x;
    }

    public float getY() {
        return pos.y;
    }
}
