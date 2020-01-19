package cn.lianhy.demo.to;

public class MenuInfoTO extends BaseTO{
    private String name;

    private String isLink;

    private String linkUrl;

    private String isFirst;

    private String isButton;

    private Integer orderInfo;

    private Integer parentId;

    private String permissionFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsLink() {
        return isLink;
    }

    public void setIsLink(String isLink) {
        this.isLink = isLink;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(String isFirst) {
        this.isFirst = isFirst;
    }

    public String getIsButton() {
        return isButton;
    }

    public void setIsButton(String isButton) {
        this.isButton = isButton;
    }

    public Integer getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Integer orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPermissionFlag() {
        return permissionFlag;
    }

    public void setPermissionFlag(String permissionFlag) {
        this.permissionFlag = permissionFlag;
    }
}
