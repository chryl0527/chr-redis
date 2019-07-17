package com.chryl;

import com.chryl.bean.SsoUser;
import com.chryl.utils.GsonUtil;
import com.chryl.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChrRedisApplicationTests {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //测试stringRedisTemplate:需要转为json再存储
    @Test
    public void contextLoads() {
        String key = "123st533s";
        SsoUser ssoUser = new SsoUser();
        ssoUser.setUserId(key);
        ssoUser.setUserName("nancy");
        ssoUser.setExpireMinite(1440);
        ssoUser.setExpireFreshTime(System.currentTimeMillis());
        String s = GsonUtil.bean2Json(ssoUser);
        //ssoUser.toString()----存地址
        //或者用序列化,先序列化在存入redis-value,取出来也得序列化
        stringRedisTemplate.opsForValue().set(
                ssoUser.getUserId(), ssoUser.toString(), 1440, TimeUnit.MINUTES
        );
        System.out.println("---");
        String strSsoUser = stringRedisTemplate.opsForValue().get(key);
        System.out.println(strSsoUser);
        System.out.println("--");
//        SsoUser ssoUser1 = GsonUtil.json2Bean(strSsoUser, SsoUser.class);
//        System.out.println(ssoUser1.getUserId());
//        System.out.println(ssoUser1.getUserName());

    }


    //测试redisTemplate
    @Test
    public void testRT() {
        String key = "####123455sr4g2";
        SsoUser ssoUser = new SsoUser();
        ssoUser.setUserId(key);
        ssoUser.setUserName("chryl");
        ssoUser.setExpireMinite(1440);
        ssoUser.setExpireFreshTime(System.currentTimeMillis());
        redisTemplate.opsForValue().set(
                ssoUser.getUserId(), ssoUser, 1440, TimeUnit.MINUTES
        );
        System.out.println("---");
        Object o = redisTemplate.opsForValue().get(ssoUser.getUserId());
        System.out.println(o);
        SsoUser su = (SsoUser) o;
        System.out.println("--");
        System.out.println(su.getUserId());
        System.out.println(su.getUserName());
    }

    /**
     * 一下为测试RedisTemplate
     */
    @Test
    public void testRT1() {
        String key = "####123455sr4g2";
        SsoUser ssoUser = new SsoUser();
        ssoUser.setUserId(key);
        ssoUser.setUserName("chryl");
        ssoUser.setExpireMinite(1440);
        ssoUser.setExpireFreshTime(System.currentTimeMillis());
        redisTemplate.opsForValue().set(ssoUser.getUserId(), ssoUser, 1440, TimeUnit.MINUTES);
    }


    @Test
    public void testRT00() {
        String key = "####123455sr4g2";
        Long expire = redisTemplate.getExpire(key);
        System.out.println(expire);
    }

}

