package app;

import java.io.File;
import java.util.*;
import de.sciss.*;
import de.sciss.desktop.impl.MacJava9Platform;

public class AppTest {
    public static void main (String[] args)
    {
        AppTest test = new AppTest();
        String str = test.getClass().getResource("").getPath() + "" + test.getClass().getSimpleName() + ".class";
        System.out.println("path = " + str);
        try {
            MacJava9Platform.revealFile(new File(str));
        }catch (Exception e){
            System.out.println("File in the jar! e:"+e);
        }

    }
}
