package star.bucks.framework.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/globals.properties")
public class RootAppContext {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("datasource.url"));
        config.setUsername(env.getProperty("datasource.user"));
        config.setPassword(env.getProperty("datasource.password"));
        config.setConnectionTestQuery("SELECT 1");
        config.addDataSourceProperty("cachePrepStmts","true");
        config.addDataSourceProperty("preStmtCacheSize","250");
        config.addDataSourceProperty("preStmtCacheSqlLimit","2048");
        return  new HikariDataSource(config);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource source) throws Exception {

        SqlSessionFactoryBean session = new SqlSessionFactoryBean();

        session.setDataSource(source);
        session.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:mapper/*.xml"));
        return session.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource source){
        return new DataSourceTransactionManager(dataSource());

    }

}