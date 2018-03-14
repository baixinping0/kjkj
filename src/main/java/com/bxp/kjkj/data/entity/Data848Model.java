package com.bxp.kjkj.data.entity;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.util.format.FormatUtil;

/**
 在第0帧错误，  正确校验码为：  1f 15,  计算后校验码为：  88 82

 0  :
 1  :  0
 2  :
 3  :  1f 15
 4  :
 5  :  88 82

 */
public class Data848Model {
    private Long uuid;

    private Long errorFrame;
    private String correctCode;
    private String actualCode;
    private Long inputTime;
    private Long produceTime;
    private EmpModel reporter;

    private String inputTimeView;
    private String produceTimeView;


    public EmpModel getReporter() {
        return reporter;
    }

    public void setReporter(EmpModel reporter) {
        this.reporter = reporter;
    }

    public String getInputTimeView() {
        return inputTimeView;
    }

    public String getProduceTimeView() {
        return produceTimeView;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getErrorFrame() {
        return errorFrame;
    }

    public void setErrorFrame(Long errorFrame) {
        this.errorFrame = errorFrame;
    }

    public String getCorrectCode() {
        return correctCode;
    }

    public void setCorrectCode(String correctCode) {
        this.correctCode = correctCode;
    }

    public String getActualCode() {
        return actualCode;
    }

    public void setActualCode(String actualCode) {
        this.actualCode = actualCode;
    }

    public Long getInputTime() {
        return inputTime;
    }

    public void setInputTime(Long inputTime) {
        this.inputTimeView = FormatUtil.formatDate(inputTime);
        this.inputTime = inputTime;
    }

    public Long getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Long produceTime) {
        this.produceTimeView = FormatUtil.formatDate(produceTime);
        this.produceTime = produceTime;
    }

    @Override
    public String toString() {
        return "Data848Model{" +
                "uuid=" + uuid +
                ", errorFrame='" + errorFrame + '\'' +
                ", correctCode='" + correctCode + '\'' +
                ", actualCode='" + actualCode + '\'' +
                ", inputTime=" + inputTime +
                ", produceTime=" + produceTime +
                ", reporter=" + reporter +
                ", inputTimeView='" + inputTimeView + '\'' +
                ", produceTimeView='" + produceTimeView + '\'' +
                '}';
    }
}
