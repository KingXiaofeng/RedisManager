package test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wangxf on 2017/6/5.
 */
public class RedisTest {

    private Jedis jedis;                        // 非切片客户端连接
    private JedisPool jedisPool;                // 非切片连接池


    public RedisTest() {
        initialPool();
        jedis = jedisPool.getResource();
    }

    private void initialPool(){

        //池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config,"192.168.137.130",7002);
        //jedisPool = new JedisPool(config,"127.0.0.1",7000);
    }

    public void show(){
        StringOperate();

    }

    private void StringOperate() {

        System.out.println("String 功能 :");
        // 清空数据
        System.out.println("清空库中所有数据："+jedis.flushDB());

        System.out.println("=============增=============");
        jedis.set("key001","value001");
        System.out.println(jedis.get("key001") + "------------------------");

        System.out.println("=============增，删，查（多个）=============");

    }

    public static int tryCatchFinally(String s){

        int i = 0;
        System.out.println(i);
        try {
            i += 1;
            System.out.println(i);
            //s.length();
            return i;
        } catch (Exception e) {
            i += 1;
            System.out.println(i);
            return i;
        } finally {
            i += 1;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new RedisTest().show();
    }
}
