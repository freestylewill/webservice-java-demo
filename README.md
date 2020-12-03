# webservice-java-demo

### 概念:

- 什么是远程调用，系统和系统之间的调用，从远程系统当中获取业务数据。
- Webservice是服务，他是用传输协议数据的一种远程调用技术

<service>    服务视图，webservice的服务结点，它包括了服务端点

<binding>     为每个服务端点定义消息格式和协议细节

<portType>   **服务端点**，描述 web service可被执行的操作方法，以及相关的消息，通过binding指向portType

<message>   定义一个操作（方法）的数据参数(可有多个参数)

<types>        定义 web service 使用的全部数据类型

### 运行方法:

wsimport -p com.guigu.internet.weather -s . WeatherWebService.xml

### 阅读方式：从下往上

Ø  服务端

- 第一步：创建SEI接口

- 第二步：创建SEI实现类，要在类上加入@WebService

- 第三步：发布服务，Endpoint的publish方法，2两个参数：1.服务地址；2.实现类实例

- 第四步：测试服务是否发布成功，通过阅读使用说明书，确定服务接口、方法、参数、返回值存在，说明服务发布成功。

- WSDL地址：服务地址+”?wsdl”

- WSDL阅读方式，从下往上，servvice->binding->portType->其中有接口、方法、参数和返回值



Ø  客户端

- 第一步：使用wsimport生成客户端代码

- 第二步：根据使用说明书，使用客户端调用服务端

- 创建服务视图，视图是从service的name属性获取

- 获取服务实现类，从portType的name属性获取

- 调用查询方法，从portTypeoperationname



## WebService的注解都位于javax.jws包下:

@WebService-定义服务，在public class上边

targetNamespace：指定命名空间

name：portType的名称

portName：port的名称

serviceName：服务名称

endpointInterface：SEI接口地址，如果一个服务类实现了多个接口，只需要发布一个接口的方法，可通过此注解指定要发布服务的接口。

@WebMethod-定义方法，在公开方法上边

​        operationName：方法名

​        exclude：设置为true表示此方法不是webservice方法，反之则表示webservice方法，默认是false

@WebResult-定义返回值，在方法返回值前边

​        name：返回结果值的名称

@WebParam-定义参数，在方法参数前边

​        name：指定参数的名称

作用：

通过注解，可以更加形像的描述Web服务。对自动生成的wsdl文档进行修改，为使用者提供一个更加清晰的wsdl文档。

当修改了WebService注解之后，会影响客户端生成的代码。调用的方法名和参数名也发生了变化