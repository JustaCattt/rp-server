package com.example.payments;

import com.example.payments.entity.User;
import com.example.payments.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = PaymentsApplication.class)
@RunWith(SpringRunner.class)
class PaymentsApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){

    }

}
