package com.soft1010.common.httpapi.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author zhangjifu
 * @Create time: 2017/2/17 11:11
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-rpc.xml")
public class Test {

    @Autowired
    private DemoAPI demoAPI;
    @Autowired
    private DemoAPI2 demoAPI2;

    @org.junit.Test
    public void test() {

        MailMessageRequestDto mailMessageRequestDto = new MailMessageRequestDto();
        mailMessageRequestDto.setMailReceiver("zhangjifu@le.com");
        mailMessageRequestDto.setTemplateParams(new String[]{"---"});

        System.out.println(demoAPI.sendMail("FForder", "8888", DigestUtils.md5Hex("FForder"), mailMessageRequestDto));
    }


    @org.junit.Test
    public void test2() {
        System.out.println(demoAPI2.test("2"));
    }

}
