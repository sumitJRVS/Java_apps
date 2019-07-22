package ca.jrvs.apps.grep;


import java.io.File;
import java.io.IOException;
import java.util.List;


public interface GrepApp { // this is publicly available and has no class and no public needed as its already public interface

    /**
     * 	Top level search workflow
     * 	@throws IOException
     */
    void workingFunction() throws IOException;

    /**
     * Traverse a given directory and return all files
     * @param rootFolder
     * @return Files in the folder
     */
    List<File> filesList(String rootFolder);

    /**
     *param input File file to be read@return lines
     * Read a file and return all the lines
     * @param extractedFiles
     * @return String lines from the obtained files.
     */
    List<String> linesList(File extractedFiles);

    /**
     * Check if a line contains the regex pattern (passed by user)
     * @param outputLines
     * @return boolean function
     */
    boolean hasPattern(String outputLines);

    /**
     * Write lines to a file
     * @param extractedLines
     * @throws Exception
     * @retur we get extracted lines from search, recorded into the file.
     */
    void writeToFile(List<String> extractedLines) throws Exception; //this is void so you can throw catch Exception

    /**
     * @return
     */
    String getRootPath();

    /**
     *
     * @param rootPath
     */
    void setRootPath(String rootPath);

    /**
     *
     * @return
     */
    String getRegex();

    /**
     *@param regex
     */
    void setRegex(String regex);

    /**
     *
     * @return
     */
    String getOutFile();

    /**
     * @param outFile
     */
    void setOutFile(String outFile);

}