# 스프링 DI를 이용한 객체 생성
- 스프링의 가장 기본적인 기능은 객체를 생성하고 초기화하여 필요로 하는 곳에 제공하는 것인데, 이 중심에는 DI(Denpendency Injection)라는 설계 패턴이 적용 되어 있다.

## DI (Dependency Injection)와 스프링
- DI(Dependency Injection)의 약자로서, 우리말로는 의존주입아라는 단어로 번역되어 사용된다.의존이라는 단어로 알수 있듯이 DI는 의존을 처리하는 방버에 대한 내용이다.스프링은 기본적으로 DI를 기반으로 동작하기 때문에, 스프링을 잘 사용하려면 DI에 대한 이해가 필수적이다.

### 의존(Dependency)이란
- DI는 의존에 의존에 대한 설계 패턴이므로, 의존의 의미를 간단하게 알아보자, 기능을 실행하기 위해 다른 클래스(또는 타입)울 필요로 할 때 이를 이를 의존이라고 한다.
타입에 의존한다는 것은 다른 말로 해당 타입의 객체를 사용한다는 것을 
뜻한다.의존하는 타입의 객체를 직업 생성하지 않고, 외부에서 전달 받을수 있다.

### DI를 사용하는 방식의 코드: 의존 객체를 외부에서 조립함
- 의존 객체를 직접 생성하는 방식과 달리 DI는 의존 객체를 외부로 전달 받는 구현 방식이다. 생성자를 이용해서 의존 객체를 전달받는 방식이 DI에 따로 구현한것이다.
스스로 객체를 생성하지 않고 외부의 누군가가 의존하는 객체 이런 방식을  Dependency Injection (의존 주입)즉 DI라고 부른다. 또 다른 말로는 객체를 연결(wire)한다는 표현을 쓰기도 한다.
- 누가 객체를 생성하고 객체들을 서로 연결해줄까? 그런 역할을 수행하는 것이 바로 조립기다.
- DI를 사용할때의 또 다른 장점은 의존하는 클래스의 구현이 완성되어 있지 않더라고 테스트를 할수 있다는 점이다.
-DI는 의존 하는 객체를 외부에서 넣어주는 방식이다.

## 생성자 방식과 프로퍼티 설정 방식
- DI에서 의존 객체를 전달하는 방법은 크게 생성자 방식과 프로퍼티 설정 방식으로 구분된다. 생성자 방식은 생성자를 통해서 의존하는 객체를 전달받는 방식이다.
-프로퍼티 설정 방식은 의존 객체를 전달 받기 위해 메서드를 이용한다. 자바빈의 영향으로 프로퍼티 설정 방식 setPropertyName()형식의 메서드를 주로 사용한다.
-생성자 방식과 프로퍼티 설정방식은 각각 장단점이 서로 다르다, 먼저 생성자 방식의 장점은 객체를 생성하는 시점에 의존하는 객체를 모두 전달 받을수 있다는 점이다. 전달 받은 파라미터가 정상인지 확인 하고 코드를 생성자에 추가할 경우, 객체 생성 이후에는 그 객체가 사용가능 상태임을 보장할수 있다.프로퍼티 설정 방식의 장점은 어떤 의존 객체를 설정하는지 메서드의 이름으로 알수 있다는 점이다.
생성자 방식과 프로퍼티 방식의 장점이 다른 방식의 단점이 되기도 한다. 즉 생성자 방식에서는 생성자에 전달되는 파라미터의 이름만으로는 실제 타임을 알아내기 힘들고, 생성자에 전달되는 파라미터의 이름만으로 실제 타입을 알아내기 힘들고 생성자의 전달되는 파라미터의 개수가 증가할수록 코드 가독성이 떨어지는 단점이 있다.반대로 프로퍼티 설정 방식에서는 객체를 생성한뒤에 의존 객체가 모두 설정되었다고 보장할수 없어서 사용 가능하지 않은 상태 일수도 있다.

## 스프링은 객체를 생성하고 연결해주는 DI 컨테이너
```
String configLocation = "classpath:applicationContext.xml";
AbstractApplicationContent ctx = new GenericXmlApplicationContext(configLocation);
Project project= ctx.getBean("sampleProject",Project.class);
project.build();
ctx.close();
```
여기서 GenricXmlApplicationContext가 조립기 기능을 구현한 클래스다. 조립기에서 생성할 객체가 무엇인고 각 객체를 어떻게 연결하는지 대한 정보는 xml파일에 정의되어 있다.
GenericXmlApplicationContext클래스는 이xml 파일에 정의된 설정 정보를 읽어와 객체를 생성하고 각각의 객체를 연결한 뒤애 내부적으로 보관한다.이렇게 생성한 객체를 보관하기 때문에 스프링을 객체 컨테이너(object container)라고도 부른다.
xml을 이용한 스프링 설정을 보면 컨테이너가 생성할 객체를 지정하기 위해 "<bren>" 태그를 사용하는데, 이 이름에서 알수 있듯이 스프링 컨이터너가 생성해서 보관하는 객체를 스프링 빈 (spring bean)객체라고 부른다. 물론 빈객체라고 해서 특별한 객체는 아니고 일반적인 자바 객체와 동일하다.

