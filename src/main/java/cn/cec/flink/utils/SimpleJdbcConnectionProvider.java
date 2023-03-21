package cn.cec.flink.utils;

/**
 * @Author Yu Tao
 * @Description Jdbc 连接类
 * @Date 20220416$
 * @Version 1.0
 */
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleJdbcConnectionProvider implements Serializable {
  private static final Logger LOG = LoggerFactory.getLogger(SimpleJdbcConnectionProvider.class);
  private static final long serialVersionUID = 1L;
  private final JdbcOptions jdbcOptions;
  private transient volatile Connection connection; //transient是类型修饰符，只能用来修饰字段。在对象序列化的过程中，标记为transient的变量不会被序列化。
  //volatile也是变量修饰符，只能用来修饰变量。volatile修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。
  // 而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值

  public SimpleJdbcConnectionProvider(JdbcOptions jdbcOptions) {
    this.jdbcOptions = jdbcOptions;
  }

  public Connection getConnection() throws SQLException, ClassNotFoundException {
    if (this.connection == null) {
      synchronized(this) {
        if (this.connection == null) {
          Class.forName(this.jdbcOptions.getDriverName());
          if (this.jdbcOptions.getUsername().isPresent()) {
            this.connection = DriverManager.getConnection(this.jdbcOptions.getDbURL(),
                this.jdbcOptions.getUsername().get(), this.jdbcOptions.getPassword().orElse(null));
          } else {
            this.connection = DriverManager.getConnection(this.jdbcOptions.getDbURL());
          }
        }
      }
    }

    return this.connection;
  }

  public Connection reestablishConnection() throws SQLException, ClassNotFoundException {
    try {
      this.connection.close();
    } catch (SQLException var5) {
      LOG.info("JDBC connection close failed.", var5);
    } finally {
      this.connection = null;
    }

    this.connection = this.getConnection();
    return this.connection;
  }

  static {
    DriverManager.getDrivers();
  }
}

