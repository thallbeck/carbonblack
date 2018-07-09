/*
 * Created on 6/28/2018.
 * 1 hour of text cases for dothings.exse
 */

/*
  Plan - first, test the basics for the 3 possible params, then see what time is left to do more detailed things.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class aTest {

    static String exeFile = "dothings.exe";
    static String workingDir = "C:\\Users\\Public\\";

    public static void main(String[] args) throws Exception {
        HelpTest();
        InputTest( "test1" );
        InputTest( "test2" );
        CommandLineTest( "1,2,3,4,5", "5");
        CommandLineTest( "text with no numbers", "Expected an integer" );
        CommandLineTest( "1 2 3 4 5", "no more tokens" );
    }


    public static void HelpTest() throws Exception {

        String helpText = executeCommandAndReturnResult( workingDir + exeFile + " --help");

        // Put a resonable number of static string checks here
        assert (helpText.contains( "SYNOPSIS" ));
        assert (helpText.contains( "DESCRIPTION" ));
        assert (helpText.contains( "dothings does some things" ));
        assert (helpText.contains( "-p" ));
        assert (helpText.contains( "-u" ));
        // you get the picture
    }

    public static void InputTest( String inputFileName) throws Exception {

        String helpText = executeCommandAndReturnResult( workingDir + exeFile + " -p " + inputFileName );

        // Running out of time, but the input file and output check should both come from a data provider / data array here in this class
        assert (helpText.contains( "(408)348-4429" ));
    }

    public static void CommandLineTest( String commandLine, String errorOrSuccessText ) throws Exception {

        String helpText = executeCommandAndReturnResult( workingDir + exeFile + " -u " + commandLine );

        // Running out of time, but the input file and output check should both come from a data provider / data array here in this class
        assert (helpText.contains( errorOrSuccessText ));
    }

    // from the web, not mine
    public static String executeCommandAndReturnResult  ( String command) throws java.io.IOException, InterruptedException
    {
        Process p = Runtime.getRuntime().exec( command );
        p.waitFor();

        BufferedReader reader =
            new BufferedReader(new InputStreamReader(p.getInputStream()));

        StringBuffer output = new StringBuffer();

        String line = "";

        while ((line = reader.readLine())!= null) {
            output.append(line + "\n");
        }

        return output.toString();
    }
}
