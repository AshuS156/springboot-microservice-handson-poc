package com.pathfinder.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProtoTypeScopeBean{

    ProtoTypeScopeBean() {
        System.out.println("ProtoTypeScopeBean cons calling .....");
    }
}
