package com.sofac;

public class Tab {

	private int index;
	private String title;
	private String content;
	private boolean open;
	
	public Tab(int index, String title, String content) {
		super();
		this.index = index;
		this.title = title;
		this.content = content;
		this.open = false;
	}
	
	public Tab(int index, String title, String content,boolean open) {
		super();
		this.index = index;
		this.title = title;
		this.content = content;
		this.open = open;
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
