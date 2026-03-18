package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Test;

public class ClevisTest {
    private static final String DEFAULT_HTML_PATH = "clevis_log.html";
    private static final String DEFAULT_TXT_PATH = "clevis_log.txt";


    @Test
    public void testClevisConstructor(){
        Clevis clevis = new Clevis(DEFAULT_HTML_PATH, DEFAULT_TXT_PATH);
        assert true;
    }
	
}