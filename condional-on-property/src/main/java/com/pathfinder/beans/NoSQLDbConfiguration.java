package com.pathfinder.beans;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "dbconfiguration" , value = "enabled" , havingValue = "true" , matchIfMissing=false)
public class NoSQLDbConfiguration{
    NoSQLDbConfiguration(){
        System.out.println("NoSQLDbConfiguration bean created : and hashcode : " + this.hashCode());
    }

    public String loadDBConfiguration(){
        System.out.println("Loading data from NoSQLDB  !!!!!!");
        return "Data from NoSQLDB  !!!!!";
    }
}
