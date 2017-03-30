package com.sofac.util;

public class Tab {

	private int index;
	private String title;
	private String content;
	private boolean open;

	public Tab(String title, String content) {
		super();
		this.title = title;
		this.content = content;
		this.open = true;
	}

	public Tab(int index, boolean open) {
		super();
		this.index = index;
		this.open = open;
		this.title = "";
		this.content = "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}