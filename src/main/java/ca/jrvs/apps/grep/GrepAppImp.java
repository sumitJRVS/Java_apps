package ca.jrvs.apps.grep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GrepAppImp implements GrepApp {

    private String regex;
    private String rootPath;
    private String outFile;

    public static void main(String[] args) {

        if (args.length != 3) {
            throw new IllegalArgumentException("USAGE: regex rootPath outFile");
        }

        GrepAppImp demo = new GrepAppImp();
        demo.setRegex(args[0]);
        demo.setRootPath(args[1]);
        demo.setOutFile(args[2]);

        try {
            demo.workingFunction();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void workingFunction() throws IOException {

        List<String> matchingLines = new ArrayList<String>();
        for (File file : filesList(this.getRootPath())) {
            for (String line : linesList(file)) {
                if (hasPattern(line)) {
                    matchingLines.add(line);

                }
            }
        }
        writeToFile(matchingLines);
    }

    @Override
    public List<File> filesList(String rootFolder) {

        List<File> files = new ArrayList<>();
        File dir = new File(rootFolder);

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                files.addAll(filesList(file.getPath()));
            } else {
                files.add(file);
            }
        }
        return files;
    }

    @Override
    public List<String> linesList(File extractedFiles) {

        List<String> abc = new ArrayList<>();
        BufferedReader br;
        String line;
        try {   //The BufferedReader object takes a FileReader object as an input which contains all the necessary information about the text file that needs to be read. (such as the file path and charset.)

            br = new BufferedReader(new FileReader(extractedFiles));
            while ((line = br.readLine()) != null) {
                abc.add(line);  //append...checkout...
                //System.out.println(abc);
                br.close();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // handle exception

        }
        return abc;
    }

    @Override
    public boolean hasPattern(String outputLines) {
        if (outputLines.matches(this.getRegex())) {
            return true;
        }
        return false;
    }

    @Override
    public void writeToFile(List<String> extractedLines) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.getOutFile()));
        for (String line : extractedLines) {
            bufferedWriter.write(line);
        }
        bufferedWriter.close();
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

}