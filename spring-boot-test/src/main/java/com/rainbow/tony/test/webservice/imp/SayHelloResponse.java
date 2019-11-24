
package com.rainbow.tony.test.webservice.imp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sayHelloResponse", propOrder = {
        "_return"
})
public class SayHelloResponse {

    @XmlElement(name = "return")
    protected String _return;

    /**
     * ��ȡreturn���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getReturn() {
        return _return;
    }

    /**
     * ����return���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReturn(String value) {
        this._return = value;
    }

}
