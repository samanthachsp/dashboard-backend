package com.dashboard.util;

import java.io.IOException;

import com.dashboard.common.Constants;

public final class DatabaseUtil {
    public static boolean backup(String dbUsername, String dbPassword, String dbName, String outputFile)
            throws IOException, InterruptedException {
        String command = String.format(Constants.DB_BACKUP_COMMAND_PATH + "mysqldump -u%s -p%s --add-drop-table --databases %s -r %s",
                dbUsername, dbPassword, dbName, outputFile);
        String[] cmd = { command };
        Process process = Runtime.getRuntime().exec(command);
        int processComplete = process.waitFor();
        return processComplete == 0;
    }
}
