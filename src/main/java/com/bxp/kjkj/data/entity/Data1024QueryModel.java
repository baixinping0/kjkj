package com.bxp.kjkj.data.entity;

import com.bxp.kjkj.util.format.FormatUtil;

public class Data1024QueryModel extends Data1024Model{
    private Long chanel2;
    private Long errorRow2;
    private Long currentCount2;
    private Long nextCount2;
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

    public Long getChanel2() {
        return chanel2;
    }

    public void setChanel2(Long chanel2) {
        this.chanel2 = chanel2;
    }

    public Long getErrorRow2() {
        return errorRow2;
    }

    public void setErrorRow2(Long errorRow2) {
        this.errorRow2 = errorRow2;
    }

    public Long getCurrentCount2() {
        return currentCount2;
    }

    public void setCurrentCount2(Long currentCount2) {
        this.currentCount2 = currentCount2;
    }

    public Long getNextCount2() {
        return nextCount2;
    }

    public void setNextCount2(Long nextCount2) {
        this.nextCount2 = nextCount2;
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
        return "Data1024QueryModel{" +
                "chanel2='" + chanel2 + '\'' +
                ", errorRow2='" + errorRow2 + '\'' +
                ", currentCount2='" + currentCount2 + '\'' +
                ", nextCount2='" + nextCount2 + '\'' +
                ", inputTime2=" + inputTime2 +
                ", produceTime2=" + produceTime2 +
                "} " + super.toString();
    }
}
