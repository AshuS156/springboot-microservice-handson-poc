package com.pathfinder.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class RequestScopeTypeBean{

    RequestScopeTypeBean() {
        System.out.println("RequestScopeTypeBean cons calling ....");
    }
}
