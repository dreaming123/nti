package com.jcz.entity;

public class Item {
    private String code;//编码

    private String  exteriorcode;//电脑号=物料编码
    private String name;//名称

    private String description;//描述
    private String  unitid; //单位id

    private String samecode; //规格
    private String price ;  //单价
    private String  cadno;//图号
    private String statecode="Enabled";//
    private String  containeritemid="4a4d09d45a18475995ece9103beb8211";
    private String  typecode="ItemTypeCode_BJ";  //物料类型
    private String  warehouseid="D360B7E006F449B59C46D28ED9BF14F0";//仓库id

    public String getCode() {
        return code;
    }

    public Item setCode(String code) {
        this.code = code;
        return this;
    }

    public String getExteriorcode() {
        return exteriorcode;
    }

    public Item setExteriorcode(String exteriorcode) {
        this.exteriorcode = exteriorcode;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUnitid() {
        return unitid;
    }

    public Item setUnitid(String unitid) {
        this.unitid = unitid;
        return this;
    }

    public String getStatecode() {
        return statecode;
    }

    public Item setStatecode(String statecode) {
        this.statecode = statecode;
        return this;
    }

    public String getSamecode() {
        return samecode;
    }

    public Item setSamecode(String samecode) {
        this.samecode = samecode;
        return this;
    }

    public String getContaineritemid() {
        return containeritemid;
    }

    public Item setContaineritemid(String containeritemid) {
        this.containeritemid = containeritemid;
        return this;
    }

    public String getCadno() {
        return cadno;
    }

    public String getPrice() {
        return price;
    }

    public Item setPrice(String price) {
        this.price = price;
        return this;
    }

    public Item setCadno(String cadno) {
        this.cadno = cadno;
        return this;
    }

    public String getTypecode() {
        return typecode;
    }

    public Item setTypecode(String typecode) {
        this.typecode = typecode;
        return this;
    }

    public String getWarehouseid() {
        return warehouseid;
    }

    public Item setWarehouseid(String warehouseid) {
        this.warehouseid = warehouseid;
        return this;
    }


    public Item(String code, String exteriorcode, String name, String description, String unitid, String samecode, String cadno,String price) {
        this.code = code;
        this.exteriorcode = exteriorcode;
        this.name = name;
        this.description = description;
        this.unitid = unitid;
        this.samecode = samecode;
        this.cadno = cadno;
         this.price=price;
    }
}
