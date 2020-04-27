package com.longder.housekeeping.entity;


import org.springframework.security.core.GrantedAuthority;

/**
 * 系统角色枚举
 */
public enum SysRole implements GrantedAuthority {
    ROLE_ADMIN("ROLE_ADMIN","管理员","系统管理员",""),
    ROLE_STAFF("ROLE_STAFF","家政服务人员","家政服务人员","label-primary"),
    ROLE_EMPLOYER("ROLE_EMPLOYER","雇主","雇主","label-success");
    /**
     * 名称
     */
    private String name;
    /**
     * 展示名
     */
    private String displayName;
    /**
     * 描述
     */
    private String describe;

    /**
     * 页面标签
     */
    private String label;

    SysRole(String name, String displayName, String describe,String label) {
        this.name = name;
        this.displayName = displayName;
        this.describe = describe;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }

    public boolean equals(SysRole role){
        return this.name.equals(role.name);
    }
}
