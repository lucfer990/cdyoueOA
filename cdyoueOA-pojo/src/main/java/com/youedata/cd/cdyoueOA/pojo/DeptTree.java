package com.youedata.cd.cdyoueOA.pojo;

public class DeptTree {
	 private Integer id;
	    private String name;
	    private Integer pId;
	    private boolean  isParent;
	    public DeptTree(Integer id, String name, Integer pId, boolean isParent) {
	        this.id = id;
	        this.name = name;
	        this.pId = pId;
	        this.isParent = isParent;
	    }
	    public DeptTree() {
	       
	    }
	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public Integer getpId() {
	        return pId;
	    }
	    public void setpId(Integer pId) {
	        this.pId = pId;
	    }
	    public boolean isParent() {
	        return isParent;
	    }
	    public void setParent(boolean isParent) {
	        this.isParent = isParent;
	    }

}
