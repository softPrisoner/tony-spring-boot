package com.tony.serilize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 实现Externalizable接口
 *
 * @author tony
 * @description User
 * @copyright rainbow
 * @date 2020/03/02
 */
@Setter
@Getter
@ToString(callSuper = true)
public class User implements Externalizable {
    private transient String name;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(name.getBytes());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }
}