## 스프링 컨테이너 종류
스프링은 BeanFactory와 ApplicationContext의 두 가지 타입의 컨테이너를 제공한다.

-                       beanFactory(interface)
- ListableBeanFactory(interface)  HierarchicalBeanFactory(interFace) 
-                       ApplicationContext(interFace)
-                       ConfigurableApplicationContext(interFace)


BreanFactory계열의 인터페이스만 구현 클래스는 단순히 컨테이너에서 객체를 생성하고 DI를 처리 해주는 기능만 제공한다.
하지만 스프링을 사용하는 이유는 스프링이 DI컨테이너이기 때문만이 아니다. 스프링을 사용하는 이유는 제공하는 다영한 부가기능(편리한 트랙잭션 처리, 자바 코드 기반 스프링 설정,애노테이션를 사용한 빈 설정, 스프링을 이용한 웹 개발, 메세지 처리등)때문인데, 이러한 부가 기능을 사용할려면 ApplicationContext 계열을 사용해야 한다. 이런 이유로 BeanFacoty를 사용하는 경우는 매우 드물며 ApplicationContext를 주로 사용한다.

- GenericXmlApplicationContext:XML 파일을 설정 정보로 사용하는 스프링 컨테이너 구현 클래스이다. 독립형 어플리케이션을 개발할때 사용된다.
- AnnotationConfigApplicationContext: 자바 코드를 설정 정보로 사용하는 스프링 컨테이너이다. 독립형 어플리케이션을 개발할때 사용된다.
- GenericGroovyApplicationContext: 그루비 언어로 작성된 설정 정보를 사용하는 스프링 컨테이너이다 독립형 어플리케이션을 개발할때 사용된다.
- XmlWebApplicationContext: 웹 어플리케이션을 개발할때 사용하는 스프링 컨테이너로서 xml파일 설정 정보로 사용한다.
- AnnotationConfigWebApplicationContext: 웹 어플리케이션을 개발할때 사용할때 사용하는 스프링 컨테이너로써 자바 코드를 설정 정보로 사용한다.

## 스프링의 DI 설정
스프링을 잘 사용하려면 가장 기본적인 DI 설정을 이해해야한다. 스프링의 DI 설정은 xml,자바코드, 그루비 코드를의 세가지 방법으로 할수 있다. 

### 예제 정리 chap02
- User: 사용자 정보를 보관하고,  암호 일치 여부(matchPassword)와 암호 변경 기능(chagePassword)을 제공한다.
- UserRepository: User 객체를 보관하며, ID를 이용해서 User객체를 찾는 기능(fineUserById)를 제공한다.
- AuthFailLogger: AuthenticaitonService가 인증에 실패한 기록을 남기기 위한 목적으로 사용한다. 
- AuthenticationService: 아이디/암호를 입력 받아 인증을 수행한다. userRepositoy로 부터 User객체를 구한 뒤,User객체의 matchPassword()메서드를 이용해서 아이디/암호 일치 여부 판단한다. 아이디/암호가 일치하지 않은 경우 authFailLogger의 insertBadPw() 메서드를 실행해서 실패 기록을 남긴다.
- PasswrodChangeService와 마찬가리로 UserRepository로 부터 User객체를 구하고, 그 user 객체의 changePassword()메서드를 이용헤서 암호 변경한다.

## xml을 이용한 DI 설정
- 설정 정보로 사용할 XML 파일을 작성하는 것 매우 간단.
<bean>태그를 이용해서 컨테이너가 생성 빈 객체를 지정해주고, <property>태그나 <constructor-arg> 태그를 이용해서 객체가 필요로 하는 값을 설정해주면된다.

-  스프링 XML 설정의 기본 골격
예)

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/maven-v4_0_0.xsd">

    <bean id="빈식별자" class="생성할 객체의 완전한 클래스 이름">
        <property name="프로퍼티 이름">
            <value>프로퍼티 값</value>
        </property>
        <property name="프로퍼티 이름" ref="다른 빈 식별자"/>
    </bean>

    <bean id="빈식별자1" class="생성할 객체의 완전한 클래스 이름">
        <consturct-arg><value>인자값</value></constructor-arg>
        <construct-arg><ref bean="다른 빈 식별자"/></construct-arg>
    </bean>
</beans>
```
- <bean> 태그 : 생성할 객체 지정
<bean> 태그는 스프링 컨테이너가 생성할 객체에 대한 정보를 지정할 때 사용한다.
<bean> 태그의 주요 속성 id와 class다.

* class 속성은 스핑 컨터이너가 생성할 객체의 클래스 이름을 값으로 갖는다.
이때 클래스의 이름ㅇ  패키지 이름을 포함한 완전한 클래스 이름이어야한다.
* id 속성으로 지정한 빈의 이름 다른 bean 태그에서 참조 할때 사용






