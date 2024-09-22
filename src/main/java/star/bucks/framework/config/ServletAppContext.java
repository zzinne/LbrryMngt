package star.bucks.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("star.bucks.app")
public class ServletAppContext extends WebMvcConfigurerAdapter {

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        super.configurePathMatch(configurer);
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp();
//
//    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] {"/WEB-INF/views/tiles.xml"});
        configurer.setCheckRefresh(true);
        return configurer;
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(1);
        return resolver;
    }
}
