//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.rainbow.tony.shiro.chapter6.principal;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface PrincipalCollection extends Iterable, Serializable {
    //获取账户
    Object getPrimaryPrincipal();
    //通过类型找到相应的bean
    <T> T oneByType(Class<T> var1);
    //找到所有该类型的bean
    <T> Collection<T> byType(Class<T> var1);

    List asList();

    Set asSet();

    Collection fromRealm(String var1);

    Set<String> getRealmNames();

    boolean isEmpty();
}
