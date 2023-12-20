package configs;

import commons.Utils;
import controllers.member.JoinValidator;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc//-3개, handlermapping, adaptor, viewresolver
@Import(DbConfig2.class)
public class MvcConfig implements WebMvcConfigurer {
    @Autowired//스프링컨테이너도 컨테이너 안에 관리객체임
    //webapplictioncontext의 상위버전, 다형성
    private ApplicationContext applicationContext;
  /*
    @Autowired
    private JoinValidator joinValidator;
    @Override
    public Validator getValidator() {
        return joinValidator;
    }
*/
    @Bean//이게 컨트로러 빈?
    public MemberOnlyInterceptor memberOnlyInterceptor(){
        return new MemberOnlyInterceptor();
    }

    @Bean
    public CommonInterceptor commonInterceptor(){
        return new CommonInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(memberOnlyInterceptor())
                .addPathPatterns("/mypage/**");
    registry.addInterceptor(commonInterceptor())
            .addPathPatterns("/**");
    //모든 경로의 파일이 commonnterceptor의 영향
    }

    @Override//모든 요청에 대해 컨트롤러빈이 없는경우, 정적자원경로를 체크
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override//정적자원의 경로를 설정해주는 것
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///c:/uploads/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");
        registry.addViewController("/mypage/**")
                .setViewName("mypage/index");
    }

    @Bean//타임리프, jsp대신 쓸 때
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        //true면 서버가 최초 로딩시에 번역,
        // 다음 요청시에는 기존 파일을 그대로 씀
        //false-매 요청마다 다시 번역(개발중)
        return templateResolver;
    }

    @Bean//밑에 EL식 가능,
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addDialect(new Java8TimeDialect());
        //Date time Api(java.time패키지)-#temporals
        templateEngine.addDialect(new LayoutDialect());
        //레이아웃 기능 추가-jsp에서 커스텀태그로 비슷하게
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setContentType("text/html");//응답헤더쪽에
        resolver.setCharacterEncoding("utf-8");
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms = new
                ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setBasenames("messages.commons", "messages.validations");
        return ms;
    }
    @Bean
    public Utils utils(){
        return new Utils();
    }

   // @Override
    //public void configureViewResolvers(ViewResolverRegistry registry) {
      //  registry.jsp("/WEB-INF/templates/", ".jsp");
            //.jsp인 hello.jsp를 찾을 수 있게 해주는 메서드
    //}
    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer(){
        PropertySourcesPlaceholderConfigurer conf =
                new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(
                new ClassPathResource("application.properties")
        );
        return conf;
    }
}
