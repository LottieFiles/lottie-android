package com.airbnb.lottie.model;

import static androidx.annotation.RestrictTo.Scope.LIBRARY;

import androidx.annotation.RestrictTo;

@RestrictTo(LIBRARY)
public class AnimationsItem{

  public AnimationsItem(String themeColor, boolean loop, String id, float speed) {
    this.themeColor = themeColor;
    this.loop = loop;
    this.id = id;
    this.speed = speed;
  }

  private String themeColor;

	private boolean loop;

	private String id;

	private float speed;

	public String getThemeColor(){
		return themeColor;
	}

	public boolean isLoop(){
		return loop;
	}

	public String getId(){
		return id;
	}

	public float getSpeed(){
		return speed;
	}
}
