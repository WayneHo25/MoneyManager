package util;
 
import java.io.BufferedReader;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
 
public class MysqlUtil {
 
    public static void backup(String mysqlPath, String backupfile) throws IOException {
        String command = mysqlPath + "bin/mysqldump -u " + DBUtil.loginName + " -p" + DBUtil.password + " " + DBUtil.database + " -r " + backupfile;
        
        Runtime.getRuntime().exec(command);
    }
 
    public static void recover(String mysqlPath, String recoverfile) {
        try {
            String[] command = new String[]{mysqlPath + "bin/mysql", DBUtil.database, "-u" + DBUtil.loginName, "-p" + DBUtil.password, "-e", " source "+ recoverfile };
            
            Process p = Runtime.getRuntime().exec(command);
            OutputStream out = p.getOutputStream();
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
 
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
            writer.flush();
            out.close();
            br.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    public static void main(String[] args) throws IOException {
        String mysqlPath = "/usr/local/mysql/bin/mysql";
        String file = "/Users/waynehe/Documents/Code/eclipse/MoneyManager/backup/moneymanager.sql";
 
        // backup(mysqlPath, file);
        // restore();
        // recover(mysqlPath, file);
        // recover(file);
        recover(mysqlPath, file);
 
    }
 
}