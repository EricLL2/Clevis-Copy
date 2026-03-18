package hk.edu.polyu.comp.comp2021.clevis.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/// The class responsible for logging commands into html/txt files.
public class CommandLogger {
    private final String htmlPath;
    private final String txtPath;
    private int operationIndex;

    /**
     * The default constructor fo the {@code CommandLooger}.
     *
     * @param htmlPath The path of the html file to log to.
     * @param txtPath The path of the txt file to log to.
     */
    public CommandLogger(String htmlPath, String txtPath) {
        this.operationIndex = 1;

        this.txtPath = txtPath;

        this.htmlPath = htmlPath;
        this.writeHtmlHeader();
        this.writeTxtHeader();
    }

    /**
     * Log the command.
     *
     * @param command the command to be logged.
     */
    public void logCommand(String command) {
        writeToTxt(command);
        writeToHtml(operationIndex, command);

        this.increaseIndex();
    }

    /**
     * Terminates logging of the command. This MUST be called if and only if the application is terminated.
     */
    public void closeLog() {
        String footer = "</table>\n</body>\n</html>";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.htmlPath, true))) { // true = append
            writer.write(footer);
        } catch (IOException e) {
            System.out.println("Error writing HTML log footer: " + e.getMessage());
        }
    }

    private void writeHtmlHeader() {
        String header = "<html>\n<body>\n"
                + "<h1>Clevis Command Log</h1>\n"
                + "<table>\n"
                + "  <tr><th>Operation Index</th><th>Command</th></tr>\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.htmlPath, false))) { // false = overwrite
            writer.write(header);
        } catch (IOException e) {
            System.out.println("Error creating HTML log header: " + e.getMessage());
        }
    }

    private void writeToHtml(int index, String command) {
        String safeCommand = command.replace("<", "&lt;").replace(">", "&gt;");

        String row = String.format("  <tr><td>%d</td><td>%s</td></tr>\n", index, safeCommand);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlPath, true))) { // true = append
            writer.write(row);
        } catch (IOException e) {
            System.out.println("Error writing to HTML log row: " + e.getMessage());
        }
    }

    private void writeTxtHeader() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.txtPath, false))) { // false = overwrite
            writer.write("");
        } catch (IOException e) {
            System.out.println("Error creating HTML log header: " + e.getMessage());
        }
    }

    private void writeToTxt(String command) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.txtPath, true))) { // true = append
            writer.write(command);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to TXT log: " + e.getMessage());
        }
    }

    private void increaseIndex() {
        this.operationIndex++;
    }
}
