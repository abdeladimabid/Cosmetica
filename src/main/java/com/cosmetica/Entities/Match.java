package com.cosmetica.Entities;


public class Match implements Comparable<Match>{
	
	public Product match;
	public Integer tags;
	
	public Product getMatch() {
		return match;
	}
	public void setMatch(Product match) {
		this.match = match;
	}
	public Integer getTags() {
		return tags;
	}
	public void setTags(int tags) {
		this.tags = tags;
	}
	public Match(Product match, int tags) {
		super();
		this.match = match;
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Match [match=" + match + ", tags=" + tags + "]";
	}
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
    public int compareTo(Match o) {
        return this.getTags().compareTo(o.getTags());
    }
	
	

}
