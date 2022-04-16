package cn.cec.flink.utils;

/**
 * @Author Yu Tao
 * @Description Jdbc描述类
 * @Date 20220416$
 * @Version 1.0
 */

import java.io.Serializable;
import java.util.Optional;
import javax.annotation.Nullable;
import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.util.Preconditions;

@PublicEvolving
public class JdbcOptions implements Serializable {
  private static final long serialVersionUID = 1L;
  protected final String url;
  protected final String driverName;
  @Nullable
  protected final String username;
  @Nullable
  protected final String password;

  protected final int maxRetries;

  protected JdbcOptions(String url, String driverName, String username, String password,
      int maxRetries) {
    this.url = Preconditions.checkNotNull(url, "jdbc url is empty");
    this.driverName = Preconditions.checkNotNull(driverName, "driver name is empty");
    this.username = username;
    this.password = password;
    this.maxRetries = maxRetries;
  }

  public String getDbURL() {
    return this.url;
  }

  public String getDriverName() {
    return this.driverName;
  }

  public Optional<String> getUsername() {
    return Optional.ofNullable(this.username);
  }

  public Optional<String> getPassword() {
    return Optional.ofNullable(this.password);
  }

  public int getMaxRetries() {
    return maxRetries;
  }

  public static class JdbcConnectionOptionsBuilder {
    private String url;
    private String driverName;
    private String username;
    private String password;
    private int maxRetries;

    public JdbcConnectionOptionsBuilder() {
    }

    public JdbcOptions.JdbcConnectionOptionsBuilder withUrl(String url) {
      this.url = url;
      return this;
    }

    public JdbcOptions.JdbcConnectionOptionsBuilder withDriverName(String driverName) {
      this.driverName = driverName;
      return this;
    }

    public JdbcOptions.JdbcConnectionOptionsBuilder withUsername(String username) {
      this.username = username;
      return this;
    }

    public JdbcOptions.JdbcConnectionOptionsBuilder withPassword(String password) {
      this.password = password;
      return this;
    }

    public JdbcOptions.JdbcConnectionOptionsBuilder withMaxRetries(int maxRetries) {
      this.maxRetries = maxRetries;
      return this;
    }

    public JdbcOptions build() {
      return new JdbcOptions(this.url, this.driverName, this.username, this.password, this.maxRetries);
    }
  }
}
