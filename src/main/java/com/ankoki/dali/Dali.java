package com.ankoki.dali;

import com.ankoki.dali.helpers.StorageCache;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Dali {

    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        if (args.length != 1) System.err.println("The storage.json path has not been declared.");
        else {
            File file = new File(args[0]);
            if (!file.exists()) System.err.println("The given file does not exist.");
            else if (file.isDirectory()) System.err.println("A JSON file must be provided.");
            else {
                StorageCache.initiate(file);
                Runnable runnable = () -> StorageCache.getInstance().backupCache();
                executor.scheduleAtFixedRate(runnable, 30, 30, TimeUnit.MINUTES);
            }
        }
    }

}
