package pl.jurgen.services;

import org.apache.commons.lang3.StringUtils;


public class DataModel {
    public String label;
    public String value;
    public String part;
    public boolean listValue;


    public DataModel() {
        this.label = StringUtils.EMPTY;
        this.value = StringUtils.EMPTY;
        this.part = StringUtils.EMPTY;
        this.listValue = false;
    }

    public boolean fieldIsNotEmpty() {
        return (StringUtils.isNoneBlank(this.label) ? true : false);
    }

    public void clearField() {
        this.label = StringUtils.EMPTY;
        this.value = StringUtils.EMPTY;
        this.part = StringUtils.EMPTY;
        this.listValue = false;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", part='" + part + '\'' +
                ", listValue='" + listValue + '\'' +
                '}';
    }
}
