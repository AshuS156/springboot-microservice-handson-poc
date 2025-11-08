package com.pathfinder.beans;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix= "dbconfiguration" , value= "enabled" , havingValue= "false" , matchIfMissing = true)
public class SQLDBConfiguration{

    SQLDBConfiguration() {
        System.out.println("SQLDBConfiguration bean created : and hashcode : " + this.hashCode());
    }

    public String loadDBConfiguration(){
        System.out.println("Loading data from SQLDB  !!!!!!");
        return "Data from SQLDB  !!!!!";
    }
}
