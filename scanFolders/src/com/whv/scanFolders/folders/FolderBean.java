package com.whv.scanFolders.folders;

public class FolderBean {
	/**����*/
	private String name;
	/**·��*/
	private String path;
	/**�ϼ�·��*/
	private String parentName;
	/**�Ƿ����²�*/
	private boolean hasNext;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	
}
