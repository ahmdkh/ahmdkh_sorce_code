package com.model.entity;

public class login {
	   private int id;
	    private String username;
	    private String password;
	    private String rule;
	    private String depart;

	    public login() {
	    }

	    public login(int id, String username, String password, String rule, String depart) {
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.rule = rule;
	        this.depart = depart;
	    }

	    public String getDepart() {
	        return depart;
	    }

	    public void setDepart(String depart) {
	        this.depart = depart;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public void setRule(String rule) {
	        this.rule = rule;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public String getRule() {
	        return rule;
	    }

	    public String getUsername() {
	        return username;
	    }
	    
	}
