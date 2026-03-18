package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Clevis;

/// The main application runner.
public class Application {
    /**
     * The main implementation of the application starts here.
     *
     * @param args: any additional options while running the project.
     */
    public static void main(String[] args){
        String htmlPath = findArgValue(args, "-html");
        String txtPath = findArgValue(args, "-txt");

        if (htmlPath == null) htmlPath = DEFAULT_HTML_PATH;
        if (txtPath == null) txtPath = DEFAULT_TXT_PATH;

        Clevis clevis = new Clevis(htmlPath, txtPath);

		clevis.start();
    }

    private static String findArgValue(String[] args, String flag) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(flag)) {
                if (i + 1 < args.length) {
                    String value = args[i + 1];

                    if (value.startsWith("-"))
                        throw new IllegalArgumentException(
                                "Missing path after " + flag + " flag. Found another flag instead: " + value
                        );

                    if (!value.endsWith("." + flag.substring(1)))
                        throw new IllegalArgumentException(value + " MUST have a proper extension.");

                    return value;
                } else {
                    throw new IllegalArgumentException("Path should be provided.");
                }
            }
        }

        return null;
    }

    private static final String DEFAULT_HTML_PATH = "clevis_log.html";
    private static final String DEFAULT_TXT_PATH = "clevis_log.txt";
}
