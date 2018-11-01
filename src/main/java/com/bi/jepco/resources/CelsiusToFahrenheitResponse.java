package com.bi.jepco.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "CelsiusToFahrenheitResponse")
public class CelsiusToFahrenheitResponse {

    private Integer CelsiusToFahrenheitResult;


    public Integer getCelsiusToFahrenheitResult() {
        return CelsiusToFahrenheitResult;
    }

    @XmlElement
    public void setCelsiusToFahrenheitResult(Integer celsiusToFahrenheitResult) {
        CelsiusToFahrenheitResult = celsiusToFahrenheitResult;
    }

}
