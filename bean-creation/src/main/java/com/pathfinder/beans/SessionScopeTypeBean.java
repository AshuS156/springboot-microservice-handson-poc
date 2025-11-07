package com.pathfinder.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SessionScopeTypeBean{

    SessionScopeTypeBean() {
        System.out.println("SessionScopeTypeBean cons calling .....");
    }
}
