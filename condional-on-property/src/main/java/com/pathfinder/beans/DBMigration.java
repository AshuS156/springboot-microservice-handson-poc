package com.pathfinder.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class DBMigration{

    @Autowired
    NoSQLDbConfiguration noSQLDbConfiguration;

    @Autowired
    SQLDBConfiguration sqldbConfiguration;


    public void loadData() {
        noSQLDbConfiguration.loadDBConfiguration();
        sqldbConfiguration.loadDBConfiguration();
    }
}
