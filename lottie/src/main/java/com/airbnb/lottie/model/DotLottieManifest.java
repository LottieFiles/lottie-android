package com.airbnb.lottie.model;

import static androidx.annotation.RestrictTo.Scope.LIBRARY;

import androidx.annotation.RestrictTo;

import java.util.List;

@RestrictTo(LIBRARY)
public class DotLottieManifest{

  public DotLottieManifest(String author, List<AnimationsItem> animations, String generator, String version) {
    this.author = author;
    this.animations = animations;
    this.generator = generator;
    this.version = version;
  }

  private String author;

	private List<AnimationsItem> animations;

	private String generator;

	private String version;

	public String getAuthor(){
		return author;
	}

	public List<AnimationsItem> getAnimations(){
		return animations;
	}

	public String getGenerator(){
		return generator;
	}

	public String getVersion(){
		return version;
	}
}
