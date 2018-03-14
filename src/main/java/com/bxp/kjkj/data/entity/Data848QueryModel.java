package com.bxp.kjkj.data.entity;

import com.bxp.kjkj.util.format.FormatUtil;

public class Data848QueryModel extends Data848Model{
    private Long errorFrame2;
    private Long inputTime2;
    private Long produceTime2;

    private String inputTime2View;
    private String produceTime2View;

    public String getInputTime2View() {
        return inputTime2View;
    }

    public String getProduceTime2View() {
        return produceTime2View;
    }

    public Long getErrorFrame2() {
        return errorFrame2;
    }

    public void setErrorFrame2(Long errorFrame2) {
        this.errorFrame2 = errorFrame2;
    }

    public Long getInputTime2() {
        return inputTime2;
    }

    public void setInputTime2(Long inputTime2) {
        this.inputTime2View = FormatUtil.formatDate(inputTime2);
        this.inputTime2 = inputTime2;
    }

    public Long getProduceTime2() {
        return produceTime2;
    }

    public void setProduceTime2(Long produceTime2) {
        this.produceTime2View = FormatUtil.formatDate(produceTime2);
        this.produceTime2 = produceTime2;
    }

    @Override
    public String toString() {
        return "Data848QueryModel{" +
                "errorFrame2='" + errorFrame2 + '\'' +
                ", inputTime2=" + inputTime2 +
                ", produceTime2=" + produceTime2 +
                "} " + super.toString();
    }
}
