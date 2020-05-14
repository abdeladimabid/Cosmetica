package com.cosmetica.entities;


public class Match implements Comparable<Match>{

    public Product pMatch;
    public Integer tags;

    public Product getMatch() {
        return pMatch;
    }
    public void setMatch(Product match) {
        this.pMatch = match;
    }
    public Integer getTags() {
        return tags;
    }
    public void setTags(int tags) {
        this.tags = tags;
    }
    public Match(Product match, int tags) {
        super();
        this.pMatch = match;
        this.tags = tags;
    }
    @Override
    public String toString() {
        return "Match [match=" + pMatch + ", tags=" + tags + "]";
    }
    public Match() {
        super();
    }
    @Override
    public int compareTo(Match o) {
        return this.getTags().compareTo(o.getTags());
    }



}
