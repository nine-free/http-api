package com.soft1010.common.httpapi.test;

import java.io.Serializable;

/**
 * @Author zhangjifu
 * @Create time: 2016/11/21 15:13
 * @Description:
 */
public class MailMessageRequestDto implements Serializable {
    private static final long serialVersionUID = 2203735788441619417L;

    private String mailReceiver;
    private String[] templateParams;

    public String getMailReceiver() {
        return mailReceiver;
    }

    public void setMailReceiver(String mailReceiver) {
        this.mailReceiver = mailReceiver;
    }

    public String[] getTemplateParams() {
        return templateParams;
    }

    public void setTemplateParams(String[] templateParams) {
        this.templateParams = templateParams;
    }
}
