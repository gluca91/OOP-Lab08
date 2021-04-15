package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 
 */
public class Controller {

    private static final String USER_HOME = System.getProperty("user.home");
    private static final String SEP = System.getProperty("file.separator");
    private static final String DEF_NAME = "output.txt";

    private File currentFile;

    public Controller() {
        setDefault();
    }

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     */

    /**
     * 
     * @param file
     *                 .
     */
    public void setFile(final File file) {
        this.currentFile = file;
    }

    /*
     * 2) A method for getting the current File
     */

    /**
     * 
     * @return .
     */
    public File getFile() {
        return this.currentFile;
    }

    /*
     * 3) A method for getting the path (in form of String) of the current File
     */

    /**
     * 
     * @return .
     */
    public String getPath() {
        return this.currentFile.getPath();
    }

    /*
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     */

    /**
     * 
     * @param text
     *                 .
     * @throws IOException
     *                         .
     */
    public void addText(final String text) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile)) {
            ps.print(text);
        }
    }

    /*
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

    private void setDefault() {
        this.currentFile = new File(USER_HOME + SEP + DEF_NAME);
    }

}
