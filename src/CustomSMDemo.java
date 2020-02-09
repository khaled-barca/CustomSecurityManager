import java.io.*;
import java.net.MalformedURLException;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;

public class CustomSMDemo extends SecurityManager{
    public static void main(String[] args) throws MalformedURLException {
        AccessControlContext con = AccessController.getContext();
        File file = new File("CustomSMDemo.policy");
        System.setProperty("java.security.policy", "file:/" + file.getAbsolutePath());
        CustomSMDemo sm = new CustomSMDemo(); // set the system security manager System.setSecurityManager(sm);
        System.setSecurityManager(sm);
// perform the check
        sm.checkPermission(new FilePermission("Data.txt", "read")); // print a message if we passed the check

        System.out.println("allowed");
    }

    @Override
    public void checkPermission(Permission perm) {
        super.checkPermission(perm);
    }
}
