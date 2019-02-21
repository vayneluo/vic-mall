package com.github.manage.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.util
 * @Description: java类作用描述
 * @Author: Vayne.Luo
 * @date 2018/12/20
 */
@Slf4j
public class GeneralUtil {

    public static void main(String[] args) {
        String pwd = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePwd = passwordEncoder.encode(pwd); //$2a$10$zKDL1BScP3zSHx7Oij2E8.i5QYroE4AoMtQQVMpiNferLjcOGQ.n6
        log.info(encodePwd);
        boolean flag = passwordEncoder.matches("123456","$2a$10$WOAGFZD7spZCshM5GzxD7uORv3TzyBsgWYbgZAPOPGoco/sdmdymu");
        System.out.println(flag);
        String[] payment = "Deposit, Second, Third, Balance".split(",");
        System.out.println(payment);

    }
}
