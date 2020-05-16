package com.live.model;

import java.io.Serializable;

public class LiveSystemConfig implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.menu_name
     *
     * @mbggenerated
     */
    private String menu_name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.input_type
     *
     * @mbggenerated
     */
    private String input_type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.config_tab_id
     *
     * @mbggenerated
     */
    private Integer config_tab_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.parameter
     *
     * @mbggenerated
     */
    private String parameter;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.upload_type
     *
     * @mbggenerated
     */
    private Integer upload_type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.required
     *
     * @mbggenerated
     */
    private String required;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.width
     *
     * @mbggenerated
     */
    private Integer width;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.high
     *
     * @mbggenerated
     */
    private Integer high;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.value
     *
     * @mbggenerated
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.info
     *
     * @mbggenerated
     */
    private String info;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.desc
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.sort
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column live_system_config.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table live_system_config
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.id
     *
     * @return the value of live_system_config.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.id
     *
     * @param id the value for live_system_config.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.menu_name
     *
     * @return the value of live_system_config.menu_name
     *
     * @mbggenerated
     */
    public String getMenu_name() {
        return menu_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.menu_name
     *
     * @param menu_name the value for live_system_config.menu_name
     *
     * @mbggenerated
     */
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name == null ? null : menu_name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.type
     *
     * @return the value of live_system_config.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.type
     *
     * @param type the value for live_system_config.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.input_type
     *
     * @return the value of live_system_config.input_type
     *
     * @mbggenerated
     */
    public String getInput_type() {
        return input_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.input_type
     *
     * @param input_type the value for live_system_config.input_type
     *
     * @mbggenerated
     */
    public void setInput_type(String input_type) {
        this.input_type = input_type == null ? null : input_type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.config_tab_id
     *
     * @return the value of live_system_config.config_tab_id
     *
     * @mbggenerated
     */
    public Integer getConfig_tab_id() {
        return config_tab_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.config_tab_id
     *
     * @param config_tab_id the value for live_system_config.config_tab_id
     *
     * @mbggenerated
     */
    public void setConfig_tab_id(Integer config_tab_id) {
        this.config_tab_id = config_tab_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.parameter
     *
     * @return the value of live_system_config.parameter
     *
     * @mbggenerated
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.parameter
     *
     * @param parameter the value for live_system_config.parameter
     *
     * @mbggenerated
     */
    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.upload_type
     *
     * @return the value of live_system_config.upload_type
     *
     * @mbggenerated
     */
    public Integer getUpload_type() {
        return upload_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.upload_type
     *
     * @param upload_type the value for live_system_config.upload_type
     *
     * @mbggenerated
     */
    public void setUpload_type(Integer upload_type) {
        this.upload_type = upload_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.required
     *
     * @return the value of live_system_config.required
     *
     * @mbggenerated
     */
    public String getRequired() {
        return required;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.required
     *
     * @param required the value for live_system_config.required
     *
     * @mbggenerated
     */
    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.width
     *
     * @return the value of live_system_config.width
     *
     * @mbggenerated
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.width
     *
     * @param width the value for live_system_config.width
     *
     * @mbggenerated
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.high
     *
     * @return the value of live_system_config.high
     *
     * @mbggenerated
     */
    public Integer getHigh() {
        return high;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.high
     *
     * @param high the value for live_system_config.high
     *
     * @mbggenerated
     */
    public void setHigh(Integer high) {
        this.high = high;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.value
     *
     * @return the value of live_system_config.value
     *
     * @mbggenerated
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.value
     *
     * @param value the value for live_system_config.value
     *
     * @mbggenerated
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.info
     *
     * @return the value of live_system_config.info
     *
     * @mbggenerated
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.info
     *
     * @param info the value for live_system_config.info
     *
     * @mbggenerated
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.desc
     *
     * @return the value of live_system_config.desc
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.desc
     *
     * @param desc the value for live_system_config.desc
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.sort
     *
     * @return the value of live_system_config.sort
     *
     * @mbggenerated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.sort
     *
     * @param sort the value for live_system_config.sort
     *
     * @mbggenerated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column live_system_config.status
     *
     * @return the value of live_system_config.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column live_system_config.status
     *
     * @param status the value for live_system_config.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_system_config
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menu_name=").append(menu_name);
        sb.append(", type=").append(type);
        sb.append(", input_type=").append(input_type);
        sb.append(", config_tab_id=").append(config_tab_id);
        sb.append(", parameter=").append(parameter);
        sb.append(", upload_type=").append(upload_type);
        sb.append(", required=").append(required);
        sb.append(", width=").append(width);
        sb.append(", high=").append(high);
        sb.append(", value=").append(value);
        sb.append(", info=").append(info);
        sb.append(", desc=").append(desc);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}