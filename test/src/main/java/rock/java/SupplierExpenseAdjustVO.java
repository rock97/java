package rock.java;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Meng Li
 */

public class SupplierExpenseAdjustVO {
//
//    private static final String REDIS_KEY_MOLA_SUPPLIER_EXPENSE_ADJUST_WHITELIST
//            = "mola:supplier-expense-adjust:whitelist";


    private Long id;
    private String cityCode;
    private String cityName;
    private String supplierId;
    private String supplierName;
    private Date validDate;
    private Date ascriptionDate;
    private Integer status;
    private String priceId;
    private String operationType;
    private String operationTypeName;
    private String subtype;
    private String subtypeName;
    private String costObject;
    private String costObjectName;
    private String vehicleType;
    private String vehicleTypeName;
    private String unit;
    private String unitName;
    private String tax;
    private String invoiceType;
    private String invoiceTypeName;
    private Integer count;
    private Integer carriedBike;
    private BigDecimal price;
    private BigDecimal money;
    private String reasonType;
    private String reason;
    private String operatorId;
    private String operatorName;
    private Boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isClosed;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getAscriptionDate() {
        return ascriptionDate;
    }

    public void setAscriptionDate(Date ascriptionDate) {
        this.ascriptionDate = ascriptionDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationTypeName() {
        return operationTypeName;
    }

    public void setOperationTypeName(String operationTypeName) {
        this.operationTypeName = operationTypeName;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getSubtypeName() {
        return subtypeName;
    }

    public void setSubtypeName(String subtypeName) {
        this.subtypeName = subtypeName;
    }

    public String getCostObject() {
        return costObject;
    }

    public void setCostObject(String costObject) {
        this.costObject = costObject;
    }

    public String getCostObjectName() {
        return costObjectName;
    }

    public void setCostObjectName(String costObjectName) {
        this.costObjectName = costObjectName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTypeName() {
        return invoiceTypeName;
    }

    public void setInvoiceTypeName(String invoiceTypeName) {
        this.invoiceTypeName = invoiceTypeName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCarriedBike() {
        return carriedBike;
    }

    public void setCarriedBike(Integer carriedBike) {
        this.carriedBike = carriedBike;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getReasonType() {
        return reasonType;
    }

    public void setReasonType(String reasonType) {
        this.reasonType = reasonType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }


    public Date computeAscriptionDate() {

        Calendar calendarK = Calendar.getInstance();
        calendarK.setTime(this.getValidDate());
        int day = calendarK.get(Calendar.DAY_OF_MONTH);
        //账单日期大于24号就是k+1
        if (day > 24) {
            calendarK.set(Calendar.MONTH, calendarK.get(Calendar.MONTH) + 1);
        }

        Calendar calendarUpdatedAt = Calendar.getInstance();
        calendarUpdatedAt.setTime(this.getUpdatedAt());//最后更新时间

        calendarK.set(Calendar.DAY_OF_MONTH, 29);
        if (calendarUpdatedAt.before(calendarK)) {
            return this.getValidDate();
        } else {
            calendarUpdatedAt.set(Calendar.DAY_OF_MONTH, 25);//设置成本月的25日
            calendarUpdatedAt.set(Calendar.MONTH,calendarK.get(Calendar.MONTH));
            return calendarUpdatedAt.getTime();
        }
    }

    public static void main(String[] args) {
        String aaa = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(aaa);

        SupplierExpenseAdjustVO adjustVO = new SupplierExpenseAdjustVO();
        Calendar calendarK = Calendar.getInstance();
        Calendar calendarT = Calendar.getInstance();
        calendarT.set(2019,11,29);

        calendarK.set(2019,10,29);
        adjustVO.setUpdatedAt(calendarT.getTime());
        adjustVO.setValidDate(calendarK.getTime());
        adjustVO.setStatus(21);
        System.out.println("adjustVO = " + sdf.format(adjustVO.computeAscriptionDate()));
    }
}
