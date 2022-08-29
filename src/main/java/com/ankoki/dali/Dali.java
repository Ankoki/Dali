package com.ankoki.dali;

import com.ankoki.dali.helpers.StorageCache;

import java.io.File;

public class Dali {

    public static void main(String[] args) {
        if (args.length != 1) System.err.println("The storage.json path has not been declared.");
        else {
            File file = new File(args[0]);
            if (!file.exists()) System.err.println("The given file does not exist.");
            else {
                StorageCache.initiate(file);
            }
        }
    }

}
