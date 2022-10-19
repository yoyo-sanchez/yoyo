package com.example.wechat;

import java.io.Serializable;

public class ChatEntity implements Serializable {
    public String imgPath;//图片地址
    public String chatName;//聊天名称
    public String chatRecord;//聊天记录

    public ChatEntity() {
    }

    public ChatEntity(String imgPath, String chatName, String chatRecord) {
        this.imgPath = imgPath;
        this.chatName = chatName;
        this.chatRecord = chatRecord;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getChatRecord() {
        return chatRecord;
    }

    public void setChatRecord(String chatRecord) {
        this.chatRecord = chatRecord;
    }

    @Override
    public String toString() {
        return "ChatEntity{" +
                "imgPath='" + imgPath + '\'' +
                ", chatName='" + chatName + '\'' +
                ", chatRecord='" + chatRecord + '\'' +
                '}';
    }
}
