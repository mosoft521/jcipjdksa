package test.jta;

import com.mysql.cj.jdbc.MysqlXADataSource;
import com.mysql.cj.jdbc.MysqlXid;
import org.junit.jupiter.api.Test;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.Statement;

public class XaTest {
    private static MysqlXADataSource getDataSource(String connStr, String user, String pwd) {
        try {
            MysqlXADataSource ds = new MysqlXADataSource();
            ds.setUrl(connStr);
            ds.setUser(user);
            ds.setPassword(pwd);
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void xaTest01() throws NullPointerException {
        String connStr1 = "jdbc:mysql://localhost:3306/test1";
        String connStr2 = "jdbc:mysql://localhost:3306/test2";
        try {
            //从不同数据库获取数据库数据源
            MysqlXADataSource ds1 = getDataSource(connStr1, "root", "admin");
            MysqlXADataSource ds2 = getDataSource(connStr2, "root", "admin");

            //数据库1获取连接
            XAConnection xaConnection1 = null;
            if (ds1 != null) {
                xaConnection1 = ds1.getXAConnection();
            }
            XAResource xaResource1 = null;
            if (xaConnection1 != null) {
                xaResource1 = xaConnection1.getXAResource();
            }
            Connection connection1 = null;
            if (xaConnection1 != null) {
                connection1 = xaConnection1.getConnection();
            }
            Statement statement1 = null;
            if (connection1 != null) {
                statement1 = connection1.createStatement();
            }

            //数据库2获取连接
            XAConnection xaConnection2 = null;
            if (ds2 != null) {
                xaConnection2 = ds2.getXAConnection();
            }
            XAResource xaResource2 = null;
            if (xaConnection2 != null) {
                xaResource2 = xaConnection2.getXAResource();
            }
            Connection connection2 = null;
            if (xaConnection2 != null) {
                connection2 = xaConnection2.getConnection();
            }
            Statement statement2 = null;
            if (connection2 != null) {
                statement2 = connection2.createStatement();
            }

            //创建事务分支的xid
            Xid xid1 = new MysqlXid(new byte[]{0x01}, new byte[]{0x02}, 100);
            Xid xid2 = new MysqlXid(new byte[]{0x011}, new byte[]{0x012}, 100);

            try {
                //事务分支1关联分支事务sql语句
                if (xaResource1 != null) {
                    xaResource1.start(xid1, XAResource.TMNOFLAGS);
                }
                int update1Result = 0;
                if (statement1 != null) {
                    update1Result = statement1.executeUpdate("update account_from set money=money - 100 where id=1");
                }
                if (xaResource1 != null) {
                    xaResource1.end(xid1, XAResource.TMSUCCESS);
                }

                //事务分支2关联分支事务sql语句
                if (xaResource2 != null) {
                    xaResource2.start(xid2, XAResource.TMNOFLAGS);
                }
                int update2Result = 0;
                if (statement2 != null) {
                    update2Result = statement2.executeUpdate("update account_to set money= money + 100 where id=1");
                }
                if (xaResource2 != null) {
                    xaResource2.end(xid2, XAResource.TMSUCCESS);
                }

                // 两阶段提交协议第一阶段
                int ret1 = 0;
                if (xaResource1 != null) {
                    ret1 = xaResource1.prepare(xid1);
                }
                int ret2 = 0;
                if (xaResource2 != null) {
                    ret2 = xaResource2.prepare(xid2);
                }

                // 两阶段提交协议第二阶段
                if (XAResource.XA_OK == ret1 && XAResource.XA_OK == ret2) {
                    if (xaResource1 != null) {
                        xaResource1.commit(xid1, false);
                    }
                    if (xaResource2 != null) {
                        xaResource2.commit(xid2, false);
                    }

                    System.out.println("reslut1:" + update1Result + ", result2:" + update2Result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
