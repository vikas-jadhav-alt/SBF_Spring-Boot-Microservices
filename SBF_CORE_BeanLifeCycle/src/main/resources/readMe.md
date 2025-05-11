

## Steps to Execute and Run The Code

Just Run The Main.class in Main.java as Java Application

## Order of Bean LifeCycle Events:

1. Constructor 
2. Field injection
3. Setter injection
4. Aware methods
4.1 BeanPostProcessor.postProcessBeforeInitialization
5. @PostConstruct / afterPropertiesSet()
5. BeanPostProcessor.postProcessAfterInitialization
6. Ready to use
7. (On shutdown) @PreDestroy / destroy()



## In Which Order Bean Are Destroyed Upon Application Context Close

When you close a Spring `ApplicationContext`, **singleton beans** are destroyed in **reverse order of their creation** — *last created, first destroyed*. This is known as **reverse dependency order**.

---

### 🔁 Lifecycle Summary:

1. Beans are **created in dependency order**
2. When the context is closed:

   * Beans are **destroyed in reverse order**
   * Spring ensures that **a bean is destroyed after all beans that depend on it**

---

### 🧠 Example:

Suppose you have these beans:

```java
@Component
public class A {
    public A() { System.out.println("A created"); }
    @PreDestroy
    public void destroy() { System.out.println("A destroyed"); }
}

@Component
public class B {
    @Autowired
    private A a;
    public B() { System.out.println("B created"); }
    @PreDestroy
    public void destroy() { System.out.println("B destroyed"); }
}
```

### Output:

```
A created
B created
--- Context closing ---
B destroyed
A destroyed
```

Explanation:

* `A` is created first (needed by `B`)
* But `B` is destroyed first (because it *depends on* `A`)
* This avoids `NullPointerException` or broken state during shutdown

---

### 🚨 Important Notes:

* This applies to **singleton beans**
* For **prototype beans**, Spring does **not manage destruction**
* Beans implementing `DisposableBean`, `@PreDestroy`, or `destroyMethod` in XML are all triggered

---

==============================>>


Great question!

Yes — **for prototype-scoped beans**, **Spring does not call their destruction callbacks automatically** (like `@PreDestroy`, `destroy()`, etc.). It only manages their **creation**, not the **full lifecycle**.

---

### 🔁 Singleton vs Prototype Lifecycle

| Aspect                     | Singleton Scope      | Prototype Scope   |
| -------------------------- | -------------------- | ----------------- |
| Creation                   | Managed by Spring    | Managed by Spring |
| Dependency Injection       | Done by Spring       | Done by Spring    |
| `@PostConstruct`           | Called               | Called            |
| `@PreDestroy`              | ✅ **Called**         | ❌ **Not called**  |
| `DisposableBean.destroy()` | ✅ Called             | ❌ Not called      |
| Destruction Order          | Controlled by Spring | Not controlled    |

---

### 🔥 Example

```java
@Component
@Scope("prototype")
public class MyPrototypeBean {

    public MyPrototypeBean() {
        System.out.println("MyPrototypeBean created");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("MyPrototypeBean destroyed");
    }
}
```

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

MyPrototypeBean bean = context.getBean(MyPrototypeBean.class); // created
context.close(); // destroy() or @PreDestroy NOT called
```

### Output:

```
MyPrototypeBean created
```

> No `destroy()` or `@PreDestroy` output — **you must call it manually**.

---

### ✅ To Destroy Manually:

```java
MyPrototypeBean bean = context.getBean(MyPrototypeBean.class);
// ... use it
((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(bean);
```

---

### Summary:

* Spring creates prototype beans and injects them
* **You must manage their cleanup manually**
* Useful when you want short-lived or lightweight beans

Would you like to see a Spring-managed workaround to handle prototype destruction automatically?

