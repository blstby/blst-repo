package com.sofac.util;

public class Tab {

	private int index;
	private String title;
	private String content;
	private String controller;
	private int param;
	private boolean open;

	public Tab(String title, String content, String controller, int param) {
		super();
		this.title = title;
		this.content = content;
		this.controller = controller;
		this.param = param;
		this.open = true;
	}

	public Tab(String title, String content, String controller) {
		super();
		this.title = title;
		this.content = content;
		this.controller = controller;
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

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public int getParam() {
		return param;
	}

	public void setParam(int param) {
		this.param = param;
	}

}