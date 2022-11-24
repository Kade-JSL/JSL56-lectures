package controller;

import dao.ScoreDaoImpl;

public class ScoreMain {
    public static void main(String[] args) {
        
        ScoreDaoImpl sdi = ScoreDaoImpl.getInstance();
        sdi.run();
        
    }
}
