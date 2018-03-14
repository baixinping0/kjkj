package com.bxp.kjkj.data.entity;

import com.bxp.kjkj.auth.entity.EmpModel;
import com.bxp.kjkj.util.format.FormatUtil;

import java.util.HashMap;
import java.util.Map;

/**
 通道8中直传数据第46874行不连续：当前计数=53910，下一帧计数=53912

 0  :
 1  :  8
 2  :  直传数据
 3  :  46874
 4  :  不连续
 5  :  53910
 6  :  53912

 */
public class Data1024Model {

    public static final Integer DATA_TYPE_STRAIGHT = 100;
    public static final String DATA_TYPE_STRAIGHT_VIEW = "直传数据";

    public static final Integer ERROR_TYPE_STRAIGHT = 200;
    public static final String ERROR_TYPE_STRAIGHT_VIEW = "不连续";

    public static Map<Integer, String> dataTypeMap = new HashMap<>();
    public static Map<Integer, String> errorTypeMap = new HashMap<>();

    static {
        dataTypeMap.put(DATA_TYPE_STRAIGHT, DATA_TYPE_STRAIGHT_VIEW);
        errorTypeMap.put(ERROR_TYPE_STRAIGHT, ERROR_TYPE_STRAIGHT_VIEW);
    }

    private Long uuid;
    private Long chanel;
    private Integer dataType;
    private Long errorRow;
    private Integer errorType;
    private Long currentCount;
    private Long nextCount;
    private Long inputTime;
    private Long produceTime;
    private EmpModel reporter;


    private String inputTimeView;
    private String produceTimeView;
    private String dataTypeView;
    private String errorTypeView;

    public String getDataTypeView() {
        return dataTypeView;
    }

    public String getErrorTypeView() {
        return errorTypeView;
    }

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

    public Long getChanel() {
        return chanel;
    }

    public void setChanel(Long chanel) {
        this.chanel = chanel;
    }

    public Long getErrorRow() {
        return errorRow;
    }

    public void setErrorRow(Long errorRow) {
        this.errorRow = errorRow;
    }

    public Long getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Long currentCount) {
        this.currentCount = currentCount;
    }

    public Long getNextCount() {
        return nextCount;
    }

    public void setNextCount(Long nextCount) {
        this.nextCount = nextCount;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataTypeView = dataTypeMap.get(dataType);
        this.dataType = dataType;
    }

    public Integer getErrorType() {
        return errorType;
    }

    public void setErrorType(Integer errorType) {
        this.errorTypeView = errorTypeMap.get(errorType);
        this.errorType = errorType;
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
        return "Data1024Model{" +
                "uuid=" + uuid +
                ", chanel='" + chanel + '\'' +
                ", dataType='" + dataType + '\'' +
                ", errorRow='" + errorRow + '\'' +
                ", errorType='" + errorType + '\'' +
                ", currentCount='" + currentCount + '\'' +
                ", nextCount='" + nextCount + '\'' +
                ", inputTime=" + inputTime +
                ", produceTime=" + produceTime +
                ", reporter=" + reporter +
                ", inputTimeView='" + inputTimeView + '\'' +
                ", produceTimeView='" + produceTimeView + '\'' +
                '}';
    }
}
