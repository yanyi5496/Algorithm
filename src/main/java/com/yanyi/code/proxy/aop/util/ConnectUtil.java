package com.yanyi.code.proxy.aop.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;

/**
 * @author chenqiang
 * @date 2020-09-27
 */
public class ConnectUtil {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private static BasicDataSource dataSource = new BasicDataSource();

    //静态代码块,设置连接数据库的参数
    static{
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }


    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        try{
            //1.先从ThreadLocal上获取
            Connection conn = tl.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
