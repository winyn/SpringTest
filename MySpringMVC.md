# SpringMVC之踩过的坑
## 新建表单处理项目 SpringTest
### web.xml
> _选择Spring/Spring MVC以及Java EE/Web Application，才可以在项目结构中生成WEB-INF下的web.xml_

![新建](./pic/newpj.png)

### JDK
> _各处JDK版本必须保持一致（Project&Module）_

![JDK](./pic/jdk.png)

## 配置项目
### Module
> 右键把classes和lib加到项目中

![配置](./pic/artifacts.png)

### Tomcat
* new一个local server
![tomcat](./pic/tomdeploy.png)

* 选择本地Tomcat位置
* Deployment加入新建的项目
![tomcat](./pic/tomdeployed.png)

### 修改配置文件
> web.xml 修改url拦截不区分类型的路径下文件

```
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```
> dispatcher-servlet.xml 增加以下配置
```
    <context:component-scan base-package="controller"/>
    <!-- 默认使用基于注释的适配器和映射器 -->
    <mvc:annotation-driven/>
    <!-- 只把动态信息当做controller处理，忽略静态信息 -->
    <mvc:default-servlet-handler/>
    <!-- 自动扫描包中的Controlller -->

    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/jsp/"/><!-- 前缀 -->
        <property name="suffix" value=".jsp"/><!-- 后缀，自动拼接 -->
    </bean>
```
## 运行报错
### Wrong 1 
> Neither BindingResult nor plain target object for bean name 'command' available as request attribute
### How to deal with it?
#### 进入spring：bind标签源码可以看到
```jsp
Object target = requestContext.getModelObject(beanName);
if (target == null) {
   throw new IllegalStateException("Neither BindingResult nor plain target object for bean name '" +
   beanName + "' available as request attribute");
}
```

#### 如果是直接对某个页面进行请求，那么request中还没command这个对象，需要在jsp页面开始位置增加：
                                                        
`<jsp:useBean id="command" class="controller.Studen" scope="request" ></jsp:useBean>`

---